import java.util.Scanner; 
class Knapsack1
{ 
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in); 
		System.out.print("Enter the total objects : ");
		int object=sc.nextInt();
		int weight[]=new int[object]; 
		int profit[]=new int[object];
		System.out.print("Enter the Profits : ");
		for(int i=0;i<object;i++) 
		{
			profit[i]=sc.nextInt();
		}
		System.out.print("Enter the weights : ");
		for(int i=0;i<object;i++) 
		{
			weight[i]=sc.nextInt();
		}
		System.out.print("Enter the Knapsack capacity : ");
		int m=sc.nextInt();
		double p_w[]=new double[object];
		for(int i=0;i<object;i++)
		{
			p_w[i]=(double)profit[i]/(double)weight[i];
		}
		
		
		
		for(int i=0;i<object-1;i++)
		{
			for(int j=i+1;j<object;j++)
			{
				if(p_w[i]<p_w[j])
				{
					double temp=p_w[j];
					p_w[j]=p_w[i];
					p_w[i]=temp;
					int temp1=profit[j];
					profit[j]=profit[i];
					profit[i]=temp1;
					int temp2=weight[j];
					weight[j]=weight[i];
					weight[i]=temp2;
				}
			}
		}
		
		int k=0;
		double sum=0;
		System.out.println();
		while(m>0)
		{
			if(weight[k]<m)
			{
				sum+=1*profit[k];
				m=m-weight[k];
			}
			else
			{
				double x4=m*profit[k];
				double x5=weight[k];
				double x6=x4/x5;
				sum=sum+x6;
				m=0;
			}
			k++;
		}
		System.out.println("\nFinal Profit="+sum);
	}
}