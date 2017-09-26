import java.util.Scanner;

/**
 * Find the average of some student test scores.
 */

public class TestScores {
	private static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args)
	{		
		do {
			System.out.print("Enter student's name: "); 
			String name = console.next();   // what could go wrong?

			if (name.equals("quit") || name.equals("exit")) break;

			// avoid duplicate code - "Don't Repeat Yourself" (DRY)
			System.out.print("Enter score 1: ");
			int score1 = console.nextInt();
			System.out.print("Enter score 2: ");
			int score2 = console.nextInt();
			System.out.print("Enter score 3: ");
			int score3 = console.nextInt();
			
			// There is a BUG here.  What is it?
			double avg = (score1 + score2 + score3)/3;
			System.out.printf("%s Average is %.2f\n", name, avg);
		} while(true);
	}
}
