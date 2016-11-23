package HW_17november;

import java.util.Scanner;

/**
 * Created by Timbaev on 23.11.2016.
 */
public class Dynasty {

    private static int dinastyEnter;
    private static int sum = 0;
    private static int multiplyer = 9;
    private static int tmp = 1;

    public static void main(String[] args) {
        int startDinasty = 2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of dinasty: ");
        dinastyEnter = scanner.nextInt();
        System.out.println(countOfChildren(startDinasty));
    }

    private static int countOfChildren(int dinasty) {
        if (dinastyEnter >= dinasty) {
            if (dinasty % 2 == 0) {
                multiplyer++;
                tmp *= multiplyer;
                sum += tmp;
                return countOfChildren(++dinasty);
            } else {
                multiplyer -= 2;
                tmp *= multiplyer;
                sum += tmp;
                return countOfChildren(++dinasty);
            }
        } else {
            return sum;
        }
    }
}
