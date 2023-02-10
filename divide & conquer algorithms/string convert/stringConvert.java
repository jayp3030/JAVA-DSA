// problem : 

// given to string S1 and S2
// convert S2 to S1 using delete , insert , replace ops
// find the minimum amount of ops required to convert s2 to s1

// ex - S1 = table
//      S2 = tgble
//      ops = 1            -> only replace g to a


public class stringConvert {

    public static int numberOfOperatios(String s1 , String s2 , int i1 , int i2){

        if (i1 == s1.length()) {
            return s2.length() - i2;
        }

        if (i2 == s2.length()) {
            return s1.length() - i1;
        }

        if (s1.charAt(i1) == s2.charAt(i2)) {
            return numberOfOperatios(s1, s2, i1+1, i2+1);
        }

        int deleteOps = 1 + numberOfOperatios(s1, s2, i1+1, i2);
        int insertOps = 1 + numberOfOperatios(s1, s2, i1, i2+1);
        int replaceOps = 1 + numberOfOperatios(s1, s2, i1+1, i2+1);

        return Math.min(deleteOps, Math.min(insertOps, replaceOps));
    }
    public static void main(String[] args) {

        String s1 = "table";
        String s2 = "tbres";

        System.out.println("Number of ops require to convert S2 = "+s2+" to S1 = "+s1+" is = "+numberOfOperatios(s1, s2, 0, 0));

        // Number of ops require to convert S2 = tbres to S1 = table is = 3
    }
}
