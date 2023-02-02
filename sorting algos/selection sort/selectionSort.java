class Sort {

    void SelectionSort(int arr[]){

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
public class selectionSort {
    public static void main(String[] args) {

        int arr[] = { 3,21,4,1,0,32,45};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");                           // output : 3 21 4 1 0 32 45 
        }
        System.out.println();

        Sort ss = new Sort();

        ss.SelectionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");                          // output : 0 1 3 4 21 32 45
        }
    }
}
