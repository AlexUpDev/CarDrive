

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends JFrame{
    JPanel  dashboard= new JPanel(new GridLayout(6,1));
    JTextArea speedDisplay= new JTextArea(1,20);
    JTextArea engineIODisplay= new JTextArea(1,20);
    JTextArea enginePowerDisplay= new JTextArea(1,20);
    JTextArea transmissionDisplay= new JTextArea(1,20);
    JTextArea brakesDisplay= new JTextArea(1,20);
    JTextArea infoDisplay= new JTextArea(1,20);


    JPanel engineStartStopPanel = new JPanel(new GridLayout(1,2));
    JPanel buttonPanel = new JPanel(new GridLayout(3,5));
    JButton engineStartStop = new JButton("Engine Start/Stop");
    JButton engine0 = new JButton("E0%");
    JButton engine25 = new JButton("E25%");
    JButton engine50 = new JButton("E50%");
    JButton engine75 = new JButton("E75%");
    JButton engine100 = new JButton("E100%");
    JButton transmissionP = new JButton("P");
    JButton transmissionN = new JButton("N");
    JButton transmissionD = new JButton("D");
    JButton transmissionR = new JButton("R");
    JButton button8 = new JButton(" ");
    JButton brakes0 = new JButton("B0%");
    JButton brakes25 = new JButton("B25%");
    JButton brakes50 = new JButton("B50%");
    JButton brakes75 = new JButton("B75%");
    JButton brakes100 = new JButton("B100%");

    Car car = new Car();

    public Main() {
        setBounds(550, 250, 550, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(dashboard, BorderLayout.WEST);
        dashboard.add(speedDisplay);
        dashboard.add(engineIODisplay);
        dashboard.add(enginePowerDisplay);
        dashboard.add(transmissionDisplay);
        dashboard.add(brakesDisplay);
        dashboard.add(infoDisplay);
        add(buttonPanel,BorderLayout.CENTER);
        add(engineStartStopPanel,BorderLayout.NORTH);
        engineStartStopPanel.add(engineStartStop);
        buttonPanel.add(engine0);
        buttonPanel.add(engine25);
        buttonPanel.add(engine50);
        buttonPanel.add(engine75);
        buttonPanel.add(engine100);
        buttonPanel.add(transmissionP);
        buttonPanel.add(transmissionR);
        buttonPanel.add(transmissionN);
        buttonPanel.add(transmissionD);
        buttonPanel.add(button8);
        buttonPanel.add(brakes0);
        buttonPanel.add(brakes25);
        buttonPanel.add(brakes50);
        buttonPanel.add(brakes75);
        buttonPanel.add(brakes100);

        setVisible(true);

        engineStartStop.addActionListener(new engineStartPressed());

        engine0.addActionListener(new engineSetPower0());
        engine25.addActionListener(new engineSetPower25());
        engine50.addActionListener(new engineSetPower50());
        engine75.addActionListener(new engineSetPower75());
        engine100.addActionListener(new engineSetPower100());

        transmissionP.addActionListener(new transmissionSetModeP());
        transmissionR.addActionListener(new transmissionSetModeR());
        transmissionN.addActionListener(new transmissionSetModeN());
        transmissionD.addActionListener(new transmissionSetModeD());

        brakes0.addActionListener(new brakesSet0());
        brakes25.addActionListener(new brakesSet25());
        brakes50.addActionListener(new brakesSet50());
        brakes75.addActionListener(new brakesSet75());
        brakes100.addActionListener(new brakesSet100());



        speedDisplay.setText(" Speed: " + car.getRoundedSpeed() + "km/h");
        speedDisplay.setEditable(false);
        engineIODisplay.setText(" Engine: " + car.engine.getStateString());
        engineIODisplay.setEditable(false);
        enginePowerDisplay.setText(" Power: " + car.engine.getPowerPercents() +"%");
        enginePowerDisplay.setEditable(false);
        transmissionDisplay.setText(" Mode: " + car.transmission.getMode());
        transmissionDisplay.setEditable(false);
        brakesDisplay.append(" Brakes: " + car.wheels.getBrakesPowerPercents() +"%");
        brakesDisplay.setEditable(false);
        infoDisplay.append(" Useful info will appear here");
        infoDisplay.setEditable(false);

        Timer timer = new Timer();
        timer.schedule(new SpeedDisplay(), 0, 200);
    }

    class SpeedDisplay extends TimerTask {
        public void run() {
            car.calculateSpeed();
            speedDisplay.setText(" Speed: " + car.getRoundedSpeed() + "km/h");
        }
    }
    class engineStartPressed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.engine.startStopEngine(car.getSpeed());
            engineIODisplay.setText(" Engine: " + car.engine.getStateString());
        }
    }

    class engineSetPower0 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.engine.setPower(0.0);
            enginePowerDisplay.setText(" Power: " + car.engine.getPowerPercents() +"%");
        }
    }
    class engineSetPower25 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.engine.setPower(0.25);
            enginePowerDisplay.setText(" Power: " + car.engine.getPowerPercents() +"%");
        }
    }
    class engineSetPower50 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.engine.setPower(0.5);
            enginePowerDisplay.setText(" Power: " + car.engine.getPowerPercents() +"%");
        }
    }
    class engineSetPower75 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.engine.setPower(0.75);
            enginePowerDisplay.setText(" Power: " + car.engine.getPowerPercents() +"%");
        }
    }
    class engineSetPower100 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.engine.setPower(1.0);
            enginePowerDisplay.setText(" Power: " + car.engine.getPowerPercents() +"%");
        }
    }
    class transmissionSetModeP implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.transmission.setMode("P",car.getSpeed());
            transmissionDisplay.setText(" Mode: " + car.transmission.getMode());
        }
    }
    class transmissionSetModeR implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.transmission.setMode("R", car.getSpeed());
            transmissionDisplay.setText(" Mode: " + car.transmission.getMode());
        }
    }
    class transmissionSetModeN implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.transmission.setMode("N", car.getSpeed());
            transmissionDisplay.setText(" Mode: " + car.transmission.getMode());
        }
    }
    class transmissionSetModeD implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.transmission.setMode("D", car.getSpeed());
            transmissionDisplay.setText(" Mode: " + car.transmission.getMode());
        }
    }
    class brakesSet0 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.wheels.setBrakesPower(0.0);
            brakesDisplay.setText(" Brakes: " + car.wheels.getBrakesPowerPercents() +"%");
        }
    }
    class brakesSet25 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.wheels.setBrakesPower(0.25);
            brakesDisplay.setText(" Brakes: " + car.wheels.getBrakesPowerPercents() +"%");
        }
    }
    class brakesSet50 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.wheels.setBrakesPower(0.5);
            brakesDisplay.setText(" Brakes: " + car.wheels.getBrakesPowerPercents() +"%");
        }
    }
    class brakesSet75 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.wheels.setBrakesPower(0.75);
            brakesDisplay.setText(" Brakes: " + car.wheels.getBrakesPowerPercents() +"%");
        }
    }
    class brakesSet100 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            car.wheels.setBrakesPower(1.0);
            brakesDisplay.setText(" Brakes: " + car.wheels.getBrakesPowerPercents() +"%");
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}