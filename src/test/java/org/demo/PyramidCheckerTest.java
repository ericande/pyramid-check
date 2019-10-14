package org.demo;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PyramidCheckerTest {
    private static final String PYRAMID_WORD = "banana";
    private static final String MIXED_CASE_PYRAMID_WORD = "BananA";
    private static final String NON_PYRAMID_WORD = "Oklahoma";
    private static final String SINGLE_CHARACTER = "A";
    private static final String NON_PYRAMID_WORD_2 = "ZZ";
    private static final String NON_ASCII_PYRAMID_WORD = "∂s∂";

    private final PyramidChecker victim = new PyramidChecker();

    @Test
    public void pyramidWordShouldPass()
    {
        assertTrue(victim.check(PYRAMID_WORD));
    }

    @Test
    public void nonPyramidWordsShouldFail()
    {
        assertFalse(victim.check(NON_PYRAMID_WORD));
        assertFalse(victim.check(NON_PYRAMID_WORD_2));
    }

    @Test
    public void pyramidWordsAreCaseInsensitive()
    {
        assertTrue(victim.check(MIXED_CASE_PYRAMID_WORD));
    }

    @Test
    public void emptyStringIsAPyramidWord()
    {
        assertTrue(victim.check(""));
    }

    @Test
    public void singleCharacterIsAPyramidWord()
    {
        assertTrue(victim.check(SINGLE_CHARACTER));
    }

    @Test
    public void nonASCIIPyramidWordsShouldPass()
    {
        assertTrue(victim.check(NON_ASCII_PYRAMID_WORD));
    }
}
