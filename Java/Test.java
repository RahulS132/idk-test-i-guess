import java.util.Scanner;
public class Test{

    public static void main(String[] args){
        //Create a Scanner object to take input from user.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Var1: ");
        int a = input.nextInt();
        System.out.print("Enter Var2: ");
        int b = input.nextInt();
        System.out.print("Enter Var3: ");
        int c = input.nextInt();
        System.out.println("The 3 Integers are: " + a + " " + b + " " + c);
        System.out.printf("The 3 integers are %d %d %d %n",a ,b ,c);

        //Finding out the lagest of the 3 values
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        System.out.println("The maximum is " + max);

        //Finding the sum of the values
        int sum = a + b + c;
        System.out.println("The sum of 3 numbers are: " + sum);

        //Finding the average
        float average = sum / 3;
        System.out.println("The average is: " + average);

        //Finding the product
        int product = a * b * c;
        System.out.println("The product of 3 numbers is: " + product);
    }

}