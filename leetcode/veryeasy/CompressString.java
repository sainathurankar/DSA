package leetcode.veryeasy;

public class CompressString {
    public static void main(String[] args) {
        String s = "a11b2c1";
        String decompressed = decompress(s);
        System.out.println(decompressed);
        String compressed = compress(decompressed);
        System.out.println(compressed);
    }

    private static String compress(String s) {
        int end = 1;
        int start = 0;
        StringBuilder result = new StringBuilder();

        while (end < s.length()) {
            char c = s.charAt(start);

            while (end < s.length() && s.charAt(end) == c) {
                end++;
            }

            result.append(c).append(end - start);
            start = end;
        }

        return result.toString();
    }

    private static String decompress(String s) {
        int end = 0;
        StringBuilder result = new StringBuilder();

        while (end < s.length()) {
            char c = s.charAt(end);
            end++;
            int count = 0;

            while (end < s.length() && Character.isDigit(s.charAt(end))) {
                count = (count * 10) + (s.charAt(end) - '0');
                end++;
            }
            for (int i=0; i<count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
