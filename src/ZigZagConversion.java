package src;

public class ZigZagConversion {
    public static void main(String[] args) {
        String inputStr = "PAYPALISHIRING";
        int numRows = 4;

        System.out.println(conversion(inputStr, numRows));
    }

    public static String conversion(String inputStr, int numRows) {
        int period = 2 * (numRows - 1);
        int inputStrLen = inputStr.length();

        if(period == 0) return inputStr;
        numRows = Math.min(numRows, inputStrLen); //updating numRows so not to exceed inputStr length

        int rows = 0;
        int offset = 0;
        StringBuilder resStr = new StringBuilder();

        while(rows < numRows) {
            int a = rows;
            resStr.append(inputStr.charAt(a));

            if(rows == 0 || rows == numRows - 1) { // for first and last row
                a += period;
                while (a < inputStrLen) {
                    resStr.append(inputStr.charAt(a));
                    a += period;
                }
            } else { // for every other row
                int b = period - offset;
                int c = offset;

                a += b;

                while ( a < inputStrLen){
                    resStr.append(inputStr.charAt(a));
                    a += c;

                    if( a < inputStrLen) {
                        resStr.append(inputStr.charAt(a));
                        a += b;
                    }
                }
            }
            offset += 2;
            rows++;
        }
        return resStr.toString();
    }
}