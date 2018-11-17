package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

public class SimulationChampionnat extends Observable {

    private ArrayList<Track> tracks;
    private ArrayList<Pilot> pilots;
    int [][] tab;

    public SimulationChampionnat(ArrayList<Track> tracks, ArrayList<Pilot> pilots) {
        this.tracks = tracks;
        this.pilots = pilots;
        tab = new int[tracks.size()][pilots.size()];
    }

    public void simulateChampionship(){
        int i = 0;
        for(Track t : tracks){
            SimulationCourse sc = new SimulationCourse(t);
            int j = 0;
            for(Pilot p : pilots){
                tab[i][j] = sc.simulationPilot(p);
                j++;
            }
            i++;
        }
    }

    public int[][] indiceToPoints(){
        int[][] tabRes = new int[tab.length][tab[0].length];
        tabRes = indiceToPosition();
        tabRes = positionToPoints(tabRes);
        this.tab = tabRes;
        setChanged();
        notifyObservers();
        System.out.println("NOTIFY");
        return tabRes;
    }

    public int[][] indiceToPosition(){
        int reste, max, indiceMax;
        int[][] tabRes = new int[tab.length][tab[0].length];
        for(int i = 0;i < tab.length;i++){
            reste = 10;
            max = 0;
            indiceMax = -1;
            while(reste > 0){
                for(int j = tab[0].length-1;j >= 0;j--){
                    if(max <= tab[i][j]){
                        max = tab[i][j];
                        indiceMax = j;
                        //System.out.print(indiceMax+"  ");
                    }
                }
                //System.out.println("\n");
                tab[i][indiceMax] = -1;
                tabRes[i][indiceMax] = reste;
                indiceMax = -1;
                max = 0;
                reste--;
            }
        }
        return tabRes;
    }

    public int[][] positionToPoints(int[][] tabPos){
        int[][] tabRes = new int[tab.length][tab[0].length];
        for(int i = 0;i < tab.length;i++){
            for(int j = 0;j< tab[0].length;j++){
                switch (tabPos[i][j]){
                    case 10:
                        tabRes[i][j] = 25;
                        pilots.get(j).setPoints( pilots.get(j).getPoints() + 25);
                        pilots.get(j).tabPoints[i] = 25;
                        break;
                    case 9:
                        tabRes[i][j] = 18;
                        pilots.get(j).setPoints( pilots.get(j).getPoints() + 18);
                        pilots.get(j).tabPoints[i] = 18;
                        break;
                    case 8:
                        tabRes[i][j] = 15;
                        pilots.get(j).setPoints( pilots.get(j).getPoints() + 15);
                        pilots.get(j).tabPoints[i] = 15;
                        break;
                    case 7:
                        tabRes[i][j] = 12;
                        pilots.get(j).setPoints( pilots.get(j).getPoints() + 12);
                        pilots.get(j).tabPoints[i] = 12;
                        break;
                    case 6:
                        tabRes[i][j] = 10;
                        pilots.get(j).setPoints( pilots.get(j).getPoints() + 10);
                        pilots.get(j).tabPoints[i] = 10;
                        break;
                    case 5:
                        tabRes[i][j] = 8;
                        pilots.get(j).setPoints( pilots.get(j).getPoints() + 8);
                        pilots.get(j).tabPoints[i] = 8;
                        break;
                    case 4:
                        tabRes[i][j] = 6;
                        pilots.get(j).setPoints( pilots.get(j).getPoints() + 6);
                        pilots.get(j).tabPoints[i] = 6;
                        break;
                    case 3:
                        tabRes[i][j] = 4;
                        pilots.get(j).setPoints( pilots.get(j).getPoints() + 4);
                        pilots.get(j).tabPoints[i] = 4;
                        break;
                    case 2:
                        tabRes[i][j] = 2;
                        pilots.get(j).setPoints( pilots.get(j).getPoints() + 2);
                        pilots.get(j).tabPoints[i] = 2;
                        break;
                    case 1:
                        tabRes[i][j] = 1;
                        pilots.get(j).setPoints( pilots.get(j).getPoints() + 1);
                        pilots.get(j).tabPoints[i] = 1;
                        break;
                        default:
                            tabRes[i][j] = 0;
                            break;
                }
            }
        }
        return tabRes;
    }

    @Override
    public String toString() {
        String res = "SimulationChampionnat{" + "tab=\n";
        for(int i =0; i<tab.length; i++){
            for (int j=0; j<tab[0].length;j++){
                res += tab[i][j]+" ";
            }
            res += "\n";
        }
        return res;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public ArrayList<Pilot> getPilots() {
        return pilots;
    }

    public int[][] getTab() {
        return tab;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public void setPilots(ArrayList<Pilot> pilots) {
        this.pilots = pilots;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }
}
