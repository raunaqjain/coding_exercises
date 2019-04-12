package sorting;
import java.util.Scanner;

public class QuickSort {
	
	private static int partition(int[] ar, int b, int h) {
		int p = ar[h];
		int i=b, j=b;
		for (int k=b; k<=h; k++) {
			if (ar[k] <= p) {
				int temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
				i++;
				j++;
			}
			else {
				i++;
			}
		}
		
		return j - 1;
	}
	
	public static void quicksort(int[] ar, int b, int h) {
		if (b < h) {
			int p = partition(ar, b, h);
			quicksort(ar, b, p-1);
			quicksort(ar, p + 1, h);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] ar = new int[50];
		
		System.out.print("Enter size of the array: ");
		int size = scan.nextInt();
		
		System.out.println("Enter the elements of the array");
		for (int i = 0; i < size; i++)
			ar[i] = scan.nextInt();
		
		quicksort(ar, 0, size-1);
		System.out.print("\nSorted array is: ");
		for (int i = 0; i < size; i++)
			System.out.printf("%d ", ar[i]);
		
		scan.close();
	}
}
