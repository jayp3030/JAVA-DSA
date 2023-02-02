class Sort{
    void BUbbleSort(int arr[]){

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
public class bubbleSort {
    public static void main(String[] args) {

        int arr[] = { 3,21,4,1,0,32,45};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");                           // output : 3 21 4 1 0 32 45 
        }
        System.out.println();

        Sort s = new Sort();

        s.BUbbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");                          // output : 0 1 3 4 21 32 45
        }
    }
}
