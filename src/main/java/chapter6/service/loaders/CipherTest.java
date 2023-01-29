package chapter6.service.loaders;

import java.util.Optional;
import java.util.ServiceLoader;

public class CipherTest {
  public static ServiceLoader<Cipher> cipherLoader = ServiceLoader.load(Cipher.class);
  
  public static Cipher getChiper(int minStrength) {
    System.out.println("Cipher Size : " + cipherLoader.findFirst());
    for (Cipher cipher : cipherLoader) {
      if (cipher.strength() >= minStrength)
        return cipher;
    }
    System.out.println("Cipher is null");
    
    return null;
  }
  
  public static Optional<Cipher> getChiper2(int minStrength) {
    return cipherLoader.stream()
            .filter(descr -> descr.type() == chapter6.service.loaders.impl.CaesarCipher.class)
            .findFirst()
            .map(ServiceLoader.Provider::get);
  }
  
  public static void main(String[] args) {
    Optional<Cipher> cipher = cipherLoader.findFirst();
    
    String secretData = "Ini adalah data rahasia";
    String key = "secret key";
    
    System.out.println("isPresent : " + cipher.isPresent());
    
//    // Encrypt
//    byte[] encryptedData = cipher.encrypt(secretData.getBytes(), key.getBytes());
//    System.out.println("Encrypted Data : " + encryptedData.toString());
//    
//    // Decrypt
//    byte[] decyptedData = cipher.decrypt(encryptedData, key.getBytes());
//    System.out.println("Decrypted Data : " + decyptedData.toString());
  }
}
