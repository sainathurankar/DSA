package leetcode.veryeasy;

public class ReverseString {


    public static void main(String[] args) {
        String A = " the sky is blue ";
        System.out.println(A);
        System.out.println(new ReverseString().solve(A));
    }

    public String solve(String A) {
        StringBuilder ans = new StringBuilder();
        String[] arr = A.split(" ", -1);
        for (int i = 0; i < arr.length; i++) {
            ans.append(arr[arr.length - 1 - i]);
            if (i != arr.length - 1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}
