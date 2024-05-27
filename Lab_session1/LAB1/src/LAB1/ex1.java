package LAB1;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class ex1 {
    public static int readfromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 3 for the operations and 4 if you wish to exit: ");
        int number = scanner.nextInt();
        return number;
    }

    public static void main(String[] args) {
        int r1, r2;
        int img1, img2;

        r1 = 2;
        img1 = 5;
        r2 = 4;
        img2 = -1;

        System.out.println("c1 = " + r1 + " + " + img1 + "i");
        System.out.println("c2 = " + r2 + " + " + "(" + img2 + ")" + "i");
        System.out.println("For the complex numbers c1 and c2 choose from the following operations: ");
        System.out.println(" 1.Addition\n 2.Subtraction\n 3.Multiplication ");

        int opt = 1;
        while(opt!=4) {
            switch (readfromConsoleInt()) {
                case 1: {
                    int sum1 = 0, sum2 = 0;
                    sum1 = r1 + r2;
                    sum2 = img1 + img2;
                    System.out.println("result = " + sum1 + " + " + sum2 + "i");
                    break;
                }
                case 2: {
                    int sub1 = 0, sub2 = 0;
                    sub1 = r1 - r2;
                    sub2 = img1 - img2;
                    System.out.println("result = " + sub1 + " + " + sub2 + "i");
                    break;
                }
                case 3: {
                    int mul1 = 0, mul2 = 0;
                    mul1 = r1 * r2 - img1 * img2;
                    mul2 = r1 * img2 + img2 * r2;
                    System.out.println("result = " + mul1 + " + " + mul2 + "i");
                    break;
                }
                case 4: {
                    opt = 4;
                }
                default:
                    System.out.println("*ERROR* plz choose a number between 1 and 3");
                    break;
            }
        }
    }
}