/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.xmumcarpick;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Francis
 */
public class XMUMCarPick {

    public void changeColor(JPanel panel1){
        panel1.setBackground(new Color(240, 240, 240));
    }
    
    public void normalColor(JPanel panel1){
        panel1.setBackground(new Color(204,204,204));
    }
    
    public void serverChange(JLabel label1){
        label1.setForeground(Color.GREEN);
    }
    
    public void serverNormal(JLabel label1){
        label1.setForeground(Color.BLACK);
    }
    
    public void NormalWhite(JPanel panel1){
        panel1.setBackground(new Color(255, 255, 255));
    }
}
