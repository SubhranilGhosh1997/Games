package com.monocept.test;

import java.util.Scanner;

public class PigDiceGame {

	public static void main(String[] args) {
		System.out.println("Let's Play PIG!\n\n");
		System.out.println("* See how many turns it takes you to get to 20.");
		System.out.println("* Turn ends when you hold or roll a 1.");
		System.out.println("* If you roll a 1, you lose all points for the turn.");
		System.out.println("* If you hold, you save all points for the turn.\n\n");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("Want to play ihis game press y.");
		char flag = sc.nextLine().charAt(0);
		while (flag == 'y' || flag == 'Y') {
			System.out.println();
			System.out.println("Welcome to the game of Pig!\r\n");
			System.out.println();
			int turn = 1, score = 0, point;
			int currentscore = 0;
			char choice;
			do {
				System.out.println("Turn " + turn + ":");
				System.out.println();
				System.out.println("Enter 'r' to roll again, 'h' to hold.");
				currentscore = score;
				choice = sc.nextLine().charAt(0);
				while (choice != 'h' && choice != 'H') {
					if (choice == 'r' || choice == 'R') {
						point = roll();
						if (point != 1) {
							currentscore += point;
							if (currentscore >= 20) {
								choice = 'h';
								break;
							}
							System.out.printf("Your turn score is %d and your total score is %d\n", currentscore,
									score);
							System.out.println("Enter 'r' to roll again, 'h' to hold.");
							choice = sc.nextLine().charAt(0);
						} else {
							System.out.println("Turn over. No Score\n");
							break;
						}
					}
				}
				if (choice == 'h' || choice == 'H') {
					score = currentscore;
					System.out.printf("Your turn score is %d and your total score is %d\n", currentscore, score);
				}
				if (score >= 20) {
					System.out.println("You Win! You finished in " + turn + " turns!");
					System.out.println("Game Over\n");
				}
				turn++;
			} while (score <= 20);
			System.out.println("Want to play ihis game press y.");
			flag = sc.nextLine().charAt(0);
			sc.nextLine();
		}
	}

	public static int roll() {
		int point = 0;
		point = (int) (Math.random() * (6 - 1 + 1) + 1);
		System.out.println("You rolled: " + point);
		return point;

	}

}
