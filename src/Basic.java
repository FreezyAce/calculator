import java.util.Scanner;

public class Basic {
    public static void main(String[] args) {
        String value1;
        String value2;
        int value3 = 0;
        int value4 = 0;
        int res = 0;
        String operation = null;
        String[] rome = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        int[] arab = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte index = 0;

        System.out.println("Введите 2  целых числа: ");
        Scanner scanner = new Scanner(System.in);

        value1 = scanner.next();
        operation = scanner.next();
        value2 = scanner.next();

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

        if(value3 < 0 || value3 > 10 || value4 < 0 || value4 > 10 || index == 1){
            System.out.println("Error!!!");
            System.exit(0);
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
            System.out.println(convert(res));
        }
        else if (index == 0) {
            System.out.println(res);
        }
        else {
            System.out.println("Error!!!");
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
        number /=10;
        String convertThousands = ivanСollector(number%10, "M", "", "");

        String result = convertThousands + convertHundreds + convertTens + convertOnes;
        return result;

    }
}


