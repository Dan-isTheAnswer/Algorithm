// https://www.acmicpc.net/problem/11052
package Greedy;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Greedy Algorithm 
class ID11052 {

    public static void main(String[] args) throws IOException {
        int n = 5; // ans is 14.
        int[] input = {1, 6, 8, 12, 10};
        
        int[] values = new int[input.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = input[i] *10 / (i+1); // avoid floating point values
        }

        int result = calcMaxVal(n, values, input); // BreakPonint*
        System.out.println(result);
    }

    public static int calcMaxVal(int n, int[] values, int[] input) {
        Map<Integer, Integer> sortedVal = treeInReversedOrder(values);
        Set<Integer> kSet = sortedVal.keySet();
        
        int tmp = n;
        int max = 0;
        for (int i = 0; i < n; i++) { // BP*
            for (Iterator<Integer> it = kSet.iterator(); it.hasNext();)  {
                int val = it.next();
                int num = sortedVal.get(val);
                if (tmp >= num) {
                    tmp -= num;
                    max += input[num-1];
                    break; // BP*
                }
    
            }
            if (tmp == 0) break; // BP*
        }

        System.out.println("tmp: " + tmp);
        System.out.println("max: " + max);
        return max;
    }

    private static Map<Integer, Integer> treeInReversedOrder(int[] values) {
        Map<Integer, Integer> tree = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < values.length; i++) {
            tree.putIfAbsent(values[i], i+1); // value for card1; value for card2 ...
        }

        return tree; //BP*
    }
}

//   
/**
 * Greedy Alogirhtm only works if not it compares with remaining.
 * Thus, DP required. 
 * 
 * (p.s. If you figured out what algorithm the problem asks you, you should follow up the intention
 *  so that you may encounter less obstalcles. If you couldn't figure out, then, think by yourself!)
 */