import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
//Nadia Escamilla, 10/2, pd:7
//process through all values and print words based on user input
public class WordSorter 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in); 
		Scanner input = new Scanner(System.in);
		ArrayList <String> uniqueWords = new ArrayList <String>();
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
			uniqueWords.add(word);
		}//end while
		
		System.out.println("Choose one of the options listed:");
		System.out.println("1. Print out all the words starting with a specific letter.");
		System.out.println("2. Print out all words");
		System.out.println("3. Print out the total number of total unique words");
		System.out.println("4. Search and determine if a word is in the article");
		System.out.println("5. Remove a word from the data structure");
		System.out.println("6. Exit");
		int option = input.nextInt();

		if(option == 1){
			System.out.println("Enter a letter");
			char letter = input.nextLine();
			int convert = (int)letter;

			for(int i = 0; i <= uniqueWords.size(); i++){
				if(uniqueWords(i) == convert)
					System.out.println(word);
			}//end for loop
		}//end if

		if(option == 2){
			System.out.println(uniqueWords);
		}//end if

	}//end main
}//end class