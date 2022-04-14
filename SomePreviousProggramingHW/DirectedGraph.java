//
// Name: Barrientos, Joshua
// Project: 3
// Due: 5/15/20 Noon
// Course: cs-2400-02-sp19
//
// Description:
//  DirectGraph is a class that creates a implements a graph Interface using HashMap in the java library.
//

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraph<T> implements GraphInterface<T> {
    
    private Map<T, VertexInterface<T>> vertices;
    private int edgeCount;
    
    
    public DirectedGraph(){
        vertices = new HashMap();
        edgeCount = 0;
    }

    @Override
    public boolean addVertex(T vertexLabel){    
        VertexInterface<T> vertex = new Vertex(vertexLabel);
        vertices.put(vertexLabel, vertex);
        return true;    
    }
    
    @Override
    public boolean addEdge(T begin, T end, double edgeWeight){
        boolean result = false;
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if ((beginVertex != null) && (endVertex != null))
            result = beginVertex.connect(endVertex, edgeWeight);
        if (result)
            edgeCount++;
        return result;

    }
    @Override        
    public boolean addEdge(T begin, T end){
        return addEdge(begin, end, 0);
    }
    
    @Override
    public boolean removeEdge(T begin, T end){
        boolean result = false;
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if (hasEdge(begin, end))
            result = beginVertex.disconnect(endVertex);
        if(result)
            edgeCount--;
        return result;
    }
    
    @Override
    public boolean hasEdge(T begin, T end){
        boolean found = false;
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if ((beginVertex != null) && (endVertex != null)){
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
            while (!found && neighbors.hasNext()){
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor))
                    found = true;
            }
        }
        return found;
    }

    @Override
    public boolean isEmpty(){
        return vertices.isEmpty();
    }
    @Override
    public int getNumberOfVertices(){
        return vertices.size();
    }
    @Override
    public int getNumberOfEdges(){
        return edgeCount;
    }
    @Override
    public void clear(){
        vertices.clear();
    }
    
    @Override
    public double getCheapestPath(T begin, T end, Stack<T> path){
        resetVertices();
        boolean done = false;
        
        Queue<EntryPQ> priorityQueue = new PriorityQueue<>();
        VertexInterface<T> originVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        originVertex.visit();
        priorityQueue.add(new EntryPQ(originVertex, 0, null));
        while (!done && !priorityQueue.isEmpty()){
            EntryPQ frontEntry = priorityQueue.remove();
            VertexInterface<T> frontVertex = frontEntry.vertex;
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
            Iterator<Double> associatedWeight = frontVertex.getWeightIterator();
            while (!done && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                double nextWeight = associatedWeight.next();
                if (!nextNeighbor.isVisited()){
                    nextNeighbor.visit();
                    nextNeighbor.setCost(nextWeight);
                    nextNeighbor.setPredecessor(frontVertex);
                    priorityQueue.add(new EntryPQ(nextNeighbor, nextWeight, nextNeighbor.getPredecessor()));
                } // end if
                if (nextNeighbor.equals(endVertex))
                    done = true;
            } 
        } // end while
        // Traversal ends; construct shortest path
        double pathLength = endVertex.getCost();
        path.push(endVertex.getLabel());
        VertexInterface<T> vertex = endVertex;
        while (vertex.hasPredecessor()){
            vertex = vertex.getPredecessor();
            pathLength += vertex.getCost();
            path.push(vertex.getLabel());
        } // end while
        return pathLength;

    }
    private class EntryPQ implements Comparable<EntryPQ>{
        private VertexInterface<T> vertex;
        private VertexInterface<T> previousVertex;
        private double cost;
        
        private EntryPQ(VertexInterface<T> vertex, double cost, VertexInterface<T> previousVertex){
            this.vertex = vertex;
            this.cost = cost;
            this.previousVertex = previousVertex;
        }
        
        @Override
        public int compareTo(EntryPQ otherEntry){
            return (int)Math.signum(otherEntry.cost- cost);
        }
    }
    public void resetVertices(){
        for(HashMap.Entry<T, VertexInterface<T>> vertexEntries : vertices.entrySet()){
            VertexInterface<T> vertex = vertexEntries.getValue();
            vertex.unvisit();
            vertex.setCost(0);
            vertex.setPredecessor(null);
        } 
    }


}
    
    



