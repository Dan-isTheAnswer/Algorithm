// https://www.acmicpc.net/problem/10809
package STR;

class ID10809 {

    public static void main(String[] args) {
        String input = "baekjoon";

        int[] answer = process(input);
        for (int e : answer) {
            System.out.print(e + " ");
        }
        System.out.println();

    }

    private static int[] process(String input) {
        int n = 'z' - 'a' +1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        for (int i = 0, e = 0; i < input.length(); i++, e++) {
            int index = input.charAt(i) - 'a';
            if (ans[index] == -1) {
                ans[index] = e;
            }
        }

        return ans;
    } 


}
