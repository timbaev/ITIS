package HW_17november;

import java.util.Scanner;

/**
 * Created by Timbaev on 23.11.2016.
 */
public class Dynasty {

    private static int dynastyEnter;
    private static int sum = 0;
    private static int multiplyer = 9;
    private static int tmp = 1;

    public static void main(String[] args) {
        int startDynasty = 2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of dynasty: ");
        dynastyEnter = scanner.nextInt();
        System.out.println(countOfChildren(startDynasty));
    }

    private static int countOfChildren(int dynasty) {
        if (dynastyEnter >= dynasty) {
            if (dynasty % 2 == 0) {
                multiplyer++;
                tmp *= multiplyer;
                sum += tmp;
                return countOfChildren(++dynasty);
            } else {
                multiplyer -= 2;
                tmp *= multiplyer;
                sum += tmp;
                return countOfChildren(++dynasty);
            }
        } else {
            return sum;
        }
    }
}
