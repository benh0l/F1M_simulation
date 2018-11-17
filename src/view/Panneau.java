package view;

import model.Pilot;
import model.SimulationChampionnat;
import model.Track;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Panneau extends JPanel implements Observer{

    private int[][] tabPoint;
    private Font policeF1;
    private String policeRegularPath = "/font/Formula1-Regular.otf";
    private ArrayList<Track> tracks;
    private ArrayList<Pilot> pilots;

    public Panneau(Observable o) throws IOException, FontFormatException {
        super();
        o.addObserver(this);
        this.setSize(800,500);
        this.setBackground(Color.WHITE);
        policeF1 = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream(policeRegularPath)).deriveFont(15f);
        tabPoint = null;
        tracks = null;
        pilots = null;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(policeF1);
        g.setColor(Color.BLACK);
        //DRAW TRACKS NAME
        if(tabPoint != null){
            for(int t = 0; t < tabPoint.length; t++){
                if(tracks!=null)
                    g.drawString(tracks.get(t).getName().substring(0,3),150+t*75,20);
            }

        //DRAW POINTS
            for(int i = 0; i<tabPoint[0].length;i++){
                if(pilots!=null)
                    g.drawString(pilots.get(i).getName(),10,50+i*30);
                for(int j = 0;j<tabPoint.length;j++){
                    g.drawString(Integer.toString(tabPoint[j][i]),150+j*75,50+i*30);
                    System.out.println(tabPoint[j][i]);
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.tabPoint = ((SimulationChampionnat)o).getTab();
        this.tracks = ((SimulationChampionnat)o).getTracks();
        this.pilots = ((SimulationChampionnat)o).getPilots();
        repaint();
    }
}
