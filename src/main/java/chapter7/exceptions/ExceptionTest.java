package chapter7.exceptions;

public class ExceptionTest {

  private static void testKumahaAingException() throws KumahaAingException {
    throw new KumahaAingException("Alah Error Siah ...");
  }

  public static void main(String[] args) {
    System.out.println("Begin");

    try {
      testKumahaAingException();

    } catch (Exception e) {
      System.out.println("Exception Occured : " + e.getMessage());
    }

    System.out.println("End");
  }
}
