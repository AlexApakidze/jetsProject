package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Bird {
	protected String family;
	protected String birdType;
	protected long speed;
	protected int range;
	protected double weight;

	public Bird() {
	}

	public Bird(String family, String birdType, long speed, int range, double weight) {
		this.family = family;
		this.birdType = birdType;
		this.speed = speed;
		this.range = range;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "(" + family + ") " + birdType + ": Top Speed = " + speed + ", Range = " + range + ", average lbs = "
				+ weight + ".";
	}

	public void Strut() {
		double range = (int) this.range;
		double speed = (long) this.speed;
		double time = range / speed;
		System.out.printf("If this bird goes its max speed, it can cover its daily travel in %.2f", time * 60);
		System.out.print(" minutes\n\n\n");
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getBirdType() {
		return birdType;
	}

	public void setBirdType(String birdType) {
		this.birdType = birdType;
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birdType, range, speed, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		return Objects.equals(birdType, other.birdType) && range == other.range && speed == other.speed
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

}