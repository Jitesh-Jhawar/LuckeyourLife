/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class MainGame extends javax.swing.JFrame {

    private int times = 2;
    /**
     * if the dice is being rolled
     */
    Boolean RollDie = true;
    /**
     * will contain the no of the player whose chance is going on
     */
    private int chanceplayer = 1;
    /**
     * will contain total number of player
     */
    private int noplayers = 4;
    /**
     * frame for dice
     */
    private JFrame frame = new JFrame("Dual Dice");
    /**
     * frame for city buy
     */
    private JFrame framecity;
    /**
     * frame for city rent
     */
    private JFrame FrameRentCity;
    /**
     *
     * <pre>
     * next position of movers
     * For X [][0],
     * For Y[][1],
     * For first x [1][0],
     * For last y [33][1]
     * </pre>
     */
    private final int[][] xy = new int[][]{{100, 555}, {170, 555}, {240, 555}, {310, 555}, {380, 555}, {450, 555}, {520, 555}, {590, 555}, {660, 555}, {730, 555}, {800, 555}, {800, 490}, {800, 425}, {800, 360}, {800, 295}, {800, 230}, {800, 165}, {800, 100}, {730, 100}, {660, 100}, {590, 100}, {520, 100}, {450, 100}, {380, 100}, {310, 100}, {240, 100}, {170, 100}, {100, 100}, {100, 165}, {100, 230}, {100, 295}, {100, 360}, {100, 425}, {100, 490}};
    /**
     * will contain name of city
     */
    private final String[] city = new String[]{"Start", "Las Vegas", "Transport", "Dubai", "Washington DC", "Melbourne",
        "New York", "Kolkata", "Quethe", "London", "Merchants Club", "Delhi", "Jaipur", "Post Office", "Paris", "Radio Station",
        "Hyderabad", "Jail", "Singapore", "Lahore", "Kathmandu", "Chicago", "Steamer", "Honkong", "Agra", "Rio De Janerio", "Denmark",
        "Milk Bar", "Morisicious", "Income Tax", "Bali", "Aeroplane", "Andaman and Nicobar Islands", "Raliway"};
    /**
     * will contain price of city
     */
    private final int[] price = new int[]{0, 5000, 7000, 4000, 4500, 2000, 4500, 3500, 2000,
        3000, 100, 4000, 2500, 5500, 4500, 4500, 2000, 150, 2000, 1500, 2000, 1500, 6500, 2500,
        2500, 2500, 1500, 50, 1500,
        500, 2000, 7000, 4000, 5000};
    /**
     * basic colors of cities
     */
    private final Color cblack = new Color(0, 0, 0),
            cblue = new Color(0, 0, 255),
            cgrey = new Color(204, 204, 204),
            corange = new Color(255, 129, 66),
            cpink = new Color(255, 115, 162),
            cred = new Color(255, 0, 0),
            cgreen = new Color(0, 255, 0),
            cyellow = new Color(255, 255, 0),
            cwhite = new Color(255, 255, 255),
            cbrown = new Color(102, 51, 0),
            cdefault = new Color(252, 42, 119);
    /**
     * will contain color of city on it
     */
    private final Color[] citycolor = new Color[]{cdefault, cgrey, cblack, cblue, cgrey, cpink, cgrey, cblue, cblack, cgrey, cdefault, cblue, cpink, cred, cpink, corange, cpink, cdefault, cred, cblack, cred, cpink, corange, cred, cgrey, cblue, cred, cdefault, corange, cblack, corange, cblue, corange, cblack}; //grey-5,black-5,blue-5,pink-5,red-5,def-4
    /**
     * will contain no of erections on it
     */
    private int[] addable = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    /**
     * will contain no of player who ones it
     */
    private int[] oner = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    int defaultoner = 5;
    private Color[] playercolor = new Color[]{cdefault,cgreen, cwhite, cyellow, cbrown, cdefault};
    private Boolean dualdiemouseclicked = false;
    private final Object[][] supreb = new Object[][]{{cdefault, 0, 10, 17, 27}, {cblack, 0, 0, 0, 0, 0}, {cblue, 0, 0, 0, 0, 0}, {cgrey, 0, 0, 0, 0, 0},
    {corange, 0, 0, 0, 0, 0}, {cpink, 0, 0, 0, 0, 0}, {cred, 0, 0, 0, 0, 0}};

    public Image createimg(int width, int height, Color c, String FilePath) {
        //int width =640;int height = 320;

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; x++) {
                img.setRGB(x, y, c.getRGB());
            }
        }
        Image imga = null;
        try {
            imga = (Image) img;
            /*   f = new File("" + FilePath);
             ImageIO.write(img, "png", f);*/
        } catch (Exception ex) {
            System.err.println("Error" + ex);
        }
        /* System.out.println(f.getAbsolutePath());*/
        System.out.println("Ended");
        return imga;
    }

    /**
     * Creates new form MainGame
     *
     * @param players
     */
    public MainGame(int players) {
        noplayers = players;
        initComponents();
        switch (players) {
            case 4:
                PlayerName4.setText(JOptionPane.showInputDialog(null, "Please type your name.", "Player 4  ",JOptionPane.INFORMATION_MESSAGE));
                JOptionPane.showMessageDialog(null, "You are the fourth player(Player 4).\nThank you " + PlayerName4.getText() + ".\nLets start the game");
            case 3:
                                PlayerName3.setText(JOptionPane.showInputDialog(null, "Please type your name.", "Player 4  ",JOptionPane.INFORMATION_MESSAGE));

                JOptionPane.showMessageDialog(null, "You are the fourth player(Player 3).\nThank you " + PlayerName3.getText() + ".\nLets start the game");
            case 2:
                                PlayerName2.setText(JOptionPane.showInputDialog(null, "Please type your name.", "Player 4  ",JOptionPane.INFORMATION_MESSAGE));

                JOptionPane.showMessageDialog(null, "You are the fourth player(Player 2).\nThank you " + PlayerName2.getText() + ".\nLets start the game");
            case 1:
                PlayerName1.setText(JOptionPane.showInputDialog(null, "Please type your name.", "Player 4  ",JOptionPane.INFORMATION_MESSAGE));
                JOptionPane.showMessageDialog(null, "You are the fourth player(Player 1).\nThank you " + PlayerName1.getText() + ".\nLets start the game");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Sorry cannot accomodate them", "Error of accomodation", JOptionPane.ERROR_MESSAGE);
        }
        frame.setUndecorated(true);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);
        frame.add(DualDie);
        frame.add(Die1);
        frame.add(Die2);
        DualDie.setBounds(0, 0, DualDie.getWidth(), DualDie.getHeight());
        Die1.setBounds(0, 0, Die1.getWidth(), Die1.getHeight());
        Die2.setBounds(DualDie.getWidth() - Die2.getWidth(), DualDie.getHeight() - Die2.getHeight(), Die2.getWidth(), Die2.getHeight());
        frame.setSize(new Dimension(DualDie.getWidth(), DualDie.getHeight()));
        frame.setLocationRelativeTo(null);
        makeframecity();
        addnames();
        playdie();
    }

    private JLabel GetLabel(int plot) {
        switch (plot) {
            case 0:
                return N0;
            case 1:
                return N1;
            case 2:
                return N2;
            case 3:
                return N3;
            case 4:
                return N4;
            case 5:
                return N5;
            case 6:
                return N6;
            case 7:
                return N7;
            case 8:
                return N8;
            case 9:
                return N9;
            case 10:
                return N10;
            case 11:
                return N11;
            case 12:
                return N12;
            case 13:
                return N13;
            case 14:
                return N14;
            case 15:
                return N15;
            case 16:
                return N16;
            case 17:
                return N17;
            case 18:
                return N18;
            case 19:
                return N19;
            case 20:
                return N20;
            case 21:
                return N21;
            case 22:
                return N22;
            case 23:
                return N23;
            case 24:
                return N24;
            case 25:
                return N25;
            case 26:
                return N26;
            case 27:
                return N27;
            case 28:
                return N28;
            case 29:
                return N29;
            case 30:
                return N30;
            case 31:
                return N31;
            case 32:
                return N32;
            case 33:
                return N33;
            default:
                return null;

        }
    }

    private JLabel GetLabelText(int plot) {
        switch (plot) {
            case 0:
                return NN0;
            case 1:
                return NN1;
            case 2:
                return NN2;
            case 3:
                return NN3;
            case 4:
                return NN4;
            case 5:
                return NN5;
            case 6:
                return NN6;
            case 7:
                return NN7;
            case 8:
                return NN8;
            case 9:
                return NN9;
            case 10:
                return NN10;
            case 11:
                return NN11;
            case 12:
                return NN12;
            case 13:
                return NN13;
            case 14:
                return NN14;
            case 15:
                return NN15;
            case 16:
                return NN16;
            case 17:
                return NN17;
            case 18:
                return NN18;
            case 19:
                return NN19;
            case 20:
                return NN20;
            case 21:
                return NN21;
            case 22:
                return NN22;
            case 23:
                return NN23;
            case 24:
                return NN24;
            case 25:
                return NN25;
            case 26:
                return NN26;
            case 27:
                return NN27;
            case 28:
                return NN28;
            case 29:
                return NN29;
            case 30:
                return NN30;
            case 31:
                return NN31;
            case 32:
                return NN32;
            case 33:
                return NN33;
            default:
                return null;

        }
    }

    private JLabel GetLabelPriceTXT(int plot) {
        switch (plot) {
            case 0:
                return null;
            case 1:
                return NP1;
            case 2:
                return NP2;
            case 3:
                return NP3;
            case 4:
                return NP4;
            case 5:
                return NP5;
            case 6:
                return NP6;
            case 7:
                return NP7;
            case 8:
                return NP8;
            case 9:
                return NP9;
            case 10:
                return NP10;
            case 11:
                return NP11;
            case 12:
                return NP12;
            case 13:
                return NP13;
            case 14:
                return NP14;
            case 15:
                return NP15;
            case 16:
                return NP16;
            case 17:
                return NP17;
            case 18:
                return NP18;
            case 19:
                return NP19;
            case 20:
                return NP20;
            case 21:
                return NP21;
            case 22:
                return NP22;
            case 23:
                return NP23;
            case 24:
                return NP24;
            case 25:
                return NP25;
            case 26:
                return NP26;
            case 27:
                return NP27;
            case 28:
                return NP28;
            case 29:
                return NP29;
            case 30:
                return NP30;
            case 31:
                return NP31;
            case 32:
                return NP32;
            case 33:
                return NP33;
            default:
                return null;

        }
    }

    private JLabel GetLabelPrice(int plot) {
        switch (plot) {
            case 0:
                return null;
            case 1:
                return Pr1;
            case 2:
                return Pr2;
            case 3:
                return Pr3;
            case 4:
                return Pr4;
            case 5:
                return Pr5;
            case 6:
                return Pr6;
            case 7:
                return Pr7;
            case 8:
                return Pr8;
            case 9:
                return Pr9;
            case 10:
                return Pr10;
            case 11:
                return Pr11;
            case 12:
                return Pr12;
            case 13:
                return Pr13;
            case 14:
                return Pr14;
            case 15:
                return Pr15;
            case 16:
                return Pr16;
            case 17:
                return Pr17;
            case 18:
                return Pr18;
            case 19:
                return Pr19;
            case 20:
                return Pr20;
            case 21:
                return Pr21;
            case 22:
                return Pr22;
            case 23:
                return Pr23;
            case 24:
                return Pr24;
            case 25:
                return Pr25;
            case 26:
                return Pr26;
            case 27:
                return Pr27;
            case 28:
                return Pr28;
            case 29:
                return Pr29;
            case 30:
                return Pr30;
            case 31:
                return Pr31;
            case 32:
                return Pr32;
            case 33:
                return Pr33;
            default:
                return null;

        }
    }

    private void addnames() {
        /*P29.setBounds(10, 220, 150, 65);
        P.settext(city[plot]);
       if(plot<10&&plot>=0){ int x = P.getX();
            int y = P.getY() + P.getHeight() - 10 - 25 - 10;}*/
        System.out.print("done");
        for (int plot = 0; plot < 34; plot++) {
            System.out.println("D");
            JLabel P = GetNowLabel(plot);
            int x = 0, y = 0, width = 0;
            if (plot < 10 && plot >= 0) {
                x = P.getX();
                width = 70;
                y = P.getY() + P.getHeight() - 10 - 25 - 10;
            } else if (plot <= 17 && plot >= 10) {
                width = 80;
                x = P.getX() + P.getWidth() - 80;
                y = P.getY() + 10;
            } else if (plot < 27 && plot >= 18) {
                x = P.getX();
                width = 70;
                y = P.getY() + 10;
            } else if (plot < 34 && plot >= 27) {
                x = P.getX();
                width = 80;
                y = P.getY() + 10;
            }
            GetLabel(plot).setBounds(x, y, width, 25);
            GetLabelText(plot).setBounds(x, y, width, 25);
            GetLabel(plot).setIcon(new ImageIcon(createimg(GetLabel(plot).getWidth(), GetLabel(plot).getHeight(), citycolor[plot], "")));
            if (citycolor[plot] == cblack || citycolor[plot] == cblue) {
                GetLabelText(plot).setForeground(Color.WHITE);
            }
            GetLabel(plot).setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            GetLabel(plot).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            GetLabelText(plot).setText(city[plot]);
            GetLabel(plot).setText("");
        }
        for (int plot = 1; plot < 34; plot++) {
            System.out.println("D");
            JLabel P = GetNowLabel(plot);
            int x = 0, y = 0, width = 0;
            if (plot < 10 && plot >= 0) {
                x = P.getX();
                y = P.getY() + P.getHeight() - 10 - 10;
                width = 25;
            } else if (plot <= 17 && plot >= 10) {
                width = 25;
                x = P.getX() + P.getWidth() - 25;
                y = P.getY() + 10 + 25;
            } else if (plot < 27 && plot >= 18) {
                x = P.getX();
                y = P.getY() + 10 + 25;
                width = 25;
            } else if (plot < 34 && plot >= 27) {
                width = 25;
                x = P.getX();
                y = P.getY() + 10 + 25;
            }
            GetLabelPrice(plot).setBounds(x, y, width, 25);
            GetLabelPriceTXT(plot).setBounds(x, y, width, 25);
            // GetLabelPrice(plot).setIcon(new ImageIcon(createimg(GetLabelPrice(plot).getWidth(), GetLabelPrice(plot).getHeight(), playercolor[oner[plot]], "")));

            GetLabelPrice(plot).setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            GetLabelPrice(plot).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            GetLabelPriceTXT(plot).setText("" + price[plot]);
            GetLabelPrice(plot).setText("");
        }
    }

    /*07
070
4:1:4
0700
2
2
070
4
4:1:1
0700*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Player1 = new javax.swing.JLabel();
        Player2 = new javax.swing.JLabel();
        Player3 = new javax.swing.JLabel();
        Player4 = new javax.swing.JLabel();
        NP1 = new javax.swing.JLabel();
        NP2 = new javax.swing.JLabel();
        NP3 = new javax.swing.JLabel();
        NP4 = new javax.swing.JLabel();
        NP5 = new javax.swing.JLabel();
        NP6 = new javax.swing.JLabel();
        NP7 = new javax.swing.JLabel();
        NP8 = new javax.swing.JLabel();
        NP9 = new javax.swing.JLabel();
        NP10 = new javax.swing.JLabel();
        NP11 = new javax.swing.JLabel();
        NP12 = new javax.swing.JLabel();
        NP13 = new javax.swing.JLabel();
        NP14 = new javax.swing.JLabel();
        NP15 = new javax.swing.JLabel();
        NP16 = new javax.swing.JLabel();
        NP17 = new javax.swing.JLabel();
        NP18 = new javax.swing.JLabel();
        NP19 = new javax.swing.JLabel();
        NP20 = new javax.swing.JLabel();
        NP21 = new javax.swing.JLabel();
        NP22 = new javax.swing.JLabel();
        NP23 = new javax.swing.JLabel();
        NP24 = new javax.swing.JLabel();
        NP25 = new javax.swing.JLabel();
        NP26 = new javax.swing.JLabel();
        NP27 = new javax.swing.JLabel();
        NP28 = new javax.swing.JLabel();
        NP29 = new javax.swing.JLabel();
        NP30 = new javax.swing.JLabel();
        NP31 = new javax.swing.JLabel();
        NP32 = new javax.swing.JLabel();
        NP33 = new javax.swing.JLabel();
        Pr1 = new javax.swing.JLabel();
        Pr2 = new javax.swing.JLabel();
        Pr3 = new javax.swing.JLabel();
        Pr4 = new javax.swing.JLabel();
        Pr5 = new javax.swing.JLabel();
        Pr6 = new javax.swing.JLabel();
        Pr7 = new javax.swing.JLabel();
        Pr8 = new javax.swing.JLabel();
        Pr9 = new javax.swing.JLabel();
        Pr10 = new javax.swing.JLabel();
        Pr11 = new javax.swing.JLabel();
        Pr12 = new javax.swing.JLabel();
        Pr13 = new javax.swing.JLabel();
        Pr14 = new javax.swing.JLabel();
        Pr15 = new javax.swing.JLabel();
        Pr16 = new javax.swing.JLabel();
        Pr17 = new javax.swing.JLabel();
        Pr18 = new javax.swing.JLabel();
        Pr19 = new javax.swing.JLabel();
        Pr20 = new javax.swing.JLabel();
        Pr21 = new javax.swing.JLabel();
        Pr22 = new javax.swing.JLabel();
        Pr23 = new javax.swing.JLabel();
        Pr24 = new javax.swing.JLabel();
        Pr25 = new javax.swing.JLabel();
        Pr26 = new javax.swing.JLabel();
        Pr27 = new javax.swing.JLabel();
        Pr28 = new javax.swing.JLabel();
        Pr29 = new javax.swing.JLabel();
        Pr30 = new javax.swing.JLabel();
        Pr31 = new javax.swing.JLabel();
        Pr32 = new javax.swing.JLabel();
        Pr33 = new javax.swing.JLabel();
        NN0 = new javax.swing.JLabel();
        NN1 = new javax.swing.JLabel();
        NN2 = new javax.swing.JLabel();
        NN3 = new javax.swing.JLabel();
        NN4 = new javax.swing.JLabel();
        NN5 = new javax.swing.JLabel();
        NN6 = new javax.swing.JLabel();
        NN7 = new javax.swing.JLabel();
        NN8 = new javax.swing.JLabel();
        NN9 = new javax.swing.JLabel();
        NN10 = new javax.swing.JLabel();
        NN11 = new javax.swing.JLabel();
        NN12 = new javax.swing.JLabel();
        NN13 = new javax.swing.JLabel();
        NN14 = new javax.swing.JLabel();
        NN15 = new javax.swing.JLabel();
        NN16 = new javax.swing.JLabel();
        NN17 = new javax.swing.JLabel();
        NN18 = new javax.swing.JLabel();
        NN19 = new javax.swing.JLabel();
        NN20 = new javax.swing.JLabel();
        NN21 = new javax.swing.JLabel();
        NN22 = new javax.swing.JLabel();
        NN23 = new javax.swing.JLabel();
        NN24 = new javax.swing.JLabel();
        NN25 = new javax.swing.JLabel();
        NN26 = new javax.swing.JLabel();
        NN27 = new javax.swing.JLabel();
        NN28 = new javax.swing.JLabel();
        NN29 = new javax.swing.JLabel();
        NN30 = new javax.swing.JLabel();
        NN31 = new javax.swing.JLabel();
        NN32 = new javax.swing.JLabel();
        NN33 = new javax.swing.JLabel();
        N0 = new javax.swing.JLabel();
        N1 = new javax.swing.JLabel();
        N2 = new javax.swing.JLabel();
        N3 = new javax.swing.JLabel();
        N4 = new javax.swing.JLabel();
        N5 = new javax.swing.JLabel();
        N6 = new javax.swing.JLabel();
        N7 = new javax.swing.JLabel();
        N8 = new javax.swing.JLabel();
        N9 = new javax.swing.JLabel();
        N10 = new javax.swing.JLabel();
        N11 = new javax.swing.JLabel();
        N12 = new javax.swing.JLabel();
        N13 = new javax.swing.JLabel();
        N14 = new javax.swing.JLabel();
        N15 = new javax.swing.JLabel();
        N16 = new javax.swing.JLabel();
        N17 = new javax.swing.JLabel();
        N18 = new javax.swing.JLabel();
        N19 = new javax.swing.JLabel();
        N20 = new javax.swing.JLabel();
        N21 = new javax.swing.JLabel();
        N22 = new javax.swing.JLabel();
        N23 = new javax.swing.JLabel();
        N24 = new javax.swing.JLabel();
        N25 = new javax.swing.JLabel();
        N26 = new javax.swing.JLabel();
        N27 = new javax.swing.JLabel();
        N28 = new javax.swing.JLabel();
        N29 = new javax.swing.JLabel();
        N30 = new javax.swing.JLabel();
        N31 = new javax.swing.JLabel();
        N32 = new javax.swing.JLabel();
        N33 = new javax.swing.JLabel();
        P33 = new javax.swing.JLabel();
        P32 = new javax.swing.JLabel();
        P31 = new javax.swing.JLabel();
        P30 = new javax.swing.JLabel();
        P29 = new javax.swing.JLabel();
        P28 = new javax.swing.JLabel();
        P27 = new javax.swing.JLabel();
        P26 = new javax.swing.JLabel();
        P25 = new javax.swing.JLabel();
        P24 = new javax.swing.JLabel();
        P23 = new javax.swing.JLabel();
        P22 = new javax.swing.JLabel();
        P21 = new javax.swing.JLabel();
        P20 = new javax.swing.JLabel();
        P19 = new javax.swing.JLabel();
        P18 = new javax.swing.JLabel();
        P17 = new javax.swing.JLabel();
        P16 = new javax.swing.JLabel();
        P15 = new javax.swing.JLabel();
        P14 = new javax.swing.JLabel();
        P13 = new javax.swing.JLabel();
        P12 = new javax.swing.JLabel();
        P11 = new javax.swing.JLabel();
        P10 = new javax.swing.JLabel();
        P9 = new javax.swing.JLabel();
        P8 = new javax.swing.JLabel();
        P7 = new javax.swing.JLabel();
        P6 = new javax.swing.JLabel();
        P5 = new javax.swing.JLabel();
        P4 = new javax.swing.JLabel();
        P3 = new javax.swing.JLabel();
        P2 = new javax.swing.JLabel();
        P1 = new javax.swing.JLabel();
        P0 = new javax.swing.JLabel();
        PlayerName1 = new javax.swing.JLabel();
        PlayerName2 = new javax.swing.JLabel();
        PlayerName3 = new javax.swing.JLabel();
        PlayerName4 = new javax.swing.JLabel();
        PAmt1 = new javax.swing.JLabel();
        PAmt2 = new javax.swing.JLabel();
        PAmt3 = new javax.swing.JLabel();
        PAmt4 = new javax.swing.JLabel();
        Exit = new javax.swing.JLabel();
        Game = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        Die2 = new javax.swing.JLabel();
        Die1 = new javax.swing.JLabel();
        DualDie = new javax.swing.JLabel();
        VR1 = new javax.swing.JLabel();
        VR2 = new javax.swing.JLabel();
        VR3 = new javax.swing.JLabel();
        VR4 = new javax.swing.JLabel();
        VR5 = new javax.swing.JLabel();
        R1 = new javax.swing.JLabel();
        R2 = new javax.swing.JLabel();
        R3 = new javax.swing.JLabel();
        R4 = new javax.swing.JLabel();
        R5 = new javax.swing.JLabel();
        R6 = new javax.swing.JLabel();
        CityRentName = new javax.swing.JLabel();
        CityRentframe = new javax.swing.JLabel();
        L1 = new javax.swing.JLabel();
        L2 = new javax.swing.JLabel();
        L3 = new javax.swing.JLabel();
        L4 = new javax.swing.JLabel();
        CityName = new javax.swing.JLabel();
        Cityframe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(154, 25, 25));
        setUndecorated(true);
        getContentPane().setLayout(null);

        Player1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Player1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player1.setText("1");
        Player1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(Player1);
        Player1.setBounds(190, 300, 50, 45);

        Player2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Player2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player2.setText("2");
        Player2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(Player2);
        Player2.setBounds(190, 470, 50, 45);

        Player3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Player3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player3.setText("3");
        Player3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(Player3);
        Player3.setBounds(610, 300, 50, 45);

        Player4.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Player4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player4.setText("4");
        Player4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(Player4);
        Player4.setBounds(610, 470, 50, 45);
        getContentPane().add(NP1);
        NP1.setBounds(700, 210, 0, 0);
        getContentPane().add(NP2);
        NP2.setBounds(700, 210, 0, 0);
        getContentPane().add(NP3);
        NP3.setBounds(700, 210, 0, 0);
        getContentPane().add(NP4);
        NP4.setBounds(700, 210, 0, 0);
        getContentPane().add(NP5);
        NP5.setBounds(700, 210, 0, 0);
        getContentPane().add(NP6);
        NP6.setBounds(700, 210, 0, 0);
        getContentPane().add(NP7);
        NP7.setBounds(700, 210, 0, 0);
        getContentPane().add(NP8);
        NP8.setBounds(700, 210, 0, 0);
        getContentPane().add(NP9);
        NP9.setBounds(700, 210, 0, 0);
        getContentPane().add(NP10);
        NP10.setBounds(700, 210, 0, 0);
        getContentPane().add(NP11);
        NP11.setBounds(700, 210, 0, 0);
        getContentPane().add(NP12);
        NP12.setBounds(700, 210, 0, 0);
        getContentPane().add(NP13);
        NP13.setBounds(700, 210, 0, 0);
        getContentPane().add(NP14);
        NP14.setBounds(700, 210, 0, 0);
        getContentPane().add(NP15);
        NP15.setBounds(700, 210, 0, 0);
        getContentPane().add(NP16);
        NP16.setBounds(700, 210, 0, 0);
        getContentPane().add(NP17);
        NP17.setBounds(700, 210, 0, 0);
        getContentPane().add(NP18);
        NP18.setBounds(700, 210, 0, 0);
        getContentPane().add(NP19);
        NP19.setBounds(700, 210, 0, 0);
        getContentPane().add(NP20);
        NP20.setBounds(700, 210, 0, 0);
        getContentPane().add(NP21);
        NP21.setBounds(700, 210, 0, 0);
        getContentPane().add(NP22);
        NP22.setBounds(700, 210, 0, 0);
        getContentPane().add(NP23);
        NP23.setBounds(700, 210, 0, 0);
        getContentPane().add(NP24);
        NP24.setBounds(700, 210, 0, 0);
        getContentPane().add(NP25);
        NP25.setBounds(700, 210, 0, 0);
        getContentPane().add(NP26);
        NP26.setBounds(700, 210, 0, 0);
        getContentPane().add(NP27);
        NP27.setBounds(700, 210, 0, 0);
        getContentPane().add(NP28);
        NP28.setBounds(700, 210, 0, 0);
        getContentPane().add(NP29);
        NP29.setBounds(700, 210, 0, 0);
        getContentPane().add(NP30);
        NP30.setBounds(700, 210, 0, 0);
        getContentPane().add(NP31);
        NP31.setBounds(700, 210, 0, 0);
        getContentPane().add(NP32);
        NP32.setBounds(700, 210, 0, 0);
        getContentPane().add(NP33);
        NP33.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr1);
        Pr1.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr2);
        Pr2.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr3);
        Pr3.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr4);
        Pr4.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr5);
        Pr5.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr6);
        Pr6.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr7);
        Pr7.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr8);
        Pr8.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr9);
        Pr9.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr10);
        Pr10.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr11);
        Pr11.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr12);
        Pr12.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr13);
        Pr13.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr14);
        Pr14.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr15);
        Pr15.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr16);
        Pr16.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr17);
        Pr17.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr18);
        Pr18.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr19);
        Pr19.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr20);
        Pr20.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr21);
        Pr21.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr22);
        Pr22.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr23);
        Pr23.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr24);
        Pr24.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr25);
        Pr25.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr26);
        Pr26.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr27);
        Pr27.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr28);
        Pr28.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr29);
        Pr29.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr30);
        Pr30.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr31);
        Pr31.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr32);
        Pr32.setBounds(700, 210, 0, 0);
        getContentPane().add(Pr33);
        Pr33.setBounds(700, 210, 0, 0);
        getContentPane().add(NN0);
        NN0.setBounds(700, 210, 0, 0);
        getContentPane().add(NN1);
        NN1.setBounds(700, 210, 0, 0);
        getContentPane().add(NN2);
        NN2.setBounds(700, 210, 0, 0);
        getContentPane().add(NN3);
        NN3.setBounds(700, 210, 0, 0);
        getContentPane().add(NN4);
        NN4.setBounds(700, 210, 0, 0);
        getContentPane().add(NN5);
        NN5.setBounds(700, 210, 0, 0);
        getContentPane().add(NN6);
        NN6.setBounds(700, 210, 0, 0);
        getContentPane().add(NN7);
        NN7.setBounds(700, 210, 0, 0);
        getContentPane().add(NN8);
        NN8.setBounds(700, 210, 0, 0);
        getContentPane().add(NN9);
        NN9.setBounds(700, 210, 0, 0);
        getContentPane().add(NN10);
        NN10.setBounds(700, 210, 0, 0);
        getContentPane().add(NN11);
        NN11.setBounds(700, 210, 0, 0);
        getContentPane().add(NN12);
        NN12.setBounds(700, 210, 0, 0);
        getContentPane().add(NN13);
        NN13.setBounds(700, 210, 0, 0);
        getContentPane().add(NN14);
        NN14.setBounds(700, 210, 0, 0);
        getContentPane().add(NN15);
        NN15.setBounds(700, 210, 0, 0);
        getContentPane().add(NN16);
        NN16.setBounds(700, 210, 0, 0);
        getContentPane().add(NN17);
        NN17.setBounds(700, 210, 0, 0);
        getContentPane().add(NN18);
        NN18.setBounds(700, 210, 0, 0);
        getContentPane().add(NN19);
        NN19.setBounds(700, 210, 0, 0);
        getContentPane().add(NN20);
        NN20.setBounds(700, 210, 0, 0);
        getContentPane().add(NN21);
        NN21.setBounds(700, 210, 0, 0);
        getContentPane().add(NN22);
        NN22.setBounds(700, 210, 0, 0);
        getContentPane().add(NN23);
        NN23.setBounds(700, 210, 0, 0);
        getContentPane().add(NN24);
        NN24.setBounds(700, 210, 0, 0);
        getContentPane().add(NN25);
        NN25.setBounds(700, 210, 0, 0);
        getContentPane().add(NN26);
        NN26.setBounds(700, 210, 0, 0);
        getContentPane().add(NN27);
        NN27.setBounds(700, 210, 0, 0);
        getContentPane().add(NN28);
        NN28.setBounds(700, 210, 0, 0);
        getContentPane().add(NN29);
        NN29.setBounds(700, 210, 0, 0);
        getContentPane().add(NN30);
        NN30.setBounds(700, 210, 0, 0);
        getContentPane().add(NN31);
        NN31.setBounds(700, 210, 0, 0);
        getContentPane().add(NN32);
        NN32.setBounds(700, 210, 0, 0);
        getContentPane().add(NN33);
        NN33.setBounds(700, 210, 0, 0);
        getContentPane().add(N0);
        N0.setBounds(700, 210, 0, 0);
        getContentPane().add(N1);
        N1.setBounds(700, 210, 0, 0);
        getContentPane().add(N2);
        N2.setBounds(700, 210, 0, 0);
        getContentPane().add(N3);
        N3.setBounds(700, 210, 0, 0);
        getContentPane().add(N4);
        N4.setBounds(700, 210, 0, 0);
        getContentPane().add(N5);
        N5.setBounds(700, 210, 0, 0);
        getContentPane().add(N6);
        N6.setBounds(700, 210, 0, 0);
        getContentPane().add(N7);
        N7.setBounds(700, 210, 0, 0);
        getContentPane().add(N8);
        N8.setBounds(700, 210, 0, 0);
        getContentPane().add(N9);
        N9.setBounds(700, 210, 0, 0);
        getContentPane().add(N10);
        N10.setBounds(700, 210, 0, 0);
        getContentPane().add(N11);
        N11.setBounds(700, 210, 0, 0);
        getContentPane().add(N12);
        N12.setBounds(700, 210, 0, 0);
        getContentPane().add(N13);
        N13.setBounds(700, 210, 0, 0);
        getContentPane().add(N14);
        N14.setBounds(700, 210, 0, 0);
        getContentPane().add(N15);
        N15.setBounds(700, 210, 0, 0);
        getContentPane().add(N16);
        N16.setBounds(700, 210, 0, 0);
        getContentPane().add(N17);
        N17.setBounds(700, 210, 0, 0);
        getContentPane().add(N18);
        N18.setBounds(700, 210, 0, 0);
        getContentPane().add(N19);
        N19.setBounds(700, 210, 0, 0);
        getContentPane().add(N20);
        N20.setBounds(700, 210, 0, 0);
        getContentPane().add(N21);
        N21.setBounds(700, 210, 0, 0);
        getContentPane().add(N22);
        N22.setBounds(700, 210, 0, 0);
        getContentPane().add(N23);
        N23.setBounds(700, 210, 0, 0);
        getContentPane().add(N24);
        N24.setBounds(700, 210, 0, 0);
        getContentPane().add(N25);
        N25.setBounds(700, 210, 0, 0);
        getContentPane().add(N26);
        N26.setBounds(700, 210, 0, 0);
        getContentPane().add(N27);
        N27.setBounds(700, 210, 0, 0);
        getContentPane().add(N28);
        N28.setBounds(700, 210, 0, 0);
        getContentPane().add(N29);
        N29.setBounds(700, 210, 0, 0);
        getContentPane().add(N30);
        N30.setBounds(700, 210, 0, 0);
        getContentPane().add(N31);
        N31.setBounds(700, 210, 0, 0);
        getContentPane().add(N32);
        N32.setBounds(700, 210, 0, 0);
        getContentPane().add(N33);
        N33.setBounds(700, 210, 0, 0);

        P33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P33);
        P33.setBounds(10, 480, 150, 65);

        P32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P32);
        P32.setBounds(10, 415, 150, 65);

        P31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P31);
        P31.setBounds(10, 350, 150, 65);

        P30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P30);
        P30.setBounds(10, 285, 150, 65);

        P29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P29);
        P29.setBounds(10, 220, 150, 65);

        P28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P28);
        P28.setBounds(10, 155, 150, 65);

        P27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P27);
        P27.setBounds(10, 10, 150, 145);

        P26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P26);
        P26.setBounds(160, 10, 70, 145);

        P25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P25);
        P25.setBounds(230, 10, 70, 145);

        P24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P24);
        P24.setBounds(300, 10, 70, 145);

        P23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P23);
        P23.setBounds(370, 10, 70, 145);

        P22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P22);
        P22.setBounds(440, 10, 70, 145);

        P21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P21);
        P21.setBounds(510, 10, 70, 145);

        P20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P20);
        P20.setBounds(580, 10, 70, 145);

        P19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P19);
        P19.setBounds(650, 10, 70, 145);

        P18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P18);
        P18.setBounds(720, 10, 70, 145);

        P17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P17);
        P17.setBounds(790, 10, 150, 145);

        P16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P16);
        P16.setBounds(790, 155, 150, 65);

        P15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P15);
        P15.setBounds(790, 220, 150, 65);

        P14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P14);
        P14.setBounds(790, 285, 150, 65);

        P13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P13);
        P13.setBounds(790, 350, 150, 65);

        P12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P12);
        P12.setBounds(790, 415, 150, 65);

        P11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P11);
        P11.setBounds(790, 480, 150, 65);

        P10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P10);
        P10.setBounds(790, 545, 150, 145);

        P9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P9);
        P9.setBounds(720, 545, 70, 145);

        P8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P8);
        P8.setBounds(650, 545, 70, 145);

        P7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P7);
        P7.setBounds(580, 545, 70, 145);

        P6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P6);
        P6.setBounds(510, 545, 70, 145);

        P5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P5);
        P5.setBounds(440, 545, 70, 145);

        P4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P4);
        P4.setBounds(370, 545, 70, 145);

        P3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P3);
        P3.setBounds(300, 545, 70, 145);

        P2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P2);
        P2.setBounds(230, 545, 70, 145);

        P1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P1);
        P1.setBounds(160, 545, 70, 145);

        P0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(P0);
        P0.setBounds(10, 545, 150, 145);

        PlayerName1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlayerName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlayerName1.setText("PlayerName1");
        getContentPane().add(PlayerName1);
        PlayerName1.setBounds(180, 195, 110, 30);

        PlayerName2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlayerName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlayerName2.setText("PlayerName2");
        getContentPane().add(PlayerName2);
        PlayerName2.setBounds(180, 370, 110, 30);

        PlayerName3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlayerName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlayerName3.setText("PlayerName3");
        getContentPane().add(PlayerName3);
        PlayerName3.setBounds(600, 195, 110, 30);

        PlayerName4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlayerName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlayerName4.setText("PlayerName4");
        getContentPane().add(PlayerName4);
        PlayerName4.setBounds(600, 370, 110, 30);

        PAmt1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PAmt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PAmt1.setText("3500000");
        getContentPane().add(PAmt1);
        PAmt1.setBounds(180, 240, 110, 30);

        PAmt2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PAmt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PAmt2.setText("3500000");
        getContentPane().add(PAmt2);
        PAmt2.setBounds(180, 420, 110, 30);

        PAmt3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PAmt3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PAmt3.setText("3500000");
        getContentPane().add(PAmt3);
        PAmt3.setBounds(600, 240, 110, 30);

        PAmt4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PAmt4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PAmt4.setText("35000000");
        getContentPane().add(PAmt4);
        PAmt4.setBounds(600, 420, 110, 30);

        Exit.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Exit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Exit.setText("Save & Exit");
        Exit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ExitMouseReleased(evt);
            }
        });
        Exit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ExitKeyReleased(evt);
            }
        });
        getContentPane().add(Exit);
        Exit.setBounds(690, 515, 100, 30);

        Game.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Game.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(Game);
        Game.setBounds(0, 10, 950, 700);

        Background.setBackground(new java.awt.Color(154, 25, 25));
        Background.setForeground(new java.awt.Color(154, 25, 25));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rec/BACKGROUND.png"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 950, 700);

        Die2.setFont(new java.awt.Font("Digital-7", 0, 48)); // NOI18N
        Die2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Die2.setText("1");
        Die2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(Die2);
        Die2.setBounds(420, 350, 57, 57);

        Die1.setFont(new java.awt.Font("Digital-7", 0, 48)); // NOI18N
        Die1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Die1.setText("1");
        Die1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(Die1);
        Die1.setBounds(420, 350, 57, 57);

        DualDie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DualDie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DualDieMouseClicked(evt);
            }
        });
        getContentPane().add(DualDie);
        DualDie.setBounds(400, 320, 115, 115);

        VR1.setText("Rs.");
        getContentPane().add(VR1);
        VR1.setBounds(430, 260, 240, 20);

        VR2.setText("Rs.");
        getContentPane().add(VR2);
        VR2.setBounds(430, 280, 240, 20);

        VR3.setText("Rs.");
        getContentPane().add(VR3);
        VR3.setBounds(430, 300, 240, 20);

        VR4.setText("Rs.");
        getContentPane().add(VR4);
        VR4.setBounds(430, 320, 240, 20);

        VR5.setText("Rs.");
        getContentPane().add(VR5);
        VR5.setBounds(430, 340, 240, 20);

        R1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        R1.setText("Site Only :");
        getContentPane().add(R1);
        R1.setBounds(310, 260, 110, 20);

        R2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        R2.setText("With Office :");
        getContentPane().add(R2);
        R2.setBounds(310, 280, 110, 20);

        R3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        R3.setText(" With Bungalow :");
        getContentPane().add(R3);
        R3.setBounds(310, 300, 110, 20);

        R4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        R4.setText("With Godown :");
        getContentPane().add(R4);
        R4.setBounds(310, 320, 110, 20);

        R5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        R5.setText("Total Rent :");
        getContentPane().add(R5);
        R5.setBounds(310, 340, 110, 20);

        R6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        R6.setText("Pay Rs.");
        R6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R6MouseReleased(evt);
            }
        });
        getContentPane().add(R6);
        R6.setBounds(310, 360, 360, 40);

        CityRentName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CityRentName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CityRentName.setText("City Name");
        CityRentName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(CityRentName);
        CityRentName.setBounds(310, 190, 360, 70);

        CityRentframe.setToolTipText("");
        CityRentframe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CityRentframe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(CityRentframe);
        CityRentframe.setBounds(310, 190, 360, 210);

        L1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L1.setText("Cost of each erection Rs. 5500");
        L1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                L1MouseReleased(evt);
            }
        });
        getContentPane().add(L1);
        L1.setBounds(490, 240, 180, 140);

        L2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L2.setText("Buy for Rs. 5000");
        L2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        L2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                L2MouseReleased(evt);
            }
        });
        getContentPane().add(L2);
        L2.setBounds(310, 240, 180, 140);

        L3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L3.setText("If you own three of this colour the rent of the site is only doubled");
        L3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(L3);
        L3.setBounds(310, 380, 360, 30);

        L4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L4.setText("Morgage value : Half");
        L4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        L4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(L4);
        L4.setBounds(310, 410, 360, 20);

        CityName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CityName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CityName.setText("City Name");
        CityName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(CityName);
        CityName.setBounds(310, 180, 360, 60);

        Cityframe.setToolTipText("");
        Cityframe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Cityframe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(Cityframe);
        Cityframe.setBounds(310, 180, 360, 250);

        setSize(new java.awt.Dimension(950, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private void ddmc(){
        if (!dualdiemouseclicked) {
            dualdiemouseclicked = true;
            new Thread() {
                @Override
                public void run() {
                    int i = 0;
                    oner[10] = defaultoner;
                    oner[27] = defaultoner;
                    oner[17] = defaultoner;
                    oner[0] = defaultoner;
                    int plot = 10;
                    GetLabelPrice(plot).setIcon(new ImageIcon(createimg(GetLabelPrice(plot).getWidth(), GetLabelPrice(plot).getHeight(), playercolor[chanceplayer], "")));
                    GetLabelPriceTXT(plot).setText("" + price[plot]);
                    plot = 17;
                    GetLabelPrice(plot).setIcon(new ImageIcon(createimg(GetLabelPrice(plot).getWidth(), GetLabelPrice(plot).getHeight(), playercolor[chanceplayer], "")));
                    GetLabelPriceTXT(plot).setText("" + price[plot]);
                    plot = 27;
                    GetLabelPrice(plot).setIcon(new ImageIcon(createimg(GetLabelPrice(plot).getWidth(), GetLabelPrice(plot).getHeight(), playercolor[chanceplayer], "")));
                    GetLabelPriceTXT(plot).setText("" + price[plot]);
                   i=0;
                    while (i <= times) {
                        ++i;

                        for (long d = 0; d <= 999999999; ++d) {
                        }
                        int d1 = (int) (((Math.random() * 100) % 6) + 1),
                                d2 = (int) (((Math.random() * 100) % 6) + 1);
                        set(Die1, d1);
                        set(Die2, d2);
                        System.out.println(d1 + ":" + d2);
                        Play(d1 + d2, i);
                    }
                    System.out.println();
                    for (int j = 0; j < oner.length; ++j) {
                        System.err.print(":" + oner[j]);
                    }
                }
            }.start();
        }

}
    /**
     * Dice will be rolled and game will be started
     */
    private void DualDieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DualDieMouseClicked
