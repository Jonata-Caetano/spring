package com.bmarques.springregex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

//https://www.baeldung.com/regular-expressions-java
public class RegexLibTest {

    @Test
    void givenTextWhenSimpleRegexMatches_thenCorrect() {
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher("foo");

        assertTrue(matcher.find());
    }

    @Test
    void givenTextWhenSimpleRegexMatchesTwiceThenCorrect() {
        int matches = runTest("foo", "foofoo");

        assertEquals(matches, 2);
    }

    @Test
    void givenText_whenMatchesWithDotMetachThenCorrect() {
        int matches = runTest(".", "foo");

        assertTrue(matches > 0);
    }

    @Test
    void givenRepeatedText_whenMatchesOnceWithDotMetach_thenCorrect() {
        int matches= runTest("foo.", "foofoo");

        assertEquals(matches, 1);
    }

    @Test
    void givenORSet_whenMatchesAny_thenCorrect() {
        int matches = runTest("[abc]", "b");

        assertEquals(matches, 1);
    }

    @Test
    void givenORSet_whenMatchesAnyAndAll_thenCorrect() {
        int matches = runTest("[abc]", "cabab");

        assertEquals(matches, 5);
    }

    @Test
    void givenORSet_whenMatchesAllCombinations_thenCorrect() {
        int matches = runTest("[bcr]at", "bat cat rat");

        assertEquals(matches, 3);
    }

    @Test
    void givenNORSet_whenMatchesNon_thenCorrect() {
        int matches = runTest("[^abc]a", "ga");

        assertTrue(matches > 0);
    }

    @Test
    void givenNORSet_whenMatchesAllExceptElements_thenCorrect() {
        int matches = runTest("[^bcr]at", "sat mat eat");

        assertEquals(matches, 3);
    }

