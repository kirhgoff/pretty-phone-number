package org.kirhgoff.phoneprettifier;

import org.testng.annotations.Test;

import java.util.ConcurrentModificationException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.fail;

public class MultiWordTest {
  @Test
  public void testMultiWordBasic() throws Exception {
    MultiWord word = new MultiWord(new NumberArray(new int [] {1}));
    word.addVariant("a");
    word.addVariant("b");

    Set<String> variants = word.getVariants();
    assertThat(variants).containsExactly("a", "b");

    try {
      variants.add("c");
      fail("No modifications are allowed");
    } catch (UnsupportedOperationException e) {}
  }
}