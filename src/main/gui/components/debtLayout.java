package gui.components;

import javax.swing.*;
import java.awt.*;

public class debtLayout {
    String p1;
    String p2;
    double price;
    public debtLayout(String p1, String p2, double price) {
        this.p1 = p1;
        this.p2 = p2;
        this.price = price;
    }

    public Component draw() {
        if (price > 0) {
            return new JLabel(p1 +" moet "+ price + "€ van "+ p2 + " krijgen!");
        } else {
            return new JLabel(p1 +" moet "+ Math.abs(price) + "€ aan "+ p2 + " betalen!");
        }
    }
}