    @Test
    void givenUpperCaseRange_whenMatchesUpperCase_thenCorrect() {
        int matches = runTest("[A-Z]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 2);
    }

    @Test
    void givenLowerCaseRange_whenMatchesLowerCase_thenCorrect() {
        int matches = runTest("[a-z]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 26);
    }

    @Test
    void givenBothLowerAndUpperCaseRange_whenMatchesAllLetters_thenCorrect() {
        int matches = runTest("[a-zA-Z]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 28);
    }

    @Test
    void givenNumberRange_whenMatchesAccurately_thenCorrect() {
        int matches = runTest("[1-5]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 2);
    }

    @Test
    void givenNumberRange_whenMatchesAccurately_thenCorrect2(){
        int matches = runTest("3[0-5]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 1);
    }

    @Test
    void givenTwoSets_whenMatchesUnion_thenCorrect() {
        int matches = runTest("[1-3[7-9]]", "123456789");

        assertEquals(matches, 6);
    }

    @Test
    void givenTwoSets_whenMatchesIntersection_thenCorrect() {
        int matches = runTest("[1-6&&[3-9]]", "123456789");

        assertEquals(matches, 4);
    }

    @Test
    void givenSetWithSubtraction_whenMatchesAccurately_thenCorrect() {
        int matches = runTest("[0-9&&[^2468]]", "123456789");

        assertEquals(matches, 5);
    }

    @Test
    void givenDigits_whenMatches_thenCorrect() {
        int matches = runTest("\\d", "123");

        assertEquals(matches, 3);
    }

    @Test
    void givenDigits_whenMatches_thenCorrectEscapeCharacter() {
//        equivalent to [0-9]:
//        int matches = runTest("[0-9]", "123");
        int matches = runTest("\\d", "123");

        assertEquals(matches, 3);
    }

    @Test
    void givenNonDigits_whenMatches_thenCorrectEscapeCharacter() {
        //equivalent to [^0-9]:
        int matches = runTest("\\D", "a6c");

        assertEquals(matches, 2);
    }

    @Test
    void givenWhiteSpace_whenMatches_thenCorrect() {
        int matches = runTest("\\s", "a  c");

        assertEquals(matches, 2);
    }

    @Test
    void givenNonWhiteSpace_whenMatches_thenCorrect() {
        int matches = runTest("\\S", "a c");

        assertEquals(matches, 2);
    }

    @Test
    void givenWordCharacter_whenMatches_thenCorrect() {
//        equivalent to [a-zA-Z_0-9]:
        int matches = runTest("\\w", "hi!_");

        assertEquals(matches, 3);
    }

    @Test
    void givenNonWordCharacter_whenMatches_thenCorrect() {
        int matches = runTest("\\W", "hi!");

        assertEquals(matches, 1);
    }

    @Test
    void givenZeroOrOneQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("\\a?", "hi tiago");

        assertEquals(matches, 9);
    }

    @Test
    void givenZeroOrOneQuantifier_whenMatches_thenCorrect2() {
        int matches = runTest("\\a{0,1}", "hi");

        assertEquals(matches, 3);
    }

    @Test
    void givenBraceQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("a{3}", "aaaaaaaaa");

        assertEquals(matches, 3);
    }

    @Test
    void givenCapturingGroup_whenMatches_thenCorrect1() {
        int matches = runTest("(\\d\\d)", "1111");

        assertEquals(matches, 2);
    }

    @Test
    void givenCapturingGroup_whenMatches_thenCorrect() {
        int matches = runTest("(\\d\\d)", "12");

        assertEquals(matches, 1);
    }

    @Test
    void givenCapturingGroup_whenMatches_thenCorrect2() {
        int matches = runTest("(\\d\\d)", "1212");

        assertEquals(matches, 2);
    }

    @Test
    void givenCapturingGroupWhenMatchesWithBackReferenceThenCorrect() {
        int matches = runTest("(\\d\\d)\\1", "12121212");

        assertEquals(2, matches);
    }

    @Test
    void givenCapturingGroup_whenMatches_thenCorrect3() {
        int matches = runTest("(\\d\\d)(\\d\\d)", "1212");

        assertEquals(matches, 1);
    }

    @Test
    void givenCapturingGroup_whenMatchesWithBackReference_thenCorrect2() {
        int matches = runTest("(\\d\\d)\\1\\1\\1", "464646468");

        assertEquals(matches, 1);
    }

    @Test
    void givenCapturingGroupAndWrongInput_whenMatchFailsWithBackReference_thenCorrect() {
        int matches = runTest("(\\d\\d)\\1", "1213");

        assertFalse(matches > 0);
    }

    @Test
    public void givenText_whenMatchesAtBeginning_thenCorrect() {
        int matches = runTest("^dog", "dogs are friendly");

        assertTrue(matches > 0);
    }

    @Test
    void givenTextAndWrongInput_whenMatchFailsAtBeginning_thenCorrect() {
        int matches = runTest("^dog", "are dogs are friendly?");

        assertEquals(0, matches);
    }

    @Test
    void givenText_whenMatchesAtEnd_thenCorrect() {
        int matches = runTest("dog$", "Man's best friend is a dog");

        assertTrue(matches > 0);
    }

    @Test
    void givenTextAndWrongInput_whenMatchFailsAtEnd_thenCorrect() {
        int matches = runTest("dog$", "is a dog man's best friend?");

        assertEquals(0, matches);
    }

    @Test
    void givenText_whenMatchesAtWordBoundary_thenCorrect() {
        int matches = runTest("\\bdog\\b", "a little dog is friendly");

        assertTrue(matches > 0);
    }

    @Test
    void givenText_whenMatchesAtWordBoundary_thenCorrect2() {
        int matches = runTest("\\bdog\\b", "dog is man's best friend");

        assertTrue(matches > 0);
    }

    @Test
    void givenWrongText_whenMatchFailsAtWordBoundary_thenCorrect() {
        int matches = runTest("\\bdog\\b", "snoop dogg is a rapper");

        assertEquals(0, matches);
    }

    @Test
    public void givenText_whenMatchesAtWordAndNonBoundary_thenCorrect() {
        int matches = runTest("\\bdog\\B", "snoop dogg is a rapper");
        assertTrue(matches > 0);
    }

    @Test
    void givenRegexWithDefaultMatcher_whenMatchFailsOnDifferentCases_thenCorrect() {
        int matches = runTest("dog", "This is a Dog");

        assertFalse(matches > 0);
    }

    @Test
    void givenRegexWithCaseInsensitiveMatcher_whenMatchesOnDifferentCases_thenCorrect() {
        int matches = runTest(
                "dog", "This is a Dog", Pattern.CASE_INSENSITIVE);

        assertTrue(matches > 0);
    }

    @Test
    void givenRegexWithEmbeddedCaseInsensitiveMatcher_whenMatchesOnDifferentCases_thenCorrect() {
        int matches = runTest("(?i)dog", "This is a Dog");

        assertTrue(matches > 0);
    }
    @Test
    void simpleTest() {
        String name = "Tiago";

        boolean matches = name.matches("[A-Z]{1}[a-z]{4}");

        assertTrue(matches);
    }

    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    public static int runTest(String regex, String text, int flags) {
        Pattern pattern = Pattern.compile(regex, flags);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()){
            matches++;
        }
        return matches;
    }
}
