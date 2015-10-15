import java.util.Scanner;
public class BasicGame 
{
	public static void main (String[] args)
	{
		int oddRollCount = 0;
		int evenCount = 0;
		int wins = 0;
		Scanner input = new Scanner (System.in);
		String choice;
		String guess;
		char guessChar;
		int roll;
		char choiceChar = 'Y';
		int count = 0;
		do{
			roll = (int) (Math.random() * 6 ) + 1;
			count ++;
			//System.out.print(roll);
			
			System.out.printf("You rolled a dice. Did the dice land on an odd or even number? 'O' for odd 'E' for even: ");
			guess = input.next();
			guessChar = guess.charAt(0);
			guessChar = Character.toUpperCase(guessChar);
			
			switch(guessChar)
			{
				case 'O':
				{
					if (roll % 2 == 0)
					{
						System.out.println("You guessed odd and the roll was even. Fail.");
					}
					else if (roll % 2 == 1)
					{
						System.out.println("You guessed odd and the roll was odd. Win.");
						wins++;
						oddRollCount++;
					}
					break;
				}
				case 'E':
				{
					if (roll % 2 == 0)
					{
						System.out.println("You guessed even and the roll was even. Win.");
						wins++;
						evenCount++;
					}
					else if (roll % 2 == 1)
					{
						System.out.println("You guessed even and the roll was odd. Fail.");
						evenCount++;
						oddRollCount++;
					}
					break;
				}
		
			}
			System.out.print("\nDo again? 'Y' for yes 'N' for no: ");
			choice = input.next();
			
			choiceChar = choice.charAt(0);
			choiceChar = Character.toUpperCase(choiceChar);
			System.out.print("\n\n");
		}while (choiceChar == 'Y');
		float percentOddRoll = (((float)oddRollCount) / ((float)count) * (100));
		float percentEven = (((float)evenCount)/((float)count)) * (100);
		float percentWin = (((float)wins)/((float)count)) * (100);
		System.out.printf("You played this game %d times!", count);
		System.out.printf("\nYou win %f percent of the time.", percentWin);
		System.out.printf("\nYou select even %f percent of the time.", percentEven);
		System.out.printf("\nYou roll an odd number %f percent of the time.", percentOddRoll);
	}
}
