import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BitwiseShift {

    static String getBinary(Integer number) {

        List<String> list = new ArrayList<String>();

        while (number != 0) {
            if (number % 2 == 0)
                list.add("0");
            else
                list.add("1");
            number = number / 2;
        }
        Collections.reverse(list);
        return String.join("", list);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Integer number, numberLeftShifted, numberRightShifted;
        number = scanner.nextInt();

        System.out.println("Number is " + number);
        System.out.println("Binary is " + getBinary(number));

        System.out.println("==Left shift by 2 bits==");
        numberLeftShifted = number << 2;

        System.out.println("Number is " + numberLeftShifted);
        System.out.println("Binary is " + getBinary(numberLeftShifted));

        System.out.println("==Right shift by 2 bits==");
        numberRightShifted = number >> 2;

        System.out.println("Number is " + numberRightShifted);
        System.out.println("Binary is " + getBinary(numberRightShifted));

    }

}
