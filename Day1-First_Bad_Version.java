public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int highest = n,lowest = 1;
        while(highest>lowest){
            int medium = (highest-lowest);
            medium = medium/2+lowest;
            if(isBadVersion(medium)){
                highest = medium;
            }else{
                lowest = medium+1;
            }
        }
        if(isBadVersion(lowest))
            return lowest;
        else
            return -1;
    }
}
