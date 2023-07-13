// Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

// Note:
// Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
// In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 

// Example 1:
// Input: n = 00000000000000000000000000001011
// Output: 3
// Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

// Example 2:
// Input: n = 00000000000000000000000010000000
// Output: 1
// Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.

// Example 3:
// Input: n = 11111111111111111111111111111101
// Output: 31
// Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;

        for( int i = 0 ; i < 32 ; i++){
            if((n&1) == 1) ans++;
            n>>=1;
        }
        return ans;
    }

    // example : 0000 0000 0000 0000 0000 0000 0000 0000 1010
    // after 1 iterration n&1 = 0   -> right shift by 1
    // after 2 iteration n&1 = 1    -> right shift by 1 , ans++
    // after 3 iteration n&1 = 0    -> right shift by 1
    // after 4 iteration n&1 = 1    -> right shift by 1 , ass++
    // so on ......
}