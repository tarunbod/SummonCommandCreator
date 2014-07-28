package me.FirstWorldAnarchy.scc.application;

public class PotionEffect {
	private int id;
	private int duration;
	private int level;
	private boolean ambient;
	
	public PotionEffect(int id, int duration, int level, boolean ambient) {
		this.id = id;
		this.duration = duration;
		this.level = level;
		this.ambient = ambient;
	}
	
	public int getId() {
		return id;
	}
	public int getDuration() {
		return duration;
	}
	public int getLevel() {
		return level;
	}
	public boolean isAmbient() {
		return ambient;
	}
}
