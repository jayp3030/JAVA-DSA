
public class missNum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,8,9,10};

        int sum1=0;

        for (int i = 0; i < arr.length; i++) {                        //sum of all element of above array
            sum1+=arr[i];
        }

        int sum2=10*(11)/2;                                          // sum of array containing 1 to 10 element if 1 to n then n(n+1)/2
        
        System.out.print("Missing element is: " +(sum2-sum1));       // output: missing element is: 7
    }
}
