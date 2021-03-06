// In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

// If the town judge exists, then:

// The town judge trusts nobody.
// Everybody (except for the town judge) trusts the town judge.
// There is exactly one person that satisfies properties 1 and 2.
// You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

// If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

// Example 1:

// Input: N = 2, trust = [[1,2]]
// Output: 2

// Example 2:

// Input: N = 3, trust = [[1,3],[2,3]]
// Output: 3

// Example 3:

// Input: N = 3, trust = [[1,3],[2,3],[3,1]]
// Output: -1

// Example 4:

// Input: N = 3, trust = [[1,2],[2,3]]
// Output: -1

// Example 5:

// Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
// Output: 3
 

// Note:

// 1 <= N <= 1000
// trust.length <= 10000
// trust[i] are all different
// trust[i][0] != trust[i][1]
// 1 <= trust[i][0], trust[i][1] <= N

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
