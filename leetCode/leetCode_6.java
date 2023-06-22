// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"

// Write the code that will take a string and make this conversion given a number of rows:
// string convert(string s, int numRows);
 

// Example 1:
// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"

// Example 2:
// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
// P     I    N
// A   L S  I G
// Y A   H R
// P     I

// Example 3:
// Input: s = "A", numRows = 1
// Output: "A"

// ----------------------------------------------------------------------------------------------------------------------------------


// If the number of rows numRows is 1, return the string s as it is since there will be only one row in this case.

// Create a StringBuilder sb to store the resulting zig-zag pattern.

// Initialize the step variable to 2 * numRows - 2, which is the distance between two consecutive characters in the same row.

// For each row from 0 to numRows - 1:
// If the row is the first or the last row, add characters to the StringBuilder by skipping      characters in intervals of the step size.
// If the row is not the first or the last row, add characters to the StringBuilder by     alternating between two step sizes (one for moving up and the other for moving  down) until the end of the string is reached.

// Return the resulting string from the StringBuilder.

class Solution {
    public String convert(String s, int numRows) {
        if( numRows == 1 || s.length() == 1 ) return s;

        StringBuilder res = new StringBuilder();

        int steps = 2*numRows - 2;
        for(int i = 0 ; i < numRows ; i++){

            if(i == 0 || i == numRows-1){ // for first and last row
                for(int j = i ; j < s.length() ; j += steps) 
                    res.append(s.charAt(j));
            }
            else {  // for middlw rows
                int j = i;
                boolean flag = true;
                // one for moving up and the other for moving down (alternatively)
                int step1 = 2 * (numRows - 1 - i);  
                int step2 = steps - step1; 

                while( j < s.length()){

                    res.append(s.charAt(j));

                    if( flag ) j = j + step1;
                    else j = j + step2;

                    flag = !flag;
                }

            }
        }
        return res.toString();
    }
}