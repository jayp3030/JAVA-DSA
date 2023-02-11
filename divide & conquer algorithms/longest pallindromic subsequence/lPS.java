
public class lPS {

    public static int countOfLPS(String s , int startIndex , int endIndex){

        if (startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            return 1;
        }

        int count1 = 0;

        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            return 2 + countOfLPS(s, startIndex+1, endIndex-1);
        }

        int count2 = countOfLPS(s, startIndex, endIndex-1);         // option-1 : take first characer from start and at end skip last and so on...
        int count3 = countOfLPS(s, startIndex+1, endIndex);         // option-2 : first skip character from start and continue with last element at end and so on...

        return Math.max(count1, Math.max(count2, count3));
    }
    public static void main(String[] args) {
        
        String s1 = "elrmenmet";

        System.out.println("Longest pallindromic subsequence = "+countOfLPS(s1, 0, s1.length()-1));

        // Longest pallindromic subsequence = 5   -> ememe
    }
}
