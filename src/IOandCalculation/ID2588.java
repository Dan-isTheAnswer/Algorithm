// 곱셈
package IOandCalculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ID2588 {
    public static void main(String[] args) throws IOException {
        InputStreamReader r1 = new InputStreamReader(System.in);
        InputStreamReader r2 = new InputStreamReader(System.in);
        BufferedReader br1 = new BufferedReader(r1);
        BufferedReader br2 = new BufferedReader(r2);

        String aStr = br1.readLine(); int aNum = Integer.parseInt(aStr); 
        String bStr = br2.readLine(); int bNum = Integer.parseInt(bStr); 

        int first = aNum;
        int second = bNum;
        int third = bNum%10 /1 * aNum;
        int fourth = bNum%100 /10 * aNum;
        int fifth = bNum /100 * aNum;
        int sixth = aNum * bNum;
        
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);
        System.out.println(fifth);
        System.out.println(sixth);
    }
}

// Think of the cases with that bNum is 1, 12, 122, 1222. 