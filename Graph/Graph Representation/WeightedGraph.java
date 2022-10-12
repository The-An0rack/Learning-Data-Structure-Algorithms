import java.util.*;

public class WeightedGraph
{
    static List<List<List<Integer>>> readAsList(int N, List<List<Integer>> edgeList)
    {
        List<List<List<Integer>>> adjList=new ArrayList<>();
        for(int i=0; i<N; i++) adjList.add(new ArrayList<>());
        for(List<Integer> edge: edgeList)
        {
            List<List<Integer>> atNode=adjList.get(edge.get(0)-1);
            atNode.add(Arrays.asList(edge.get(1), edge.get(2)));
            atNode=adjList.get(edge.get(1)-1);
            atNode.add(Arrays.asList(edge.get(0), edge.get(2)));
        }

        return adjList;
    }

    static int[][] readAsMatrix(int N, List<List<Integer>> edgeList)
    {
        int adjMatrix[][]=new int[N][N];
        for(List<Integer> edge: edgeList)
        {
            adjMatrix[edge.get(0)-1][edge.get(1)-1]=edge.get(2);
            adjMatrix[edge.get(1)-1][edge.get(0)-1]=edge.get(2);
        }
        return adjMatrix;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        List<List<Integer>> edgeList=new ArrayList<>();
        for(int m=0; m<M; m++) edgeList.add(Arrays.asList(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        System.out.println(readAsList(N, edgeList));
        int adjMatrix[][]=readAsMatrix(N, edgeList);
        for(int[] row: adjMatrix)
        {
            for(int e: row)
                System.out.print(e+" ");
            System.out.println();
        }
        sc.close();
    }
}