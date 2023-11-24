package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 6;
        int month = 5;
        int year = 1992;
        System.out.println(collectBirthdays(year, month, day));

    }
    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate dateNowe = LocalDate.now();
        String data = "";
        int count = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - eee").
                localizedBy(new Locale("us"));
        while (true) {
            if (birthday.isAfter(dateNowe)) {
                break;
            }
            data = data + count + " - " + formatter.format(birthday) + System.lineSeparator();
            count++;
            birthday = birthday.plusYears(1);

        }
        return data;
    }
}
