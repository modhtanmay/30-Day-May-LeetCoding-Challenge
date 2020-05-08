// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
// You may assume that the array is non-empty and the majority element always exist in the array.

// Example 1:

// Input: [3,2,3]
// Output: 3

// Example 2:

// Input: [2,2,1,1,1,2,2]
// Output: 2


// Solution Using HashMap 

class Solution {
    public int majorityElement(int[] nums) {
        
        // Created HashMap
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        
        // Adding in HashMap with number of times it repeated
        for(int i : nums){
            if(hm.containsKey(i)){
                hm.put(i,hm.get(i)+1);
            }else{
                hm.put(i,1);
            }
        }
        
        // setting limit as arrays length divide by 2
        
        int limit = nums.length/2;
        int max = 0;
        
        // iterating through HashMap using entrySet and will fing the value of a key greater than limit
        
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            if(entry.getValue()>limit){
                max = entry.getKey();                               // stored in max variable
            }
        }
        return max;                                                 // returned majority element
    }
}
