import java.io.IOException;
import java.net.Inet4Address;
import java.nio.channels.FileLockInterruptionException;
import java.text.NumberFormat;
import java.lang.Integer;
import java.time.Instant;
import java.util.Scanner;


public class Main {

    public static void  main (String [] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение в формате a + b, с учетом пробелов");
        String m = in.nextLine();
        calc(m);
    }

    public static String calc(String input) throws Exception{
        String [] el = input.split(" ");
        Integer a, b, otvet = 0;
        try {
            if (el.length != 3) {
                throw new IOException();
            }
        } catch (IOException e) {
            System.out.println("Неверный формат ввода");
        }
        try {
            a = Integer.parseInt(el[0]);
            b = Integer.parseInt(el[2]);
            if ((a >= 0 && a <= 10) && (b >= 0 && b <= 10) ) {
                otvet = calculateA(input);
            }
            else
                throw new Exception("Введенные значения вне диапазона");
            System.out.println(otvet);
        }catch (Exception e){
            a = convertToArabic(el[0]);
            b = convertToArabic(el[2]);
            if ((a >= 0 && a <= 10) && (b >= 0 && b <= 10) ) {
                otvet = calculateR(input);
                System.out.println(convertToRome(otvet));
            }
            else
            throw new Exception("Введенные значения вне диапазона");
        }
        return String.valueOf(otvet);


    }

    public static Integer operator (String op, Integer x, Integer y){
        Integer result;
        switch (op){
            case "+":
                result = summator(x, y);
                break;
            case "-":
                result = minus(x, y);
                break;
            case "/":
                result = devide(x, y);
                break;
            case "*":
                result = multiply(x, y);
                break;
            default:
                throw new IllegalArgumentException("");
        }
        return result;
    }

    public static Integer calculateA(String args) throws IllegalArgumentException {
        Integer result, x, y;
        String[] preloader = args.split(" ");
        x = Integer.parseInt(preloader[0]);
        y = Integer.parseInt(preloader[2]);
        result = operator(preloader[1], x, y);

        return result;
    }

    public static Integer calculateR(String args) throws Exception {
        Integer result;
        String[] preloader = args.split(" ");
        Integer x = convertToArabic(preloader[0]);
        Integer y = convertToArabic(preloader[2]);
        result = operator(preloader[1], x, y);
                if (result <= 0) {
                    throw new Exception("Недопустимое значение числа");
                }
                return result;
        }

    private static Integer minus(Integer x, Integer y) {
        return x - y;
    }

    private static Integer devide(Integer x, Integer y) {
        return  x / y;
    }

    private static Integer multiply(Integer x, Integer y) {
        return x * y;
    }

    private static Integer summator(Integer x, Integer y) {
        return x + y;
    }

    private static Integer convertToArabic (String s){
        return Rome.valueOf(s).getConvertToArabic();

    }
    private static String convertToRome (Integer i){
        return Rome.arabicToRoman(i);
    }
}













