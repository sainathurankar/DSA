package leetcode.veryeasy;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.solve("abbaa"));
    }

    public int solve(String A) {
        // check palindrome
        int i = 0;
        int j = A.length() - 1;
        while (i < j) {
            if (A.charAt(i) != A.charAt(j)) {
                return 0;
            }
            i++;
        }
        return 1;
    }
}
