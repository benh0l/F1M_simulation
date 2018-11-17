package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Fenetre extends JFrame {

    private SimulationChampionnat sc;

    public Fenetre() throws IOException, FontFormatException {
        sc = new SimulationChampionnat(new ArrayList<Track>(),new ArrayList<Pilot>());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(65, 58, 58));

        //CHOIX FICHIER
        JButton fichier = new JButton("Sélectionner un fichier");
        fichier.setSize(new Dimension(200, 50));
        fichier.setBounds(545, 25, 200, 50);
        JTextField status = new JTextField("");
        status.setEditable(false);
        status.setSize(new Dimension(250, 50));
        status.setBounds(15, 25, 500, 50);
        fichier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setApproveButtonText("Choix");
                jfc.showOpenDialog(null);
                if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    status.setText(jfc.getSelectedFile().getAbsolutePath());
                }
            }
        });

        JButton simuler = new JButton("Simuler");
        simuler.setSize(new Dimension(200,50));
        simuler.setBounds(775,25,200,50);
        simuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(status!=null){
                    try{
                        simuler(status.getText());
                    }catch(IOException ioe){
                        JOptionPane.showMessageDialog(new JFrame(),"Le fichier indiqué n'existe pas ou n'est pas compatible","Inane error",JOptionPane.ERROR_MESSAGE);
                        ioe.printStackTrace();
                    }
                }
            }
        });

        Panneau panneau = new Panneau(sc);
        panneau.setBounds(15,110,950,650);


        this.setLayout(null);
        this.add(status);
        this.add(fichier);
        this.add(simuler);
        this.add(panneau);

        this.pack();
        this.setSize(new Dimension(1000,800));
        this.setVisible(true);
    }


    public void simuler(String file) throws IOException {
        DataLoader dl = new DataLoader(file);

        //Load data
        ArrayList<Track> tracks = dl.loadTrack();
        ArrayList<Car> cars = dl.loadCar();
        ArrayList<Pilot> pilots = dl.loadPilot();

        //Link pilots to cars
        for(Pilot p : pilots){
            boolean trouve = false;
            while(!trouve){
                for(Car c : cars){
                    if(c.getName().equals(p.getTeam())) {
                        p.setCar(c);
                        trouve = true;
                    }
                }
            }
        }

        //Championship
        this.sc.setTracks(tracks);
        this.sc.setPilots(pilots);
        this.sc.setTab(new int[tracks.size()][pilots.size()]);
        sc.simulateChampionship();

        //test
        //System.out.println(sc.toString());

        int[][] tabPoints = sc.indiceToPoints();

        pilots.sort(new Comparator<Pilot>() {
            @Override
            public int compare(Pilot p1, Pilot p2) {
                return (p2.getPoints() - p1.getPoints());
            }
        });
    }


}
