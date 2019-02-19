package IHM;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class SelectionWindow extends JPanel {


    private JPanel Panel;
    private JCheckBox Mousqueton;
    private JCheckBox Gant;
    private JCheckBox Ceinture;
    private JCheckBox Brassard;
    private JCheckBox Detecteur;
    private JCheckBox Lampe;
    private JCheckBox Gilet;
    private JSpinner MousquetonNB;
    private JSpinner GantNB;
    private JSpinner CeintureNB;
    private JSpinner DetecteurNB;
    private JSpinner BrassardNB;
    private JSpinner LampeNB;
    private JSpinner GiletNB;
    private JLabel UserPanel;
    private JButton DeconnectionButton;

    public SelectionWindow(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Pierre NEGRE
        Panel = new JPanel();
        Mousqueton = new JCheckBox();
        Gant = new JCheckBox();
        Ceinture = new JCheckBox();
        Brassard = new JCheckBox();
        Detecteur = new JCheckBox();
        Lampe = new JCheckBox();
        Gilet = new JCheckBox();
        MousquetonNB = new JSpinner();
        GantNB = new JSpinner();
        CeintureNB = new JSpinner();
        DetecteurNB = new JSpinner();
        BrassardNB = new JSpinner();
        LampeNB = new JSpinner();
        GiletNB = new JSpinner();
        UserPanel = new JLabel();
        DeconnectionButton = new JButton();

        try {
            InputStream is = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Roboto-Medium.ttf"));
            Font mediumFont = Font.createFont(Font.TRUETYPE_FONT, is);
            Font font = mediumFont.deriveFont(15f);
            Mousqueton.setFont(font);
            Gant.setFont(font);
            Ceinture.setFont(font);
            Brassard.setFont(font);
            Detecteur.setFont(font);
            Lampe.setFont(font);
            Gilet.setFont(font);
            DeconnectionButton.setFont(font);
            UserPanel.setFont(font);
            MousquetonNB.setFont(font);
            GantNB.setFont(font);
            CeintureNB.setFont(font);
            BrassardNB.setFont(font);
            DetecteurNB.setFont(font);
            LampeNB.setFont(font);
            GiletNB.setFont(font);
        }catch(Exception ffe){
            ffe.printStackTrace();
        }

        //======== Panel ========
        Panel.setLayout(null);

        //---- Mousqueton ----
        Mousqueton.setText("Mousqueton");
        Mousqueton.addChangeListener(e -> StateChanged(e));
        Panel.add(Mousqueton);
        Mousqueton.setBounds(5, 105, 110, 30);

        //---- Gant ----
        Gant.setText("Gant");
        //Gant.addChangeListener(e -> StateChanged(e));
        Panel.add(Gant);
        Gant.setBounds(5, 135, 110, 30);

        //---- Ceinture ----
        Ceinture.setText("Ceinture");
        //Ceinture.addChangeListener(e -> StateChanged(e));
        Panel.add(Ceinture);
        Ceinture.setBounds(5, 165, 110, 30);

        //---- Brassard ----
        Brassard.setText("Brassard");
        //Brassard.addChangeListener(e -> StateChanged(e));
        Panel.add(Brassard);
        Brassard.setBounds(175, 105, 110, 30);

        //---- Detecteur ----
        Detecteur.setText("Detecteur");
        //Detecteur.addChangeListener(e -> StateChanged(e));
        Panel.add(Detecteur);
        Detecteur.setBounds(5, 195, 110, 30);

        //---- Lampe ----
        Lampe.setText("Lampe");
        //Lampe.addChangeListener(e -> StateChanged(e));
        Panel.add(Lampe);
        Lampe.setBounds(175, 135, 110, 30);

        //---- Gilet ----
        Gilet.setText("Gilet");
        //Gilet.addChangeListener(e -> StateChanged(e));
        Panel.add(Gilet);
        Gilet.setBounds(175, 165, 110, 30);


        //---- MousquetonNB ----
        MousquetonNB.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        Panel.add(MousquetonNB);
        MousquetonNB.setBounds(115, 105, 50, 30);

        //---- GantNB ----
        GantNB.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        Panel.add(GantNB);
        GantNB.setBounds(115, 135, 50, 30);

        //---- CeintureNB ----
        CeintureNB.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        Panel.add(CeintureNB);
        CeintureNB.setBounds(115, 165, 50, 30);

        //---- DetecteurNB ----
        DetecteurNB.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        Panel.add(DetecteurNB);
        DetecteurNB.setBounds(115, 195, 50, 30);

        //---- BrassardNB ----
        BrassardNB.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        Panel.add(BrassardNB);
        BrassardNB.setBounds(285, 105, 50, 30);

        //---- LampeNB ----
        LampeNB.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        Panel.add(LampeNB);
        LampeNB.setBounds(285, 135, 50, 30);

        //---- GiletNB ----
        GiletNB.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        Panel.add(GiletNB);
        GiletNB.setBounds(285, 165, 50, 30);

        //---- UserPanel ----
        UserPanel.setText("UserName");
        UserPanel.setEnabled(false);
        Panel.add(UserPanel);
        UserPanel.setBounds(15, 15, 110, 35);

        //---- DeconnectionButton ----
        DeconnectionButton.setText("Deconnexion");
        DeconnectionButton.setBackground(new Color(55, 158, 193));
        Panel.add(DeconnectionButton);
        DeconnectionButton.setBounds(330, 15, 145, DeconnectionButton.getPreferredSize().height);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < Panel.getComponentCount(); i++) {
                Rectangle bounds = Panel.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = Panel.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            Panel.setMinimumSize(preferredSize);
            Panel.setPreferredSize(preferredSize);
        }
        add(Panel);
    }

    private void StateChanged(ChangeEvent e) {
        try {
            var bla = e.getSource();
            if(bla instanceof JButton){
                var name = ((JButton) bla).getText();
                switch (name){
                    case "Mousqueton" :
                        Mousqueton.setText("pressed");
                        break;
                    case "Gant" :
                        Gant.setText("pressed");
                        break;
                    case "Ceinture" :
                        Ceinture.setText("pressed");
                        break;
                    case "Brassard" :
                        Brassard.setText("pressed");
                        break;
                    case "Detecteur" :
                        Detecteur.setText("pressed");
                        break;
                    case "Lampe" :
                        Lampe.setText("pressed");
                        break;
                    case "Gilet" :
                        Gilet.setText("pressed");
                        break;

                }
            }

        }catch (Exception ex){}
    }

}
