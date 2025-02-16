//https://leetcode.com/problems/shortest-matching-substring/
import java.util.*;

class Solution {

    public int[] giveLPS(String s) {
        int[] ans = new int[s.length()];
        ans[0] = 0; 
        int i = 1, len = 0;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) { 
                len++;
                ans[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = ans[len - 1]; 
                } else {
                    ans[i] = 0;
                    i++;
                }
            }
        }
        return ans;
    }

    public void KMPAlgo(String text, String pattern, List<Integer> ls) {
        int[] lps = giveLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                ls.add(i - j);
                j = lps[j - 1]; 
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public int shortestMatchingSubstring(String s, String p) {
        String first = "", middle = "", last = "";
        int fstar = -1, lstar = -1;

        for (int i = 0; i < p.length(); i++) { 
            if (p.charAt(i) == '*') {
                if (fstar == -1) fstar = i;
                lstar = i;
            }
        }

        if (fstar != -1) {
            first = p.substring(0, fstar);
            middle = p.substring(fstar + 1, lstar);
            last = p.substring(lstar + 1);
        } else {
            first = p;
        }

        int f = first.length(), m = middle.length(), l = last.length();

        List<Integer> foccur = new ArrayList<>();
        List<Integer> moccur = new ArrayList<>();
        List<Integer> loccur = new ArrayList<>();

        if (f != 0) KMPAlgo(s, first, foccur);
        if (m != 0) KMPAlgo(s, middle, moccur);
        if (l != 0) KMPAlgo(s, last, loccur);

        int ans = Integer.MAX_VALUE;

        if (f != 0 && m != 0 && l != 0) {
            if (foccur.isEmpty() || moccur.isEmpty() || loccur.isEmpty()) return -1;

            int mi = 0, li = 0;
            for (int fi : foccur) {
                while (mi < moccur.size() && moccur.get(mi) < fi + f) mi++;
                while (li < loccur.size() && (mi >= moccur.size() || loccur.get(li) < moccur.get(mi) + m)) li++;

                if (mi < moccur.size() && li < loccur.size()) {
                    ans = Math.min(ans, loccur.get(li) + l - fi);
                }
            }
        } 
        else if (f == 0 && m != 0 && l != 0) {
            if (moccur.isEmpty() || loccur.isEmpty()) return -1;

            int li = 0;
            for (int mi : moccur) {
                while (li < loccur.size() && loccur.get(li) < mi + m) li++;

                if (li < loccur.size()) {
                    ans = Math.min(ans, loccur.get(li) + l - mi);
                }
            }
        } 
        else if (f != 0 && m == 0 && l != 0) {
            if (foccur.isEmpty() || loccur.isEmpty()) return -1;

            int li = 0;
            for (int fi : foccur) {
                while (li < loccur.size() && loccur.get(li) < fi + f) li++;

                if (li < loccur.size()) {
                    ans = Math.min(ans, loccur.get(li) + l - fi);
                }
            }
        } 
        else if (f != 0 && m != 0 && l == 0) {
            if (foccur.isEmpty() || moccur.isEmpty()) return -1;

            int mi = 0;
            for (int fi : foccur) {
                while (mi < moccur.size() && moccur.get(mi) < fi + f) mi++;

                if (mi < moccur.size()) {
                    ans = Math.min(ans, moccur.get(mi) + m - fi);
                }
            }
        } 
        else if (f != 0 && m == 0 && l == 0) {
            return foccur.isEmpty() ? -1 : f;
        } 
        else if (f == 0 && m != 0 && l == 0) {
            return moccur.isEmpty() ? -1 : m;
        } 
        else if (f == 0 && m == 0 && l != 0) {
            return loccur.isEmpty() ? -1 : l;
        } 
        else if (f == 0 && m == 0 && l == 0) {
            return 0;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
