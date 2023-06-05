package com.skilldistillery.jets.entities;

public class Pheasant extends Bird {

	public Pheasant(String family, String birdType, long speed, int range, double weight) {
		super(family, birdType, speed, range, weight);
	}

	@Override
	public String toString() {
		return "(" + birdType + ")\n" + family + ": Top Speed = " + speed + "mph, Range = " + range
				+ " miles, average lbs = " + weight + ".";
	}

}
