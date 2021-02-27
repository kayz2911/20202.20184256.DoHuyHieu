import java.util.Scanner;
import java.util.Arrays;
public class Ex5 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a[] = new int[100];
		System.out.println("Input number of element of the array:");
		int n = scanner.nextInt();
		double sum = 0;
		for(int i = 0; i < n; i++) {
			int t = i + 1;
			System.out.println("Input element "+ t + " of array: " );
			a[i] = scanner.nextInt();
			sum+= a[i];
		}
		Arrays.sort(a);
		double average = sum/n;
		System.out.println("Array after sorting: ");
		for(int i = 100-n;i<=99;i++) {
			System.out.print(a[i]+ ";");
		}
		System.out.println("");
		System.out.println("Sum of this array elements is: " + sum);
		System.out.println("The average value of array elements is: " + average);
	}
}
