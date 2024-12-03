public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(palindromeNumber(12211));

    }

    private static boolean palindromeNumber(int number) {

        int reversedNumber = 0;
        while (number > reversedNumber) {
            reversedNumber = (reversedNumber * 10) + (number % 10);
            number = number / 10;
        }

        return (reversedNumber == number || reversedNumber / 10 == number);
    }


}