ddmc();
        // TODO add your handling code here:
    }//GEN-LAST:event_DualDieMouseClicked

    private void L2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2MouseReleased
        new Thread() {
            public void run() {
                int plot = getplot(GetPlayer());
                System.out.println("4");
                if (oner[plot] == defaultoner && chkdeduct(price[plot])) {
                    deduct(price[plot]);
                    oner[plot] = chanceplayer;
                    System.err.println(chanceplayer);
                    L2.setText("You have bought this city");
                    GetLabelPrice(plot).setIcon(new ImageIcon(createimg(GetLabelPrice(plot).getWidth(), GetLabelPrice(plot).getHeight(), playercolor[chanceplayer], "")));
                    GetLabelPriceTXT(plot).setText("" + getTotalRent(plot));
                    System.out.println("40");
                    if (chkcolor(plot)) {
                        System.out.println("00");
                        for (int i = 0; i < supreb.length; ++i) {
                            System.out.println("01");
                            if (citycolor[plot] == supreb[i][0]) {
                                System.out.println("02");
                                for (int j = 1; j < supreb[i].length; ++j) {
                                    System.out.println("03");
                                    GetLabelPriceTXT((int) supreb[i][j]).setText("" + (Integer.parseInt(GetLabelPriceTXT((int) supreb[i][j]).getText())) * 2);
                                }
                                System.out.println("04");
                                break;
                            }
                            System.out.println("05");
                        }
                        System.out.println("06");
                    }
                    System.out.println("07");
                    framecity.setVisible(false);
                    System.out.println("070");
                    nextplayer();
                    System.out.println("0700");
                    playdie();
                    System.out.println("07000");
                } else {

                }

            }
        }.start();
        /*07
070
4:1:4
0700
2
2
070
4
4:1:1
0700*/
    }//GEN-LAST:event_L2MouseReleased

    private void L1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1MouseReleased
        int plot = getplot(GetPlayer());
        System.out.println("5");
        if (oner[plot] == chanceplayer && addable[plot] <= 3) {
            int i = addable[plot];
            ++i;
            if (chkdeduct(getCostofErrection(plot))) {
                deduct(getCostofErrection(plot));
                switch (i) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "You have bought an office");
                        addable[plot] = i;
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "You have bought an Bungalow");
                        addable[plot] = i;
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "You have bought an Godown");
                        addable[plot] = i;
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "You dont have enough money to do so.");
            }
            framecity.setVisible(false);
            nextplayer();
            playdie();
        } else {
  framecity.setVisible(false);
            nextplayer();
            playdie();
        }   // TODO add your handling code here:
    }//GEN-LAST:event_L1MouseReleased

    private void R6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R6MouseReleased
        int plot = getplot(GetPlayer());
        if (chkdeduct(getTotalRent(plot))) {
            deduct(getTotalRent(plot));
            deduct((getTotalRent(plot) * (-1)), oner[plot]);
            FrameRentCity.setVisible(false);
            nextplayer();
            playdie();
        } else {
            JOptionPane.showMessageDialog(null, "You dont have enough money to do so.");
        }
