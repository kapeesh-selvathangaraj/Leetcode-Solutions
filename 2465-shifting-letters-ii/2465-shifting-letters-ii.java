class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffarray = new int[n];

        for(int[] shift : shifts)
        {
            if(shift[2] == 1)
            {
                diffarray[shift[0]]++;

                if(shift[1] + 1 < n)
                {
                    diffarray[shift[1] + 1]--;
                }
            }
            else
            {
                diffarray[shift[0]]--;
                
                if(shift[1]+1 < n)
                {
                    diffarray[shift[1] + 1]++;
                }
            }
        }

        StringBuilder res = new StringBuilder(s);
        int numofshifts = 0;

        for(int i=0;i<n;i++)
        {
            numofshifts = (numofshifts + diffarray[i]) % 26;

            if(numofshifts<0)
            {
                numofshifts += 26;
            }

            char shifted = (char)('a' + ((s.charAt(i) - 'a' + numofshifts) %26));
            res.setCharAt(i,shifted);
        }
        return res.toString();
    }
}