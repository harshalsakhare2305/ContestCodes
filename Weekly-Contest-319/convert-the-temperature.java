//https://leetcode.com/contest/weekly-contest-319/problems/convert-the-temperature/
class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15 , (celsius*1.80+32.00)};
    }
}
