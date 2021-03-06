/*
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0
*/

class Solution {
    public String removeKdigits(String num, int k) {
        
        // using greedy approach 
        
        // we will use Stack and push the elements in it
        
        // along with we will check the top stack element.
        
        // if the element to be pushed is less than the element at top of stack 
        
        // then pop the top element and push the lower one
        int size = num.length();
        
        if(k == size) return "0";
        
        Stack <Character> stack = new Stack();
        
        // adding nums to stack
        
        int count = 0;
        while(count < size){
            
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(count)){
                stack.pop();
                k--;
            }
            
            stack.push(num.charAt(count));
            count++;
            
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            char current_char = stack.pop();
            sb.append(current_char);
        }
        
        sb.reverse();
        
        //checking leading zeros and removing it
        
        while(sb.length()>1 && sb.charAt(0)=='0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
