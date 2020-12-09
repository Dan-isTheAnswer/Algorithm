package IntroductionToCodingTests;

import java.io.*;
import java.util.StringTokenizer;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        // I am going to read three items:)
        
        /* Tools for Input and Output
         * 1) BufferedReader
         * br is useless until br.readLine().
         * 
         * 2) StringTokenizer
         * st divides input by delimiter such as \n 
         * and the divided results are called tokens. 
         * 
         * 3) StringBuiler
         * sb appends results.
        */

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       
        int i = 3;
        while(i-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken());
            sb.append(st.nextToken());
            sb.append(" ");
        }

        System.out.println(sb);

    }
}
/* input: 
 * 1 3 
 * 2 4
 * 7 9
*/

/* output:
 * 13 24 79
 */