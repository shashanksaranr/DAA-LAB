import java.util.Scanner;
public class dynamic 
{
    static int max(int a,int b)
    {
        return a>b?a:b;
    }

    public static int knapsack(int w,int wt[],int val[],int n)
    {
        int i,j;
        int[][]k=new int[n+1][w+1];
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=w;j++)
            {
                if(i==0||j==0)
                {
                    k[i][j]=0;
                }

                else if(wt[i-1]<=j)
                    k[i][j]=max(val[i-1]+k[i-1][j-wt[i-1]],k[i-1][w]);
                
                else
                    k[i][j]=k[i-1][j];
            }
        }
        return k[n][w];
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int object,m;
        System.out.println("Enter the total objects:");
        object=sc.nextInt();

        int weight[]=new int[object];
        int profit[]=new int[object];
        
        for(int i=0;i<object;i++)
        {
            System.out.println("Enter the Profit:");
            profit[i]=sc.nextInt();

            System.out.println("Enter the weight:");
            weight[i]=sc.nextInt();
        }
        System.out.println("Enter the knapsack Capacity:");
        m=sc.nextInt();
        dynamic s=new dynamic();
        System.out.println("The maximum capacity is="+knapsack(m,weight,profit,object));
    } 
}