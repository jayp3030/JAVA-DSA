// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
// Return the kth positive integer that is missing from this array.

// Example 1:
// Input: arr = [2,3,4,7,11], k = 5
// Output: 9
// Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

// Example 2:
// Input: arr = [1,2,3,4], k = 2
// Output: 6
// Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

class Solution {
    public int findKthPositive(int[] arr, int k) {
        
    // if every element in the array > k , the answer would be k.
    // eg. - [5,6,7,8] , k = 2 ; so missing number = 2
    // So, for every element <= k , we need to increment k.
    
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] <= k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }
}