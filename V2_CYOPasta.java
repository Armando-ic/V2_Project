public class V2_CYOPasta extends V2_MenuItems {

   private final double PASTA_COST = 13;
   private String pastaName, order;
   private String ingredientName;
   private String ingredients;
   private final String[] INGREDIENTS = { "" };
   
   public V2_CYOPasta(String name, String ingredients)
   {
      super(name);
      this.ingredients = ingredients;
      this.calculateCost();
   }
   
   public V2_CYOPasta(String name, String pNumber, String address, String ingredients) {
      super(name, pNumber, address);
      this.ingredients = ingredients;
      this.calculateCost();
   }

	/**
	 * Returns the ingredients option menu
	 * 
	 * @return String representation of the INGREDIENTS constant array
	 */
   public  String getIngredientsOptions() {
      String ingredients = "";
      for (int x = 0; x < INGREDIENTS.length; x++) {
         ingredients += INGREDIENTS[x];
         if (x < INGREDIENTS.length - 1) {
            ingredients += ",\n ";
         }
      }
      return ingredients;
   }

	/**
	 * Looks through the INGREDIENTS array for a specific type of ingredient
	 * 
	 * @param ingredient- A string variable
	 * @return true/false based on the search
	 */
   private boolean findIngredient(String ingredientName) {
      boolean ingredientFound = false;
      int index = 0;
      while (!ingredientFound && index < INGREDIENTS.length) {
         if (INGREDIENTS[index].equals(ingredientName)) {
            ingredientFound = true;
         } else {
            ++index;
         }
      }
      return ingredientFound;
   }

	/**
	 * The following method calls the findPizza method to find a specific type of
	 * Pizza in the menu.
	 * 
	 * @param pizza- type of Pizza
	 */
   public void setIngredientName(String ingredientName) {
      if (!findIngredient(ingredientName)) {
         throw new IllegalArgumentException(
            	"Incorrect Selection!\nPlease select one of the following Ingredients. :\n "
            			+ this.getIngredientsOptions());
      }
   
      this.ingredientName = ingredientName;
   }

	/**
	 * get the Pasta name
	 * 
	 * @return
	 */
	// Note: Do we need to specify the name of the CYO pasta?
   public String getPastaName() {
   
      return pastaName;
   }

	/**
	 * Sets pasta name
	 * 
	 * @param pastaName; name of pasta is passed
	 */
	// NOTE Do we need to have pasta name?
   public void setPastaName(String pastaName) {
      if (pastaName == null || pastaName.equals("")) {
         throw new IllegalArgumentException("Please provide the Pasta name.");
      }
      this.pastaName = pastaName;
   }

	/**
	 * Returns the ingredients
	 * 
	 * @return
	 */
   public String getIngredients() {
      return ingredients;
   }

	/**
	 * Passing a string as an argument
	 * 
	 * @param ingredients
	 */
   public void setIngredients(String ingredients) {
      if (ingredients == null || ingredients.equals("")) {
         throw new IllegalArgumentException("Please provide the ingredient name.");
      }
   
      this.ingredients = ingredients;
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
      totalCost += PASTA_COST; 
      return totalCost;
   }
   
   public double getCost()
   {
      return this.PASTA_COST;
   }

   @Override
   public String toString() {
      return super.toString() + "Pasta Name: Custom Pasta" + "\nIngredients: \n" + getIngredients() + "\nTotal Cost: "
         	                  + this.getCost();
   }
}
