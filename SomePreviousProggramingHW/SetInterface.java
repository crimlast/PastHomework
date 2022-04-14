//
//	Name:		Barrientos, Joshua
//	Homework:	1
//	Due:		February 26, 2020
//	Course:		cs-2400-02
//
//	Description:
//			SetInterface determines what should be used on a set of operations involving Sets.

/* an interface that decribes the operation dealing with sets.*/
public interface SetInterface<T> extends Iterable<T>{

        /** Adds a new element to the current set
        * @param element The object to be added as a new element to the set
        * @return True if addition is a success, false otherwise.*/
        public boolean add(T element);

        /** Checks to see if an element is in a set
        * @param element The object in the set
        * @return True if the element is in the set, otherwise false*/
	public boolean contains(T element);

        /** Removes a element from the set.
         * @param element The object to be added in as a new element to the set.
         * @return True if the element is removed, false otherwise.*/
	public boolean remove(T element);

        /**Finds the number of objects in a set
        * @return the number of elements in a set*/
        public int length();

        /** Checks if every element in the set is in another set
        * @param set the set that is taken to be compared to the current LinkedSet
        * @return True if all the elements in the set are in the other set, false otherwise.*/
	public boolean subset(SetInterface<T> set);

        /** Checks two sets to see if they contain the same elements.
        * @param set the set to be compared by the current LinkedSet.
        * @return True if the sets contain the same elements, false otherwise.*/
	public boolean equals(SetInterface<T> set);

        /** Compares two linkedSets and returns a set containing all of the elements of the two sets elements.
        * @param set the set to be combined with the current set.
        * @return SetInterface<T> with all the elements in the different sets.*/
	public SetInterface<T> union(SetInterface<T> set);

}

