package de.fxnn.readablehash;

import java.util.Random;

import javax.annotation.Nullable;

import static java.lang.Character.toLowerCase;

public class ReadableHash {

  static final char[] CONSONANTS = "BCDFGHKLMNPQRSTVWXYZ".toCharArray();

  static final char[] VOWELS = "AEIJOU".toCharArray();

  static final int MIN_SYLLABLE_COUNT_PER_WORD = 1;

  static final int MAX_SYLLABLE_COUNT_PER_WORD = 6;

  private final HashFunctions hashFunctions = new HashFunctions();

  @Nullable
  public String hashAsReadableString(@Nullable String input) {
    return toReadableString(hashFunctions.computeSha256AsLong(input), MIN_SYLLABLE_COUNT_PER_WORD,
        MAX_SYLLABLE_COUNT_PER_WORD);
  }

  @Nullable
  public String toReadableString(@Nullable Long value, int minSyllableCountPerWord, int maxSyllableCountPerWord) {
    if (value != null) {
      StringBuilder resultBuilder = new StringBuilder();

      Random rng = new Random(value);
      int syllableCount =
          rng.nextInt(maxSyllableCountPerWord - minSyllableCountPerWord + 1) + minSyllableCountPerWord;
      for (int syllable = 0; syllable < syllableCount; syllable++) {
        char consonant = getRandomConsonant(rng);
        if (syllable > 0) {
          consonant = toLowerCase(consonant);
        }

        char vowel = toLowerCase(getRandomVowel(rng));

        resultBuilder.append(consonant).append(vowel);
      }

      return resultBuilder.toString();
    }

    return null;
  }

  private char getRandomConsonant(Random rng) {
    return CONSONANTS[rng.nextInt(CONSONANTS.length)];
  }

  private char getRandomVowel(Random rng) {
    return VOWELS[rng.nextInt(VOWELS.length)];
  }

}
