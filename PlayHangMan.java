import java.util.ArrayList;
import java.util.Scanner;

public class PlayHangMan {

	//variables
	private ArrayList<String> enteredLetters;
	private String[][] word;
	private int remainedLetters;
	private HangMan hangMan;
	private PlayHangMan playHangMan;

	public static void main(String[] args) {

		PlayHangMan phm = new PlayHangMan();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("WELCOME TO HANGMAN! OUR GAME CONSIST OF FRUIT AND VEGETABLES");
		System.out.println();
		System.out.println("Select a mode: easy/normal/hard: ");
		String mod = keyboard.nextLine();


		if(mod.equals("easy") || mod.equals("normal") || mod.equals("hard"))
		{
			phm.playGame(mod);
		}
		else
		{
			System.out.print("Wrong input. Please choose the difficulty of the game.");
			System.out.println();
			mod = keyboard.nextLine();
			if(mod.equals("easy") || mod.equals("normal") || mod.equals("hard"))
				phm.playGame(mod);
			else
				System.out.print("You entered wrong again. Please choose the difficulty of the game. Otherwise, game mod will be randomly selected.");
			System.out.println();
			mod = keyboard.nextLine();
			phm.playGame(mod);

		}


	} 

	public void playGame(String mod) // our game is played with invoking this method.
	{
		playHangMan = new PlayHangMan();
		hangMan = new HangMan();
		Words words = new Words(mod);
		String wrd = words.getWord();
		word = new String[wrd.length()][2];
		remainedLetters = wrd.length();
		for (int i = 0; i < wrd.length(); i++) { // creating a word. While first dimension represents the letter, second represents _
			word[i][0] = wrd.charAt(i) + "";    
			word[i][1] = "_";
		}
		Scanner keyboard = new Scanner(System.in);

		enteredLetters = new ArrayList<>();
		hangMan.printHangMan();
		while (true) {
			String hm = "";
			hm += "Letter history = ";
			for (String letter : enteredLetters)
				hm += letter + " ";

			hm += "\n\nWord = ";
			for (String[] letter : word)
				hm += letter[1] + " ";
			System.out.println(hm);

			System.out.print("Enter a letter for the word : ");
			String cmd = keyboard.nextLine();
			enterLetter(cmd);
			if (isCompleted()) 
			{
				System.out.println("Your score: " + hangMan.getScore());
				hm = "\nThe Word was = ";
				for (String[] letter : word)
					hm += letter[0] + " ";
				System.out.println(hm);
				break;
			}
			if (hangMan.isCompleted()) // if hangman is completed
			{ 
				System.out.println("You lost!");
				hm = "\nThe Word was = ";
				for (String[] letter : word)
					hm += letter[0] + " ";
				System.out.println(hm);
				break;
			}
		}
	}
	public boolean isCompleted() 
	{
		if (remainedLetters == 0) 
		{  
			System.out.println("\nYOU WON!");
			 return true;
		} 
		else
			return false;
	}

	public void enterLetter (String letter)
	{
		boolean isValid = false;
		int countLetter = 0;
		for (int i = 0; i < word.length; i++) // If the entered word and the letter is equal
		{
			if (word[i][0].equals(letter) && word[i][1].equals("_")) 
			{
				word[i][1] = letter;
				isValid = true;
				countLetter++;
			}
		}
		for (String l : enteredLetters) // The entered letter is checked to see if it is included in the entered letters. If there is, it removes it out
		{
			if (l.equals(letter)) 
			{
				isValid = false;
				enteredLetters.remove(letter);
				break;
			}
		}

		if (isValid) 
		{
			remainedLetters -= countLetter;
		} 

		else
		{
			hangMan.addPart();
		}
		enteredLetters.add(letter);
		hangMan.printHangMan();

	}

  

}


