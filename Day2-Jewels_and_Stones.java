class Solution {
    public int numJewelsInStones(String J, String S) {
        char s[] = S.toCharArray();
        int jewl = 0;
        for(char c : s){
            if(J.indexOf(c)!=-1){
                jewl++;
            }
        }
        return jewl;
    }
}
