class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        int[]dp=new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1];
        dp[nums.length-2] = nums[nums.length-2];
        for (int i=nums.length-3;i>=0;i--) {
            int iMax=0;
            for (int j=i+2;j<nums.length;j++) {
                if (iMax<dp[j]) iMax=dp[j];
            }
            dp[i]=nums[i]+iMax;
        }
        return dp[0]>dp[1]?dp[0]:dp[1];
    }
}

********************************************

class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        int[]dp=new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1];
        dp[nums.length-2] = Math.max(nums[nums.length-2],nums[nums.length-1]);
        for (int i=nums.length-3;i>=0;i--) {
            /*int iMax=0;
            for (int j=i+2;j<nums.length;j++) {
                if (iMax<dp[j]) iMax=dp[j];
            }
            dp[i]=nums[i]+iMax;*/
            dp[i]=Math.max(nums[i]+dp[i+2],dp[i+1]);
        }
        return dp[0];
    }
}
