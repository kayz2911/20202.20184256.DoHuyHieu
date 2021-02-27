import java.util.Scanner;
public class Ex6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input number row:");
		int row = scanner.nextInt();
		System.out.println("Input number column :");
		int column = scanner.nextInt();
		int a[][] = new int[20][20];
		int b[][] = new int[20][20];
		System.out.println("Input first matrix:");
		for(int i = 0;i < column;i++) {
			int t = i+1;
			for(int j = 0; j < row; j++) {
				int k = j+1;
				System.out.println("Input element at position a[" + t+"][" +k+"]:");
				a[i][j] = scanner.nextInt(); 
			}
		}
		System.out.println("Input second matrix:");
		for(int i = 0;i < column;i++) {
			int t = i+1; 
			for(int j = 0; j < row; j++) {
				int k = j+1;
				System.out.println("Input element at position b[" + t+"][" +k+"]:");
				b[i][j] = scanner.nextInt(); 
				b[i][j] += a[i][j];
			}
		}
		System.out.println("Sum of two matrix is:");
		for(int i = 0; i < column; i++) {
			for(int j = 0; j < row; j++) {
				System.out.print(b[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
}
