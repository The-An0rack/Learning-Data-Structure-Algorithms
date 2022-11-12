import java.util.*;

public class UndirectedGraph
{
    static List<List<Integer>> readAsList(int N, List<List<Integer>> edgeList)
    {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0; i<N; i++) adjList.add(new ArrayList<>());
        for(List<Integer> edge: edgeList)
        {
            List<Integer> atNode=adjList.get(edge.get(0)-1);
            atNode.add(edge.get(1));
            atNode=adjList.get(edge.get(1)-1);
            atNode.add(edge.get(0));
        }

        return adjList;
    }

    static boolean[][] readAsMatrix(int N, List<List<Integer>> edgeList)
    {
        boolean adjMatrix[][]=new boolean[N][N];
        for(List<Integer> edge: edgeList)
        {
            adjMatrix[edge.get(0)-1][edge.get(1)-1]=true;
            adjMatrix[edge.get(1)-1][edge.get(0)-1]=true;
        }
        return adjMatrix;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        List<List<Integer>> edgeList=new ArrayList<>();
        for(int m=0; m<M; m++) edgeList.add(Arrays.asList(sc.nextInt(), sc.nextInt()));
        System.out.println(readAsList(N, edgeList));
        boolean adjMatrix[][]=readAsMatrix(N, edgeList);
        for(boolean[] row: adjMatrix)
        {
            for(boolean e: row)
            {
                if(e) System.out.print(1+" ");
                else System.out.print(0+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}