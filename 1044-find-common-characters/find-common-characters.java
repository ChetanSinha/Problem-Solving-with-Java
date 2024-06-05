class Solution {
    public List<String> commonChars(String[] words) {
        int[] chr = countFreq(words[0]);

        for (int i=1; i<words.length; i++) {
            chr = intersection(chr, countFreq(words[i]));
        }

        List<String> ans = new ArrayList<>();
        for (int i=0; i<26; i++) {
            for (int j=0; j<chr[i]; j++) {
                ans.add(Character.toString(('a'+i)));
            }
        }
        
        return ans;
    }

    public int[] intersection(int[] chr, int[] wordFreq) {
        for (int i=0; i<26; i++) {
            chr[i] = Math.min(chr[i], wordFreq[i]);
        }
        return chr;
    }

    public int[] countFreq(String word) {
        int[] chr = new int[26];
        Arrays.fill(chr, 0);
        for (int i=0; i<word.length(); i++) {
            int idx = word.charAt(i)-'a';
            chr[idx] = chr[idx] + 1;
        }
        return chr;
    }
    
}