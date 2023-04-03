// Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

// You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

// Example 1:
// Input: num1 = "11", num2 = "123"
// Output: "134"

// Example 2:
// Input: num1 = "456", num2 = "77"
// Output: "533"

// Example 3:
// Input: num1 = "0", num2 = "0"
// Output: "0"

class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int num1Len = num1.length() - 1;
        int num2Len = num2.length() - 1;

        StringBuilder res = new StringBuilder();

        while( num1Len >=0 || num2Len >= 0){
            int n1 = (num1Len < 0) ? 0 : num1.charAt(num1Len) - '0';
            int n2 = (num2Len < 0) ? 0 : num2.charAt(num2Len) - '0';

            int sum = n1+n2+carry;

            res.append(sum%10);
            carry = sum/10;
            
            num1Len--;
            num2Len--;
        }
        if(carry == 1)
            res.append(carry);
        
        return res.reverse().toString();
    }
}