// TODO add your handling code here:
    }//GEN-LAST:event_R6MouseReleased

    private void ExitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ExitKeyReleased
        if (Exit.getForeground() == Color.BLACK) {
            Exit.setForeground(cred);
        }
// TODO add your handling code here:

    }//GEN-LAST:event_ExitKeyReleased

    private void ExitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseReleased
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_ExitMouseReleased
    // <editor-fold defaultstate="collapsed" desc="HELPER CODE">       

    private Boolean chkcolor(int plot) {
        int i = 0, got = 0;
        Boolean d = false;
        while (i < 34) {
            int j = oner[i];

            if (j != defaultoner && j == oner[plot] && citycolor[plot] == citycolor[i]) {
                ++got;
            }
            ++i;
        }
        if (got >= 3) {
            d = true;
        }
        return d;
    }

    /**
     * will move the movers forward
     */
    private void Play(int steps, int f27) {
        if (f27 == times + 1) {
            frame.setVisible(false);
            RollDie = false;
            JOptionPane.showMessageDialog(null, "Palying " + steps);
            move(GetPlayer(), steps);

            OpenCity();

        } else {
            System.out.println("Play:" + steps);
        }
    }

    /**
     * will return the label in which pic of player is there
     */
    private JLabel GetPlayer() {
       
        switch (chanceplayer) {
            case 1:
                return Player1;
            case 2:
                return Player2;
            case 3:
                return Player3;
            case 4:
                return Player4;
            default:
                return Player1;
        }
    }

    /**
     * will pass the chance to the next player 07 070 4:1:4 0700 2 2 070 4 4:1:1
     * 0700
     */
    private void nextplayer() {

        setplayer();
        System.out.println(noplayers + ":1:" + chanceplayer);
    }

    /**
     * <pre>
     * Will set the player .
     * Can be used when there is an exception.
     * </pre>
     */
    private void setplayer() {
        chanceplayer = (chanceplayer % (noplayers)) + 1;

    }

    /**
     * will set the icon in the dice
     *
     */
    private void set(JLabel D, int d) {
        //   D.setIcon(new ImageIcon("\\Die\\d"+d+".png"));
        D.setText("" + d);
    }

    /**
     * will allow the player to roll the dice07 070 4:1:4 0700 2 2 070 4 4:1:1
     * 0700
     */
    private void playdie() {
        dualdiemouseclicked = false;
        System.out.println("2");
        System.out.println("2");
        RollDie = true;
        frame.setVisible(true);
        System.out.println("2");
        ddmc();

    }

    /**
     * will the plot no of the Mover
     */
    private int getplot(JLabel D) {
        int plot = 0;
        int x = D.getX();
        int y = D.getY();
        for (int i = 0; i < this.xy.length; i++) {
            if (this.xy[i][0] == x && this.xy[i][1] == y) {
                plot = i;
                break;
            } else {
                plot = 0;
            }
        }
        return plot;
    }

    /**
     * will move the mover those steps
     */
    private void move(JLabel D, int steps) {
        while (steps != 0) {
            --steps;
            move1(D);
        }

    }

    /**
     * will move the mover those steps
     */
    private void move1(JLabel D) {
        int plots = getplot(D) + 1;
        plots = plots % 34;
        setplot(D, plots);

    }

    /**
     * will contain name of city
     */
    private void setplot(JLabel D, int plot) {
        D.setBounds(xy[plot][0], xy[plot][1], 50, 45);
    }

    private JLabel GetNowLabel(int plot) {
        switch (plot) {
            case 0:
                return P0;
            case 1:
                return P1;
            case 2:
                return P2;
            case 3:
                return P3;
            case 4:
                return P4;
            case 5:
                return P5;
            case 6:
                return P6;
            case 7:
                return P7;
            case 8:
                return P8;
            case 9:
                return P9;
            case 10:
                return P10;
            case 11:
                return P11;
            case 12:
                return P12;
            case 13:
                return P13;
            case 14:
                return P14;
            case 15:
                return P15;
            case 16:
                return P16;
            case 17:
                return P17;
            case 18:
                return P18;
            case 19:
                return P19;
            case 20:
                return P20;
            case 21:
                return P21;
            case 22:
                return P22;
            case 23:
                return P23;
            case 24:
                return P24;
            case 25:
                return P25;
            case 26:
                return P26;
            case 27:
                return P27;
            case 28:
                return P28;
            case 29:
                return P29;
            case 30:
                return P30;
            case 31:
                return P31;
            case 32:
                return P32;
            case 33:
                return P33;
            default:
                plot = getplot(GetPlayer());
                return GetNowLabel(plot);

        }
    }

    private int getRentonSite(int plot) {
        int rent = (price[plot] / 10) - 50;
        return rent;
    }

    private int getRentonOffie(int plot) {
        int rent = ((price[plot] * 28) / 100);
        return rent;
    }

    private int getRentonBungalow(int plot) {
        int rent = ((price[plot] * 44) / 100);
        return rent;
    }

    private int getRentonGodown(int plot) {
        int rent = ((price[plot] * 72) / 100);
        return rent;
    }

    private int getCostofErrection(int plot) {
        int rent = price[plot] + 500;
        return rent;
    }

    private int getMortgageValue(int plot) {
        int rent = price[plot] / 2;
        rent = rent + (getCostofErrection(plot) * addable[plot]) / 2;
        return rent;
    }

    private int getTotalRent(int plot) {
        int total = 0;
        switch (addable[plot]) {
            case 3:
                total = total + getRentonGodown(plot);
            case 2:
                total = total + getRentonBungalow(plot);
            case 1:
                total = total + getRentonOffie(plot);
            case 0:
                total = total + getRentonSite(plot);
                break;
            default:
                total = 0;
        }
        if (chkcolor(plot)) {
            total = total = total;
        }
        return total;
    }

    private void OpenCity() {// to pay for office,Bunglow,Gowdown
        int plot = getplot(GetPlayer());

        String plota = "" + plot;
        if (plota.equals(supreb[0][0]) || plota.equals(supreb[0][1]) || plota.equals(supreb[0][2]) || plota.equals(supreb[0][3])) {
            chkdeduct(price[plot]);

        } else if (oner[plot] == chanceplayer || oner[plot] == defaultoner) {
            makeframecitytrue(plot);
        } else {
            makeFrameRentCitytrue(plot);
        }
    }

    private int getamt(int player) {
        String amt = "";
        switch (player) {
            case 1:
                amt = PAmt1.getText();
                break;
            case 2:
                amt = PAmt2.getText();
                break;
            case 3:
                amt = PAmt3.getText();
                break;
            case 4:
                amt = PAmt4.getText();
                break;
        }
        return Integer.parseInt(amt);
    }

    private void setamt(int player, int amt) {
        String a = "" + amt;
        switch (player) {
            case 1:
                PAmt1.setText(a);
                break;
            case 2:
                PAmt2.setText(a);
                break;
            case 3:
                PAmt3.setText(a);
                break;
            case 4:
                PAmt4.setText(a);
                break;
        }

    }

    private Boolean chkdeduct(int pric) {
        Boolean d = false;
        if ((getamt(chanceplayer) - pric) < 0) {
        } else {
            d = true;
        }
        return d;
    }

    private Boolean chkdeduct(int pric, int chanceplayer) {
        Boolean d = false;
        if ((getamt(chanceplayer) - pric) < 0) {
        } else {
            d = true;
        }
        return d;
    }

    private void deduct(int pric) {
        if (chkdeduct(pric)) {
            setamt(chanceplayer, getamt(chanceplayer) - pric);
        } else {
            JOptionPane.showMessageDialog(null, "You dont have the MONEY to do so.");
        }
    }

    private void deduct(int pric, int chanceplayer) {
        if (chkdeduct(pric, chanceplayer)) {
            setamt(chanceplayer, getamt(chanceplayer) - pric);
        } else {
            JOptionPane.showMessageDialog(null, "You dont have the MONEY to do so.");
        }
    }

    private void makeframecity() {
        framecity = new JFrame();
        framecity.setUndecorated(true);
        framecity.setAlwaysOnTop(true);
        framecity.setLayout(null);

        framecity.add(L1);
        framecity.add(L2);
        framecity.add(L3);
        framecity.add(L4);
        framecity.add(Cityframe);
        framecity.add(CityName);
        L4.setBounds(0, 230, L4.getWidth(), L4.getHeight());
        L3.setBounds(0, 200, L3.getWidth(), L3.getHeight());
        L2.setBounds(0, 60, L2.getWidth(), L2.getHeight());
        L1.setBounds(180, 60, L1.getWidth(), L1.getHeight());
        CityName.setBounds(0, 0, CityName.getWidth(), CityName.getHeight());
        Cityframe.setBounds(0, 0, Cityframe.getWidth(), Cityframe.getHeight());
        framecity.setSize(new Dimension(Cityframe.getWidth(), Cityframe.getHeight()));
        framecity.setLocationRelativeTo(null);

        L4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        L3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        L2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        L1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }

    private void makeframecitytrue(int plot) {
        // frame.setVisible(false);
        CityName.setText(city[plot]);
        L1.setText("Cost of each erection Rs. " + getCostofErrection(plot));
        L2.setText("Buy for Rs. " + price[plot]);
        L3.setText("If you own three of this colour the rent of the site is only doubled");
        L4.setText("Morgage value : Half i.e. Rs." + getMortgageValue(plot));
        framecity.setVisible(true);
        if (oner[plot] != chanceplayer) {
            L2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
            L2.setText("You have bought this city");
            if (addable[plot] == 3) {
            } else {
                L1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        }
        L1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                L1MouseReleased(evt);
            }
        });
        L2.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                L2MouseReleased(evt);
            }
        });
        framecity.setTitle(city[plot]);

    }

    private void makeFrameRentCitytrue(int plot) {
        // frame.setVisible(false);
        FrameRentCity = new JFrame(city[plot]);
        FrameRentCity.setUndecorated(true);
        FrameRentCity.setAlwaysOnTop(true);
        FrameRentCity.setLayout(null);
        CityRentName.setText(city[plot]);

        FrameRentCity.add(R1);
        FrameRentCity.add(R2);
        FrameRentCity.add(R3);
        FrameRentCity.add(R4);
        FrameRentCity.add(R5);
        FrameRentCity.add(R6);
        FrameRentCity.add(VR1);
        FrameRentCity.add(VR2);
        FrameRentCity.add(VR3);
        FrameRentCity.add(VR4);
        FrameRentCity.add(VR5);
        FrameRentCity.add(CityRentframe);
        FrameRentCity.add(CityRentName);
        VR5.setBounds(120, 150, VR5.getWidth(), VR5.getHeight());
        VR4.setBounds(120, 130, VR4.getWidth(), VR4.getHeight());
        VR3.setBounds(120, 110, VR3.getWidth(), VR3.getHeight());
        VR2.setBounds(120, 90, VR2.getWidth(), VR2.getHeight());
        VR1.setBounds(120, 70, VR1.getWidth(), VR1.getHeight());
        R6.setBounds(0, 170, R6.getWidth(), R6.getHeight());
        R5.setBounds(0, 150, R5.getWidth(), R5.getHeight());
        R4.setBounds(0, 130, R4.getWidth(), R4.getHeight());
        R3.setBounds(0, 110, R3.getWidth(), R3.getHeight());
        R2.setBounds(0, 90, R2.getWidth(), R2.getHeight());
        R1.setBounds(0, 70, R1.getWidth(), R1.getHeight());
        CityRentName.setBounds(0, 0, CityRentName.getWidth(), CityRentName.getHeight());
        CityRentframe.setBounds(0, 0, CityRentframe.getWidth(), CityRentframe.getHeight());
        FrameRentCity.setSize(new Dimension(CityRentframe.getWidth(), CityRentframe.getHeight()));
        FrameRentCity.setLocationRelativeTo(null);
        int total = 0;
        CityRentName.setText(city[plot]);
        if (addable[plot] >= 0) {
            VR1.setText("Rs. " + getRentonSite(plot));
            total += getRentonSite(plot);
        }
        if (addable[plot] >= 1) {
            VR2.setText("Rs. " + getRentonOffie(plot));
            total += getRentonOffie(plot);
        }
        if (addable[plot] >= 2) {
            VR3.setText("Rs. " + getRentonBungalow(plot));
            total += getRentonBungalow(plot);

        }
        if (addable[plot] >= 3) {
            VR4.setText("Rs. " + getRentonGodown(plot));
            total += getRentonGodown(plot);
        }
        VR5.setText("RS. " + total);
        R6.setText("Pay Rs. " + getTotalRent(plot));
        R6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        R6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        FrameRentCity.setVisible(true);
    }

