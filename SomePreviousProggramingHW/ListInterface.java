//
//  Name: Barrientos, Joshua
//  Homework: 3
//  Due: 3/22/20 (end of the day)
//  Course: cs-2400-02
//
//  Description:
//      An interface for a DoublyLinkedList that implements only add methods.
//

public interface ListInterface<T> {

    /** Adds an entry at the bottom of the list.
     * @param entry The object added to as a new entry in the list.*/
    public void add(T entry);

    /** Removes a specific entry in the bag.
     * @param position The integer that specifies the position in which the entry is going to be added in the list.
     * @param entry The object added as a new entry.
     * @throws RuntimeException if either newPosition is less than 1 or greater than the numberOfEntries + 1. */
    public void add(int position, T entry);
}
