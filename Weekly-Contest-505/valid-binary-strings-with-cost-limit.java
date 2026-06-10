// https://leetcode.com/contest/weekly-contest-505/problems/valid-binary-strings-with-cost-limit/
class Solution {

     List<String> ans ;

    public void rec(int idx,boolean isPrevZero,int cost,String s,int n,int k){
        if(idx== n && cost<=k){
            ans.add(s);
            return;
        }
         
        rec(idx+1,true,cost,s+"0",n,k);

        if(isPrevZero){
            s=s+'1';
            cost+=idx;
            if(cost<=k){
                rec(idx+1,false,cost,s,n,k);
            }
        }

        return;
    }
    public List<String> generateValidStrings(int n, int k) {
       ans=new ArrayList<>();

        rec(0,true,0,"",n,k);

        return ans;
        
    }
}
