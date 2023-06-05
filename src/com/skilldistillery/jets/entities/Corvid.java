package com.skilldistillery.jets.entities;

public class Corvid extends Bird implements ToolBox {

	public Corvid(String family, String birdType, long speed, int range, double weight) {
		super(family, birdType, speed, range, weight);
	}

	public Corvid() {
	}

	@Override
	public String toString() {
		return "(" + birdType + ")\n" + family + ": Top Speed = " + speed + "mph, Range = " + range
				+ " miles, average lbs = " + weight + ".";
	}

	public void usesTools() {

		System.out.println("\nMembers of the Corvid family can use a stick for leverage.\n");

	}

}
