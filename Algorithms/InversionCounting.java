import java.util.Arrays;

public class InversionCounting {
	public static void main(String[] args) {
		int array[] = {9, 6, 8, 4, 9, 6, 8, 4};
		int inversionCount = 0;
		System.out.println(Arrays.toString(array));
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] > array[j] && i < j) {
					System.out.printf("%d vs %d\n", array[i], array[i]);
					inversionCount++;
					System.out.printf("Count = %d\n", inversionCount);
				}
			}
		}

		System.out.println(inversionCount);
	}
}