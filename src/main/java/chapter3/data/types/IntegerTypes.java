package chapter3.data.types;

public class IntegerTypes {
  public static void main(String[] args) {
    System.out.println("Min Value Of byte : " + Byte.MIN_VALUE);
    System.out.println("Max Value Of byte : " + Byte.MAX_VALUE);

    System.out.println("Min Value Of short : " + Short.MIN_VALUE);
    System.out.println("Max Value Of short : " + Short.MAX_VALUE);

    System.out.println("Min Value Of int : " + Integer.MIN_VALUE);
    System.out.println("Max Value Of int : " + Integer.MAX_VALUE);

    System.out.println("Min Value Of long : " + Long.MIN_VALUE);
    System.out.println("Max Value Of long : " + Long.MAX_VALUE);

    System.out.println("Byte Range 255 : " + byteRange255((byte) 250));

    int binaryFormatByte = 0b1111_1111;
    int octalFormatByte = 0777;
    int hexaFormatByte = 0xFF;

    System.out.println("Byte in Binary Format 1111_1111 is " + binaryFormatByte);
    System.out.println("Byte in Octal Format 77 is " + octalFormatByte);
    System.out.println("Byte in Hexadecimal Format FF is " + hexaFormatByte);
  }

  private static int byteRange255(byte b) {
    return Byte.toUnsignedInt(b);
  }
}
