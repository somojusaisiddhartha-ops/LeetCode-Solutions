class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c=0;
        boolean r=true;
        for(int x:arr1){
            for(int y:arr2){
                if(Math.abs(x-y)<=d) r=false;
            }
            if(r) c++;
            r=true;
        }
        return c;
    }
}