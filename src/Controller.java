import java.util.*;

public class Controller {

	public static void main(String[] args) {
		
		Util utility = new Util();
		Map<Character,Integer> lettersCount = utility.getSingleLetterCountFromFile();
		Map<String,Integer> digraphsCount = utility.getGraphs(2);
		Map<String,Integer> trigraphsCount = utility.getGraphs(3);
		
		System.out.println("Single Letters");
		lettersCount.forEach((k,v) -> System.out.println("Letter: " + k + " Count: "+v));		
		System.out.println();
		System.out.println("Digraphs");
		digraphsCount.forEach((k,v) -> System.out.println("Digraphs: "+k+" Count: "+v));
		System.out.println();
		System.out.println("Trigraphs");
		trigraphsCount.forEach((k,v) -> System.out.println("Trigraphs: "+k+" Count: "+v));
		System.out.println();
		System.out.println(utility.deCrypt());
		
		
		

	}

}
