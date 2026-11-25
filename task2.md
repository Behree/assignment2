# Dependencies

## UML diagram

[task2_uml.png.pdf](task2_uml.png.pdf) 


# Questions:

## 1- Which dependencies are necessary?
- CarController → Car because CarController is responsible for controlling part in cars.
- CarView → CarController necessary to receive user inputs and send them to controller.
- CarController → CarView necessary so the controller can tell the view to update (repaint) after moving the cars.
  But together with  CarView → CarController it becomes a two-way dependency (see question 3).
- CarApplication → CarController, CarView, Volvo240, Saab95 necessary because it creates all the objects and starts the program.
- Car → Movable necessary to determine car movements.
- Saab95 → Car & Volvo240 → Car because both cars inherited from car.

## 2- Which classes depend on each other even though they shouldn't?
CarController depends on Saab95 and Volvo240 directly by using instanceof.
The CarController should work with Car (the general) instead of depending on specific types like Saab95 and Volvo240, using instanceof breaks abstraction & makes the classes too tightly coupled. This breaks DIP and OCP. 

## 3- Are there any dependencies that are stronger than necessary?
The dependency between CarController and CarView (↔️) both classes are connected to each other, which makes the coupling stronger than necessary.
The CarController depends on CarView details like DrawPanel (frame.drawPanel.volvoImage), so the coupling is too tight. This breaks the Law of Demeter (LoD) or "don't talk to strangers".

## 4- Can you identify any violations of other design principles we've talked about in the course?
- **Dependency inversion principle (DIP):** CarController depends on concrete classes such that Volvo and Saab instead of depending on abstractions like "Car".

- **Single Responsibility principle (SRP):** Every single class should have one clear responsibility.
  e.g. CarController is responsible for car movement but also handles few details (view) like DrawPanel, so it has low cohesion. 

- **Open/closed principle (OCP):** The CarController needs changes whenever we add a new car type.