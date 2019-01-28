package IHM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SelectionWindow extends JPanel implements ActionListener {
    protected JButton b1, b2;
    public SelectionWindow(){

        b1 = new JButton("click left");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_L);
        b1.setActionCommand("disable");

        b2 = new JButton("click right");
        b2.setMnemonic(KeyEvent.VK_R);
        b2.setActionCommand("enable");
        b2.setEnabled(false);

        b1.addActionListener(this);
        b2.addActionListener(this);

        b1.setToolTipText("Click this button !.");
        b2.setToolTipText("Click this other button !!.");

        add(b1);
        add(b2);
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