// </editor-fold> 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGame(4).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel CityName;
    private javax.swing.JLabel CityRentName;
    private javax.swing.JLabel CityRentframe;
    private javax.swing.JLabel Cityframe;
    private javax.swing.JLabel Die1;
    private javax.swing.JLabel Die2;
    private javax.swing.JLabel DualDie;
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel Game;
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel N0;
    private javax.swing.JLabel N1;
    private javax.swing.JLabel N10;
    private javax.swing.JLabel N11;
    private javax.swing.JLabel N12;
    private javax.swing.JLabel N13;
    private javax.swing.JLabel N14;
    private javax.swing.JLabel N15;
    private javax.swing.JLabel N16;
    private javax.swing.JLabel N17;
    private javax.swing.JLabel N18;
    private javax.swing.JLabel N19;
    private javax.swing.JLabel N2;
    private javax.swing.JLabel N20;
    private javax.swing.JLabel N21;
    private javax.swing.JLabel N22;
    private javax.swing.JLabel N23;
    private javax.swing.JLabel N24;
    private javax.swing.JLabel N25;
    private javax.swing.JLabel N26;
    private javax.swing.JLabel N27;
    private javax.swing.JLabel N28;
    private javax.swing.JLabel N29;
    private javax.swing.JLabel N3;
    private javax.swing.JLabel N30;
    private javax.swing.JLabel N31;
    private javax.swing.JLabel N32;
    private javax.swing.JLabel N33;
    private javax.swing.JLabel N4;
    private javax.swing.JLabel N5;
    private javax.swing.JLabel N6;
    private javax.swing.JLabel N7;
    private javax.swing.JLabel N8;
    private javax.swing.JLabel N9;
    private javax.swing.JLabel NN0;
    private javax.swing.JLabel NN1;
    private javax.swing.JLabel NN10;
    private javax.swing.JLabel NN11;
    private javax.swing.JLabel NN12;
    private javax.swing.JLabel NN13;
    private javax.swing.JLabel NN14;
    private javax.swing.JLabel NN15;
    private javax.swing.JLabel NN16;
    private javax.swing.JLabel NN17;
    private javax.swing.JLabel NN18;
    private javax.swing.JLabel NN19;
    private javax.swing.JLabel NN2;
    private javax.swing.JLabel NN20;
    private javax.swing.JLabel NN21;
    private javax.swing.JLabel NN22;
    private javax.swing.JLabel NN23;
    private javax.swing.JLabel NN24;
    private javax.swing.JLabel NN25;
    private javax.swing.JLabel NN26;
    private javax.swing.JLabel NN27;
    private javax.swing.JLabel NN28;
    private javax.swing.JLabel NN29;
    private javax.swing.JLabel NN3;
    private javax.swing.JLabel NN30;
    private javax.swing.JLabel NN31;
    private javax.swing.JLabel NN32;
    private javax.swing.JLabel NN33;
    private javax.swing.JLabel NN4;
    private javax.swing.JLabel NN5;
    private javax.swing.JLabel NN6;
    private javax.swing.JLabel NN7;
    private javax.swing.JLabel NN8;
    private javax.swing.JLabel NN9;
    private javax.swing.JLabel NP1;
    private javax.swing.JLabel NP10;
    private javax.swing.JLabel NP11;
    private javax.swing.JLabel NP12;
    private javax.swing.JLabel NP13;
    private javax.swing.JLabel NP14;
    private javax.swing.JLabel NP15;
    private javax.swing.JLabel NP16;
    private javax.swing.JLabel NP17;
    private javax.swing.JLabel NP18;
    private javax.swing.JLabel NP19;
    private javax.swing.JLabel NP2;
    private javax.swing.JLabel NP20;
    private javax.swing.JLabel NP21;
    private javax.swing.JLabel NP22;
    private javax.swing.JLabel NP23;
    private javax.swing.JLabel NP24;
    private javax.swing.JLabel NP25;
    private javax.swing.JLabel NP26;
    private javax.swing.JLabel NP27;
    private javax.swing.JLabel NP28;
    private javax.swing.JLabel NP29;
    private javax.swing.JLabel NP3;
    private javax.swing.JLabel NP30;
    private javax.swing.JLabel NP31;
    private javax.swing.JLabel NP32;
    private javax.swing.JLabel NP33;
    private javax.swing.JLabel NP4;
    private javax.swing.JLabel NP5;
    private javax.swing.JLabel NP6;
    private javax.swing.JLabel NP7;
    private javax.swing.JLabel NP8;
    private javax.swing.JLabel NP9;
    private javax.swing.JLabel P0;
    private javax.swing.JLabel P1;
    private javax.swing.JLabel P10;
    private javax.swing.JLabel P11;
    private javax.swing.JLabel P12;
    private javax.swing.JLabel P13;
    private javax.swing.JLabel P14;
    private javax.swing.JLabel P15;
    private javax.swing.JLabel P16;
    private javax.swing.JLabel P17;
    private javax.swing.JLabel P18;
    private javax.swing.JLabel P19;
    private javax.swing.JLabel P2;
    private javax.swing.JLabel P20;
    private javax.swing.JLabel P21;
    private javax.swing.JLabel P22;
    private javax.swing.JLabel P23;
    private javax.swing.JLabel P24;
    private javax.swing.JLabel P25;
    private javax.swing.JLabel P26;
    private javax.swing.JLabel P27;
    private javax.swing.JLabel P28;
    private javax.swing.JLabel P29;
    private javax.swing.JLabel P3;
    private javax.swing.JLabel P30;
    private javax.swing.JLabel P31;
    private javax.swing.JLabel P32;
    private javax.swing.JLabel P33;
    private javax.swing.JLabel P4;
    private javax.swing.JLabel P5;
    private javax.swing.JLabel P6;
    private javax.swing.JLabel P7;
    private javax.swing.JLabel P8;
    private javax.swing.JLabel P9;
    private javax.swing.JLabel PAmt1;
    private javax.swing.JLabel PAmt2;
    private javax.swing.JLabel PAmt3;
    private javax.swing.JLabel PAmt4;
    private javax.swing.JLabel Player1;
    private javax.swing.JLabel Player2;
    private javax.swing.JLabel Player3;
    private javax.swing.JLabel Player4;
    private javax.swing.JLabel PlayerName1;
    private javax.swing.JLabel PlayerName2;
    private javax.swing.JLabel PlayerName3;
    private javax.swing.JLabel PlayerName4;
    private javax.swing.JLabel Pr1;
    private javax.swing.JLabel Pr10;
    private javax.swing.JLabel Pr11;
    private javax.swing.JLabel Pr12;
    private javax.swing.JLabel Pr13;
    private javax.swing.JLabel Pr14;
    private javax.swing.JLabel Pr15;
    private javax.swing.JLabel Pr16;
    private javax.swing.JLabel Pr17;
    private javax.swing.JLabel Pr18;
    private javax.swing.JLabel Pr19;
    private javax.swing.JLabel Pr2;
    private javax.swing.JLabel Pr20;
    private javax.swing.JLabel Pr21;
    private javax.swing.JLabel Pr22;
    private javax.swing.JLabel Pr23;
    private javax.swing.JLabel Pr24;
    private javax.swing.JLabel Pr25;
    private javax.swing.JLabel Pr26;
    private javax.swing.JLabel Pr27;
    private javax.swing.JLabel Pr28;
    private javax.swing.JLabel Pr29;
    private javax.swing.JLabel Pr3;
    private javax.swing.JLabel Pr30;
    private javax.swing.JLabel Pr31;
    private javax.swing.JLabel Pr32;
    private javax.swing.JLabel Pr33;
    private javax.swing.JLabel Pr4;
    private javax.swing.JLabel Pr5;
    private javax.swing.JLabel Pr6;
    private javax.swing.JLabel Pr7;
    private javax.swing.JLabel Pr8;
    private javax.swing.JLabel Pr9;
    private javax.swing.JLabel R1;
    private javax.swing.JLabel R2;
    private javax.swing.JLabel R3;
    private javax.swing.JLabel R4;
    private javax.swing.JLabel R5;
    private javax.swing.JLabel R6;
    private javax.swing.JLabel VR1;
    private javax.swing.JLabel VR2;
    private javax.swing.JLabel VR3;
    private javax.swing.JLabel VR4;
    private javax.swing.JLabel VR5;
    // End of variables declaration//GEN-END:variables
}
