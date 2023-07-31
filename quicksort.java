import java.util.Random;
import java.util.Arrays;

class quicksort {

	int partition(int arr[], int low, int high)
	{
		
		int pivot = arr[low];
		int k = high;
		for (int i = high; i > low; i--) {
			if (arr[i] > pivot)
				swap(arr, i, k--);
		}
		swap(arr, low, k);
				return k;
	}

	
	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	void quickSort(int arr[], int low, int high)
	{
		
		if (low < high) {
			int idx = partition(arr, low, high);
			quickSort(arr, low, idx - 1);
			quickSort(arr, idx + 1, high);
		}
	}

	void printArray(int arr[], int size)
	{
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}


	public static void main(String args[])
	{
		Random rand=new Random();
		for(int i=0;i<5;i++)
		{
			int[] arr=new int[6];
		
			int n = arr.length;

			for(int j=0;j<n;j++)
			{
				arr[j]=5000+rand.nextInt(100);
			}
			System.out.println("\noriginal array: " + Arrays.toString(arr));
			quicksort ob = new quicksort();
			ob.quickSort(arr,0,n-1);

			System.out.println("Sorted array");
			ob.printArray(arr, n);
		}
	}
}

