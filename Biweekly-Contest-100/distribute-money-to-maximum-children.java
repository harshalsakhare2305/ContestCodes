class Solution {
    public int distMoney(int money, int children) {
        if (money < children) return -1;

        money -= children; // give $1 to every child

        int ans = Math.min(money / 7, children);

        money -= ans * 7;
        children -= ans;

        // all children got 8 but money still remains
        if (children == 0 && money > 0) {
            ans--;
        }
        // one child left and it would get exactly 4 dollars
        else if (children == 1 && money == 3) {
            ans--;
        }

        return ans;
    }
}
