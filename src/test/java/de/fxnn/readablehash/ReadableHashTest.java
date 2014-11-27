package de.fxnn.readablehash;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;

public class ReadableHashTest {

  static final List<String> NON_NULL_INPUTS = asList("Dies ist ein Test",
      "Falsches Üben von Xylophonmusik quält jeden größeren Zwerg", "abc", "", "123");

  static final List<String> INPUTS = Lists
      .newArrayList(Iterables.concat(NON_NULL_INPUTS, Collections.<String>singleton(null)));

  ReadableHash sut;

  @Before
  public void setUp() {
    sut = new ReadableHash();
  }

  @Test
  public void testNullSafe() {

    Assert.assertNull(sut.hashAsReadableString(null));

  }

  @Test
  public void testSameInputSameOutput() {

    for (String input : INPUTS) {
      Set<String> results = new HashSet<String>();

      for (int i = 0; i < 100; i++) {
        results.add(sut.hashAsReadableString(input));
      }

      Assert.assertEquals(1, results.size());
    }

  }

  @Test
  public void testOutputDoesNotEqualInput() {

    for (String nonNullInput : NON_NULL_INPUTS) {
      Assert.assertNotEquals(nonNullInput, sut.hashAsReadableString(nonNullInput));
    }

  }

  @Test
  public void testDifferentInputDifferentOutput() {

    Set<String> results = new HashSet<String>();

    for (String input : INPUTS) {
      results.add(sut.hashAsReadableString(input));
    }

    Assert.assertEquals(INPUTS.size(), results.size());

  }

  @Test
  public void testFirstCharacterUppercaseAndFollowingCharactersLowercase() {

    for (String nonNullInput : NON_NULL_INPUTS) {
      String result = sut.hashAsReadableString(nonNullInput);

      Assert.assertTrue(Character.isUpperCase(result.charAt(0)));

      for (int i = 1; i < result.length(); i++) {
        Assert.assertTrue(Character.isLowerCase(result.charAt(i)));
      }
    }

  }

}
