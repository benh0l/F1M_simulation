package model;

public class Pilot {

    private String name, team;
    private int braking, talent, luck, overtake, strategy;
    private Car car;

    public Pilot(String name, int braking, int talent, int luck, int overtake, int strategy,String team) {
        this.name = name;
        this.braking = braking;
        this.talent = talent;
        this.luck = luck;
        this.overtake = overtake;
        this.strategy = strategy;
        this.team = team;
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
}
