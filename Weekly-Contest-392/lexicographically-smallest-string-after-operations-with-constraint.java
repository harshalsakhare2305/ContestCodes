//https://leetcode.com/problems/lexicographically-smallest-string-after-operations-with-constraint/
class Solution {
    public String getSmallestString(String s, int k) {
     
        char[] tarr = s.toCharArray();
        char[] sarr =s.toCharArray();

        int n=s.length();

        for(int i=0;i<n;i++){
            char ch=sarr[i];
            if(ch=='a')continue;

            if(ch>='b' && ch<='m'){
                int dist =(ch-'a');

                if(k>0 && dist<=k){
                   tarr[i]='a';
                    k-=dist;
                }else {
                    char c =(char)((int)ch-k);
                    tarr[i]=c;
                    k=0;
                }
                
            }else if(ch<='z' && ch>='n') {
                int dist = Math.abs((ch-'a') - 26);

                if(k>0 && dist<=k){
                   tarr[i]='a';
                    k-=dist;
                }else {
                    char c =(char)((int)ch-k);
                    tarr[i]=c;
                    k=0;
                }
            }

            if(k==0)return new String(tarr);
        }

        return new String(tarr);

        
    }
}
