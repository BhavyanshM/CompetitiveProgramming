/*
 * Package java.util
 * Class Arrays
 * This is a short program which tests all the available methods in the Arrays class 
 * and prints out the result on the console output. 
*/

import java.util.*;

public class Collection {
	
	public static void main(String[] args){
		List<Integer> intList = new ArrayList<Integer>();
		
		//Using the method add() of the ArrayList class
		//Works only for one element
		intList.add(23);
		intList.add(24);
		intList.add(25);
		
		//Using the addAll method of the Collections class
		List<Integer> newIntList = new ArrayList<Integer>();
		Collections.addAll(intList, 2,3,4);
		
		//Using the toString() method from the List set of methods to print out the List
		String s = intList.toString();
		System.out.println("intList: " + s);
		
		//Using the binarySearch method from the Collections class
		//Sorting the List using the Sort() method in the Collections class
		Collections.sort(intList);
		System.out.println("Key Index = " + Collections.binarySearch(intList, 2));
		
		//newIntList.add(2);
		//newIntList.add(3);
		newIntList.add(13);
		
		//Using the disjoint method of the Collections class
		//It tells us if the two lists are disjoint or not.
		System.out.println("Disjoint: " + Collections.disjoint(newIntList, intList));
		
		//Using the fill() method of the Collections class
		newIntList.add(0);
		newIntList.add(12);
		System.out.println("newIntList: " + newIntList);
		Collections.fill(newIntList, 5);
		System.out.println("newIntList: " + newIntList);
		
		//Using the method frequency() from the class Collections
		newIntList.add(2);
		newIntList.add(23);
		System.out.println("newIntList: " +(newIntList));
		System.out.println("Frequency(5): "+ Collections.frequency(newIntList, 5));
		System.out.println("Frequency(2): " +Collections.frequency(newIntList, 2));
		
		//Using the indexOfSubList() method from the Collections method on a list
		//There is also a method named lastIndexOfSubList()
		List<Integer> theList = new ArrayList<Integer>();
		theList.add(4);
		theList.add(23);
		theList.add(24);
//		theList.add(26);
		System.out.println("intList: "+intList);
		System.out.println("theList: "+theList);
		System.out.println("indexOfSubList: "+Collections.indexOfSubList(intList, theList));
		
		//Using the max method of the Collections class
		System.out.println("Max(intList): "+Collections.max(intList));
		System.out.println("Max(newIntList): "+Collections.max(newIntList));
		
		
		//Using the min method of the Collections class
		System.out.println("Min(intList): "+Collections.min(intList));
		System.out.println("Min(newIntList): "+Collections.min(newIntList));
		
		//Using the method of nCopies to create a list with n repeated elements
		List<String> names = Collections.nCopies(3, "Aqua");
		System.out.println(names);
		
		//Using the reverse() function from the Collections class
		System.out.println("Before reverse (intList): "+intList);
		Collections.reverse(intList);
		System.out.println("After reverse (intList): "+intList);
		
		//Using the replaceAll() method from the Collections class
		Collections.replaceAll(intList, 25, 5);
		System.out.println("Replace 25 by 5(intList): "+intList);
		
		//Using the rotate() method of the Collections class
		//Rotations work in both directions, change the sign
		System.out.println("Before rotation (intList): "+intList);
		Collections.rotate(intList, -2);
		System.out.println("After rotate (intList): "+intList);

		//Using the shuffle() method from the Collections class
		Collections.shuffle(intList);
		System.out.println("Shuffled intList: "+intList);
		
		//Using the swap() method from the Collecitons class
		Collections.swap(intList, 0, intList.size()-1);
		System.out.println("Swapped 0<->length intList: "+intList);
	}

}







