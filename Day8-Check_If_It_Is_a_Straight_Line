// You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. 
// Check if these points make a straight line in the XY plane.

// Example 1:

// Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
// Output: true

// Example 2:

// Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
// Output: false
 

// Constraints:

// 2 <= coordinates.length <= 1000
// coordinates[i].length == 2
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
// coordinates contains no duplicate point.

// Hide Hint #1  
// If there're only 2 points, return true.

// Hide Hint #2  
// Check if all other points lie on the line defined by the first 2 points.

// Hide Hint #3  
// Use cross product to check collinearity.



// In this problem the matrix input is given where the rows can be n number but columns will be 2.

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        // First we will take all the matrix elements in an arrayList
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        
        for(int i=0;i<coordinates.length;i++){
            x.add(coordinates[i][0]);
        }
        for(int i=0;i<coordinates.length;i++){
            y.add(coordinates[i][1]);
        }
        
        // first checking vertical straight line where all x coordinate are same
        
        int x_count = 0;
        if(x.get(0) == x.get(1)){
            for(int i=0;i<x.size()-1;i++){
                if(x.get(i)==x.get(i+1))
                    x_count++;
            }
            if(x_count == x.size()-1)
                return true;
            else
                return false;
        }
         
        //Now we will calculate slope 'm' between two points using m = [(y2-y1)/(x2-x1)] || [(y1-y2)/(x1-x2)]
        // example (1,2) = (x1,y1) | (2,3) = (x2,y2) | slope = (3-2)/(2-1) = 1
        
        // then we will check if(y-y1) != m*(x-x1) then they are not in straight line.
        
        else{
            double slope = (y.get(0)-y.get(1))/(x.get(0)-x.get(1));
            for(int i=0;i<x.size();i++){
                if(y.get(i)-y.get(0) != slope * (x.get(i)-x.get(0)))
                    return false;
            }
            return true;
        }
    }
}
