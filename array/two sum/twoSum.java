
public class twoSum {
    
    public static void main(String[] args) {
        int arr[]= {2,3,4,7,5,10};
        int target = 9;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]+arr[j] == target) {
                    System.out.println("["+i+","+j+"]");      //output : [0,3] [2,4]
                }

            }
        }
        System.out.print("No solution found");
    }

}
