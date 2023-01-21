package chapter3.file.input.output;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class FileReader {
  public static void main(String[] args) throws IOException {
    String dir = System.getProperty("user.dir");
    System.out.println("dir : " + dir);

    Scanner in = new Scanner(Path.of("Test.txt"), StandardCharsets.UTF_8);

    String input = in.nextLine();
    System.out.println("Input : " + input);

    String output = "Output Test";

    PrintWriter out = new PrintWriter("Output.txt", StandardCharsets.UTF_8);
    out.println("asjdflajsd;flajsdf");
    out.close();
  }
}
