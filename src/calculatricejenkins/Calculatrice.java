/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatricejenkins;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculatrice extends JFrame {
    private JPanel container = new JPanel();
    String[] tab_string = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
    JButton[] tab_button;
    private JLabel ecran;
    private Dimension dim;
    private Dimension dim2;
    private double chiffre1;
    private boolean clicOperateur;
    private boolean update;
    private String operateur;

    public Calculatrice() {
        this.tab_button = new JButton[this.tab_string.length];
        this.ecran = new JLabel();
        this.dim = new Dimension(50, 40);
        this.dim2 = new Dimension(50, 31);
        this.clicOperateur = false;
        this.update = false;
        this.operateur = "";
        this.setSize(240, 260);
        this.setTitle("Calculette");
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.setResizable(false);
        this.initComposant();
        this.setContentPane(this.container);
        this.setVisible(true);
    }

    private void initComposant() {
        Font police = new Font("Arial", 1, 20);
        this.ecran = new JLabel("0");
        this.ecran.setFont(police);
        this.ecran.setHorizontalAlignment(4);
        this.ecran.setPreferredSize(new Dimension(220, 20));
        JPanel operateur = new JPanel();
        operateur.setPreferredSize(new Dimension(55, 225));
        JPanel chiffre = new JPanel();
        chiffre.setPreferredSize(new Dimension(165, 225));
        JPanel panEcran = new JPanel();
        panEcran.setPreferredSize(new Dimension(220, 30));

        for(int i = 0; i < this.tab_string.length; ++i) {
            this.tab_button[i] = new JButton(this.tab_string[i]);
            this.tab_button[i].setPreferredSize(this.dim);
            switch(i) {
            case 11:
                this.tab_button[i].addActionListener(new Calculatrice.EgalListener());
                chiffre.add(this.tab_button[i]);
                break;
            case 12:
                this.tab_button[i].setForeground(Color.red);
                this.tab_button[i].addActionListener(new Calculatrice.ResetListener());
                operateur.add(this.tab_button[i]);
                break;
            case 13:
                this.tab_button[i].addActionListener(new Calculatrice.PlusListener());
                this.tab_button[i].setPreferredSize(this.dim2);
                operateur.add(this.tab_button[i]);
                break;
            case 14:
                this.tab_button[i].addActionListener(new Calculatrice.MoinsListener());
                this.tab_button[i].setPreferredSize(this.dim2);
                operateur.add(this.tab_button[i]);
                break;
            case 15:
                this.tab_button[i].addActionListener(new Calculatrice.MultiListener());
                this.tab_button[i].setPreferredSize(this.dim2);
                operateur.add(this.tab_button[i]);
                break;
            case 16:
                this.tab_button[i].addActionListener(new Calculatrice.DivListener());
                this.tab_button[i].setPreferredSize(this.dim2);
                operateur.add(this.tab_button[i]);
                break;
            default:
                chiffre.add(this.tab_button[i]);
                this.tab_button[i].addActionListener(new Calculatrice.ChiffreListener());
            }
        }

        panEcran.add(this.ecran);
        panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
        this.container.add(panEcran, "North");
        this.container.add(chiffre, "Center");
        this.container.add(operateur, "East");
    }

    private void calcul() {
        if (this.operateur.equals("+")) {
            this.chiffre1 += Double.valueOf(this.ecran.getText());
            this.ecran.setText(String.valueOf(this.chiffre1));
        }

        if (this.operateur.equals("-")) {
            this.chiffre1 -= Double.valueOf(this.ecran.getText());
            this.ecran.setText(String.valueOf(this.chiffre1));
        }

        if (this.operateur.equals("*")) {
            this.chiffre1 *= Double.valueOf(this.ecran.getText());
            this.ecran.setText(String.valueOf(this.chiffre1));
        }

        if (this.operateur.equals("/")) {
            try {
                this.chiffre1 /= Double.valueOf(this.ecran.getText());
                this.ecran.setText(String.valueOf(this.chiffre1));
            } catch (ArithmeticException var2) {
                this.ecran.setText("0");
            }
        }

    }

    class ResetListener implements ActionListener {
        ResetListener() {
        }

        public void actionPerformed(ActionEvent arg0) {
            Calculatrice.this.clicOperateur = false;
            Calculatrice.this.update = true;
            Calculatrice.this.chiffre1 = 0.0D;
            Calculatrice.this.operateur = "";
            Calculatrice.this.ecran.setText("");
        }
    }

    class DivListener implements ActionListener {
        DivListener() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (Calculatrice.this.clicOperateur) {
                Calculatrice.this.calcul();
                Calculatrice.this.ecran.setText(String.valueOf(Calculatrice.this.chiffre1));
            } else {
                Calculatrice.this.chiffre1 = Double.valueOf(Calculatrice.this.ecran.getText());
                Calculatrice.this.clicOperateur = true;
            }

            Calculatrice.this.operateur = "/";
            Calculatrice.this.update = true;
        }
    }

    class MultiListener implements ActionListener {
        MultiListener() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (Calculatrice.this.clicOperateur) {
                Calculatrice.this.calcul();
                Calculatrice.this.ecran.setText(String.valueOf(Calculatrice.this.chiffre1));
            } else {
                Calculatrice.this.chiffre1 = Double.valueOf(Calculatrice.this.ecran.getText());
                Calculatrice.this.clicOperateur = true;
            }

            Calculatrice.this.operateur = "*";
            Calculatrice.this.update = true;
        }
    }

    class MoinsListener implements ActionListener {
        MoinsListener() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (Calculatrice.this.clicOperateur) {
                Calculatrice.this.calcul();
                Calculatrice.this.ecran.setText(String.valueOf(Calculatrice.this.chiffre1));
            } else {
                Calculatrice.this.chiffre1 = Double.valueOf(Calculatrice.this.ecran.getText());
                Calculatrice.this.clicOperateur = true;
            }

            Calculatrice.this.operateur = "-";
            Calculatrice.this.update = true;
        }
    }

    class PlusListener implements ActionListener {
        PlusListener() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (Calculatrice.this.clicOperateur) {
                Calculatrice.this.calcul();
                Calculatrice.this.ecran.setText(String.valueOf(Calculatrice.this.chiffre1));
            } else {
                Calculatrice.this.chiffre1 = Double.valueOf(Calculatrice.this.ecran.getText());
                Calculatrice.this.clicOperateur = true;
            }

            Calculatrice.this.operateur = "+";
            Calculatrice.this.update = true;
        }
    }

    class EgalListener implements ActionListener {
        EgalListener() {
        }

        public void actionPerformed(ActionEvent arg0) {
            Calculatrice.this.calcul();
            Calculatrice.this.update = true;
            Calculatrice.this.clicOperateur = false;
        }
    }

    class ChiffreListener implements ActionListener {
        ChiffreListener() {
        }

        public void actionPerformed(ActionEvent e) {
            String str = ((JButton)e.getSource()).getText();
            if (Calculatrice.this.update) {
                Calculatrice.this.update = false;
            } else if (!Calculatrice.this.ecran.getText().equals("0")) {
                str = Calculatrice.this.ecran.getText() + str;
            }

            Calculatrice.this.ecran.setText(str);
        }
    }
}

