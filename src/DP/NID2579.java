package DP;

class NID2579 {
    static int[] ans = new int[301];
    
    public static void main(String[] args) {
        int n = 6;
        int[] inputs = {10, 20, 15, 25, 10, 20};
        dp(inputs, n);
    }
    
    // from Bottom to Top
    static void dp(int[] inputs, int n) {
    	ans[1] = inputs[0];
    	ans[2] = inputs[0]+inputs[1];
    	
    	for(int i = 3; i<=n; i++) {
    		ans[i] = Math.max(ans[i-3] + inputs[i-2] + inputs[i-1], ans[i-2] + inputs[i-1]);
    	}
    	System.out.println(ans[n]);
    }
}
