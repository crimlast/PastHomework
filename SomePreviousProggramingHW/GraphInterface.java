//
// Name: Barrientos, Joshua
// Project: 3
// Due: 5/15/20 Noon
// Course: cs-2400-02-sp19
//
// Description:
//  An interface of graph with a the graph algorithm getCheapestPath by Dikstri.
//

import java.util.Stack;

public interface GraphInterface<T> {
    /** An interface of methods providing basic operations for directed 
     * and undirected graphs that are either weighted or unweighted. */
    
    /** Adds a given vertex to this graph.
     * @param vertexLabel An object that labels the new vertex and is distinct from the labels of current vertices. 
     * @return True if the vertex is added, or false if not. */
    public boolean addVertex(T vertexLabel);
    
    
    /** Adds a weighted edge between two given distinct vertices that
    are currently in this graph. The desired edge must not already
    be in the graph. In a directed graph, the edge points toward
    the second vertex given.
    * @param begin An object that labels the origin vertex of the edge.
    * @param end An object, distinct from begin, that labels the end vertex of the edge.
    * @param edgeWeight The real value of the edge's weight. 
    * @return True if the edge is added, or false if not. */
    public boolean addEdge(T begin, T end, double edgeWeight);
    
    /* Removes a weighted edge between different vertices. Th desired edge must already be in the graph.
    * @param begin An object that labels the origin vertex of the edge.
    * @param end An object, distinct from begin, that labels the end vertex of the edge.
    * @return True if the edge is removed, or false if not. */
    public boolean removeEdge(T begin, T end);
    
    /** Adds an unweighted edge between two given distinct vertices
    that are currently in this graph. The desired edge must not
    already be in the graph. In a directed graph, the edge points
    toward the second vertex given.
    * @param begin An object that labels the origin vertex of the edge.
    * @param end An object, distinct from begin, that labels the end
    * vertex of the edge. 
    * @return True if the edge is added, or false if not. */
    public boolean addEdge(T begin, T end);
    
    /** Sees whether an edge exists between two given vertices.
    * @param begin An object that labels the origin vertex of the edge.
    * @param end An object that labels the end vertex of the edge. 
    * @return True if an edge exists. */
    public boolean hasEdge(T begin, T end);
    
    /** Sees whether this graph is empty.
     * @return True if the graph is empty. */
    public boolean isEmpty();
    
    /** Gets the number of vertices in this graph. 
     * @return The number of vertices in the graph. */
    public int getNumberOfVertices();

    /** Gets the number of edges in this graph. 
     * @return The number of edges in the graph. */
    public int getNumberOfEdges();

    /** Removes all vertices and edges from this graph
    resulting in an empty graph. */
    public void clear();
    

    
    /**Gets the shortest path of a weighted graph.
     * @param begin Vertex that starts the transversal.
     * @param end the Vertex that is used as the end vertex
     * @param path stores the paths
     * @return double which is the distance of the shortest path.     */
    public double getCheapestPath(T begin, T end, Stack<T> path);


} 
