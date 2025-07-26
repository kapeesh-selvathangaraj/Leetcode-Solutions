class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        int res = 0;
        for (char ch : s.toCharArray())
            count[ch - 'a']++;
        for (char ch : t.toCharArray())
            count[ch - 'a']--;

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                res = count[i] + res;
            }
        }
        return res;
    }
}