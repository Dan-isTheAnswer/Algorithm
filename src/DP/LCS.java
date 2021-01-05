// https://medium.com/javascript-in-plain-english/dynamic-programming-made-simple-part-2-longest-common-subsequence-7059862431c5
package DP;

import java.util.Arrays;

class LCS {
    
    public static void main(String[] args) {

        String s1 = "FISH";
        String s2 = "FOSH";
        // ACAYKP와 CAPCAK

        int result = lcs(s1, s2);
        System.out.println(result);

    }

    // DP
    public static int lcs(String s1, String s2) {
        int[][] cell = new int[s1.length()+1][s2.length()+1];

        // i for fish and j for fosh
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    // i.e. Bring the maximum lcs which doesn't include str1.charAt(i) and str2.charAt(j)
                    cell[i+1][j+1] = cell[i][j] + 1;
                } else {
                    // e.g. which lsc between fis and fos vs lsc between fish and fo is larger?
                    cell[i+1][j+1] = Integer.max(cell[i][j+1], cell[i+1][j]); // Longest Common Subsequence
                    // cell[i+1][j+1] = 0; // Longest Common Substring
                }
            }
        }
        
        printCell(cell);
        String lcsString = lcsString(s1, s2, cell);
        System.out.println(lcsString);

        return cell[s1.length()][s2.length()];

    }

    private static void printCell(int[][] cell) {
        for (int[] i : cell) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }

    // For LCSubsequence 
    private static String lcsString(String str1, String str2, int[][] lcsMatrix) {
        StringBuilder lcs = new StringBuilder();
        int i = str1.length(), j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (lcsMatrix[i - 1][j] > lcsMatrix[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs.reverse().toString();
    }

}
// Substring vs Subsequence: Subsequence presents gap while substring doesn't. 
// Subsequence: the number of letters in a sequence that the two words have in common.