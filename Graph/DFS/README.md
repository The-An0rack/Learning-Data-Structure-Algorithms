# BFS

Depth First Search Technique

- depth wise traversal
- uses stack (or calling stack)

[see problem]( https://bit.ly/3bn84K8)

## Recursive Approach

```java
boolean visited[];
    ArrayList<Integer> dfs(int node, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> res=new ArrayList<>();
        visited[node]=true;
        res.add(node);
        for(int child: adj.get(node))
            if(!visited[child]) res.addAll(dfs(child, adj));
        return res;
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        visited=new boolean[V];
        return dfs(0, adj);
    }
```

## Iterative Approach

```java
public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> res=new ArrayList<>();
    Stack<Integer> nodes=new Stack<>();
    nodes.push(0);
    boolean visited[]=new boolean[V];
    while(!nodes.isEmpty())
    {
        int node=nodes.pop();
        if(!visited[node])
        {
            for(int child: adj.get(node)) nodes.push(child);
            res.add(node);
            visited[node]=true;
        }
    }
    return res;
}
}
```

Time: O(VE)
Space: O(V)
