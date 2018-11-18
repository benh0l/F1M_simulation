package model;

import java.util.Random;

public class SimulationCourse {

    private Track track;

    public SimulationCourse(Track track){
        this.track = track;
    }

    public int simulationPilot(Pilot p){
        int res = 0;
        Random r = new Random();
        int random = r.nextInt(100);
        if(random <= 100 - ( (p.getLuck() + p.getTalent())/2 + track.getDifficulty()) ){
            int indice1 = ((p.getBraking() + p.getCar().getChassis()) + (r.nextInt(2)-1) )* track.getBraking();
            int indice2 = ((p.getCar().getMotor() + p.getOvertake()) + (r.nextInt(2)-1) )* track.getSpeed();
            int indice3 = ((p.getTalent() + p.getCar().getAero()) + (r.nextInt(2)-1) ) * track.getDownforce();
            int indice4 = ((p.getTalent() + p.getStrategy()) + (r.nextInt(2)-1) ) * track.getDifficulty();
            res = indice1+indice2+indice3+indice4;
        }
        return res;
    }


}
