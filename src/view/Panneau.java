package view;

import model.Pilot;
import model.SimulationChampionnat;
import model.Track;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Observable;
import java.util.Observer;

public class Panneau extends JPanel implements Observer{

    private int[][] tabPoint;
    private int[] tabTotal;
    private Font policeF1;
    private String policeRegularPath = "/font/Formula1-Regular.otf";
    private ArrayList<Track> tracks;
    private ArrayList<Pilot> pilots;

    public Panneau(Observable o) throws IOException, FontFormatException {
        super();
        o.addObserver(this);
        this.setSize(800,500);
        this.setBackground(Color.BLACK);
        policeF1 = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream(policeRegularPath)).deriveFont(12f);
        tabPoint = null;
        //tabTotal = null;
        tracks = null;
        pilots = null;
    }

    public void paintComponent(Graphics gr){
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(policeF1);
        g.setColor(Color.WHITE);
        //DRAW TRACKS NAME
        if(tabPoint != null){
            for(int t = 0; t < tabPoint.length; t++){
                if(tracks!=null)
                    g.drawString(tracks.get(t).getName().substring(0,3),150+t*50,20);
            }

            //SORT PILOT BY TOTAL POINTS
            pilots.sort(new Comparator<Pilot>() {
                @Override
                public int compare(Pilot o1, Pilot o2) {
                    return o2.getPoints()-o1.getPoints();
                }
            });

            //DRAW POINTS
            for(int i = 0; i<tabPoint[0].length;i++){
                //DRAW PILOT NAME
                if(pilots!=null) {
                    g.setColor(pilots.get(i).getColor());
                    g.fillRect(2,38+i*25,5,12);
                    g.setColor(Color.WHITE);
                    g.drawString(pilots.get(i).getName(), 10, 50 + i * 25);
                }
                for(int j = 0;j<tabPoint.length;j++){
                    //g.drawString(Integer.toString(tabPoint[j][i]),150+j*50,50+i*25);
                    g.drawString(Integer.toString(pilots.get(i).tabPoints[j]),150+j*50,50+i*25);
                    //pilots.get(i).setPoints(pilots.get(i).getPoints() + tabPoint[j][i]);
                }
            }



            //DRAW TOTAL
            for(int ii = 0; ii<pilots.size();ii++){
                g.drawString(Integer.toString(pilots.get(ii).getPoints()),900,50+ii*25);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.tabPoint = ((SimulationChampionnat)o).getTab();
        this.tracks = ((SimulationChampionnat)o).getTracks();
        this.pilots = ((SimulationChampionnat)o).getPilots();
        this.tabTotal = new int[pilots.size()];
        repaint();
    }
}
