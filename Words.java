import java.util.ArrayList;
import java.util.Random;

public class Words {

	//variables
	private String[] listOfWords ; //the list holds our words
	private String mod;

	//constructor
	public Words(String level) 
	{
		this.mod = level;
		listOfWords = new String[] {"PEE","KIWI","PEAR","ONION","LEMON","APPLE","ORANGE","BANANA","CARROT","POTATO","MANDARIN",                            
				"CUCUMBER", "GRAPEFRUIT", "STRAWBERRY", "WATERMELON" , "GRAPEFRUIT" };
	}
	
	public String getWord() //determining difficulty of game according to its number of letters
	{
		int minLevel=0;
		int maxLevel=0;
		if (mod.equals("easy")){
			minLevel = 3;
			maxLevel = 4;}
		else if (mod.equals("normal")){
			minLevel = 5;
			maxLevel = 9;}
		else if (mod.equals("hard")){
			minLevel = 10;
			maxLevel = 12;}
		
		
		Random rnd  = new Random();


		if (minLevel == 0 && maxLevel == 0) // If user enters wrong input 3 times in a row, it selects a random word and returns it
			return listOfWords[rnd.nextInt(listOfWords.length)];
		else {
			ArrayList<String> wordsInLevel = new ArrayList<>();
			for (String word : listOfWords) {
				if (word.length() <= maxLevel && word.length() >= minLevel) // if our word satisfies with condition
					wordsInLevel.add(word);
			}
			return wordsInLevel.get(rnd.nextInt(wordsInLevel.size()));
		}
	}

	//getters and setters
	public String[] getListOfWords() {
		return listOfWords;
	}

	public void setListOfWords(String[] listOfWords) {
		this.listOfWords = listOfWords;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String level) {
		this.mod = level;
	}
	
}