package de.fxnn.readablehash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ReadableHashCliApplication {

  static final ReadableHash READABLE_HASH = new ReadableHash();

  public static void main(String[] args) {

    List<String> arguments = Arrays.asList(args);
    if (arguments.isEmpty()) {
      hashFromStdin();
    } else {
      hashAllArguments(arguments);
    }

  }

  protected static void hashFromStdin() {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      String input;
      while ((input = reader.readLine()) != null) {
        System.out.println(READABLE_HASH.hashAsReadableString(input));
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  protected static void hashAllArguments(List<String> arguments) {
    for (String parameter : arguments) {
      System.out.println(READABLE_HASH.hashAsReadableString(parameter));
    }
  }

}
