package com.panchen.myAlgorithm.string;

/**
 * 
 * String a="abc", String b="cab", return true
 * 
 * @author pc
 *
 */
public class DeformedWords {

    private static boolean deformedWords(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();

        int[] res = new int[256];

        for (int i = 0; i < chara.length; i++) {
            res[chara[i]]++;
        }

        for (int i = 0; i < charb.length; i++) {
            if (res[charb[i]]-- == 0) {
                return false;
            }
        }

        return true;

    }

}
