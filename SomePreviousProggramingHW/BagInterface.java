//
//  Name: Barrientos, Joshua
//  Project: 2
//  Due: 3/9/20
//  Course: cs-2400-02 
//
//  Description:
//      An interface for a ArrayBag.
//
public interface BagInterface<T> {
    
    /** returns the number of entries. 
     * @return number of entries in Bag. */
    public int getCurrentSize();
   
    /** Checks to see if Bag has nothing in it. 
     * @return true if empty, false otherwise. */
    public boolean isEmpty();
    
    /** Adds an entry to the bag. 
     * @return The object at the top of the stack. */
    public boolean add(T newEntry);
    
    /** Removes a specific entry in the bag. 
     * @param newEntry looks for the parameter in the bag, then removes it.
     * @return T The object at the top of the stack.  */
    public T remove(T newEntry);
    
    /** Check to see if the bag has a specific entry. 
     * @param anEntry a specific datatype. 
     * @return true if it is contained in the bag, false otherwise. */
    public boolean contains(T anEntry);
    
    /* creates an array from the bag. 
     * @return Array of the specified data type of the bag.*/
    public T[] toArray();}
