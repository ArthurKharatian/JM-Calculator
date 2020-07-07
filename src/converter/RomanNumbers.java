package converter;

public class RomanNumbers {

    public static boolean isRoman(String number) {
        return number.matches("^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$");
    }

    public static int convertToArabic(String number) {

        if (!isRoman(number)) { throw new RuntimeException("Wrong data!");}
        int arabic = 0;
        RomanSymbols[] romanNumbers = RomanSymbols.define(number);

        for (int i = 0; i < romanNumbers.length; i++) {

            if (i < romanNumbers.length - 1)
                if (romanNumbers[i].value() < romanNumbers[i + 1].value()) {
                    arabic += romanNumbers[i + 1].value() - romanNumbers[i++].value();
                    continue;
                }

            arabic += romanNumbers[i].value();
        }

        return arabic;
    }

}
