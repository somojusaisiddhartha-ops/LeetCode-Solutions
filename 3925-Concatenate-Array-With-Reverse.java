class Solution {
    public int[] concatWithReverse(int[] nums) {
        int a[]=new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            a[i]=nums[i];
            a[(nums.length*2)-1-i]=nums[i];
        }
        return a;
    }
}