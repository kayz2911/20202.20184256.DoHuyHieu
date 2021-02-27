import java.util.Scanner;
public class Ex3 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the height: ");
		int n = keyboard.nextInt();
		for(int i = 0;i<n;i++) {
			for(int j = 1;j<= n-i-1;j++) {
				System.out.print(" ");
			}
			for(int j = 1;j<=2*i+1;j++) {
				System.out.print("*");
			}
			for(int j = 2*i+2;j<= n;j++) {
				System.out.print(" ");
				
			}
			System.out.println();
		}
	}
}