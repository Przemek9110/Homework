package Exercise2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Date {
    private static final LocalDate TODAY = LocalDate.now();
    private static final Pattern DATE_PATTERN = Pattern.compile(
            "^((19|20)[0-9]{2})-(0[13456789]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$"     //general date structure
                    + "|^((19|20)([02468][048]|[13579][26]))-02-29$"                //leap year
                    + "|^((19|20)[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8])$"               //28 day February
                    + "|^((19|20)[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30)$"      //Months with 30days
    );

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No dates");
            System.exit(0);
        }
        int i=0;
        int count = 0;
        for (String arg : args) {
            if (matches(arg)) {
                count++;
            }
        }
        LocalDate[] localDates = new LocalDate[count];
        for (String arg : args) {
            if (matches(arg)) {
                localDates[i] = LocalDate.parse(arg);
                i++;

            }
        }
        if (localDates.length == 0) {
            System.out.println("All dates are incorrect");
            System.exit(0);
        }
        Arrays.sort(localDates);

        Period minPeriod = Period.between(localDates[0], TODAY);
        Period maxPeriod = Period.between(localDates[localDates.length - 1], TODAY);

        System.out.println("Maximum " + localDates[0] + " period " + minPeriod);
        System.out.println("Minimum " + localDates[localDates.length - 1] + " period " + maxPeriod);
    }

    public static boolean matches(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }
}