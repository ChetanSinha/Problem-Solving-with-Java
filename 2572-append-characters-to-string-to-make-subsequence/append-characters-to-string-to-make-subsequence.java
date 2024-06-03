class Solution {
    public int appendCharacters(String s, String t) {
        int sPtr = 0;
        int tPtr = 0;

        while (sPtr < s.length() && tPtr < t.length()) {
            if (s.charAt(sPtr) == t.charAt(tPtr)) {
                tPtr += 1;
            }
            sPtr += 1;
        }

        return t.length() - tPtr;
    }
}