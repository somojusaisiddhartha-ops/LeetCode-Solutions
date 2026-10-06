class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c=0;
        int mc=0;
        for(int x:nums){
            if(x==1) c++;
            else c=0;
            mc=Math.max(c,mc);
        }
        return mc;
    }
}