import java.util.Scanner;
public class Equation {
	public static void main(String[] args) {
		System.out.println("First task");
		System.out.println("ax + b = 0");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input a:");
		double a = scanner.nextDouble();
		System.out.println("Input b");
		double b = scanner.nextDouble();
		if(a == 0) {
			if(b == 0) {
				System.out.println("Equation has countless solutions.");
			}
			else {
				System.out.println("Equantion has no solution.");
			}
		}
		else {
			double result = (-1)*b/a;
			System.out.println("Root for first euqation:" + result);
		}
		System.out.println("Second task");
		
		System.out.println("a1*x + b1*y = c1");
		System.out.println("a2*x + b2*y = c2");
		System.out.println("Enter a1 : ");
		double a1 = scanner.nextDouble();
		System.out.println("Enter b1 : ");
		double b1 = scanner.nextDouble();
		System.out.println("Enter c1 : ");
		double c1 = scanner.nextDouble();
		System.out.println("Enter a2 : ");
		double a2 = scanner.nextDouble();
		System.out.println("Enter b2 : ");
		double b2 = scanner.nextDouble();
		System.out.println("Enter c2 : ");
		double c2 = scanner.nextDouble();
		double D = a1*b2 - a2*b1;
		double D1 = c1*b2 - c2*b1;
		double D2 = a1*c2 - a2*c1;
		if (D == 0) {
			if (D1 + D2 == 0) {
				System.out.println("The equation infinity roots");
			}else {
				System.out.println("The equation has no root ");
			}
		}else {
			double x = D1/D;
			double y = D2/D;
			System.out.println("The equation has an unique root (x,y) = (" + x + "," + y +")" );
			
		}
	
	}
	
}