public class V2_Pasta extends V2_MenuItems {
   private double pastaCost;
   private String pasta, order;
   private int index = 0;
   private final String[] PASTA_TYPE = { "Chicken Penne", "Shrimp Carbonara", "Meatball Pomodoro",
   		"Chicken Bacon Alfredo", "Shrimp Scampi" };
   private final double[] PASTA_COST = { 20, 25, 22, 21, 25 };

   public V2_Pasta(String name, String pasta)
   {
      super(name);
      if (pasta == null || pasta.equals("")) 
      {
         throw new IllegalArgumentException("Please provide the pasta.");
      }
      this.pasta = pasta;
      this.calculateCost();
   }
   
   public V2_Pasta(String name, String pNumber, String address, String pasta) {
      super(name, pNumber, address);
      this.pasta = pasta;
      this.calculateCost();
   }
   
	/**
	 * Returns the Pasta Type menu
	 * 
	 * @return String representation of the PASTA_TYPE constant array
	 */
   public String getPastaMenu() {
      String pasta = "";
      for (int x = 0; x < PASTA_TYPE.length; x++) {
         pasta += PASTA_TYPE[x];
         if (x < PASTA_TYPE.length - 1) {
            pasta += ", ";
         }
      }
      return pasta;
   }

	/**
	 * Looks through the PASTA_TYPE array for a specific type of pasta
	 * 
	 * @param pasta- A string variable
	 * @return true/false based on the search
	 */
   private boolean findPasta(String pasta) {
      boolean pastaFound = false;
   
      while (!pastaFound && index < PASTA_TYPE.length) {
         if (PASTA_TYPE[index].equals(pasta)) {
            pastaFound = true;
         } else {
            ++index;
         }
      }
      return pastaFound;
   }

	/**
	 * The following method calls the findPasta method to find a specific type of
	 * Pasta in the menu
	 * 
	 * @param pasta- type of Pasta
	 */
   public void setPasta(String pasta) {
      if (!findPasta(pasta)) {
         throw new IllegalArgumentException(
            	"Incorrect Selection!\\nPlease select one of the following Pasta types. :\n" + this.getPastaMenu());
      
      }
   
      this.pasta = pasta;
   }

   public String getPasta() {
      return this.pasta;
   }

   public int getIndex() {
      return this.index;
   }

   @Override
   public double calculateCost() {
      this.findPasta(this.getPasta());
      pastaCost += PASTA_COST[this.getIndex()];
      return pastaCost;
   }
   
   public double getCost()
   {
      return this.pastaCost;
   }
   
   @Override
   public String toString() {
      return super.toString() + "Pasta Name: " + getPasta() + "\nTotal Cost: " + getCost();
   }
}
