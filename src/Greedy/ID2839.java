// https://www.acmicpc.net/problem/2839
package Greedy;

// Greedy Algorithm
class ID2839tmp4 {

    public static void main(String[] args) {
        int[] N = {18, 4, 6, 9, 11, 22};
        for (int i : N) {
            int a  = checkValidity(i);
            System.out.println("i is " + i + "; validity is " + a);
            System.out.println("Result : " + howManyPackOfSugar(a, i));

        }
    }

    private static int howManyPackOfSugar(int validity, int n) {
        int ans = 0;

        if (validity == 1) {
            ans = n/5;
        } else if (validity == 2) {
            int temp = n;
            int tempoftemp = 0;
            for (int i = 0; i < n/3 && temp > 0; i++) {
                temp -= 5;
                if (temp % 3 == 0 && temp >0) {
                    ans = i+1;
                    tempoftemp = temp;
                }
            }
            ans = ans + tempoftemp/3;
        } else if (validity == 3) {
            ans = n/3;
        } else {
            ans = -1;
        }

        return ans;

    }

    private static int checkValidity(int n) {
        int validity = 0;
        
        // case 1: n % 5 == 0; case 2: mixed; case 3: n % 3 ==0;
        if (n % 5 == 0) {
            validity = 1;
            return validity;
        }
         
        int temp = n;
        for (int i = 0; i < n/3; i++) {
            temp -= 5;
            if (temp % 3 == 0 && temp >0) {
                validity = 2;
                return validity;
            }
        }

        if (n % 3 == 0) {
            validity = 3;
            return validity;
        }

        validity = -1;
        return validity;
    }

}
// minValue could be if n%5 == 0 || 5 and 3 mixed || n%3 == 0.
// n = 18, 4, 6, 9, 11, 22
/**
 * Greedy Algorithm is possible 
 * since only two items, which are 5 and 3, are available. 
 * If the number of items are many, inevitably move to DP.
 */