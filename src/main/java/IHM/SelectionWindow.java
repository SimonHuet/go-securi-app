package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SelectionWindow extends JPanel implements ActionListener {
    protected JButton b1, b2;
    public SelectionWindow(){

        JPanel pan=new JPanel();
        pan.setLayout(null);

        /* Les boutons */
        JButton id=new JButton("Identification");
        id.addActionListener(this);

        /* Les CheckBox */
        Checkbox mousqueton=new Checkbox();
        Checkbox gant=new Checkbox();
        Checkbox ceinture=new Checkbox();
        Checkbox detecteur=new Checkbox();
        Checkbox brassard=new Checkbox();
        Checkbox lampe=new Checkbox();
        Checkbox gilet=new Checkbox();

        /* Les Labels */
        JLabel mousq=new JLabel("Mousqueton");
        JLabel gan=new JLabel("Gant d'intervention");
        JLabel ceint=new JLabel("Ceinture de sécurité tactique");
        JLabel detect=new JLabel("Détecteur de métaux");
        JLabel brass=new JLabel("Brassard de sécurité");
        JLabel lamp=new JLabel("Lampe torche");
        JLabel gil=new JLabel("Gilet pare balle");

        /* Image de profil */
        JLabel image=new JLabel(new ImageIcon("../resources/logo.PNG"));

        /* On ajoute le bouton */
        pan.add(id);

        /* On ajoute les checkbox */
        pan.add(mousqueton);
        pan.add(gant);
        pan.add(ceinture);
        pan.add(detecteur);
        pan.add(brassard);
        pan.add(lampe);
        pan.add(gilet);

        /* On ajoute les Label */
        pan.add(mousq);
        pan.add(gan);
        pan.add(ceint);
        pan.add(detect);
        pan.add(brass);
        pan.add(lamp);
        pan.add(gil);

        /* On ajoute l'image */
        pan.add(image);


        mousqueton.setBounds(400,280,20,20);
        mousq.setBounds(307,237,100,100);

        gant.setBounds(400,310,20,20);
        gan.setBounds(270,267,200,100);

        ceinture.setBounds(400,340,20,20);
        ceint.setBounds(210,297,200,100);

        detecteur.setBounds(400,370,20,20);
        detect.setBounds(255,327,200,100);

        brassard.setBounds(400,400,20,20);
        brass.setBounds(255,357,200,100);

        lampe.setBounds(400,430,20,20);
        lamp.setBounds(295,387,200,100);

        gilet.setBounds(400,460,20,20);
        gil.setBounds(288,417,200,100);

        id.setBounds(20,10,150,35);

        image.setBounds(550,10,220,220);

        add(pan);
    }
    public void actionPerformed (ActionEvent e){
        if ("disable".equals(e.getActionCommand())) {
            b2.setEnabled(true);
            b1.setEnabled(false);
        } else {
            b2.setEnabled(false);
            b1.setEnabled(true);
        }
    }

}
