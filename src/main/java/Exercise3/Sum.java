package Exercise3;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        if (args.length > 0) {      //numbers provided by run configuration
            for (String number : args) {
                if (checkFormat(number)) {
                    long sum = sumDigits(number);
                    System.out.println("For your number " + number + " sum of digits is: " + sum);
                } else {
                    System.out.println("Your number " + number + " is wrong");
                }
            }
        } else {        //numbers enter from keyboard
            String number;
            System.out.println("If you want stop program write \"exit\"\n");

            do {
                System.out.print("Please enter number for sum digits: ");
                number = readValue();
                if (checkFormat(number)) {
                    long sum = sumDigits(number);
                    System.out.println("For your number " + number + " sum of digits is: " + sum + "\n");
                } else if (!number.equals("exit")) {
                    System.out.println("Your number " + number + " is wrong \n");
                }
            } while (!number.equals("exit"));
        }
    }

    public static String readValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static long sumDigits(String number) {

        long num = Long.parseLong(number);
        long sum = 0;
        int i = 0;
        while (number.length() - i > 0) {
            sum = (num % 10) + sum;
            num = num / 10;
            i++;
        }
        if (sum < 0) {
            sum = Math.abs(sum);
        }
        return sum;
    }

    public static boolean checkFormat(String number) {
        return number.matches("^\\d+$" + "|^-\\d+$");
    }
}
