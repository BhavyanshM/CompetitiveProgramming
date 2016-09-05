
/*
 * Package java.util
 * Class Arrays
 * This is a short program which tests all the available methods in the Arrays class 
 * and prints out the result on the console output. 
*/

import java.util.*;


public class Main {
	
	public static void main(String[] args){
		int[] intArray = {1,2,3,40,5};
		
		//Using toString method from the Arrays class
		System.out.println("intArray: " + Arrays.toString(intArray));
		
		//Using binarySearch method from Arrays class
		System.out.println("Index of 40: " + Arrays.binarySearch(intArray, 40));
		
		//Using the copyOf method of the Arrays class
		int[] newArray = Arrays.copyOf(intArray, 6);
		System.out.println("newArray: " + Arrays.toString(newArray));
		
		//Using the copyRangeOf method of the Array class
		//Does not include the toIndex, takes everything before that
		int[] anotherArray = Arrays.copyOfRange(intArray, 2, 5);
		System.out.println("anotherArray: " + Arrays.toString(anotherArray));
		
		//Using the deepEquals method of the Array class
		int[][] deepArray = {intArray, newArray, anotherArray};
		int[][] anotherDeepArray = {intArray, newArray, anotherArray};
		int[][] newDeepArray = {intArray, newArray, {1,2,3}};
		System.out.println("intArray.deepEquals(anotherDeepArray):  " + Arrays.deepEquals(deepArray, anotherDeepArray));
		System.out.println("intArray.deepEquals(newDeepArray):  " + Arrays.deepEquals(deepArray, newDeepArray));
		
		//Using the deepHashCode method of the Arrays class
		System.out.println("HashCode(deepArray): " + Arrays.deepHashCode(deepArray));
		
		//Using the deepToString method fo the Array class
		System.out.println("deepArray: " + Arrays.deepToString(deepArray));
		
		//Using the equals method of the Arrays class
		System.out.println("intArray.equals(newArray):  " + Arrays.equals(intArray, newArray));
		System.out.println("intArray.equals(intArray):  " + Arrays.equals(intArray, intArray));
		
		//Using the fill method of the Arrays class
		Arrays.fill(intArray, 40);
		System.out.println("Fill(intArray, 40):  " + Arrays.toString(intArray));
		
		
/*		OUTPUT of the program: 
 * 
 * 		intArray: [1, 2, 3, 40, 5]
		Index of 40: 3
		newArray: [1, 2, 3, 40, 5, 0]
		anotherArray: [3, 40, 5]
		intArray.deepEquals(anotherDeepArray):  true
		intArray.deepEquals(newDeepArray):  false
		HashCode(deepArray): 1088175066
		deepArray: [[1, 2, 3, 40, 5], [1, 2, 3, 40, 5, 0], [3, 40, 5]]
		intArray.equals(newArray):  false
		intArray.equals(intArray):  true
		Fill(intArray, 40):  [40, 40, 40, 40, 40]
*/
	}

}
