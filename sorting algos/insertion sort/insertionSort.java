class Sort{

    void InsertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;

            while (j>0 && arr[j-1]>temp) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
public class insertionSort {
    public static void main(String[] args) {
        int arr[] = { 3,21,4,1,0,32,45};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");                           // output : 3 21 4 1 0 32 45 
        }
        System.out.println();

        Sort is = new Sort();

        is.InsertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");                          // output : 0 1 3 4 21 32 45
        }
    }
}
