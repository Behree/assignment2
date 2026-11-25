void main() {
    // Instance of this class
    CarController cc = new CarController();

    // TODO uncomment: DONE
    cc.cars.add(new Volvo240());          // Volvo has been added s(0,0)

    Saab95 saab = new Saab95();           // A new saab car has been created
        saab.setPosition(0, 150);   // d.s(0,150)
        cc.cars.add(saab);


    // Start a new view and send a reference to the controller
    cc.frame = new CarView("CarSim 1.0", cc);
    cc.startTimer();

}