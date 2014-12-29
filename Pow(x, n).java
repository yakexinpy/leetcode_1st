public class Solution {
    public double pow(double x, int n) {
        if(n < 0)
            return 1/power(x, -n);
        else
            return power(x,n);
    }
    
    private double power(double x, int n){
        if(n == 0)
            return 1;
         double temp = power(x, n/2);
         if(n % 2 == 1)
            return temp * temp * x;
         else 
            return temp * temp;
    }
}
