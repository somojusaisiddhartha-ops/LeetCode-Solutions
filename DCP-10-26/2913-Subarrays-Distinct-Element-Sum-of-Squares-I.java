class Solution {
    public int sumCounts(List<Integer> nums) {
        HashSet<Integer> h=new HashSet<>();
        int sum=0;
        for(int i=0;i<nums.size();i++){
            for(int j=i;j<nums.size();j++){
                h.add(nums.get(j));
                sum+=h.size()*h.size();
            }
            h.clear();
        }
        return sum;
    }
}