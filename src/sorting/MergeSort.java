package sorting;
import java.util.Scanner;

public class MergeSort {
	
	private static void merge(int[] ar, int l, int m, int h) {
		int size_l = m - l + 1;
		int size_r = h - m;
		int[] left = new int[size_l];
		int[] right = new int[size_r];
		
		for (int i=0; i<size_l; i++) 
			left[i] = ar[l + i];
		for (int i=0; i<size_r; i++)
			right[i] = ar[m+1 + i];
		
		int i = 0;
		int j = 0;
		int k = l;
		
		while (i<size_l && j<size_r) {
			if (left[i] < right[j]) {
				ar[k] = left[i];
				i++;
			}
			else {
				ar[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i<size_l) 
			ar[k++] = left[i++];
		while(j<size_r)
			ar[k++] = right[j++];
	}
	
	public static void mergesort(int[] ar, int l, int h) {
		if (l < h) {
			int m = (l + h) / 2;
			mergesort(ar, l, m);
			mergesort(ar, m + 1, h);
			merge(ar, l, m, h);
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
		
		mergesort(ar, 0, size-1);
		System.out.print("\nSorted array is: ");
		for (int i = 0; i < size; i++)
			System.out.printf("%d ", ar[i]);
		
		scan.close();
	}

}
