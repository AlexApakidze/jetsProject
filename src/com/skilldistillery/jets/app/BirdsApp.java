package com.skilldistillery.jets.app;

import java.util.Scanner;
import com.skilldistillery.jets.entities.BirdPark;

public class BirdsApp {
	Scanner sc = new Scanner(System.in);
	BirdPark bp = new BirdPark();

	public static void main(String[] args) {
		BirdsApp ba = new BirdsApp();

		ba.mainMenu();
	}

	public void mainMenu() {

		boolean keepGoing = true;
		String choice;
		while (keepGoing) {
			printMenu();

			choice = sc.next();

			switch (choice) {

			case "1":
				bp.listBirds();
				continue;

			case "2":

				bp.strut();
				continue;

			case "3":
				bp.pickFastest();
				continue;

			case "4":
				bp.pickLongestRange();
				continue;

			case "5":
				bp.useToolbox();
				continue;

			case "6":
				bp.hasRaptorVision();
				continue;

			case "7":
				bp.addBird();
				continue;

			case "8":
				bp.removeBird();
				continue;

			case "9":
				bp.quit();
				sc.close();
				keepGoing = false;
				break;

			default:
				System.out.println("Invalid entry, please pick a number from 1-9.");
				continue;

			}

		}

	}

	public void printMenu() {

		System.out.println(" ________________________________________");
		System.out.println("|               Bird Park                |");
		System.out.println("|----------------------------------------|");
		System.out.println("| 1: See birds in the park.              |");
		System.out.println("| 2: Strut all birds.                    |");
		System.out.println("| 3: View the fastest bird.              |");
		System.out.println("| 4: See which bird can fly the furthest |");
		System.out.println("| 5: Who can use tools?                  |");
		System.out.println("| 6: Which family can see the best?      |");
		System.out.println("| 7: Add a bird to the park.             |");
		System.out.println("| 8: Remove a bird from the park.        |");
		System.out.println("| 9: Quit                                |");
		System.out.println("|________________________________________|");
	}
}