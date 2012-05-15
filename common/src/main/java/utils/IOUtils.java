package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtils {
   public static String readLine(String s) {
      System.out.print(s);
      String returnval = null;
      try {
         BufferedReader bufRead = new BufferedReader(new InputStreamReader(System.in));
         returnval = bufRead.readLine();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
      return returnval;
   }

   public static void dumpWelcomeMessage() {
      System.out.println("Ticket booking system");
      System.out.println("=====================");
      System.out.println("Commands: book, pay, list");
   }
}
