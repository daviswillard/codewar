package valid.palindrome;

public class Main {

    public static void main(String[] args) {
        Main kek = new Main();
        System.out.println("A man, a plan, a canal: Panama");
        System.out.println(kek.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("race a car");
        System.out.println(kek.isPalindrome("race a car"));
        System.out.println(" ");
        System.out.println(kek.isPalindrome(" "));
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        s = s.chars()
                .filter(ch -> Character.isDigit(ch) || Character.isAlphabetic(ch))
                .map(Character::toLowerCase)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i <= j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
