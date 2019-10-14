package org.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Path("pyramid")
public class PyramidChecker {

    /**
     * Accepts GET requests under webapi/pyramid/{word}
     *
     * Returns whether the input is a pyramid word. A word is a ‘pyramid’ word
     * if you can arrange the letters in increasing frequency, starting with 1
     * and continuing without gaps and without duplicates.
     */
    @GET
    @Path("{word}")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean check(@PathParam("word") String word) {
        return isPyramidWord(word);
    }

    private static boolean isPyramidWord(String s) {
        Map<Character, Integer> charCountMap = calculateCharacterCounts(s);

        int  numUniqueCharacters = charCountMap.size();
        boolean[] characterFrequencies = new boolean[numUniqueCharacters];
        Arrays.fill(characterFrequencies, false);
        for (int freq : charCountMap.values()) {
            if (freq <= 0 || freq > numUniqueCharacters) {
                return false; //Character has frequency not in range 1-n
            } else if (characterFrequencies[freq - 1]) {
                return false;  //Character has same frequency as another character
            } else {
                characterFrequencies[freq - 1] = true;
            }
        }
        return true;
    }

    private static Map<Character, Integer> calculateCharacterCounts(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        char[] chars = s.toLowerCase().toCharArray();
        for (Character c : chars) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        return charCountMap;
    }
}
