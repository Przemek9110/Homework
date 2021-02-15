package Exercise1;

import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.print("Please enter miles: ");

            String miles = readValue();
            miles = valueCheck(miles);

            System.out.printf(miles + " mi \u2248 %.2f km", convert(miles));
        } else {
            String miles = args[0];
            miles = valueCheck(miles);

            System.out.printf(miles + " mi \u2248 %.2f km", convert(miles));
        }
    }

    public static String readValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public static double convert (String miles) {
        double formattedMiles = Double.parseDouble(miles);
        return formattedMiles* 1.609344;
    }

    public static String valueCheck(String miles) {
        boolean check = miles.matches("^\\d+(\\.\\d+)?$");
        if (!check) {
            do {
                System.out.println("Wrong value");
                System.out.print("Enter correct miles: ");
                miles = readValue();
                check = miles.matches("^\\d+(\\.\\d+)?$");
            } while (!check);
        }
        return miles;
    }
}