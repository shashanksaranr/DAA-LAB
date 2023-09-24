import java.util.Scanner;
import java.util.Random;

	public class qsort
	{
		int Partition(int a[],int low,int high)
		{
		  int i,j,temp,key;
		  
		  key=a[low];
		  i=low+1;
		  j=high;

		  while(true)
		   {
		     while(i < high && key >= a[i]) 
		     	i++;
		     while(key < a[j]) 
		     	j--;

		     if(i<j)			// exchange ith and jth elements
		      {
		    	temp=a[i];
			    a[i]=a[j];
			    a[j]=temp;
		      }
		      else			// exchange key and jth elements
		      {
		       temp=a[low];
		       a[low]=a[j];
		       a[j]=temp;
		       return j;		// returns the position of key 
		      }
		   }//end of while
		}//end of Paritition method

	        void QuickSort(int a[],int low,int high)
		{
		 int j;
		 if(low<high)
		  {
		    j=Partition(a,low,high);
		    QuickSort(a,low,j-1);
		    QuickSort(a,j+1,high);
		  }
		}

	        public static void main(String args[])
	        {
	          Random r = new Random();
	          final int MAX = 10000;
	          int[] a = new int[MAX];
	          qsort obj = new qsort();
	          int n=0,i=0;
	          
	          Scanner input = new Scanner(System.in);
	          System.out.print("\n Enter the number of elements : ");
	          n=input.nextInt();

	          for(i=0;i<n;i++) 
        		{
          			a[i] = r.nextInt(1000);//for random number inputs
          		
        		}
	          System.out.println("The array elements before sorting are: ");
	  		for(int j=0;j<n;j++)
	  		{
	  			System.out.print(a[j]+ " ");
	  		}

	          long stime=0, etime=0;
	          stime = System.nanoTime();
	   
	               obj.QuickSort(a,0,n-1);
	   
	          etime = System.nanoTime();
	   
	          System.out.print("\n The sorted elements are \n");
	          for(i=0;i<n;i++)
	              System.out.print(a[i]+"\t");
	   
	          long Tcomplexity = etime - stime;
	          System.out.println("\n\nTime Complexity  for n = " + n + " is: " + (double) Tcomplexity / 1000000 + " msec");
	          input.close(); 
	       }//end of main method
	}//end of QSort class
