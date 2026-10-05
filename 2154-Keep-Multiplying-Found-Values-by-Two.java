class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> s=new HashSet<>();
        for(int x:nums)
        {
            s.add(x);
        }
        while(s.contains(original))
        {
            original=2*original;
        }
        return original;
        
    }
}