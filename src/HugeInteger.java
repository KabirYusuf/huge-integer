public class HugeInteger {

    private int[] numbers;

    public HugeInteger(String s) {
        this();
        this.parse(s);
    }

    public HugeInteger() {
        int ARRAY_LENGTH = 40;
        numbers = new int[ARRAY_LENGTH];
    }

    public static HugeInteger add(HugeInteger hugeIntegerOne, HugeInteger hugeIntegerTwo) {
        HugeInteger hugeInteger = new HugeInteger();
        int remainder = 0;
        int count = 39;
        while (count >= 0){
            int sum = hugeIntegerOne.numbers[count] + hugeIntegerTwo.numbers[count] + remainder;
            if (sum > 9 && count != 0)remainder = sumLengthGreaterThanOne(hugeInteger, count, sum);
            else remainder = sumLengthLessEqualOne(hugeInteger, count, sum);
            count --;
        }
        return hugeInteger;
    }

    private static int sumLengthLessEqualOne(HugeInteger hugeInteger, int count, int sum) {
        int remainder;
        hugeInteger.numbers[count] = sum;
        remainder = 0;
        return remainder;
    }

    private static int sumLengthGreaterThanOne(HugeInteger hugeInteger, int count, int sum) {
        int remainder;
        int div = sum / 10;
        int mod = sum % 10;
        hugeInteger.numbers[count] = mod;
        remainder = div;
        return remainder;
    }

    public static HugeInteger sub(HugeInteger hugeInteger1, HugeInteger hugeInteger2) {
        HugeInteger hugeInteger = new HugeInteger();
        int count = 39;
        while (count >= 0){
            int sub = 0;
            boolean isLessThan = hugeInteger1.numbers[count] < hugeInteger2.numbers[count];
            int borrow = 10;
            if (isLessThan && count != 0){
                hugeInteger1.numbers[count] += borrow;
                sub += hugeInteger1.numbers[count] - hugeInteger2.numbers[count];
                hugeInteger.numbers[count] = sub;
                hugeInteger1.numbers[count - 1] -= 1;
            }
            else if (isLessThan){
                sub += hugeInteger1.numbers[count] - hugeInteger2.numbers[count];
                hugeInteger.numbers[count] = sub;
            }
            else {
                sub += hugeInteger1.numbers[count] - hugeInteger2.numbers[count];
                hugeInteger.numbers[count] = sub;
            }
            count--;
        }
        return hugeInteger;
    }

    public static boolean isGreaterThan(HugeInteger hugeInteger1, HugeInteger hugeInteger2) {
        int sumHugeOne = 0;
        int sumHugeTwo = 0;
        for (int i = 0; i < 40; i++) {
            sumHugeOne += hugeInteger1.numbers[i];
            sumHugeTwo += hugeInteger2.numbers[i];
            if (sumHugeOne > sumHugeTwo)return true;
        }
        return false;

    }

    public static boolean isLessThan(HugeInteger hugeInteger1, HugeInteger hugeInteger2) {
        int sumHugeOne = 0;
        int sumHugeTwo = 0;
        for (int i = 0; i < 40; i++) {
            sumHugeOne += hugeInteger1.numbers[i];
            sumHugeTwo += hugeInteger2.numbers[i];
            if (sumHugeOne < sumHugeTwo)return true;
        }
        return false;
    }

    public static boolean isEqual(HugeInteger hugeInteger1, HugeInteger hugeInteger2) {
        for (int i = 0; i < 40; i++) {
            if (hugeInteger1.numbers[i] != hugeInteger2.numbers[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEqual(HugeInteger hugeInteger1, HugeInteger hugeInteger2) {
        boolean isNotEqual = false;
        for (int i = 0; i < 40; i++) {
            if (hugeInteger1.numbers[i] != hugeInteger2.numbers[i]){
                isNotEqual = true;
                break;
            }

        }
        return isNotEqual;
    }

    public void parse(String string) {
        if(string.length() > 40) throw new RuntimeException("Characters cannot exceed forty");
        else {
            for (int i = 0; i < string.length(); i++) {
                if (!Character.isDigit(string.charAt(i)))throw new NumberFormatException("Cannot contain letter");
                else characterToInt(string, i);
            }
        }
    }

    private void characterToInt(String string, int i) {
        char digit = string.charAt(i);
        int digitToInt = Integer.parseInt(String.valueOf(digit));
        numbers[i] = digitToInt;
    }

    public int[] getNumbers() {
        return numbers;
    }


    public String toString(){
        String numberToString = "";
        for (int number : numbers) {
            numberToString += number;
        }
        return numberToString;
    }
}
