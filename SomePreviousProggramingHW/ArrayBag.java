//
//  Name: Barrientos, Joshua
//  Project: 2
//  Due: 3/9/20
//  Course: cs-2400-02 
//
//  Description:
//      An Array Bag to hold a different data types with no order in an array.
//
public class ArrayBag<T> implements BagInterface<T>{
      private T[] bag;
        private static final int Capacity = 6;
        private int numberOfEntries;
        @SuppressWarnings("unchecked")
        public ArrayBag() {
                T[] tempBag = (T[])new Object[Capacity];
                numberOfEntries = 0;
                bag = tempBag;
        }
        @Override
        public int getCurrentSize(){
                return numberOfEntries;
        }
        @Override
        public boolean isEmpty(){
                return numberOfEntries == 0;
        }
        @Override
        public boolean add(T newEntry){
                if (numberOfEntries == 6){
                        return false;
                }
                else{
                        bag[numberOfEntries] = newEntry;
                        numberOfEntries++;
                        return true;
                }
        }
        @Override
        public T remove(T entry){
            for(int i = 0; i < numberOfEntries; i++){
                if(bag[i] == entry){
                T temp = bag[i];
                bag[i] = bag[--numberOfEntries];
                bag[numberOfEntries] = temp;
                return temp;
                }
            }
            return null;
        }
        @Override
        public boolean contains(T entry){
                for(int i = 0; i < numberOfEntries; i++){
                        if(bag[i] == entry){
                                return true;
                        }
                }
                return false;

        }
        @Override
        public T[] toArray(){
            return bag;
        }
}
