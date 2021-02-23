// https://www.acmicpc.net/problem/1699
package DP;

class ID1699 {
    public static void main(String[] args) {
        // int n = 11;
        int n = 99999; // ans: 4
        // int n = 4;

        
        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = 1;

        // bottom to top
        for (int i = 2; i <= n; i++) {
            // init curr which consists of only 1
            int curr = i; 
            for (int j = 1; j*j <= i; j++) { 
                // **look for the min among the previous ones
                int tmp = d[i - j*j] + 1; 
                // compare them and update current if tmp is smaller 
                if(curr > tmp) curr = tmp; 
            }
            d[i] = curr;
        }
        System.out.println(d[n]);

    }
}

/**
 * Why d[i - 1^2] +1 and then d[i -2^2] +1 and so on,
 * rather then [i -1] and then [i -1 -1]?!?!
 * 
 * each plus 1 means the j factor. 
 * e.g. As in d[i -1^2] +1, +1 represents j factor
 * The same goes for all j. 
 * 
 */