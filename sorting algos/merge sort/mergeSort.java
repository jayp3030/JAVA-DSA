class Sort{
    void MergeSort(int arr[] , int left , int right){
        if (left<right) {
            int mid = (left+right)/2;
            MergeSort(arr, left, mid);
            MergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    void merge(int arr[] , int left , int mid , int right){
        int i = 0;
        int j = 0;
        int k = left;

        int n1 = mid-left+1;
        int n2 = right-mid;

        // temp arrays

        int [] leftArr = new int[n1];
        int [] rightArr = new int[n2];

        for (int l = 0; l < n1; l++) {
            leftArr[l]  = arr[left+l];
        }

        for (int l = 0; l < n2; l++) {
            rightArr[l]  = arr[mid+1+l];
        }

        while (i<n1 && j<n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k]=leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i<n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j<n2) {
            arr[k] = rightArr[j];
            j++;
            k++; 
        }
    }
}
public class mergeSort {
    public static void main(String[] args) {

        int arr[] = {3 ,21, 4, 1, 0, 32, 45, 30 };
        int left = 0;
        int right = arr.length -1;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");                          // output : 3 21 4 1 0 32 45 30
        }
        System.out.println();

        Sort ms = new Sort();
        ms.MergeSort(arr, left, right);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");                          // output : 0 1 3 4 21 30 32 45
        }
    }
}
