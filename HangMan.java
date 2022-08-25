
public class HangMan {

	
	private int partCounter;
	private String[][] hangman = null;

	public HangMan() { // Constructor: the platform of hangman by using two dimensional array
		partCounter = 0; //gives info about hangmans body
		hangman = new String[11][9];
		for (int i = 0; i<11; i++)
			for (int j = 0; j < 9; j++)
				hangman[i][j] = "  ";
		for (int i = 0; i<9; i++) {
			hangman[0][i] = "--";
			hangman[10][i] = "--";
			hangman[i+1][0] = "|";
			hangman[i+1][8] = "|";
		}
		hangman[10][0] = "|"; 
		hangman[10][8] = "|";
		hangman[0][0] = "|";
		hangman[0][8] = "|";
		hangman[9][5] = "--";
		hangman[9][6] = " |";
		hangman[9][7] = "--";
		hangman[8][6] = " |";
		hangman[7][6] = " |";
		hangman[6][6] = " |";
		hangman[5][6] = " |";
		hangman[4][6] = " |";
		hangman[3][6] = " |";
		hangman[2][6] = " |";
		hangman[1][6] = "--";
		hangman[1][5] = "--";
		hangman[1][4] = "--";
		hangman[1][3] = "--";
	}

	public boolean isCompleted() { // check whether the man is hanged. If partCounter reaches 5, the game is finished
		return partCounter == 5;
	}

	public void addPart() {
		if (partCounter == 0) 
		{
			hangman[2][3] = "| ";
			hangman[3][3] = "()";
		} 
		else if (partCounter == 1) 
		{
			hangman[4][2] = " /";
			hangman[4][4] = "\\ ";
		} 
		else if (partCounter == 2)
		{
			 
			hangman[4][3] = " |";
		} 
		else if (partCounter == 3) 
		{
			hangman[5][3] = " |";
		} 
		else if(partCounter == 4) 
		{
			hangman[6][2] = " /";
			hangman[6][4] = "\\ ";
			hangman[3][3] = " X";
		} 
			  
		
		partCounter++;   
	}

	public int getScore() { //score calculator
		return (20)* (5-partCounter);
	}

	public void printHangMan() {
		String hm = "";
		for (int i = 0; i<11; i++) {
			for (int j = 0; j < 9; j++){
				hm += hangman[i][j];
			}
			hm += "\n";
		}
		System.out.println(hm);
	}







	
	
	
	
	
}
