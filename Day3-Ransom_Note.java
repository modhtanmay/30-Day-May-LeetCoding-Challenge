// Given an arbitrary ransom note string and another string containing letters from all the magazines, 
// write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

// Each letter in the magazine string can only be used once in your ransom note.

// Example 1:

// Input: ransomNote = "a", magazine = "b"
// Output: false
// Example 2:

// Input: ransomNote = "aa", magazine = "ab"
// Output: false
// Example 3:

// Input: ransomNote = "aa", magazine = "aab"
// Output: true


// Constraints:

// You may assume that both strings contain only lowercase letters.

// Using HashMap Concept

// Time Complexity : O(1)
// Space Complexity : O(N)


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(char chars : magazine.toCharArray()){
            if(hm.containsKey(chars)){
                hm.put(chars,hm.get(chars)+1);
            }else{
                hm.put(chars,1);
            }
        }
        for(char chars : ransomNote.toCharArray()){
            if(hm.containsKey(chars)){
                if(hm.get(chars)>1){
                    hm.put(chars,hm.get(chars)-1);
                }else{
                    hm.remove(chars);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
