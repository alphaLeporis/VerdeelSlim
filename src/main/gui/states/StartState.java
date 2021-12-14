package gui.states;

import gui.Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class StartState extends State {
    private final Container pane;
    private final Interface inter;

    private Button lookUsers;
    private Button addTicket;
    private Button lookTicket;
    private Button calculate;
    private Button exit;

    public StartState(Interface inter) {
        this.inter = inter;
        this.pane = inter.getPane();
    }

    public void init() {
        pane.setLayout(new GridLayout(0, 1));
        BufferedImage img = null;
        try {
            img = ImageIO.read(Objects.requireNonNull(StartState.class.getResource("/logo.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel pic = new JLabel(new ImageIcon(img));
        pane.add(pic);



        lookUsers = new Button("Bekijk gebruikers 👥");
        addTicket = new Button("Voeg een ticket toe 🎟");
        lookTicket = new Button("Bekijk hudige tickets");
        calculate = new Button("Bereken 🧾");
        exit = new Button("Sluit af 🚪");
        lookUsers.addActionListener(this);
        addTicket.addActionListener(this);
        lookTicket.addActionListener(this);
        calculate.addActionListener(this);
        exit.addActionListener(this);
        pane.add(lookUsers);
        pane.add(addTicket);
        pane.add(lookTicket);
        pane.add(calculate);
        pane.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lookUsers) {
            inter.changeState(new UserState(this.inter));
        }

        if (e.getSource() == addTicket) {
            inter.changeState(new AddState(this.inter));
        }

        if (e.getSource() == lookTicket) {
            inter.changeState(new TicketState(this.inter));
        }

        if (e.getSource() == calculate) {
            inter.changeState(new CalculateState(this.inter));
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
