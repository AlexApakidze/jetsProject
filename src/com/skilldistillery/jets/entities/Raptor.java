package com.skilldistillery.jets.entities;

public class Raptor extends Bird implements RaptorVision {

	public Raptor(String family, String birdType, long speed, int range, double weight) {
		super(family, birdType, speed, range, weight);
	}

	@Override
	public String toString() {
		return "(" + birdType + ")\n" + family + ": Top Speed = " + speed + "mph, Range = " + range
				+ " miles, average lbs = " + weight + ".";
	}

	public void keenEye() {

		System.out.println(
				"\nBirds in the Raptor family have the best eyesight in the entirety of the Animal Kingdom.\n");
	}

}
