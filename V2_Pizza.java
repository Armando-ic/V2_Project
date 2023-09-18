public class V2_Pizza extends V2_MenuItems {

   private double pizzaCost;
   private String pizza, order;
   private int index = 0;
   private final String[] PIZZA_TYPE = { "Pepperoni Pizza", "Cheese Pizza", "Hawaiian Pizza", "Greek Pizza",
                                         "MeatLovers Pizza" };
   private final double[] PIZZA_COST = { 20, 25, 22, 21, 25 };

   public V2_Pizza(String name, String pizza)
   {
      super(name);
      if (pizza == null || pizza.equals("")) 
      {
         throw new IllegalArgumentException("Please provide the pizza.");
      }
      this.pizza = pizza;
      this.calculateCost();
   }
   
   public V2_Pizza(String name, String pNumber, String address, String pizza) {
      super(name, pNumber, address);
      if (pizza == null || pizza.equals("")) 
      {
         throw new IllegalArgumentException("Please provide the pizza.");
      }
      this.pizza = pizza;
      this.calculateCost();
   }

	/**
	 * Returns the Pizza Type menu
	 * 
	 * @return String representation of the PIZZA_TYPE constant array
	 */
   public String getPizzaMenu() {
      String pizzaMenu = "";
      for (int x = 0; x < PIZZA_TYPE.length; x++) {
         pizzaMenu += PIZZA_TYPE[x];
         if (x < PIZZA_TYPE.length - 1) {
            pizzaMenu += ",\n ";
         }
      }
      return pizzaMenu;
   }

	/**
	 * Looks through the PIZZA_TYPE array for a specific type of pizza
	 * 
	 * @param Pizza- A string variable
	 * @return true/false based on the search
	 */
   private boolean findPizza(String pizza) {
      boolean pizzaFound = false;
   
      while (!pizzaFound && index < PIZZA_TYPE.length) {
         if (PIZZA_TYPE[index].equals(pizza)) {
            pizzaFound = true;
         } else {
            ++index;
         }
      }
      return pizzaFound;
   }

	/**
	 * The following method calls the findPizza method to find a specific type of
	 * Pizza in the menu
	 * 
	 * @param pizza- type of Pizza
	 */
   public void setPizza(String pizza) {
      if (!findPizza(pizza)) {
         throw new IllegalArgumentException(
            	"Incorrect Selection!\nPlease select one of the following Pizza types. :\n " + this.getPizzaMenu());
      }
   
      this.pizza = pizza;
   }

   public String getPizza() {
      return this.pizza;
   }

   public int getIndex() {
      return this.index;
   }

   @Override
   public double calculateCost() {
      this.findPizza(this.getPizza());
      pizzaCost += PIZZA_COST[this.getIndex()];
      return pizzaCost;
   }
   
   public double getCost()
   {
      return this.pizzaCost;
   }
   
   @Override
   public String toString() {
      return super.toString() + "Pizza Name: " + this.getPizza() + "\nTotal Cost: " + this.getCost();
   }
}
