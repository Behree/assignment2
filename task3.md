# Responsibilities:

Movable: 
* Interface
* Is a contract for an implemented object to be able to move and turn

Car:
* Superclass for two subclasses
* Storing cars attributes
* Controls engine state and the speed with startEngine(), stopEngine(), gas(), brake().
* Car implements Movable and tracks the cars direction and position (x, y).

Volvo240:
* Inherits from Car
* Sets own specific values e.g "4 doors", "enginePower" etc.
* Acceleration: Implements **speedFactor()** with its own special value **trimFactor.**

Saab95:
* Inherits from Car
* Sets own specific values e.g "2 doors", "color.red" etc.
* Checks if **turboOn** = true/false; with methods "setTurboOn(), setTurboOff()".
* Acceleration: Implements **speedFactor** that changes if turboOn = true/false;

CarApplication:
* Has the main-method that starts the whole program
* Creates the carController and carView objects
* Creates a Volvo240 and Saab95 and starts the simulator

CarView:
* Builds the graphical user interface
* Builds all the control buttons
* Attaches ActionListener so all buttons commands to methods in CarController.

DrawPanel:
* Loads images for Saab and Volvo.
* Draws the car images on the panel using paintComponent().
* Stores car position (x,y) for volvoPoint, saabPoint and updates them using moveVolvo() and moveSaab().

CarController:
* Stores the list of cars (ArrayList)
* Updates _DrawPanel_ with the car's new positions and calls repaint().
* Runs a Timer every 50ms that moves all cars
* Checks if a car hits wall, if so, stops it, turns it around and starts it again.
* Receives calls from _carView_ (gas, brake) etc and applies them to the cars.

CarTest (bonus):
* Unit tests

# Reasons to change (SRP):

CarController:
* Must change if timer or wall collisions logic changes.
* Must change if how the list of cars is stored changes
* Must change if a new car model is added (instanceof) in _DrawPanel_.
* Must change if new buttons/commands are added in _CarView_.

DrawPanel:
* Must change if a new car model is added (because volvoPoint, saabPoint, images etc) are hardcoded.
* Must change if how images are loaded or drawn changes.

CarView:
* Must change if buttons change
* Must change if how buttons click are sent to CarController changes.

Car:
* Must change if engine/speed logic changes.
* Must change if direction and position logic changes.

# SoC & SRP:
* Split CarController: Move the car list, timer and wall collision logic into a new Model class for example CarModel. Let CarController only handle commands from CarView.
* Clean DrawPanel: Remove hardcoded car positions(volvoPoint,saabPoint) and moveVolvo()/moveSaab(). Let it only draw cars using positions from the model.
* No classes need to be fused. The main problem is that CarController and DrawPanel do too much, not too little. Each class should have one clear responsibility. This would make programs very much easier to look at.





