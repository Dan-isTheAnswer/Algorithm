// https://www.acmicpc.net/problem/1946
package Greedy;

class ID1946 {
    
	public static void main(String[] args) {
        // int tc = 2;
        
        int n = 5;
        int[] records = new int[] {4, 2, 3, 1, 5};  
        int result = check(n, records); // ans is 4, 2, 1
        System.out.println(result);
        
    }

	public static int check(int n, int[] records) {
        int ans = 1;
        int previousWorstRecord = records[0];

        for (int i = 1; i < records.length; i++) {
            if (previousWorstRecord > records[i]) {
                previousWorstRecord = records[i];
                ans++;
            }
        }

        return ans;
	}
}
// Doc order is equal to index. Interview order is the value of each index.
// The rule is that at least one of the two results 
// must be better than the one who got better score than itself. (o)
// must be within (x)