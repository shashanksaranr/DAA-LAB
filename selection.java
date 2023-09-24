import java.util.Scanner;
import java.util.Random;

public class selection {
	public static void sorting(int arr[],int a,int n)
	{
		int m=a;
		
		for(int i=m;i<n;i++)
		{
			int min=i;
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]<arr[min])
				{
					min=j;
				}
			}
			
			int temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
		
		
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Random rd=new Random();
		int arr[]=new int[1000];
		System.out.println("Enter number of elements: ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			arr[i]=rd.nextInt(1000)+5000;
			
		}
		System.out.println("The array elements before sorting are: ");
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+ " ");
		}
	
		
		
		System.out.println("\nThe array elements after sorting are: ");
		for(int m=0;m<n;m++)
		{
			System.out.print(arr[m]+ " ");
		}
		
		 long stime=0, etime=0;
         stime = System.nanoTime();
  
         sorting(arr,0,n-1);
         
         etime = System.nanoTime();
  
         System.out.print("\n The sorted elements are \n");
         for(int j=0;j<n;j++)
             System.out.print(arr[j]+"\t");
  
         long Tcomplexity = etime - stime;
         System.out.println("\n\nTime Complexity  for n = " + n + " is: " + (double) Tcomplexity / 1000000 + " msec");
         sc.close(); 
	}

}