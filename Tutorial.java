package idontcare;

import java.util.Scanner;

public class Tutorial {
	
	Player onlyPlayer = new Player();
	
	private Scanner input = new Scanner(System.in);
	
	public void manageTutorial() throws InterruptedException {
		TypedText.typedNormal("\nHey kid, I don't have much time but it looks like you're confused do you want my help?\nEnter 'Yes' or 'No'");
		String answer = input.nextLine();
		onlyPlayer.setAnswer(answer); 
		if (onlyPlayer.getAnswer().equalsIgnoreCase("yes")) {
			startTutorial();
		}
		else {
			skipTutorial();
		}
	}
	
	public void startTutorial() throws InterruptedException {
		TypedText.typedNormal("Nice to meet you " + onlyPlayer.getName()+"\n");
		TypedText.typedNormal("Seems like you're stuck in quite the predicament, but don't worry let me help you out a little.\n");
		TypedText.typedNormal("You're currently about 6 floors above base level.\n");
		TypedText.typedNormal("Right now you need to get out of here before you become like me, so go grab that rod over there.\n\n");
		TypedText.typedFast("**You see some sort of beat up iron rod to your left, do you want to pick it up?**");
	}
	
	public void skipTutorial() throws InterruptedException {
		// Throw them into the level
	}
}