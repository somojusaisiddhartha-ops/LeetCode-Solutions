class Solution {
    public int maxProfit(int[] prices) {
        // int []a=new int[prices.length];
        int max=Integer.MIN_VALUE;
        int ans=0;
        for(int i=prices.length-1;i>=0;i--){
            max=Math.max(max,prices[i]);
            int sum=max-prices[i];
            ans=Math.max(ans,sum);
        }
        return ans;
        
    }
}