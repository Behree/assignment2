import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // The delay (ms) corresponds to 20 updates/second (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // TODO A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    public void startTimer() {
        this.timer.start();
    }

    /* Each step, the TimerListener moves all cars in the list and tells the
     * view to update its images.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                int panelWidth = frame.drawPanel.getWidth();
                    if (car.getDirection() == 1) {              // Right
                        if (x + frame.drawPanel.volvoImage.getWidth() >= panelWidth) {
                            car.stopEngine();
                            car.turnRight();
                            car.turnRight();
                            car.startEngine();
                        }
                    }

                if (car.getDirection() == 3) {                 // Left
                    if (x <= 0) {
                        car.stopEngine();
                        car.turnRight();
                        car.turnRight();
                        car.startEngine();
                    }
                }

                int panelHeight = frame.drawPanel.getHeight();
                    if (car.getDirection() == 0) {             // Down = +y
                        if (y + frame.drawPanel.volvoImage.getHeight() >= panelHeight) {
                            car.stopEngine();
                            car.turnRight();
                            car.turnRight();
                            car.startEngine();
                    }
                }

                if (car.getDirection() == 2) {                // Up = -y
                    if (y <= 0) {
                        car.stopEngine();
                        car.turnRight();
                        car.turnRight();
                        car.startEngine();
                    }
                }

                if (car instanceof Saab95) {
                    frame.drawPanel.moveSaab(x, y);
                } else if (car instanceof Volvo240) {
                    frame.drawPanel.moveVolvo(x, y);
                }

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.revalidate();
                frame.drawPanel.repaint();
            }

        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }


    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void turnLeft() {
       for (Car car : cars) {
           car.turnLeft();
       }
    }

    void turnRight() {
        for (Car car : cars) {
            car.turnRight();
        }
    }

    void setTurboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
}

     
