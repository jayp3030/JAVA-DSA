
public class isUnique {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,1,7,8,9};

        System.out.println(unique(arr));                //output:false
    }
    public static boolean unique(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]==arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
