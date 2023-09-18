public class V2_CYOPizza extends V2_MenuItems {

   private final double PIZZA_COST = 30;
   private String pizzaName, order;
   private String toppingName;
   private String toppings;
   private final String[] TOPPINGS = { "Pepporoni", "Sausage", "Chicken", "Ham", "Pineapple"};

   public V2_CYOPizza(String name, String toppings)
   {
      super(name);
      if (toppings == null || toppings.equals("")) 
      {
         throw new IllegalArgumentException("Please provide pizza toppings.");
      }
      this.toppings = toppings;
      this.calculateCost();
   }
   
   public V2_CYOPizza(String name, String pNumber, String address, String toppings) {
      super(name, pNumber, address);
      this.toppings = toppings;
      this.calculateCost();
   }

	/**
	 * Returns the toppings option menu
	 * 
	 * @return String representation of the TOPPINGS constant array
	 */
   public  String getToppingsOptions() {
      String toppings = "";
      for (int x = 0; x < TOPPINGS.length; x++) {
         toppings += TOPPINGS[x];
         if (x < TOPPINGS.length - 1) {
            toppings += ",\n ";
         }
      }
      return toppings;
   }

	/**
	 * Crawls through the TOPPINGS array for a specific type of Topping
	 * 
	 * @param Topping- A string variable
	 * @return true/false based on the search
	 */
   private boolean findIngredient(String toppingName) {
      boolean toppingFound = false;
      int index = 0;
      while (!toppingFound && index < TOPPINGS.length) {
         if (TOPPINGS[index].equals(toppingName)) {
            toppingFound = true;
         } else {
            ++index;
         }
      }
      return toppingFound;
   }

	/**
	 * The following method calls the findTopping method to find a specific type of
	 * pizza toping in the menu.If only found then the instance variable is set
	 * 
	 * @param pizza- type of Pizza
	 */
   public void setToppingName(String toppingName) {
      if (!findIngredient(toppingName)) {
         throw new IllegalArgumentException(
            	"Incorrect Selection!\nPlease select one of the following Pizza Toppings. :\n "
            			+ this.getToppingsOptions());
      }
   
      this.toppingName = toppingName;
   }

	/**
	 * get the Pizza name
	 * 
	 * @return
	 */
   public String getPizzaName() {
   
      return this.pizzaName;
   }

	/**
	 * Sets pasta name
	 * 
	 * @param pastaName; name of pasta is passed
	 */
   public void setPizzaName(String pizzaName) {
      if (pizzaName == null || pizzaName.equals("")) {
         throw new IllegalArgumentException("Please provide the Pizza name.");
      }
      this.pizzaName = pizzaName;
   }

   public static void setExtraToppings(String extraToppings) {
      if (extraToppings == null || extraToppings.equals("")) {
         throw new IllegalArgumentException("Please provide the ingredient name.");
      }
   
      extraToppings += "\n" + extraToppings;
   }

	/**
	 * Returns the ingredients
	 * 
	 * @return
	 */
   public String getToppings() {
      return toppings;
   }

	/**
	 * Passing a string as an argument
	 * 
	 * @param ingredients
	 */
   public void setToppings(String toppings) {
      if (toppings == null || toppings.equals("")) {
         throw new IllegalArgumentException("Please provide the pizza topping name.");
      }
   
      this.toppings = toppings;
   }

	/**
	 * returns the number of extra ingredients
	 * 
	 * @return
	 */

	/**
	 * Pass the number of ingredients as an argument/ concatenated string in the
	 * implementation has a counter
	 * 
	 * @param numExtraIngredients/ counter is passed as an argument
	 */

   @Override
   public double calculateCost() {
      double totalCost = 0;
      totalCost += PIZZA_COST; 
      return totalCost;
   }
   
   public double getCost()
   {
      return this.PIZZA_COST;
   }
   
   @Override
   public String toString() {
      return super.toString() + "Pizza Name: Custom Pizza" + "\nTotal Cost: $"
         	                  + this.getCost();
   }
}


   
   
