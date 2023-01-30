package chapter7.exceptions;

public class KumahaAingException extends Exception {

  public KumahaAingException() {
    super();
  }

  public KumahaAingException(String message) {
    super("Exception Kumaha Aing => " + message);
  }
}
