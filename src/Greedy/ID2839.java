// https://www.acmicpc.net/problem/2839
package Greedy;

// Greedy Algorithm
class ID2839tmp4 {

    public static void main(String[] args) {
        int[] N = {18, 4, 6, 9, 11, 22};
        for (int i : N) {
            System.out.println("Result : " + howManyPackOfSugar(i));

        }
        // Scanner sc = new Scanner(System.in);
        // int N = sc.nextInt();
        // sc.close();


        // int result = howManyPackOfSugar(N);
        // System.out.println(result);
    }

    public static int howManyPackOfSugar(int n) {
        int ans = 0;
        boolean isMixed = false;

        if (n % 5 == 0) {
            ans = n/5;
            return ans;
        } else {

            int temp = n;
            int tmpoftmp = 0;
            for (int i = 0; i < n/3 && temp > 0; i++) {
                temp -= 5;
                
                if (temp % 3 == 0 && temp > 0) {
                    isMixed = true;
                    tmpoftmp= temp;
                    ans = i+1;
                }
            }
            ans = ans + tmpoftmp/3;
        } 

        if (isMixed) return ans;
        else if (n % 3 == 0) return n/3;
        else return -1;
    }

}
// minValue could be if n%5 == 0 || 5 and 3 mixed || n%3 == 0.
// n = 18, 4, 6, 9, 11, 22
/**
 * Greedy Algorithm is possible 
 * since only two items, which are 5 and 3, are available. 
 * If the number of items are many, inevitably move to DP.
 */