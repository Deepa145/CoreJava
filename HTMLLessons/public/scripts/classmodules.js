class Pizza {
         // instance property
      #slices = 10  // private field
      //constructor
      constructor (toppings = [], customer) {
        // computer instance property - global fields of pizza
        this.toppings = toppings;
        this.customer = customer;
      }  
      // static property - array of Strings
      static extraToppings = ['pepperoni', 'cheese'];
    //  static method
    static sayThanyou () {
        console.log('ThankYou!!!')
      }
      // nonstatic method(instance method)
      eat () {
        console.log(this.toppings)
        console.log(this.#slices)
      }
    
     
      // Getter Property
      get length () {
        return this.#slices
      }
    
      set length (value) {
        this.#slices = value
      }
      
    }
    
    const myPizza = new Pizza(['onions'], 'Venkat');
    console.log(myPizza.toppings);
    console.log(myPizza.customer);
    console.log(Pizza.extraToppings);
    Pizza.sayThanyou();
    myPizza.eat()
    myPizza.toppings = ['Carrot', 'Almonds', 'Lobster']
    console.log(myPizza.toppings);
    console.log(myPizza.length)
    myPizza.length = 10;
    console.log(myPizza.length)
    console.log(myPizza.slices)  // undefined slices
    myPizza.slices = 240;  // adding dynamic field slices to myPizza
    console.log(myPizza.length)
    console.log(myPizza.slices)
    
    