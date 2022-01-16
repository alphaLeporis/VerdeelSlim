package gui.components;

import gui.Interface;

import javax.swing.*;
import java.awt.*;

public class debtLayout {
    final String p1;
    final String p2;
    final double price;
    final Interface inter;

    public debtLayout(Interface inter, String p1, String p2, double price) {
        this.p1 = p1;
        this.p2 = p2;
        this.price = price;
        this.inter = inter;
    }

    public Component draw() {
        if (price > 0) {
            if (inter.currentLanguage.isRTL()) {
                return new JLabel(String.format(inter.currentLanguage.receives(), p1,p2,Double.toString(price)));
            } else {
                return new JLabel(String.format(inter.currentLanguage.receives(), p1,price,p2));
            }
        } else {
            if (inter.currentLanguage.isRTL()) {
                return new JLabel(String.format(inter.currentLanguage.receives(), p1,p2, Double.toString(Math.abs(price))));
            } else {
                return new JLabel(String.format(inter.currentLanguage.receives(), p1,Math.abs(price),p2));
            }
        }
    }
}
