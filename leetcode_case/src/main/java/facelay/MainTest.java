package facelay;

public class MainTest {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int sum = sum(arr, 0);
		System.out.println("arr sum is: " + sum);
	}

	public static int sum(int[] arr, int l) {
		if (l == arr.length - 1) {
			return arr[l];
		}
		return arr[l] + sum(arr, l + 1);
	}

}
