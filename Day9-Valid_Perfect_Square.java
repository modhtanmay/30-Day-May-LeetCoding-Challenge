// Given a positive integer num, write a function which returns True if num is a perfect square else False.

// Note: Do not use any built-in library function such as sqrt.

// Example 1:

// Input: 16
// Output: true

// Example 2:

// Input: 14
// Output: false
// ------------------------------------------------------------------------------- //
        // method 1
        // brute force with complexity O(n/2)
        
        // if(num==1)
        //     return true;
        // for(int i=2;i<=num/2;i++){
        //     if(i*i==num)
        //         return true;
        // }
        // return false;
        
        // method 2
        // brute force with complexity O(sqrt(n))
        
        // for (int i = 0; (int64_t)i * i <= num; ++i) {
        //     if (i * i == num) return true;
        // }
        // return false;
        
        // method 3 Newton Iteration which runs at constant time
        // it uses derivative function like f'(x) of f(x) 
        // f(x) = x^2, f'(x) = 2x
        
        // if (num < 1) 
        //    return false;
        //   if (num == 1) return true;
        //   long t = num / 2;
        //   while (t * t > num) {
        //     t = (t + num / t) / 2;
        //   }
        //   return t * t == num;   
        
    // method 4 Efficient using Binary Search
    // time complexity O(logn)
    
    class Solution {
    public boolean isPerfectSquare(int num) {
        
        if(num < 0)
            return false;
        if(num <= 1)
            return true;
        long lef = 2;
        long rig = 100000;
        while(lef <= rig){
            long mid = (lef + rig)/2;
            long midsqr = mid * mid;
            if(midsqr == num) 
                return true;
            else if(midsqr>num)
                rig = mid - 1;
            else 
                lef = mid + 1;
        }
        return false;
    }
}
