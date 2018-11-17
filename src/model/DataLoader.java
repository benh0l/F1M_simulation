package model;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader {

    private String file;

    public DataLoader(String file){
        this.file = file;
    }

    public ArrayList<Track> loadTrack() throws IOException {
        File f = new File(file);
        Sheet sheet = SpreadSheet.createFromFile(f).getSheet(0);

        ArrayList<Track> tracks = new ArrayList<>();
        Track[] tabTrack = new Track[15];

        for(int i = 3; i<16; i++){
            String num = sheet.getCellAt(new String("A"+i)).getTextValue();
            if(!num.equals("")){
                String name = sheet.getCellAt(new String("B"+i)).getTextValue();
                String braking = sheet.getCellAt(new String("C"+i)).getTextValue();
                String speed = sheet.getCellAt(new String("D"+i)).getTextValue();
                String downforce = sheet.getCellAt(new String("E"+i)).getTextValue();
                String difficulty = sheet.getCellAt(new String("F"+i)).getTextValue();
                tabTrack[Integer.parseInt(num)-1] = new Track(name,Integer.parseInt(braking),Integer.parseInt(speed),Integer.parseInt(downforce),Integer.parseInt(difficulty));
            }
        }

        for(int j = 0; j<tabTrack.length; j++){
            if (tabTrack[j]!=null)
                tracks.add(tabTrack[j]);
        }

        return tracks;
    }


    public ArrayList<Car> loadCar() throws IOException {
        File f = new File(file);
        Sheet sheet = SpreadSheet.createFromFile(f).getSheet(1);

        ArrayList<Car> cars = new ArrayList<>();

        for(int i = 3; i<13; i++){
            String name = sheet.getCellAt(new String("B"+i)).getTextValue();
            if(!name.equals("")){
                String aero = sheet.getCellAt(new String("C"+i)).getTextValue();
                String chassis = sheet.getCellAt(new String("D"+i)).getTextValue();
                String motor = sheet.getCellAt(new String("E"+i)).getTextValue();
                Car c = new Car(name,Integer.parseInt(aero),Integer.parseInt(chassis),Integer.parseInt(motor));
                cars.add(c);
            }
        }
        return cars;
    }


    public ArrayList<Pilot> loadPilot() throws IOException {
        File f = new File(file);
        Sheet sheet = SpreadSheet.createFromFile(f).getSheet(2);
        ArrayList<Pilot> pilots = new ArrayList<>();
        int indice = 0;

        for(int i = 3; i<23; i++){
            String name = sheet.getCellAt(new String("B"+i)).getTextValue();
            if(!name.equals("")){
                String braking = sheet.getCellAt(new String("C"+i)).getTextValue();
                String talent = sheet.getCellAt(new String("D"+i)).getTextValue();
                String luck = sheet.getCellAt(new String("E"+i)).getTextValue();
                String overtake = sheet.getCellAt(new String("F"+i)).getTextValue();
                String strategy = sheet.getCellAt(new String("G"+i)).getTextValue();
                String team = sheet.getCellAt(new String("H"+i)).getTextValue();
                Pilot p = new Pilot(name,Integer.parseInt(braking),Integer.parseInt(talent),Integer.parseInt(luck),Integer.parseInt(overtake),Integer.parseInt(strategy),team,indice);
                pilots.add(p);
                indice++;
            }

        }
        return pilots;
    }



}
