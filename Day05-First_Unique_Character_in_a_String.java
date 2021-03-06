// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

// Examples:

// s = "leetcode"
// return 0.

// s = "loveleetcode",
// return 2.

//Note: You may assume the string contain only lowercase letters.


class Solution {
    public int firstUniqChar(String s) {
        
        int []count = new int[26];                // creating countArray to have index of character     
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;             // getting index and incrementing
        }
        
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'a']==1)         // now if the index is 1 then return that character index.
                return i;                         // stopped the further execution
        }
        
        return -1;                                // if not found return -1.
    }
}
