class Search{
    public int BinarySearch(int arr[] , int key , int start , int end){
        if (start <= end) {
            int mid = start+end/2;
            if (arr[mid] == key) {
                System.out.println(key +" found at index "+ mid);
                return mid;
                
            } else if (key<arr[mid]) {
                return BinarySearch(arr, key, start, end-1);
            } else {
               return BinarySearch(arr, key, start+1, end) ;
            }
        }
        System.out.println(key + " not found in array");
        return -1;

    }
}
public class binarySearch {
    public static void main(String[] args) {
        
        int arr[] = { 1,3,5,7,9,11,13,15,17};
        int start = 0;
        int end = arr.length -1;

        Search bs  = new Search();

        bs.BinarySearch(arr, 11, start, end);                       // ouput : 11 found at index 5
        bs.BinarySearch(arr, 10, start, end);                       // ouput : 10 not found in array
    }   
}
