class Sort{
    void QuickSort(int arr[] , int start , int end){
        if (start<end) {
            int  locOfPivot = partition(arr ,  start ,  end);       // it gives the position of pivot element
            QuickSort(arr, start, locOfPivot-1);
            QuickSort(arr, locOfPivot+1, end);
        }
    }

    int partition(int arr[] , int start , int end){

        int pivot = arr[start];
        int left = start;
        int right = end;

       while (left<right) {
            while (arr[left] <= pivot) {                            // move left pointer untill we found element greater than pivot
                left++;
            }
            while (arr[right] > pivot) {                            // move right pointer untill we found element less than pivot
                right--;
            }

            if (left< right) {                                      // then swap left and right
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
       }

       int temp = arr[right];                                       // swap right and pivot
       arr[right] = arr[start];
       arr[start] = temp;

       return right;
    }
}
public class quickSort {
    public static void main(String[] args) {
        int arr[] = {3 ,21, 4, 1, 0, 32, 45, 30 };
        int start = 0;
        int end = arr.length-1;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");                          // output : 3 21 4 1 0 32 45 30
        }
        System.out.println();

        Sort qs = new Sort();
        qs.QuickSort(arr, start, end);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");                          // output : 0 1 3 4 21 30 32 45
        }
    }
}
