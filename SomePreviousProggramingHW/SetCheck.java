//
//	Name:		Barrientos, Joshua
//	Project:	1
//	Due:		February 26, 2020
//	Course:		cs-2400-02
//
//	Description:
//			SetCheck class to test the method linkedSet class and all of the cases for each method.
//

public class SetCheck{
	public static void main(String[] args){
            System.out.println("J. Barrientos's Set ADT\n");
            System.out.println("Using add() and remove() method on an empty Set called set2.");
            SetInterface<Integer> set2 = new LinkedSet<>();
            SetInterface<Integer> set1 = new LinkedSet<>();
            System.out.println("set2.add(2) returns the boolean " + set2.add(2) + " when adding 2 to an empty set" );
            System.out.println("set2.add(2)returns the boolean " + set2.add(2) + " when adding 2 in a set with 2");
            System.out.println("set2.contains(2) returns the boolean " + set2.contains(2) + " when looking for 2 in a set");
            System.out.println("set2.contains(3) returns the boolean " + set2.contains(3) + " when looking for 3 in a set without it");
            System.out.println("set2.remove(2) returns the boolean " + set2.remove(2) + " when removing 2");
            System.out.println("set2.remove(2) returns the boolean" + set2.remove(2) + " when removing 2 to a set with no elements");
            System.out.println("set2.contains(2) returns the boolean " + set2.contains(2) + " when looking for 2 in a set with no numbers");
            System.out.println("Testing subset(), union(), and equals()\ntoString will be used when printing out sets");
            System.out.println("\nCase 1: equal but different sets");
            set2.add(3);
            set2.add(4);
            set2.add(5);
            set2.add(2);
            set1.add(5);
            set1.add(2);
            set1.add(4);
            set1.add(3);
            System.out.println("Set1= " + set1);
            System.out.println("Set2 = " + set2);
            System.out.println("set2.subset(set1) returns " + set2.subset(set1));
            System.out.println("set1.subset(set2) returns " + set1.subset(set2));
            System.out.println("set2.equals(set1)returns " + set2.equals(set1));
            System.out.println("set1.equals(set2)returns " + set1.equals(set2));
            System.out.println("set1.union(set2) returns the set " + set1.union(set2));
            System.out.println("set2.union(set1) returns the set " + set2.union(set1));

            System.out.println("\nCase 2: A set and a subset of it" );
            set1.remove(4);
            System.out.println("Set1 = " + set1 + "\nSet2 = " + set2);
            System.out.println("set2.subset(set1) returns " + set2.subset(set1));
            System.out.println("set1.subset(set2) returns " + set1.subset(set2));
            System.out.println("set2.equals(set1)returns " + set2.equals(set1));
            System.out.println("set1.equals(set2)returns " + set1.equals(set2));
            System.out.println("set1.union(set2) returns the set " + set1.union(set2));
            System.out.println("set2.union(set1) returns the set " + set2.union(set1));

            System.out.println("\nCase 3: Two different sets with common and different elements");
            set1.remove(5);
            set1.add(1);
            set1.add(6);
            System.out.println("Set1 = " + set1 + "\nSet2 = " + set2);
            System.out.println("set2.subset(set1) returns " + set2.subset(set1));
            System.out.println("set1.subset(set2) returns " + set1.subset(set2));
            System.out.println("set2.equals(set1)returns " + set2.equals(set1));
            System.out.println("set1.equals(set2)returns " + set1.equals(set2));
            System.out.println("set1.union(set2) returns the set " + set1.union(set2));
            System.out.println("set2.union(set1) returns the set " + set2.union(set1));

            System.out.println("\nCase 4: Sets that are nonEmpty with no common elements");
            set1.remove(2);
            set1.remove(3);
            System.out.println("Set1 = " + set1 + "\nSet2 = " + set2);
            System.out.println("set2.subset(set1) returns " + set2.subset(set1));
            System.out.println("set1.subset(set2) returns " + set1.subset(set2));
            System.out.println("set2.equals(set1)returns " + set2.equals(set1));
            System.out.println("set1.equals(set2)returns " + set1.equals(set2));
            System.out.println("set1.union(set2) returns the set " + set1.union(set2));
            System.out.println("set2.union(set1) returns the set " + set2.union(set1));

            System.out.println("\nCase 5: One is non empty and one is empty");
            set1.remove(1);
            set1.remove(6);
            System.out.println("Set1 = " + set1 + "\nSet2 = " + set2);
            System.out.println("set2.subset(set1) returns " + set2.subset(set1));
            System.out.println("set1.subset(set2) returns " + set1.subset(set2));
            System.out.println("set2.equals(set1)returns " + set2.equals(set1));
            System.out.println("set1.equals(set2)returns " + set1.equals(set2));
            System.out.println("set1.union(set2) returns the set " + set2.union(set2));
            System.out.println("set2.union(set1) returns the set " + set2.union(set1));

            System.out.println("\nCase 6: two empty sets");
            SetInterface<Integer> set3 = new LinkedSet();
            System.out.println("Set1 = " + set3 + "\nSet3 = " + set3);
            System.out.println("set3.subset(set1) returns " + set3.subset(set1));
            System.out.println("set1.subset(set3) returns " + set1.subset(set3));
            System.out.println("set3.equals(set1)returns " + set3.equals(set1));
            System.out.println("set3.union(set1) returns the set " + set3.union(set1));
			SetInterface<String> stringSet = new LinkedSet();
			SetInterface<String> stringSet2 = new LinkedSet();
			stringSet.add("dog");
			stringSet.add("hi");
			stringSet2.add("hi");
			stringSet2.add("dog");
			System.out.println("\nExtra Case Strings");
			System.out.println("stringSet = " + stringSet + "\nstringSet2 = " + stringSet2);
            System.out.println("stringSet.subset(stringSet2) returns " + stringSet.subset(stringSet2));
            System.out.println("stringSet2.subset(stringSet) returns " + stringSet2.subset(stringSet));
            System.out.println("stringSet2.equals(stringSet)returns " + stringSet.equals(stringSet2));
            System.out.println("stringSet.union(stringSet2) returns the set " + stringSet.union(stringSet2));


        }
}
