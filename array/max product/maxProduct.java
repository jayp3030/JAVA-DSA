
public class maxProduct {
    public static void main(String[] args) {
        int arr[] = {10 ,30 ,40 ,25 ,60};
        int maxProduct = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]*arr[j]>maxProduct) {
                    maxProduct = arr[i]*arr[j];
                }
            }
        }
        System.out.print("Max product is : " + maxProduct);    //output : Max product is : 2400
    }
}
