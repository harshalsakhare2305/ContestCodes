//https://leetcode.com/problems/sum-of-compatible-numbers-in-range-i/
class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int l=n-k;
        int r=n+k;
        int sum=0;
        for(int i=l;i<=r;i++){
            if(i>0 && (n & i) == 0 )sum+=i;
        }

        return sum;
    }
}
