class Solution {

   

    public int rob(int[] nums) {


        /**
        Time Complexity: O(n), you're just scanning over the list one time
        Space Complexity: O(n), you only have your list
        */
        int n = nums.length;

        if (n==1) {return nums[0];}

        // dp[i] represents the maximum amount of money you can rob houses 0 ... i without alerting police
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            
            if (i == 0) {
                // you gotta rob this one
                dp[i] = nums[i];
            } else if (i == 1) {
                // either this one or the last one, you only seen 2 houses
                dp[i] = Math.max(dp[i-1], nums[i]);
            } else {
                // either skip (just take max rob value of last adj house) or rob this one (with max rob value of the one skipped over behind)
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
            
        }


        return dp[n-1];


        
    }
}
