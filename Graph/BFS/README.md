# BFS

Bredth First Search Technique

- level wise traversal
- uses queue

[see problem]( https://bit.ly/3bn84K8)

```java
public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> res=new ArrayList<>();
    Queue<Integer> nodes=new LinkedList<>();
    nodes.offer(0);
    boolean visited[]=new boolean[V];
    while(!nodes.isEmpty())
    {
        int node=nodes.poll();
        if(!visited[node])
        {
            for(int child: adj.get(node)) nodes.offer(child);
            res.add(node);
            visited[node]=true;
        }
    }
    return res;
}
```
