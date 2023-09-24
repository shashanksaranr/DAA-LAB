import java.util.Scanner;

public class prims {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int weight[][]=new int[10][10];
        int n,i,j,source,vertex=0;
        int min, sum=0,u=0,v=0;
        int visited[]=new int [10];
        
        System.out.println("Enter the number of vertices");
        n=sc.nextInt();
        
        for(i=1; i<=n; i++)
            visited[i]=0;
        
        
        System.out.println("Enter the weighted graph/ cost matrix");
        for(i=1; i<=n; i++)
            for(j=1; j<=n; j++)
                weight[i][j] = sc.nextInt();
        
        System.out.println("Enter the source vertex");
        source=sc.nextInt();
        
        visited[source]=1; //Visited 
        
        vertex=1;
        
        while(vertex<=n-1)
        {
            min=999;
            for(i=1; i<=n; i++)
                for(j=1; j<=n; j++)
                    if(visited[i]==1 && visited[j]==0)
                        if(i!=j && min>weight[i][j])
                        {
                            min=weight[i][j];  //Minimum cost
                            u=i;  //Source 
                            v=j;  //Destination
                            
                        }
            visited[v]=1;  //visited
            sum=sum+min;
            vertex++;
            System.out.println(u+"-->"+v+"="+min);
        }
        
        System.out.println("The cost of minimum spanning tree is "+sum);
        
        sc.close();         
    }
}
