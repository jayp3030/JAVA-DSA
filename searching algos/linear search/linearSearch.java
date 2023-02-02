class search{
    public int LinearSearch(int arr[] , int key){

        for (int i = 0; i < arr.length; i++) {
                if (arr[i] == key) {
                    System.out.println(key + " found at index "+ i);
                    return i;
                }
        }
        System.out.println(key + " not present in array");
        return -1;
    }
}
public class linearSearch {
    public static void main(String[] args) {

        int arr[] = { 5 , 3 , 6 , 8 , 11 , 34 , 56 , 90 , 1};

        search ls = new search();

        ls.LinearSearch(arr, 90);                                   // output : 90 found at index 7
        ls.LinearSearch(arr, 100);                                  // output : 100 not present in array
    }
}
