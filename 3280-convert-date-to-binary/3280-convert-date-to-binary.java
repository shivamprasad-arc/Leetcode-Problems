class Solution {
    public String convertDateToBinary(String date) {
        // split the date into YYYY MM DD and store individually year, month, and day into string array
        String YMD[] = date.split("-");
       
        // convert each peice directly into binary
       String yearBin = Integer.toBinaryString(Integer.parseInt(YMD[0]));
       String monthBin = Integer.toBinaryString(Integer.parseInt(YMD[1]));
       String dayBin = Integer.toBinaryString(Integer.parseInt(YMD[2]));

       return yearBin + "-" + monthBin + "-" + dayBin;
    }
}