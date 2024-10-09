import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
//Nadia Escamilla, 10/2, pd:7
//process through all values and print words based on user input
public class WordSorter 
{
	public static void main(String[] args) 
	{
		boolean run = true;
		while(run != false){
		Scanner in = new Scanner(System.in); 
		Scanner input = new Scanner(System.in);
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

		//NOTE: Check all word inputs are in lowercase!

		if(option == 1){
			System.out.println("Enter a letter");
			input.nextLine();
			String letter = input.nextLine().toLowerCase();
			char letterOne = letter.charAt(0);
			System.out.println("Here's a list of all words starting with " + letter);
			boolean ans;
			for(int i = 0; i < uniqueWords.size(); i++){
				String firstWord = uniqueWords.get(i);
				char firstLetter = firstWord.charAt(0);
				if(firstLetter == letterOne){
					ans = true;
					System.out.println(uniqueWords.get(i));
				}//end if
				else 
					ans = false;
			}//end for loop
			if(ans = false) 
				System.out.println("No words start with this letter");
			System.out.println();
		}//end if

		//finish option 2
		if(option == 2){
			int x = 97;
			int i = 0;
			//while(x >= 97 && x <= 122)
			System.out.println();
			System.out.println("List of letter " + (char)x);
			//for(int i = 0; i <= uniqueWords.size(); i++)
			while (x >= 97 && x <= 122){
				if(uniqueWords.get(i).charAt(0) == (char)x){
					System.out.println(uniqueWords.get(i));
				}//end if
				i++;
			}//end while
			x++;
		}//end option 2 

		if(option == 3){
			System.out.println("There are " + uniCounter + " unique words in the article");
			if(uniCounter == 0)
				System.out.println("Empty List");
		}//end option 3

		if(option == 4){
			boolean inside;
			System.out.println("Enter a single word");
			input.nextLine();
			String word1 = input.nextLine().toLowerCase();
			for(int i = 0; i < uniqueWords.size(); i++){
				if(uniqueWords.get(i).equals(word1))
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
			String word2 = input.nextLine().toLowerCase();
			for(int x = uniqueWords.size()-1; x >= 0; x--){
				if(uniqueWords.get(x).equals(word2)){
					uniqueWords.remove(x);
				}//end if
			}//end for loop
			if(!uniqueWords.contains(word2))
				System.out.println("Word successfully removed from the list");
			else
				System.out.println("Word NOT found in the article");
		}//end if
		if(option == 6)
			run = false;
		}//end while loop (from the beginning)
	}//end main
}//end class