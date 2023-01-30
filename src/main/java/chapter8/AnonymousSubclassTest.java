package chapter8;

import java.util.ArrayList;

public class AnonymousSubclassTest {
  public static void main(String[] args) {
    ArrayList<String> superScriptsText = new ArrayList<>() {
      public String get(int n) {
        return super.get(n).toUpperCase();
      }
    };

    superScriptsText.add("testOne");
    superScriptsText.add("testTwo");

    for (String s : superScriptsText) {
      System.out.println(s);
    }

    for (int i = 0; i < superScriptsText.size(); i++)
      System.out.println("Index " + i + " = " + superScriptsText.get(i));
  }
}
