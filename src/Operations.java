import converter.ArabicToRoman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static converter.RomanNumbers.isRoman;
import static converter.RomanNumbers.convertToArabic;


public class Operations {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void calculate() throws IOException {
        System.out.println("Input: \n");
        String value = "";
        value = reader.readLine();
        int result = 0;

        String number1 = null;
        String number2 = null;
        char operation = 0;

        for (int i = 0; i < value.length(); i++) {
            switch (value.charAt(i)) {
                case '+':
                    operation = '+';
                    number1 = value.substring(0, i);
                    number2 = value.substring(i + 1);
                    break;
                case '-':
                    operation = '-';
                    number1 = value.substring(0, i);
                    number2 = value.substring(i + 1);
                    break;
                case '*':
                    operation = '*';
                    number1 = value.substring(0, i);
                    number2 = value.substring(i + 1);
                    break;
                case '/':
                    operation = '/';
                    number1 = value.substring(0, i);
                    number2 = value.substring(i + 1);
                    break;
            }
            if (operation != 0)
                break;
        }

        String numberRegex = "[+-]?\\d+";

        if (number1.matches(numberRegex) && number2.matches(numberRegex)) {
            result = integerCalc(number1, number2, operation);
            System.out.println("Output: \n" + result);
        } else if (isRoman(number1) && isRoman(number2)) {
            result = romanCalc(number1, number2, operation);
            String rNum = ArabicToRoman.intToRoman(result);
            System.out.println("Output: \n" + rNum);
        } else if (number1.matches(numberRegex) &&  isRoman(number2)){throw new NumberFormatException("Wrong format!");}
          else if(isRoman(number1) && number2.matches(numberRegex)) {throw new NumberFormatException("Wrong format!");}
    }

    private int integerCalc(String number1, String number2, char operation) {
        int val1 = Integer.parseInt(number1);
        int val2 = Integer.parseInt(number2);
        if(val1 > 10 || val2 > 10 || val1 < 1 || val2 < 1){
            throw new IllegalArgumentException("Out of range!");}

        switch (operation) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                return val1 / val2;
        }

        return 0;
    }

    private int romanCalc(String number1, String number2, char operation) {
        int val1 = convertToArabic(number1);
        int val2 = convertToArabic(number2);
        if(val1 > 10 || val2 > 10 || val1 < 1 || val2 < 1){
            throw new IllegalArgumentException("Out of range!");}
        switch (operation) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                return val1 / val2;
        }

        return 0;
    }
}
