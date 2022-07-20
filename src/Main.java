import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите 2  целых числа: ");
        Scanner scanner = new Scanner(System.in);

        String scan = scanner.nextLine();

        System.out.println(calc(scan));
    }
    public static String calc(String input){
        String value1;
        String value2;
        int value3 = 0;
        int value4 = 0;
        int res = 0;
        String operation;
        String[] rome = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        int[] arab = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte index = 0;
        String[] mass = input.split(" ");

        if(mass.length != 3){
            return "Error";
        }

        value1 = mass[0];
        operation = mass[1];
        value2 = mass[2];

        if(!(operation.equals("+") || operation.equals("-") || operation.equals("/") || operation.equals("*"))){
            return "Error!!!";
        }

        for (int i = 0; i < rome.length; i++) {
            if (value1.equals(rome[i])) {
                value3 = arab[i];
                index++;
            }
        }

        for (int i = 0; i < rome.length; i++) {
            if (value2.equals(rome[i])) {
                value4 = arab[i];
                index++;
            }
        }

        if (index == 0) {
            value3 = new Integer(value1);
            value4 = new Integer(value2);
        }

        if (value3 <= 0 || value3 > 10 || value4 <= 0 || value4 > 10 || index == 1) {
            return "Error!!!";
        }

        if (operation.equals("+")) {
            res = value3 + value4;
        }
        if (operation.equals("-")) {
            res = value3 - value4;
        }
        if (operation.equals("*")) {
            res = value3 * value4;
        }
        if (operation.equals("/")) {
            res = value3 / value4;
        }
        if (index == 2) {
            if (res <= 0) {
                return "Error!!!";
            }
            return convert(res);
        } else if (index == 0) {
            String a = "" + res;
            return a;
        } else {
            return "Error!!!";
        }
    }
    public static String ivanСollector(int n, String one, String five, String ten){

        if(n >= 1)
        {
            if(n == 1)
            {
                return one;
            }
            else if (n == 2)
            {
                return one + one;
            }
            else if (n == 3)
            {
                return one + one + one;
            }
            else if (n==4)
            {
                return one + five;
            }
            else if (n == 5)
            {
                return five;
            }
            else if (n == 6)
            {
                return five + one;
            }
            else if (n == 7)
            {
                return five + one + one;
            }
            else if (n == 8)
            {
                return five + one + one + one;
            }
            else if (n == 9)
            {
                return one + ten;
            }
        }
        return "";
    }

    public static String convert(int number){
        String convertOnes = ivanСollector( number%10, "I", "V", "X");
        number /=10;
        String convertTens = ivanСollector( number%10, "X", "L", "C");
        number /=10;
        String convertHundreds = ivanСollector(number%10, "C", "D", "M");

        String result = convertHundreds + convertTens + convertOnes;
        return result;

    }
}
