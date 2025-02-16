//https://leetcode.com/problems/separate-squares-i/
class Solution {
public:
    double separateSquares(vector<vector<int>>& squares) {
        double low = 0, high = 2e9;
        while(abs(high - low) > 1e-5) {
            double mid = (low + high)/2;
            double area = 0, tot = 0;
            for(auto& x : squares) {
                if(mid <= x[1]) {
                    tot += ((double)x[2]) * x[2];
                    continue;
                }
                else if(mid <= x[1] + x[2]) {
                    area += ((double)x[2]) * (mid - x[1]);
                    tot += ((double)x[2]) * x[2];
                }
                else{
                    area += ((double)x[2]) * x[2];
                    tot += ((double)x[2]) * x[2];
                }
            }
            if(area < tot/2) {
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
};
