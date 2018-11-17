package model;

public class SimulationCourse {

    private Track track;

    public SimulationCourse(Track track){
        this.track = track;
    }

    public int simulationPilot(Pilot p){
        int res = 0;
        int random = ((int) (Math.random()*15));
        if(random < p.getLuck()+p.getTalent()){
            int indice1 = (p.getBraking() + p.getCar().getChassis()) * track.getBraking();
            int indice2 = (p.getCar().getMotor() + p.getOvertake()) * track.getSpeed();
            int indice3 = (p.getTalent() + p.getCar().getAero()) * track.getDownforce();
            int indice4 = (p.getTalent() + p.getStrategy()) * track.getDifficulty();
            res = indice1+indice2+indice3+indice4;
        }
        return res;
    }


}