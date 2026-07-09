class Solution {
    /* let y = √x 
      y^2 = x
      taking log on both sides
      2 ln y = ln x
      ln y = 1/2 ln x
      ln y = 0.5 ln x
      change into exponential
      y = √x = e^(0.5 * ln x)   --> i directly use this formula 

      ex: x = 16
      y = e^(0.5 * ln(16));
      y = 3.9999999999  due to floating point number the result may become wrong
      so we change it into integer
      y = 3
      so we also check the next integer
      right = y + 1 = 4

      then check 
      if right^2 > x then directly return y, other wise return right
          4^2 > 16  it is false then we return right '4'
      

    */ 

    public int mySqrt(int x) {
        double log = Math.log(x);  // find the log of x
        int y = (int) Math.exp(0.5 * log);  // find the exponential and change into integer
        int right = y + 1;

        return (long)right * right > x ? y : right;   // long prevent integer overflow
    }
}