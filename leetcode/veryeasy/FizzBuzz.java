package leetcode.veryeasy;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        FizzBuzz fb = new FizzBuzz();
        for (String s : fb.fizzBuzz(n)) {
            System.out.println(s);
        };
    }

    public String[] fizzBuzz(int A) {
        String[] result = new String[A];
        for (int i = 1; i <= A; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                result[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                result[i - 1] = "Buzz";
            } else {
                result[i - 1] = Integer.toString(i);
            }
        }
        return result;
    }
}
