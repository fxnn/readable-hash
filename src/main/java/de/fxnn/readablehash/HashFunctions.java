package de.fxnn.readablehash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class HashFunctions {

  @Nullable
  public Long computeSha256AsLong(@Nullable String input) {
    if (input != null) {
      return computeHashAsLong(input, "SHA-256");
    }
    return null;
  }

  protected long computeHashAsLong(@Nonnull String input, @Nonnull String algorithm) {
    MessageDigest messageDigest = createMessageDigest(algorithm);
    messageDigest.update(input.getBytes());
    return new BigInteger(messageDigest.digest()).longValue();
  }

  protected MessageDigest createMessageDigest(@Nonnull String algorithm) {
    try {
      return MessageDigest.getInstance(algorithm);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Hashing algorithm not available", e);
    }
  }

}
