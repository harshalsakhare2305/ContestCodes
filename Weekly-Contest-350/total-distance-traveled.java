//https://leetcode.com/problems/total-distance-traveled/
class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
      int ans=0;
      int petro =mainTank;

      while(mainTank>4){
        int kmsfact = mainTank / 5;  // How many time petro is added and kmsfact of petro suppose to be added
        ans+=(kmsfact*50); // calc dist 
        mainTank%=5;  // Find out much petro left now
        if(kmsfact<=additionalTank){  // is petro availablr in additional tank to refill
            additionalTank-=kmsfact;
        }else{
           kmsfact=additionalTank;
           additionalTank=0;
        }

        mainTank+=kmsfact; // refill the petrol
      }

      return ans+(mainTank%5)*10;

    }
}
