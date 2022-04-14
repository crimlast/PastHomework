//
//  Name: Barrientos, Joshua
//  Homework: 3
//  Due: 3/22/20(end of the day)
//  Course: cs-2400-02
//
//  Description:
//     A class to check the add methods of the DoublyLinkedList.java.
//

public class DLLCheck {
    public static void main(String[] args){
        System.out.println("Doubly Linked List by J. Barrientos\n");
        ListInterface<Integer> myList = new DoublyLinkedList();
        myList.add(4);
        myList.add(9);
        myList.add(2, 7);
        myList.add(4, 8);
        myList.add(109332);
        myList.add(3, 21);
        myList.add(1);

        System.out.print(myList);
    }
}
