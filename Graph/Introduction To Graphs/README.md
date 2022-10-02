# Introduction to Graphs

## Basic Terminology

1. **Node/ Vertex:** a data point
2. **Edge:** A coonection between 2 nodes
    - **Directed Edge:** an edge, such that `A->B` does not imply `B->A`
    - **Undirected Edge:** an edge, such that `A->B` is the same as `B->A`
3. **Graph:** a collectin of nodes and vertices
    - **Directed vs Undirected Graphs:** a directed graph consistes of directed edges only, and an undirected graph consistes of undirected edges only
    ![directed vs undirected graph](https://i.pinimg.com/564x/22/ea/ab/22eaab669aa42734d274cc774a38acb7.jpg)
    - **Cyclic vs Acyclic Graphs:** a graph with any cycle is known a cyclic graph
    ![cyclic vs acyclic graph](https://i.pinimg.com/564x/3d/70/83/3d70835e884385f7ca8455f3879aca3c.jpg)
4. **Path** in a graph is a sequence of adjacent vertices, such that each of these vertices are reachable.
5. **Degree of a node**
    - **Undirected Graph:** number of edges attached to the node  
        > property: for an undirected graph, `total degree of a graph = 2 X |E|`
    - **Directed Graph**
        - **indegree:** number of incomming edges to the node
        - **outdegree:** number of outgoing edges from the node
6. **Edge Weight:** Weight Associated with an edge, any unweighted edge is assume to have the weight 1

