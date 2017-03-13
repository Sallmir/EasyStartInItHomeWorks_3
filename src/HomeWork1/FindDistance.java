package HomeWork1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FindDistance {
    public static void main(String[] args) throws IOException {

        List<Integer> numbers = new ArrayList<Integer>();

        inputNumbers(numbers);

        System.out.println(numbers);

        minNumbers(numbers);

    }

    public static void inputNumbers(List<Integer> numbers) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = "0";

        System.out.println("Введите число: (для заввершения ввода наберите \"end\" ");
        while (!number.equals("end")){
            number = reader.readLine();
            if (checkString(number)) {
                numbers.add(Integer.parseInt(number));
            }
            else
                System.out.println("некоректное значение");
        }
    }

    public static boolean checkString(String chekingInput) {

        if (chekingInput == null || chekingInput.length() == 0) return false;

        int i = 0;
        if (chekingInput.charAt(0) == '-') {
            if (chekingInput.length() == 1) {
                return false;
            }
            i = 1;
        }

        char c;
        for (; i < chekingInput.length(); i++) {
            c = chekingInput.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static void minNumbers(List<Integer> numbers) {
        int min = numbers.get(0);
        int min2 = numbers.get(numbers.size()-1);
        int indEl = numbers.indexOf(min);
        int indEl2 = numbers.indexOf(min2);

        for (int i = 0; i < numbers.size(); i++) {
            min = (min > numbers.get(i)? numbers.get(i): min);
            indEl = numbers.indexOf(min);
//            min2 = (min2 > numbers.get(i) && indEl != i? numbers.get(i): min2);
//            indEl2 = numbers.indexOf(min2);
        }
        for (int i = 0; i < numbers.size(); i++) {

            if ((min2 > numbers.get(i)) && (indEl != i)) {
               min2 = numbers.get(i);
               indEl2 = i;
            }
      }

            System.out.println("Min = "+min + " - index - " + indEl);
            System.out.println("Min2 = "+min2 + " - index2 - " + indEl2);
            System.out.println("Разница -  "+Math.abs(indEl-indEl2));
    }
}

