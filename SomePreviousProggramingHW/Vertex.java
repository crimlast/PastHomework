//
// Name: Barrientos, Joshua
// Project: 3
// Due: 5/15/20 Noon
// Course: cs-2400-02-sp19
//
// Description:
//   Vertex class is an implementation of Vertex Interface which mimics vertices of a graph.
//

import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Vertex<T> implements VertexInterface<T> {
    private T label;
    private boolean visited;
    private VertexInterface<T> previousVertex;
    private LinkedList<Edge> edgeList;
    private double cost;
    
    public Vertex(T vertexLabel) {
        label = vertexLabel; 
        edgeList = new LinkedList<>(); 
        visited = false; 
        previousVertex = null;
        cost = 0; 
    }
    @Override
    public T getLabel(){
        return label;
    }
    @Override
    public void visit(){
        visited = true;
    }
    @Override
    public void unvisit(){
        visited = false;
    }
    @Override
    public boolean isVisited(){
        return visited;
    }
    @Override
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight){
        boolean result = false;
        
        if(!this.equals(endVertex)){
            Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
            boolean duplicateEdge = false;
            while(!duplicateEdge && neighbors.hasNext()){
                VertexInterface<T> nextNeighbor = neighbors.next();
                if(endVertex.equals(nextNeighbor))
                    duplicateEdge = true;
            }
            if(!duplicateEdge){
                edgeList.add(new Edge(endVertex, edgeWeight));
                result = true;
            }
            else{
                throw new RuntimeException("Already existing connection");
            }
        }
        return result;
    }
    
    @Override
    public boolean disconnect(VertexInterface<T> endVertex){
        boolean result = false;
        
        if(!equals(endVertex)){
            Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
            int index = 0;
            boolean existingEdgeFound = false;
            while(!existingEdgeFound && neighbors.hasNext()){
                VertexInterface<T> nextNeighbor = neighbors.next();
                if(endVertex.equals(nextNeighbor)){
                    edgeList.remove(index);
                    result = true;
                    existingEdgeFound = true;
                }
                index++;
            }    
            if(result == false){
                throw new RuntimeException("Connection does not Exist");
            }
        
        }   
        return result;
    }
        
    
    
    @Override
    public boolean connect(VertexInterface<T> endVertex){
         return connect(endVertex, 0);
    }
    @Override
    public Iterator<Double> getWeightIterator(){
        return new WeightIterator();
    }
    
    private class WeightIterator implements Iterator<Double> { 

        private Iterator<Edge> edges;

        private WeightIterator() {
            edges = edgeList.listIterator();
        }
        @Override
        public boolean hasNext() { 
            return edges.hasNext(); 
        }
        @Override
        public Double next() { 
            Double nextNeighbor = null;

            if (edges.hasNext()) { 
                Edge edgeToNextNeighbor = edges.next();
                nextNeighbor = edgeToNextNeighbor.getWeight();
            }

            else throw new NoSuchElementException();
            return nextNeighbor ;
        }
    }
    @Override
    public boolean hasNeighbor(){
         return !edgeList.isEmpty();
    }
    @Override
    public VertexInterface<T> getUnvisitedNeighbor(){
        VertexInterface<T> result = null;
        Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
        while(neighbors.hasNext() && (result == null)) {
            VertexInterface<T> nextNeighbor = neighbors.next();
            if(!nextNeighbor.isVisited()) result = nextNeighbor;
            
        }
        return result;
    }
    @Override
    public void setPredecessor(VertexInterface<T> predecessor){
        previousVertex = predecessor;
    }
    @Override
    public VertexInterface<T> getPredecessor(){
        return previousVertex;
    }
    @Override
    public boolean hasPredecessor(){
        return (previousVertex != null);
    }
    @Override
    public void setCost(double newCost){
        cost = newCost;
    }
    @Override
    public double getCost(){
        return cost;
    }
    @Override
    public Iterator<VertexInterface<T>> getNeighborIterator() {
        return new NeighborIterator();
    }
    
    private class NeighborIterator implements Iterator<VertexInterface<T>> { 

        private Iterator<Edge> edges;

        private NeighborIterator() {
            edges = edgeList.listIterator();
        }  
        public boolean hasNext() { 
            return edges.hasNext(); 
        }
        public VertexInterface<T> next() { 
            VertexInterface<T> nextNeighbor = null;

            if (edges.hasNext()) { 
                Edge edgeToNextNeighbor = edges.next();
                nextNeighbor = edgeToNextNeighbor.getEndVertex();
            }
            else throw new NoSuchElementException();
            return nextNeighbor ;
        }
    }    
    
    protected class Edge{
        private VertexInterface<T> vertex; 
        private double weight; 
    
        protected Edge(VertexInterface<T> endVertex, double edgeWeight) { 
            vertex = endVertex; weight = edgeWeight; 
        }  
    
        protected Edge(VertexInterface<T> endVertex) { 
            vertex = endVertex; weight = 0; 
        } 
    
        protected VertexInterface<T> getEndVertex() { 
            return vertex; 
        }  
    
        protected double getWeight() { 
            return weight; 
        } 
    }     
}


