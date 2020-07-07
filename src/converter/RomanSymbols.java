package converter;

import java.util.HashMap;
import java.util.Map;

enum RomanSymbols {
    I {
        @Override
        int value() {
            return 1;
        }
    },
    V {
        @Override
        int value() {
            return 5;
        }
    },
    X {
        @Override
        int value() {
            return 10;
        }
    },
    L {
        @Override
        int value() {
            return 50;
        }
    },
    C {
        @Override
        int value() {
            return 100;
        }
    },
    D {
        @Override
        int value() {
            return 500;
        }
    },
    M {
        @Override
        int value() {
            return 1000;
        }
    };

    public static Map<Character, RomanSymbols> symbols = new HashMap<>();

    static {
        symbols.put('I', I);
        symbols.put('V', V);
        symbols.put('X', X);
        symbols.put('L', L);
        symbols.put('C', C);
        symbols.put('D', D);
        symbols.put('M', M);
    }


    int value() {
        return 0;
    }

    public static RomanSymbols[] define(String string) {
        RomanSymbols[] result = new RomanSymbols[string.length()];
        for (int i = 0; i < string.length(); i++) {
            result[i] = symbols.get(string.charAt(i));
        }
        return result;
    }
}
