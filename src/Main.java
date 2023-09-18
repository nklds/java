import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String res = calc(input);
        System.out.println(res);
    }

    public static String calc(String input) throws Exception {
        String[] arr = findSymbolsOrFail(input);
        int first = Integer.parseInt(arr[0]);
        int second = Integer.parseInt(arr[2]);
        String symbol = arr[1];
        if (first < 1 || first > 10 || second < 1 || second > 10) throw new Exception();

        int res = 0;
        switch (symbol) {
            case "+":
                res = first + second;
                break;
            case "-":
                res = first - second;
                break;
            case "*":
                res = first * second;
                break;
            case "/":
                res = first / second;
                break;
        }

        return String.valueOf(res);
    }

    public static String[] findSymbolsOrFail(String input) throws Exception {
        Pattern pattern = Pattern.compile("^\\s*(\\d{1,2})\\s*([*/+-]+)\\s*(\\d){1,2}\\s*$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) throw new Exception();
        return new String[]{matcher.group(1), matcher.group(2), matcher.group(3)};
    }
}