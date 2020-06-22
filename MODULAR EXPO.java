import java.io.*; 
  
class GFG { 
      
   
       (x^y)%p in O(log y) */
    static int power(int x, int y, int p) 
    { 
       
        int res = 1;      
         
         
        
        x = x % p;  
  
       if (x == 0) return 0; // In case x is divisible by p;    
  
        while (y > 0) 
        { 
            // If y is odd, multiply x 
            // with result 
            if((y & 1)==1) 
                res = (res * x) % p; 
      
            // y must be even now 
            // y = y / 2 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
    } 
  
   
    public static void main(String args[]) 
    { 
        int x = 2; 
        int y = 5; 
        int p = 13; 
        System.out.println("Power is " + power(x, y, p)); 
    } 
}
