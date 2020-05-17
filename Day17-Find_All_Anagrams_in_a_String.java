/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
       
        
        if(s.length() == 0 || s == null)
            return result;
        
        int []countChar = new int[26];
        char []p_array = p.toCharArray();
        
        for(char c : p_array) {
            countChar[c-'a']++;
        }
        
        // using boundry moving from left to right
        int left = 0;
        int right = 0; // end of the String s so we will go from right through left
        int count = p.length(); // as we need to find p anagram in String s
        
        while(right < s.length()){
            
            if(countChar[s.charAt(right++)-'a']-- >= 1)
                count--;
            if(count == 0)
                result.add(left);
            if(right - left == p.length() && countChar[s.charAt(left++)-'a']++ >=0)
                count++;
            
        }
        
        return result;
    }
}
