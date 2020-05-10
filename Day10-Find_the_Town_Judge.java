class Solution {
    public int findJudge(int N, int[][] trust) {
        
        //here remember the judge does not trust anybody but everybody trusts judge
        // Eg: if x trust y, z trust y, and w trust y od here y is the judge.
        
        // use map to find the judge y->x,z,w
        
        int[] arr = new int[N];
        int[] trusted = new int[N];
        
        for(int i=0;i<trust.length;i++){
            int a = trust[i][0];
            int b = trust[i][1];
            
            arr[a-1]++;
            trusted[b-1]++;
        }
        
        for(int i=0;i<N;i++){
            if(arr[i]==0 && trusted[i] == N-1)
                return i+1;
        }
        
        return -1;
        
    }
}
