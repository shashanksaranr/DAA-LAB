import java.util.Scanner;
public class ham
{
static int n;
public static void main(String[] args) 
{
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the number of vertices:");
	n=in.nextInt();
	int graph[][]=new int[10][10];
	System.out.println("Enter the adjacency matrix:");
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			graph[i][j]=in.nextInt();
	System.out.println("Entered matrix is:");
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
			System.out.print(graph[i][j]+"\t");			
		System.out.println();
	}
	hamcycle(graph);
	System.out.println("***************************");
}

static void printsol(int path[])
{
	System.out.println("Solution exists");
	System.out.println("following is one cycle");
	for(int i=0;i<n;i++)
		System.out.print(path[i]+"    ");
	System.out.println(path[0]);
}

static boolean issafe(int v,int graph[][],int path[],int pos)
{
	if(graph[path[pos-1]][v]==0)
		return false;
	for(int i=0;i<pos;i++)
		if(path[i]==v)
			return false;
	return true;
}

static boolean hamcycleutil(int graph[][],int path[],int pos)
{
	if(pos==n)
	{
		if(graph[path[pos-1]][path[0]]==1)
			return true;
		else 
			return false;
	}
	for(int v=1;v<n;v++)
	{
		if(issafe(v,graph,path,pos))
		{
			path[pos]=v;
			if(hamcycleutil(graph,path,pos+1) == true)
				return true;
			path[pos]=-1;
		}
	}
	return false;
}

static boolean hamcycle(int graph[][])
{
	int path[]=new int[n+1];
	for(int i=0;i<n;i++)
		path[i]=-1;
	path[0]=0;
	if(hamcycleutil(graph,path,1) == false)
	{
		System.out.println("Solution does not exist");
		return false;
	}
	printsol(path);
	return true;
}
}
