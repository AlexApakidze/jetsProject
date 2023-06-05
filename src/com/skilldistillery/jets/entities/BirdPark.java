package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BirdPark {
	private Scanner sc = new Scanner(System.in);
	private List<Bird> birds = new ArrayList<>();

	public BirdPark() {
		readBirds();
	}

	public List<Bird> getBirds() {

		return birds;
	}

	public void setBirds(List<Bird> birds) {
		this.birds = birds;
	}

	public List<Bird> readBirds() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("birds.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] birdRecord = line.split(",");
				String family = (birdRecord[0]);
				String birdType = (birdRecord[1]);
				long speed = Long.parseLong(birdRecord[2]);
				int range = Integer.parseInt(birdRecord[3]);
				double lbs = Double.parseDouble(birdRecord[4]);
				Bird b = null;
				if (family.equalsIgnoreCase("Raptor")) {
					b = new Raptor(family, birdType, speed, range, lbs);
				} else if (family.equalsIgnoreCase("Corvid")) {
					b = new Corvid(family, birdType, speed, range, lbs);
				} else if (family.equalsIgnoreCase("Pheasant")) {
					b = new Pheasant(family, birdType, speed, range, lbs);
				}
				birds.add(b);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return birds;
	}

	public void listBirds() {

		for (Bird bird : birds) {
			System.out.println(bird + "\n");
		}
	}

	public void strut() {

		for (Bird bird : birds) {
			System.out.println(bird + "\n");
			bird.Strut();
		}
	}

	public void pickFastest() {
		long fastestSpeed = 0;
		Bird fastestBird = null;
		for (Bird bird : birds) {
			if (bird.getSpeed() > fastestSpeed) {
				fastestSpeed = bird.getSpeed();
				fastestBird = bird;
			}
		}
		System.out.println("The " + fastestBird.getBirdType() + " is the fastest bird in the park. \n"
				+ "Its top speed is " + fastestBird.getSpeed() + "mph!");
	}

	public void pickLongestRange() {

		int longestRange = 0;
		Bird maxDistanceBird = null;
		for (Bird bird : birds) {
			if (bird.getRange() > longestRange) {
				longestRange = bird.getRange();
				maxDistanceBird = bird;
			}
		}
		System.out.println("The " + maxDistanceBird.getBirdType()
				+ " can fly the furthest distance out of all the birds in the park. \n" + "It can fly "
				+ maxDistanceBird.getRange() + " miles in one day!");
	}

	public void useToolbox() {
		ToolBox toolBird = null;
		for (Bird bird : birds) {
			if (bird instanceof ToolBox) {
				System.out.println(bird);
				toolBird = (ToolBox) bird;
			}
		}
		if (toolBird == null) {
			System.out.println("All the birds that knew how to use tools are traveling for work");

		} else {
			toolBird.usesTools();
		}
	}

	public void hasRaptorVision() {

		RaptorVision visionBird = null;
		for (Bird bird : birds) {
			if (bird.getFamily().equalsIgnoreCase("Raptor")) {
				System.out.println(bird);
				visionBird = (RaptorVision) bird;
			}
		}
		if (visionBird == null) {
			System.out.println("All the birds with great eyesight have gone sight seeing");

		} else {
			visionBird.keenEye();
		}
	}

	public void addBird() {
		boolean keepGoing = true;
		Bird newBird = null;
		int choice = 0;
		String family = null;
		String birdType = null;
		long speed = 0;
		int range = 0;
		double weight = 0;

		while (keepGoing) {
			while (choice < 1 || choice > 3) {
				System.out.println("What family does the bird belong to?");
				System.out.println("1: Corvid");
				System.out.println("2: Raptor");
				System.out.println("3: Pheasant");

				if (sc.hasNextInt()) {
					choice = sc.nextInt();
					if (choice < 1 || choice > 3) {
						System.out.println("Please pick 1 - 3.");
					}
				} else {
					sc.next();
					System.out.println("Pick a number.");
				}
			}

			if (choice == 1) {
				family = "Corvid";
			}
			if (choice == 2) {
				family = "Raptor";
			}
			if (choice == 3) {
				family = "Pheasant";
			}

			System.out.println("What kind of bird is it?");
			sc.nextLine();
			birdType = sc.nextLine();

			System.out.println("What is the birds top speed in mph?");
			while (!sc.hasNextLong()) {
				System.out.println("Please pick a whole number");
				sc.nextLine();
			}
			speed = sc.nextLong();

			System.out.println("How many miles can the bird travel in one day?");
			while (!sc.hasNextInt()) {
				System.out.println("Please pick a whole number");
				sc.nextLine();
			}
			range = sc.nextInt();

			System.out.println("How much does the bird weigh in lbs?");
			while (!sc.hasNextDouble()) {
				System.out.println("Please pick a number");
				sc.nextLine();
			}
			weight = sc.nextDouble();

			if (family.equalsIgnoreCase("Corvid")) {
				newBird = new Corvid(family, birdType, speed, range, weight);
			} else if (family.equalsIgnoreCase("Raptor")) {
				newBird = new Raptor(family, birdType, speed, range, weight);
			} else if (family.equalsIgnoreCase("Pheasant")) {
				newBird = new Pheasant(family, birdType, speed, range, weight);
			}
			birds.add(newBird);

			System.out.println(birds.get(birds.size() - 1).getBirdType() + " has been added\n");
			System.out.println("Want to add more birds?");
			System.out.println("1: Yes \n2: No");
			while (!sc.hasNextInt()) {
				System.out.println("please pick a number.");
				sc.nextLine();
			}
			sc.nextLine();
			choice = sc.nextInt();

			while (choice > 2 || choice < 1) {
				System.out.println("please pick 1 or 2.");
				sc.nextLine();
				choice = sc.nextInt();
			}

			sc.nextLine();

			if (choice == 1) {
				choice = 0;
				continue;
			} else if (choice == 2) {
				keepGoing = false;
			} else {
				System.out.println("Please pick 1 or 2");
				choice = sc.nextInt();

			}
		}

	}

	public void removeBird() {
		int choice = 0;
		boolean keepGoing = true;

		System.out.println("Please pick a bird to remove");

		try {
			while (keepGoing) {

				for (int i = 0; i < birds.size(); i++) {
					if (birds.size() == 0) {
						System.out.println("All the birds have flown home for the winter.");
						keepGoing = false;
					}
					System.out.println((i + 1) + ": " + birds.get(i) + "\n");
				}
				System.out.println((birds.size() + 1) + ": Quit");

				choice = sc.nextInt();
				if (choice == birds.size() + 1) {
					keepGoing = false;
				} else {
					System.out.println(birds.remove(choice - 1).birdType + " has flown home for the winter\n");
				}
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Not a valid number.");
		} catch (InputMismatchException e) {
			System.out.println("Not a number.");
		}
	}

	public void quit() {
		System.out.println("Thank you for using our app");
		sc.close();
	}
}
