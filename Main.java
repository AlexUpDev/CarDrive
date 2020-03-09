


package com.company;

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

    Engine engine = new Engine();
    Transmission transmission = new Transmission();
    Brakes brakes = new Brakes();
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

        Double carSpeed = 0.0;
        Integer brakesPower = 0;

        engine.State = "Off";
        engine.Power = 0;

        transmission.Mode = "P";

        brakes.Power = 0;
        car.Speed = 0.0;
        car.Resist = 0.0;


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



        speedDisplay.setText(" Speed: " + car.Speed + "km/h");
        speedDisplay.setEditable(false);
        engineIODisplay.setText(" Engine: " + engine.State);
        engineIODisplay.setEditable(false);
        enginePowerDisplay.setText(" Power: " + engine.Power +"%");
        enginePowerDisplay.setEditable(false);
        transmissionDisplay.setText(" Mode: " + transmission.Mode);
        transmissionDisplay.setEditable(false);
        brakesDisplay.append(" Brakes: " + brakesPower +"%");
        brakesDisplay.setEditable(false);
        infoDisplay.append(" Useful info will appear here");
        infoDisplay.setEditable(false);

        Timer timer = new Timer();
        timer.schedule(new SpeedDisplay(), 0, 200);



    }

    class SpeedDisplay extends TimerTask {
        public void run() {
            car.setResist(car.Speed);
            if(     car.Speed<=200.0 &&
                    car.Speed >= 0.0 &&
                    transmission.Mode == "D") {
                car.Speed += 0.12 * engine.Power/5 - car.Resist;

                if (car.Speed > 0) {
                    car.Speed -= 0.15 * brakes.Power/5;
                }
                if (car.Speed < 0) {
                    car.Speed = 0.0;
                }
                if (car.Speed > 200) {
                    car.Speed = 200.0;
                }
            }
            speedDisplay.setText(" Speed: " + Math.round(car.Speed) + "km/h");
        }
    }
    class engineStartPressed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            engine.StartStopEngine();
        }
    }


    class engineSetPower0 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            engine.setPower(0);
        }
    }
    class engineSetPower25 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            engine.setPower(25);
        }
    }
    class engineSetPower50 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            engine.setPower(50);
        }
    }
    class engineSetPower75 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            engine.setPower(75);
        }
    }
    class engineSetPower100 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            engine.setPower(100);
        }
    }
    class transmissionSetModeP implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            transmission.setMode("P");
        }
    }
    class transmissionSetModeR implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            transmission.setMode("R");
        }
    }
    class transmissionSetModeN implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            transmission.setMode("N");
        }
    }
    class transmissionSetModeD implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            transmission.setMode("D");
        }
    }
    class brakesSet0 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            brakes.setBrakesPower(0);
        }
    }
    class brakesSet25 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            brakes.setBrakesPower(25);
        }
    }
    class brakesSet50 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            brakes.setBrakesPower(50);
        }
    }
    class brakesSet75 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            brakes.setBrakesPower(75);
        }
    }
    class brakesSet100 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            brakes.setBrakesPower(100);
        }
    }



    public static void main(String[] args) {
        new Main();
    }

    public class Engine {
        //can be on/off
        String State;
        //0.33/0.66/1
        Integer Power;
        public void StartStopEngine() {
            if(engine.State == "On") {
                engine.State = "Off";
                engine.Power = 0;
                if(transmission.Mode != "P") {
                    transmission.Mode = "N";
                }
                infoDisplay.setText(" Engine Stopped");
                enginePowerDisplay.setText(" Power: " + engine.Power +"%");
                transmissionDisplay.setText(" Mode: " + transmission.Mode);
            }
            if(engine.State == "Off") {
                if(transmission.Mode != "P") {
                    infoDisplay.setText(" Select P mode on transmission");
                } else {
                    engine.State = "On";
                    infoDisplay.setText(" Engine Started");
                }
            }
            engineIODisplay.setText(" Engine: " + engine.State);
        }

        public void setPower(Integer percent) {
            if(engine.State == "Off") {
                infoDisplay.setText(" Start engine first!");
            } else {
                if (percent == 0) {
                    engine.Power = 0;
                }
                if (percent == 25) {
                    engine.Power = 25;
                }
                if (percent == 50) {
                    engine.Power = 50;
                }
                if (percent == 75) {
                    engine.Power = 75;
                }
                if (percent == 100) {
                    engine.Power = 100;
                }
                enginePowerDisplay.setText(" Power: " + engine.Power +"%");
            }

        }


    }

    public class Transmission {
        //P/R/N/D
        String Mode;

        public void setMode(String NewMode) {
            if ((   transmission.Mode == "P" ||
                    transmission.Mode == "N") &&
                    brakes.Power == 0) {
                infoDisplay.setText(" Hold brakes first!");
            } else {
                if (    NewMode == "P" ||
                        NewMode == "R" &&
                        car.Speed>0) {
                    infoDisplay.setText(" Stop first!");
                }
                if (NewMode == "P" && car.Speed == 0) {
                    transmission.Mode = "P";
                }
                if (    NewMode == "R" &&
                        engine.State == "On" &&
                        car.Speed == 0){
                    transmission.Mode = "R";
                }
                if ((NewMode == "R") && (engine.State == "Off")) {
                    infoDisplay.setText(" Start engine first!");
                }
                if (NewMode == "N") {
                    transmission.Mode = "N";
                }
                if ((NewMode == "D") && (engine.State == "On")) {
                    transmission.Mode = "D";
                }
                if ((NewMode == "D") && (engine.State == "Off")) {
                    infoDisplay.setText(" Start engine first!");
                }
                transmissionDisplay.setText(" Mode: " + transmission.Mode);
            }
        }

    }
    public class Brakes {
        //0/25/50/75/100
        Integer Power;

        public void setBrakesPower(Integer percent) {
            if (percent == 0) {
                brakes.Power = 0;
            }
            if (percent == 25) {
                brakes.Power = 25;
            }
            if (percent == 50) {
                brakes.Power = 50;
            }
            if (percent == 75) {
                brakes.Power = 75;
            }
            if (percent == 100) {
                brakes.Power = 100;
            }
            brakesDisplay.setText(" Brakes: " + brakes.Power +"%");
        }

    }

    public class Car {
        Double Speed;
        Double Resist;
        public void setResist(Double Speed) {
            car.Resist = 0.2;
            if(Speed > 60) {
                car.Resist = 0.3;
            }
            if(Speed > 80) {
                car.Resist = 0.4;
            }
            if(Speed > 100) {
                car.Resist = 0.5;
            }
            if(Speed > 120) {
                car.Resist = 0.6;
            }
            if(Speed > 140) {
                car.Resist = 0.7;
            }
            if(Speed > 160) {
                car.Resist = 0.8;
            }
            if(Speed > 180) {
                car.Resist = 0.9;
            }
        }
    }

}




