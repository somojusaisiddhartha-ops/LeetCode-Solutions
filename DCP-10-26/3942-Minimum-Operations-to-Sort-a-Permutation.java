class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int zero=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zero=i;
                break;
            }
        }
        boolean forward=true;
        boolean backward=true;
        for(int i=1;i<n;i++){
            int a=nums[(zero+i-1)%n];
            int b=nums[(zero+i)%n];
            if(a>b) forward=false;
            a=nums[(zero-i+1+n)%n];
            b=nums[(zero-i+n)%n];
            if(a>b) backward=false;
        }
        int ans=Integer.MAX_VALUE;
        if(forward){
            ans=Math.min(ans,zero);
            ans=Math.min(ans,n-zero+2);
        }
        if(backward){
            ans=Math.min(ans,zero+2);
            ans=Math.min(ans,n-zero);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}