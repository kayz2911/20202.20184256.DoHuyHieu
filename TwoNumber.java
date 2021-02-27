import java.util.Scanner;
 
public class TwoNumber {
 
    public static void main(String[] args) {
      	Scanner scanner = new Scanner(System.in);
        
        System.out.println("num1: ");
        int firstNumber = scanner.nextInt();
        System.out.println("num2: ");
        int secondNumber = scanner.nextInt();
        if(secondNumber == 0) {
        	System.out.println("Wrong input of second number");
        }else {
        	int sum = firstNumber + secondNumber;
            System.out.println(firstNumber + " + " + secondNumber + " = " + sum);
             
            int difference = firstNumber - secondNumber;
            System.out.println(firstNumber + " - " + secondNumber + " = " + difference);
             
            int product = firstNumber * secondNumber;
            System.out.println(firstNumber + " * " + secondNumber + " = " + product);
            
            int quetion = firstNumber / secondNumber;
            System.out.println(firstNumber + " / " + secondNumber + " = " + quetion);
        }
    }
}
        