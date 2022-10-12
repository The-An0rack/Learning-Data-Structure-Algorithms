# Graph Representation

## input

input is generally given in the format of `N` followed by `M` pairs of numbers such that:  
N : the number of node
M : the number of edges
nodes would generally be 1 indexed, i.e. [1, 2, 3, ..., n]
every edge `E(u, v)` in the edge list will imply `u->v` (also `v->u` if the graph is undirected)

## Storing

a graph can be stored in two ways

### Adjacency List

- used for sparse graphs
- space: O(2M)
- edge lookup time: O(V)

### Adjacency Matrix

- used for denser graphs
- space: O(NM)
- edge lookup time: O(1)

## Examples

### Directed graph

![directed graph](https://i.pinimg.com/originals/32/ae/0c/32ae0c217eef2cf33f49d46172e84dfe.png)

[browse full code](https://github.com/akankshaSha/Learning-Data-Structure-Algorithms/blob/main/Graph/Graph%20Representation/DirectedGraph.java)

#### Adjacency list

```java
static List<List<Integer>> readAsList(int N, List<List<Integer>> edgeList)
{
    List<List<Integer>> adjList=new ArrayList<>();
    for(int i=0; i<N; i++) adjList.add(new ArrayList<>());
    for(List<Integer> edge: edgeList)
    {
        List<Integer> atNode=adjList.get(edge.get(0)-1);
        atNode.add(edge.get(1));
    }

    return adjList;
}
```

#### Adjacency matrix

```java
static boolean[][] readAsMatrix(int N, List<List<Integer>> edgeList)
{
    boolean adjMatrix[][]=new boolean[N][N];
    for(List<Integer> edge: edgeList)
        adjMatrix[edge.get(0)-1][edge.get(1)-1]=true;
    return adjMatrix;
}
```

### Undirected Graph

![undirected graph](https://i.pinimg.com/originals/aa/33/28/aa332805670bb86598b4f08628b03062.png)

[browse full code](https://github.com/akankshaSha/Learning-Data-Structure-Algorithms/blob/main/Graph/Graph%20Representation/UndirectedGraph.java)

#### Adjacency List

```java
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
```

#### Adjacency Matrix

```java
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
```

### Weighted Graph

![weighted graph](https://i.pinimg.com/originals/f2/96/dc/f296dc2eafad1f37a16f93ea5727e9de.png)

[browse full code](https://github.com/akankshaSha/Learning-Data-Structure-Algorithms/blob/main/Graph/Graph%20Representation/WeightedGraph.java)

#### Adjacency List

```java
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
```

#### Adjacency Matrix

```java
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
```
