package model;

import java.awt.*;

public class Pilot {

    private String name, team;
    private int braking, talent, luck, overtake, strategy, points;
    public int indice;
    public int[] tabPoints;
    private Car car;
    private Color color;

    public Pilot(String name, int braking, int talent, int luck, int overtake, int strategy,String team, int indice) {
        this.name = name;
        this.braking = braking;
        this.talent = talent;
        this.luck = luck;
        this.overtake = overtake;
        this.strategy = strategy;
        this.points = 0;
        this.team = team;
        this.indice = indice;
        this.tabPoints = new int[21];
        switch(team){
            case "FERRARI":
                this.color = new Color(255,0,0);
                break;
            case "MERCEDES":
                this.color = new Color(48,220,134);
                break;
            case "REDBULL":
                this.color = new Color(5,0,70);
                break;
            case "RENAULT":
                this.color = new Color(212,255,1);
                break;
            case "HAAS":
                this.color = new Color(86,87,81);
                break;
            case "FORCE INDIA":
                this.color = new Color(228,92,223);
                break;
            case "MCLAREN":
                this.color = new Color(255,104,38);
                break;
            case "TORO ROSSO":
                this.color = new Color(39,79,209);
                break;
            case "SAUBER":
                this.color = new Color(144,21,2);
                break;
            case "WILLIAMS":
                this.color = new Color(255,255,255);
                break;
        }
    }

    public void setCar(Car c){
        this.car = c;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getBraking() {
        return braking;
    }

    public int getTalent() {
        return talent;
    }

    public int getLuck() {
        return luck;
    }

    public int getOvertake() {
        return overtake;
    }

    public int getStrategy() {
        return strategy;
    }

    public Car getCar() {
        return car;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", braking=" + braking +
                ", talent=" + talent +
                ", luck=" + luck +
                ", overtake=" + overtake +
                ", strategy=" + strategy +
                ", car=" + car +
                '}';
    }

    public void setPoints(int i) {
        this.points = i;
    }

    public void setPointsPourCircuit(int points,int circuit){
        tabPoints[circuit] = points;
    }

    public int getPoints() {
        return this.points;
    }
}
