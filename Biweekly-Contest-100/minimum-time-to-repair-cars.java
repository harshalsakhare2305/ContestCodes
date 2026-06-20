class Solution {

    public boolean isPossible(long mid,int cars,int[] ranks){

        long  totalCars=0;

        for(int i=0;i<ranks.length;i++){
            long added = (long)Math.floor(Math.sqrt(((double) mid/ranks[i])));

            totalCars+=added;
        }

        return totalCars>=cars;
       
    }
    
    public long repairCars(int[] ranks, int cars) {
        long sttime=1;
        long endtime = (long)1e14;
         Arrays.sort(ranks);

        long ans=-1;

        while(sttime<=endtime){
            long midtime = sttime+ (endtime-sttime)/2;

            if(isPossible(midtime,cars,ranks)){
                ans=midtime;
                endtime=midtime-1;
            }else{
                sttime=midtime+1;
            }
        }

        return ans;
    }
}©leetcode
