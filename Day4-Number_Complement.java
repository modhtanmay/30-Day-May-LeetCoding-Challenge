// Given a positive integer num, output its complement number. 
// The complement strategy is to flip the bits of its binary representation.

// Example 1:

// Input: num = 5
// Output: 2

// Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

// Example 2:

// Input: num = 1
// Output: 0

// Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 

// Constraints:

// The given integer num is guaranteed to fit within the range of a 32-bit signed integer.
// num >= 1
// You could assume no leading zero bit in the integer’s binary representation.
// This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/

// Time complexity analysis
// O(1).

// Space complexity analysis
// O(1).
    
class Solution {
    public int findComplement(int num) {
        if(num<=0)
            return 1;
        
        //finding bits by doing log base 10 
        
        int bits = (int) (Math.log(num)/Math.log(2))+1; // converting in bits using log2(num) = log10(num)/log10(2) logarithm property.
        // For example, binary format of 5 is ‘101’, then ‘101’ ^ ‘111’ = ‘10’, which is 2. 
        // Then, we need to figure out length of input number’s binary format, 
        // which can be completed by (1<<bits)-1 can help to get the number used to XOR.
        
        int res = (1<<bits)-1; 
        int compl = num^res;
        return compl;
    }
}
