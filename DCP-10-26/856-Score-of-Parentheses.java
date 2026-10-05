class Solution {
    public int scoreOfParentheses(String s) {
        int co=-1;
        int ans=0;
        boolean b=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                co++;
                b=true;
            }
            if(s.charAt(i)==')'){
                if(b)
                {
                    ans+=Math.pow(2,co);
                    b=false;
                }

                co--;
            }
        }
        return ans;

    }
}