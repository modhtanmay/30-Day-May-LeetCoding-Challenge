class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        
        for(int i : nums){
            if(hm.containsKey(i)){
                hm.put(i,hm.get(i)+1);
            }else{
                hm.put(i,1);
            }
        }
        
        int limit = nums.length/2;
        int max = 0;
        
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            if(entry.getValue()>limit){
                max = entry.getKey();
            }
        }
        return max;
    }
}
