// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21

class Solution {
    public int reverse(int x) {
        
        int temp = x;
        int reverseNum = 0;

        while(temp != 0){
            int remainder = temp%10;
            temp = temp/10;
            
            System.out.println(reverseNum);
            if(reverseNum > Integer.MAX_VALUE/10 || reverseNum < Integer.MIN_VALUE/10){
                return 0;
            }
            reverseNum = reverseNum*10 + remainder;
        }
        
        return reverseNum;
    }
}