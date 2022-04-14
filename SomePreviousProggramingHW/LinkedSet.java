//
//	Name:		Barrientos, Joshua
//	Homework:	1
//	Due:		February 26, 2020
//	Course:		cs-2400-02
//
//	Description:
//			Linked set creates methods from the SetInterface and creates a SinglyList to store objects of the same type.
//
import java.util.Iterator;

public class LinkedSet<T> implements SetInterface<T>{
	private Node firstNode;
	private int numberOfElements;
	public LinkedSet(){
		firstNode = null;
		numberOfElements = 0;
	}
        @Override
	public boolean contains(T element){
		Node current = firstNode;
		while(current != null){
			if (current.data == element){
				return true;
			}
			current = current.next;
		}
		return false;
	}
        @Override
	public boolean remove(T element){
		Node current = firstNode;
                if(numberOfElements == 0){
                    return false;
                }
		if(current.data == element){
			firstNode = current.next;
			numberOfElements--;
			return true;
		}
		while(current.next != null){
			if(current.next.data == element){
				current.setNext(current.next.next);
				numberOfElements--;
				return true;
			}
			current = current.next;
		}
		return false;
	}
        @Override
	public boolean add(T element){
		if(contains(element)){
                    return false;
                }
                if(numberOfElements == 0){
                    firstNode = new Node(element);
                    numberOfElements++;
                    return true;
                }
                Node current = firstNode;
		Node end = new Node(element);
                while (current.next != null){
                    current = current.next;
		}
		current.setNext(end);
		numberOfElements++;
		return true;
	}
        @Override
	public int length(){
		return numberOfElements;
	}
	@Override
	public boolean subset(SetInterface<T> set){
		Node current = firstNode;
		while(current != null){
			if(!set.contains(current.data)){
				return false;
			}
			current = current.next;

		}
		return true;
	}
	@Override
	public boolean equals(SetInterface<T> set){
		return numberOfElements == set.length() && subset(set);
	}
	@Override
	public SetInterface<T> union(SetInterface<T> set){
		if(subset(set)){
			return set;
		}
		Node current = firstNode;
                Iterator<T> iter = set.iterator();
                SetInterface<T> SetT = new LinkedSet();
                LinkedSet SetK = (LinkedSet)set;
                while(current != null){
			SetT.add(current.data);
			current = current.next;
		}
                current = SetK.firstNode;
                while(current != null){
			SetT.add(current.data);
			current = current.next;
		}
                return SetT;
	}
	@Override
	public String toString(){
		String theString = "{";
		Node current = firstNode;
		while (current != null){
                        if(current.next == null){
                            theString += current.data;
                        }
                        else{
                            theString += current.data + ", ";
                        }
                        current = current.next;
		}
		theString += "}";
		return theString;
	}
        @Override
	public Iterator<T> iterator(){
		return new LinkedSetIterator<>();
	}
	private class LinkedSetIterator<T> implements Iterator<T>{
                private Node current;
		public LinkedSetIterator() {
			current = firstNode;
		}
                @Override
		public boolean hasNext(){
			return current != null;
		}
                @Override
		public T next(){
                    T data = null;
                     if (current != null){
                         data = (T)current.data;
                         current = current.next;
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
		public void setData(T newData){
			data = newData;
		}
		public void setNext(Node replace){
			next = replace;
		}
	}
}


