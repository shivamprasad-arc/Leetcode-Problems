class Solution {
    public int dayOfYear(String date) {
        // extract day, month and year from the given String in integer form
        // substring(0, 4) takes characters from index 0 to 3.
        // Example: "2019-02-10" → "2019"
        // Integer.parseInt() converts the String "2019" into integer 2019. 
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        // number of days in each month
        // days[0] = number of days in January
        // days[1] = number of days in Feb

        // days[11] = number of days in DEC
        int days[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        // leap year case: in Feb number of days is 29
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            days[1] = 29;
        }

        // Initially, result contains the number of days in the current month.
        int result = day;

        // add the number of days of all months that comes before current month
        for(int i = 0; i < month - 1; i++){
            result += days[i];
        }


        return result;
    }

    
}