/**
 * 
 */
 function Car () {
    let milesDriven = 0; // private variable 
    let speed = 0; // private variable 
    // In this case, we instead use the "this" keyword,
    // which refers to CarModule
    this.accelerate = (velocity, distance) => {
      speed += velocity;
      milesDriven += distance;
    }
    this.getMilesDriven = () => milesDriven;
    this.getSpeed = () => speed;
  }
  class Ecar {
   
    constructor() {
       let milesDriven = 0;  // private variables
       let speed = 0;  // private variables
      // this. prefix makes the method public to the class.
      this.accelerate = (velocity, distance) => {
        speed += velocity;
        milesDriven += distance;
      }
  
      this.getMilesDriven = () => milesDriven;
      this.getSpeed = () => speed;
    }
  
  }
  class Bike {
   #milesDriven = 0; // private variables
      #speed = 0; // private variables
     accelerate = (velocity, distance) => {
        this.#speed += velocity;
        this.#milesDriven += distance;
      }
  
      getMilesDriven = () => this.#milesDriven;
      getSpeed = () => this.#speed;
  }