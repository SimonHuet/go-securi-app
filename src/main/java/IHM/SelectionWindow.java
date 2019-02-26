package IHM;

import javax.swing.*;
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
        Mousqueton.addActionListener(e -> StateChanged("Mousqueton"));
        Panel.add(Mousqueton);
        Mousqueton.setBounds(5, 105, 110, 30);
        Mousqueton.setSelected(true);

        //---- Gant ----
        Gant.setText("Gant");
        Gant.addActionListener(e -> StateChanged("Gant"));
        Gant.setSelected(true);
        Panel.add(Gant);
        Gant.setBounds(5, 135, 110, 30);

        //---- Ceinture ----
        Ceinture.setText("Ceinture");
        Ceinture.addActionListener(e -> StateChanged("Ceinture"));
Ceinture.setSelected(true);
        Panel.add(Ceinture);
        Ceinture.setBounds(5, 165, 110, 30);

        //---- Brassard ----
        Brassard.setText("Brassard");
        Brassard.addActionListener(e -> StateChanged("Brassard"));
Brassard.setSelected(true);
        Panel.add(Brassard);
        Brassard.setBounds(175, 105, 110, 30);

        //---- Detecteur ----
        Detecteur.setText("Detecteur");
        Detecteur.addActionListener(e -> StateChanged("Detecteur"));
Detecteur.setSelected(true);
        Panel.add(Detecteur);
        Detecteur.setBounds(5, 195, 110, 30);

        //---- Lampe ----
        Lampe.setText("Lampe");
        Lampe.addActionListener(e -> StateChanged("Lampe"));
Lampe.setSelected(true);
        Panel.add(Lampe);
        Lampe.setBounds(175, 135, 110, 30);

        //---- Gilet ----
        Gilet.setText("Gilet");
        Gilet.addActionListener(e -> StateChanged("Gilet"));
Gilet.setSelected(true);
        Panel.add(Gilet);
        Gilet.setBounds(175, 165, 110, 30);
int nbMousqueton = 10;

        //---- MousquetonNB ----
        MousquetonNB.setModel(new SpinnerNumberModel(0, 0, nbMousqueton, 1));
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
String UserFirstname = "Serge";
String UserLastname = "Leblanc";


        //---- UserPanel ----
        UserPanel.setText(UserFirstname +" "+ UserLastname);
        UserPanel.setEnabled(false);
        Panel.add(UserPanel);
        UserPanel.setBounds(15, 15, 110, 35);

        //---- DeconnectionButton ----
        DeconnectionButton.setText("Enregistrer & quitter");
        DeconnectionButton.setBackground(new Color(55, 158, 193));
        DeconnectionButton.addActionListener(e->SaveAdnQuit());
        Panel.add(DeconnectionButton);
        DeconnectionButton.setBounds(330, 15, 200, DeconnectionButton.getPreferredSize().height);

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
    private  void SaveAdnQuit(){}
    private void StateChanged(String type) {
        try {
                switch (type){
                    case "Mousqueton" :
                        if (!Mousqueton.isSelected()){
                            MousquetonNB.setValue(0);
                            MousquetonNB.setEnabled(false);
                        }else MousquetonNB.setEnabled(true);
                        break;
                    case "Gant" :
                        if (!Gant.isSelected()){
                            GantNB.setValue(0);
                            GantNB.setEnabled(false);
                        }else GantNB.setEnabled(true);
                        break;
                    case "Ceinture" :
                        if (!Ceinture.isSelected()){
                            CeintureNB.setValue(0);
                            CeintureNB.setEnabled(false);
                        }else CeintureNB.setEnabled(true);
                            break;
                    case "Brassard" :
                        if (!Brassard.isSelected()){
                            BrassardNB.setValue(0);
                            BrassardNB.setEnabled(false);
                        }else BrassardNB.setEnabled(true);
                        break;
                    case "Detecteur" :

                        if (!Detecteur.isSelected()){
                            DetecteurNB.setValue(0);
                            DetecteurNB.setEnabled(false);
                        }else DetecteurNB.setEnabled(true);
                        break;
                    case "Lampe" :
                        if (!Lampe.isSelected()){
                            LampeNB.setValue(0);
                            LampeNB.setEnabled(false);
                        }else LampeNB.setEnabled(true);
                        break;
                    case "Gilet" :
                        if (!Gilet.isSelected()){
                            GiletNB.setValue(0);
                            GiletNB.setEnabled(false);
                        }else GiletNB.setEnabled(true);
                        break;

                }


        }catch (Exception ex){}
    }

}
