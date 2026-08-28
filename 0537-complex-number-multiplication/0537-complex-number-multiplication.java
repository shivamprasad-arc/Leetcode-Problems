class Solution {
    // Time complexity : O(N)
    // Space complexity: O(N)
    public String complexNumberMultiply(String num1, String num2) {
        // remove the last character 'i' by using substring() then split the real and imaginary part and store in a string array
        String[] a = num1.substring(0, num1.length() - 1).split("\\+");
        String[] b = num2.substring(0, num2.length() - 1).split("\\+");

        // convert real and imaginary part into integer using Integer.parseInt
        int real1 = Integer.parseInt(a[0]);
        int img1 = Integer.parseInt(a[1]);

        int real2 = Integer.parseInt(b[0]);
        int img2 = Integer.parseInt(b[1]);

        // (a + ib)*(c + id) = (ac + iad + icb + bd i^2)
        // (ac - bd) + (ad + cb)i
        // i.e, real part = (ac - bd) 
        int real = (real1 * real2)  - (img1 * img2);

        // img part = (ad + cb)
        int img = (real1 * img2) + (real2 * img1);

        return real + "+" + img + "i";

    }
}