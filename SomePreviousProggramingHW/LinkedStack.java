//
//  Name: Barrientos, Joshua
//  Project: 2
//  Due: 3/9/20
//  Course: cs-2400-02 
//
//  Description:
//      An class LinkedStack to create a connection of dataTypes instead of using arrays.
//

import java.util.EmptyStackException;
import java.util.Iterator;


public class LinkedStack<T> implements StackInterface<T>{
   private Node topNode;
   
   public LinkedStack(){
       topNode = null;
   }
   @Override
   public void push(T entry){
       Node newNode = new Node(entry, topNode);
       topNode = newNode;
   }
   @Override
   public T peek(){
       if (isEmpty())
           throw new EmptyStackException();
       else
            return topNode.getData();
   }
   
   @Override
   public T pop(){
       T top = peek();
       topNode = topNode.getNext();
       return top;
   }
   @Override
   public boolean isEmpty(){
       return null == topNode;
   }
   @Override
   public void clear(){
       topNode = null;
   }
  
   public Iterator<T> iterator(){
		return new LinkedStackIterator<>();
	}
	
   private class LinkedStackIterator<T> implements Iterator<T>{
                private Node current;
		public LinkedStackIterator() {
			current = topNode;
		}
                @Override
		public boolean hasNext(){
			return current != null;
		}
                @Override
		public T next(){
                    T data = null;
                     if (current != null){
                         data = (T)current.getData();
                         current = current.getNext();
                        }
                   	return data;
		}
	}




	private class Node{
		private T data;
		private Node next;
		public Node(T dataNextPortion){
			this(dataNextPortion, null);
		}
		public Node(T dataNext, Node nexNode){
			data = dataNext;
			next = nexNode;
		}
                public Node getNext(){
                    return next;
                }
                public T getData(){
                    return data;
                }
		public void setData(T newData){
			data = newData;
		}
		public void setNext(Node replace){
			next = replace;
		}
	}
} 


