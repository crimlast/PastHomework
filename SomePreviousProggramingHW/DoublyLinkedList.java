//
//  Name: Barrientos, Joshua
//  Homework: 3
//  Due: 3/22/20 (end of the day)
//  Course: cs-2400-02
//
//  Description:
//      A Doubly Linked list that can takes in linked data that can access it next and previous nodes.
//

public class DoublyLinkedList<T> implements ListInterface<T> {
    private int numberOfElements;
    private DLNode head;
    private DLNode tail;
    public DoublyLinkedList(){
        numberOfElements = 0;
        head = new DLNode();
        tail = new DLNode();
    }

    @Override
    public void add(T entry){
        DLNode newNode = new DLNode(entry);
        if(numberOfElements == 0){
            head.next = newNode;
            newNode.prev = head;
            tail.prev = newNode;
            newNode.next = tail;
        }
        else{
            DLNode last = tail.prev;
            last.next = newNode;
            newNode.prev = last;
            tail.prev = newNode;
            newNode.next = tail;
        }
        numberOfElements++;
    }

    @Override
    public void add(int position, T entry){
        if(position > numberOfElements + 1 || position < 1){
            throw new RuntimeException("Index out of bounds.");
        }
        else if(position == numberOfElements + 1){
            add(entry);
        }
        else{
            DLNode current = head;
            for(int i = 0; i < position; i++ ){
                current = current.next;
            }
            DLNode before = current.prev;
            DLNode added = new DLNode(entry, before, current);
            before.next = added;
            current.prev = added;
            numberOfElements++;
        }
    }

    @Override
    public String toString(){
        DLNode current = head;
        StringBuilder result = new StringBuilder();
        for(int i = 1; i<= numberOfElements; i++){
            result.append(i + " - " + current.next.data + "\n");
            current = current.next;
        }
        return result.toString();
    }

    private class DLNode {
        private T data;
        private DLNode next;
        private DLNode prev;

        public DLNode(){
            this(null);
        }

        public DLNode(T data){
            this(data, null, null);
        }
        public DLNode(T data, DLNode previous, DLNode after){
            this.data = data;
            next = after;
        }

    }
}
