//https://leetcode.com/contest/weekly-contest-481/problems/mirror-distance-of-an-integer/
class Solution {
    
    public int mirrorDistance(int n) {
        int reverse=0;
        int num=n;

        while(num>0){
            int r=num%10;
            reverse =reverse*10+r;
            num/=10;
        }

        return Math.abs(n-reverse);
    }
}©leetcode
