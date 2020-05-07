class Solution {
    public int findComplement(int num) {
        if(num<=0)
            return 1;
        
        //finding bits by doing log base 10 
        int bits = (int) (Math.log(num)/Math.log(2))+1;
        int res = (1<<bits)-1;
        int compl = num^res;
        return compl;
    }
}
