import java.util.Scanner;

public class dijkstra {

		int d[]=new int[10];
		int p[]=new int[10];
		int visited[]=new int[10];

		public void dijk(int[][]a, int s, int n) 
		{
		int u=-1,v,i,j,min;
		for(v=1;v<=n;v++)
		{
		d[v]=999;
		p[v]=-1;
		}

		d[s]=0;

		for(i=1;i<=n;i++)		//perform relaxation operation n times
		{
		min=999;
		for(j=1;j<=n;j++)
		{
		if(d[j]<min && visited[j]==0)  //select a vertex with minimum weight take that as u
			{	  // and also make that vertex as visited vertex
			min=d[j];			
			u=j;
			}
		}
		visited[u]=1;

		for(v=1;v<=n;v++)
		{
		if((d[u]+a[u][v]<d[v]) && (u!=v) && visited[v]==0)
		   {
		   d[v]=d[u]+a[u][v];      //from the visited vertex u, relax the other vertices
		   p[v]=u;	//and for the relaxed vertices v, make the parent vertex as u
		    }
		}
		}
		}

		
		void path(int v, int s)
		{
			if(p[v]!=-1)
				path(p[v],s);
			System.out.print("->"+v+" ");
		}
		void display(int s, int n)
		{
			int i;
			for(i=1; i<=n; i++)
			{
				path(i,s);
				System.out.print("="+d[i]+" ");
				System.out.println();
			}
		}
		

	

	public static void main(String[] args) {
	int a[][]=new int[10][10];
	int i,j,n,s;
	System.out.println("Enter the number of vertices");
	Scanner sc= new Scanner(System.in);
	n=sc.nextInt();

	System.out.println("Enter the Weighted matrix");
	for(i=1;i<=n;i++)
		for(j=1;j<=n;j++)
			a[i][j]=sc.nextInt();

	System.out.println("Enter the source vertex");
	s=sc.nextInt();

	dijkstra dj = new dijkstra();
	dj.dijk(a,s,n);

	System.out.println("The shortest path between source "+s+ " to remaining vertices are");
	dj.display(s,n);

	sc.close();
	}
}
