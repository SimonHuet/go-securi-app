package IHM;
import Controlleur.Affichage;

import javax.swing.*;
import java.awt.event.*;

public class MainWindow extends JPanel implements ActionListener
{
        protected JButton b1, b2, b3;

    public MainWindow() {

        b1 = new JButton("Disable middle button");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("disable");

        b2 = new JButton("Middle button");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setActionCommand("Change");

        b3 = new JButton("Enable middle button");
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("enable");
        b3.setEnabled(false);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        b1.setToolTipText("Click this button to disable the middle button.");
        b2.setToolTipText("This middle button change page.");
        b3.setToolTipText("Click this button to enable the middle button.");

        add(b1);
        add(b2);
        add(b3);
    }
        public void actionPerformed (ActionEvent e){

            if(e.getActionCommand()=="disable" ) {
                b2.setEnabled(false);
                b1.setEnabled(false);
                b3.setEnabled(true);
            }else if (e.getActionCommand()=="enable") {
                b2.setEnabled(true);
                b1.setEnabled(true);
                b3.setEnabled(false);
            }else if (e.getActionCommand()=="Change") {
                Affichage.changeWindow(new SelectionWindow());
            }
        }
    }

