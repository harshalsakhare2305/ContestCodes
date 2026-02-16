
class Solution {

    int[] arr1;
    int[] arr2;

    int k;
    long[][][] dp;
    long INF=-(long)1e15;  //I am taking INF for checking my invalid take bus INF is also valid state so the recusion will get confused whether this state is calc or not and it will again calculate this
    //So take one extreemet fro invalid state 
     //How to calc the extreme 
     //max value of nums[i] is 1e6 so and size is k is 100 and  
      // so extreme is 1e6*1e6*1e2
      // it will any number greater than 1e14 
     
    int n;
    int m;

    public long rec(int i,int j,int k){

        if(k==0)return 0;
         
         if(i==n || j==m){
            if(k==0)return 0;
            return INF;
         }

         if(dp[i][j][k]!=INF)return dp[i][j][k];

        long take=((long)arr1[i]*arr2[j])+rec(i+1,j+1,k-1);

        long ntake1=rec(i+1,j,k);
        long ntake2=rec(i,j+1,k);

        return dp[i][j][k]=Math.max(take,Math.max(ntake1,ntake2));
    }
    public long maxScore(int[] nums1, int[] nums2, int m) {
        this.arr1=nums1;
        this.arr2=nums2;
        this.k=m;

        this.n=arr1.length;
        this.m=arr2.length;

        dp=new long[n][arr2.length][k+1];
        for(long[][]r2:dp){
            for(long[]r:r2){
                Arrays.fill(r,INF);
            }
        }

        return rec(0,0,k);


    }
}
