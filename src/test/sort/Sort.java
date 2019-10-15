package test.sort;

import java.util.Arrays;

public class Sort {

	/*
	 * 选择排序
	 */
	public static void selectSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minIndex])
					minIndex = j;
			}
			if (minIndex != i) {
				int temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		}
	}

	/*
	 * ��������
	 */
	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int current = a[i];
			int temp = current;
			if (current >= a[i - 1])
				continue;
			if (current < a[0]) {
				for (int j = i; j > 0; j--) {
					a[j] = a[j - 1];
				}
				a[0] = temp;
				continue;
			}
			int index = i - 1;
			while (a[index] > current && index > 0)
				index--;
			index++;
			for (int j = i; j > index; j--) {
				a[j] = a[j - 1];
			}
			a[index] = current;
		}
	}

	/*
	 * 插入排序
	 */
	public static void insertSort1(int[] a) {
		if (a != null) {
			for (int i = 1; i < a.length; i++) {
				int temp = a[i];
				int j = i;
				if (a[j - 1] > temp) {
					while (j > 0 && a[j - 1] > temp) {
						a[j] = a[j - 1];
						j--;
					}
				}
				a[j] = temp;
			}
		}
	}

	/*
	 * 冒泡排序
	 */
	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	/*
	 * 归并排序
	 */
	public static void mergeSort(int[] a, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
		}
	}

	private static void merge(int[] a, int p, int q, int r) {
		int[] tempArr = new int[r - p + 1 + p];
		int left = p;
		int right = q + 1;
		int index = p;
		while (left <= q && right <= r) {
			if (a[left] <= a[right])
				tempArr[index++] = a[left++];
			else
				tempArr[index++] = a[right++];
		}
		while (left <= q)
			tempArr[index++] = a[left++];
		while (right <= r)
			tempArr[index++] = a[right++];
		for (int i = p; i <= r; i++) {
			a[i] = tempArr[i];
		}
	}

	/*
	 * 快速排序
	 */
	public static void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int n = partition(a, left, right);
			quickSort(a, left, n - 1);
			quickSort(a, n + 1, right);
		}
	}

	private static int partition(int[] a, int left, int right) {
		int num = a[left];
		while (left < right) {
			while (left < right && a[right] >= num)
				right--;
			a[left] = a[right];
			while (left < right && a[left] <= num)
				left++;
			a[right] = a[left];
		}
		a[left] = num;
		return left;
	}

	/*
	 * 希尔排序
	 */
	public static void shellSort(int[] a) {
		int length = a.length;
		for (int i = length >> 1; i > 0; i >>= 1) {
			for (int j = i; j < length; j++) {
				int temp = a[j];
				int k = j;
				for (; k >= i && a[k - i] > temp; k -= i) {
					a[k] = a[k - i];
				}
				if (k != j)
					a[k] = temp;
			}
		}
	}

	/*
	 * 基数排序
	 */
	public static void radixSort(int[] a, int distance) {
		int len = a.length;
		int[] temp = new int[len];
		int[] count = new int[10];
		
		int divide = 1;
		for (int i = 0; i < distance; i++) {
			System.arraycopy(a, 0, temp, 0, len);
			Arrays.fill(count, 0);
			for (int j = 0; j < len; j++) {
				int index = temp[j] / divide % 10;
				count[index]++;
			}
			for (int j = 1; j < 10; j++) {
				count[j] += count[j - 1];
			}
			
			for (int j = len - 1; j >= 0; j--) {
				int index = temp[j] / divide % 10;
				count[index]--;
				a[count[index]] = temp[j];
			}
			divide *= 10;
		}
	}
}
