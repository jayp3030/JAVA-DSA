// problem : 

// given  N
// find the way to express N in sum of 1 , 3 , 4 
// ex- N=4 - {4},{1,3},{1,1,1,1}

public class numberFactor {

    public static int wayToGetN(int N){

        if (N==0 || N==1 || N==2) {
            return 1;                                               // only one way possible
        }

        if (N==3) {
            return 2 ;                                              // two way possible - {1,1,1}{3}
        }
        
        int sub1 = wayToGetN(N-1);                                  // for N=4 ->wayToGetN(3)
        int sub2 = wayToGetN(N-3);                                  // for N=4 ->wayToGetN(1)
        int sub3 = wayToGetN(N-4);                                  // for N=4 ->wayToGetN(0)

        return sub1+sub2+sub3;
    }
    public static void main(String[] args) {
        
        System.out.println("way to get 4 is = "+wayToGetN(4));
        System.out.println("way to get 5 is = "+wayToGetN(5));
        System.out.println("way to get 6 is = "+wayToGetN(6));

        // output:
        // way to get 4 is = 4
        // way to get 5 is = 6
        // way to get 6 is = 9
    }
}
