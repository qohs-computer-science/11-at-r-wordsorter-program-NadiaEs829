import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
//Nadia Escamilla, 10/2, pd:7
//process through all values and print words based on user input
public class WordSorter 
{
	public static void main(String[] args) 
	{
		//boolean run = true;
		//while(run != false){
		Scanner in = new Scanner(System.in); 
		Scanner input = new Scanner(System.in);
		ArrayList <String> allWords = new ArrayList <String>();
		ArrayList <String> uniqueWords = new ArrayList<String>();

		int uniCounter = 0;
		try
		{
			in = new Scanner(new File("article.txt"));	
		
		}
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}	

		String word = "";
		while(in.hasNext())
		{
			word = in.next();
			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");
			//System.out.println(word);
			allWords.add(word);
			if(!uniqueWords.contains(word)){
				uniqueWords.add(word);
				uniCounter++;
			}//end if
		}//end while

		System.out.println("Choose one of the options listed:");
		System.out.println();
		System.out.println("1. Print out all the words starting with a specific letter.");
		System.out.println("2. Print out all words");
		System.out.println("3. Print out the total number of total unique words");
		System.out.println("4. Search and determine if a word is in the article");
		System.out.println("5. Remove a word from the data structure");
		System.out.println("6. Exit");
		int option = input.nextInt();

		//if(option == 1){
			//System.out.println("Enter a letter");
			//String letter = input.nextLine();
			//int convert = Integer.valueOf(letter);

			//for(int i = 0; i <= allWords.size(); i++){
				//int convertLetter = Integer.valueOf(allWords[i]);
				//if(convertLetter == convert) //doesn't work
				//System.out.println("All words starting with" + letter);
				//System.out.println(word);
			//}//end for loop
		//}//end if

		if(option == 2){
			for (int i = 0; i < allWords.size(); i++){
				System.out.println(allWords.get(i));
			}
		}//end if option 2 

		if(option == 3){
			System.out.println("There are " + uniCounter + " unique words in the article");
			if(uniCounter == 0)
				System.out.println("Empty List");
		}//end if

		if(option == 4){
			boolean inside;
			System.out.println("Enter a single word");
			input.nextLine();
			String word1 = input.nextLine();
			for(int i = 0; i < allWords.size(); i++){
				if(allWords.get(i).equals(word1))
					inside = true;
			}//end for loop
			if(inside = true)
				System.out.println("Word found in the article");
			else
				System.out.println("Word NOT found in the article");
		}//end if

		if(option == 5){
			System.out.println("Enter a single word");
			input.nextLine();
			String word2 = input.nextLine();
			for(int x = allWords.size()-1; x >= 0; x--){
				if(allWords.get(x).equals(word2)){
					allWords.remove(x);
				}//end if
			}//end for loop
			if(!allWords.contains(word2))
				System.out.println("Word successfully removed from the list");
			else
				System.out.println("Word NOT found in the article");
		}//end if
		if(option == 6){
			
		}//end if
		//}//end while loop (from beginning)
	}//end main
}//end class