// Given an array of integers nums, sort the array in ascending order and return it.

// You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

// Example 1:

// Input: nums = [5,2,3,1]
// Output: [1,2,3,5]
// Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
// Example 2:

// Input: nums = [5,1,1,2,0,0]
// Output: [0,0,1,1,2,5]
// Explanation: Note that the values of nums are not necessairly unique.

class Solution {
    
    public int[] sortArray(int[] nums) {
        merge(nums,0,nums.length-1);
        return nums;
    }

    public static void merge(int arr[] , int low , int high){
        if(low < high){
            int mid = (low+high)/2;
            merge(arr , low , mid);
            merge(arr , mid+1 , high);
            mergeSort(arr , low , mid , high);
        }
    }

    public static void mergeSort(int arr[] , int low , int mid , int high){
      
        int n1=mid-low+1;
        int n2=high-mid;

        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];

        for(int p = 0 ; p<n1 ; p++){
            leftArr[p] = arr[p+low];
        }

        for(int q = 0 ;q<n2 ;q++){
            rightArr[q] = arr[mid+1+q];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while(i<n1 && j<n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }
            else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}