//https://leetcode.com/problems/count-monobit-integers/
class Solution {
    public int countMonobit(int n) {
        int count=1;
       
        for(int i=0;i<11;i++){
            int num=2<<i;
            num-=1;
            if(num<=n)count++;
            else break;
     
        }
        return count;
    }

    
}
