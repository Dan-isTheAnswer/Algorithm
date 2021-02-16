package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class ID1339 {
    static int n;
    static String[] input;

    static ArrayList<Character> characters;
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) { 
        n = 2; 
        input = new String[] {"GCF", "ACDEB"}; 
        // input = new String[] {"AB", "BA"};
        // input = new Strint[] {"BC", "AA"};

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String word = input[i];
            for (int j = 0; j < word.length(); j++) {
                set.add(word.charAt(j));
            }
        }
        characters = new ArrayList<>(set);

        boolean[] used = new boolean[10];
        int result = dfs(0, used);
        System.out.println(result);
    }

    private static int dfs(int depth, boolean[] used) {
        if (depth == characters.size()) {
            int sum = calc();
            return sum;
        }

        int maxVal = -1;
        // 1 <= depth <= 10
        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                map.put(characters.get(depth), i); // **try every case. 
                maxVal = Integer.max(maxVal, dfs(depth + 1, used));
                used[i] = false; // **backtracking 
            }
        }

        return maxVal;
    }

    private static int calc() {

        int total = 0;
        for (int i = 0; i < input.length; i++) {
            int pos = 1;
            for (int j = input[i].length() -1; j >= 0; j--) {
                char c = input[i].charAt(j);
                total += map.get(c) * pos; 
                pos *= 10;
            }
        }
        return total;
    }
}

/**
 * !!Aha-moment
 * we just iterate over the set if we have a set of characters.
 * e.g. if depth is 5, 5*4*3*2*1 = 120 cases. 
 */