package model;

public class Track {

    private String name;
    private int braking, speed, downforce, difficulty;

    public Track(String name, int braking, int speed, int downforce, int difficulty) {
        this.name = name;
        this.braking = braking;
        this.speed = speed;
        this.downforce = downforce;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public int getBraking() {
        return braking;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDownforce() {
        return downforce;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
