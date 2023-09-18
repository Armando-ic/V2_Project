//package ProjectFinalVersion;

/**
Armando Irizarry-Cortes
Farid Ghulam Sakhi
IT 206-002

Final Project: Solution Design
Project Proposal Title: Pizzeria_Menu 

Description: Pizzeria MenuGroup will allow the user to add, remove, display, and edit the menu items within this
pizzeria serving selection. 

Specifications
a) (Input) - The choice of adding a pre-designed pizza or creating your own, a pre-designed pasta with the option of adding/ removing items onto the dish.
b) (Output) - displaying a well-formatted final receipt which includes all items added / quantity and their individual price along with the total price of the order.
c) General Structure– Program begins with the choice of either Add Order, Remove Order, Display Receipt. 
If the user attempts to display or remove without adding anything into the program, an error will be displayed. When adding Items, the choice of Pizza / CYO (Create your own) Pizza, Pasta / CYO Pasta will be displayed. If a predesigned choice of either Pizza or Pasta is chosen – user will be returned to the menu. If any CYO is chosen, user will be prompted to enter up to 15 options (these will be displayed) to create your own CYO of your choosing.

 */
import javax.swing.JOptionPane;

public class V2_Pizzeria {
	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   public static void main(String[] args) {
   	// Declarations
      final int MAX_MENU_ITEMS = 10, MIN_MENU_ITEMS = 0;
      V2_MenuItems[] order = new V2_MenuItems[MAX_MENU_ITEMS];
      boolean error = false;
      String option;
   
      for (int i = 0; i < MAX_MENU_ITEMS; i++) {
         do {
            try {
               option = getMenu();
               if (option.equals("Dine-in")) {
                  if (V2_MenuItems.getNumOfOrders() < order.length)
                     order[V2_MenuItems.getNumOfOrders()] = addDineIn();
                  else {
                     JOptionPane.showMessageDialog(null, "Dine-in order cannot be entered", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                     error = true;
                  }
               } else if (option.equals("Online Order")) {
                  if (V2_MenuItems.getNumOfOrders() < order.length)
                     order[V2_MenuItems.getNumOfOrders()] = addOnline();
                  else {
                     JOptionPane.showMessageDialog(null, "Online order cannot be entered", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                     error = true;
                  }
               } else if (option.equals("Remove Order")) {
                  if (V2_MenuItems.getNumOfOrders() > MIN_MENU_ITEMS)
                     removeOrder(order);
                  else {
                     JOptionPane.showMessageDialog(null, "No orders are available for removal", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                     error = true;
                  }
               } else if (option.equals("Print receipt")) {
                  if (V2_MenuItems.getNumOfOrders() > MIN_MENU_ITEMS)
                     printReceipt(order);
                  else {
                     JOptionPane.showMessageDialog(null, "No orders are available for printing", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                     error = true;
                  }
               } else if (option.equals("Quit")) {
                  Quit();
               }
            
            } catch (Exception e) {
               error = true;
               JOptionPane.showMessageDialog(null, "Error selecting a menu option", "Error",
                  	JOptionPane.ERROR_MESSAGE);
            }
         } while (error);
      }
   }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * The getMenu method populates the menu options
	 * 
	 * @return menu as String
	 */
   public static String getMenu() {
      Object[] options = { "Dine-in", "Online Order", "Remove Order", "Print receipt", "Quit" };
      Object selectedOption = JOptionPane.showInputDialog(null, "Choose one", "Available Options",
         	JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
      String output = (String) selectedOption;
      return output;
   }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * The addDineIn method populates Dine in menu options (i.e., Pizza, Pasta, CYO
	 * Pizza or CYO Pasta)
	 * 
	 * @return Menu Items
	 */
   public static V2_MenuItems addDineIn() {
      V2_MenuItems newDineIn = null;
      String name, pizza;
      boolean error, pE, paE, cPE, cpaE;
   
      Object[] options = { "Pizza", "Pasta", "CYO Pizza", "CYO Pasta" };
      Object selectedOption = null;
   
      do {
         try {
            selectedOption = JOptionPane.showInputDialog(null, "What are you ordering?", "Available Options",
               	JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            error = false;
            if (selectedOption.equals("Pizza")) {
               do {
                  try {
                     pE = false;
                     newDineIn = new V2_Pizza(getString("name"), getPizza());
                  } catch (Exception IllegalArgumentException) {
                     pE = true;
                     JOptionPane.showMessageDialog(null, "Error choosing your pizza", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                  }
               } while (pE);
            } else if (selectedOption.equals("Pasta")) {
               do {
                  try {
                     paE = false;
                     newDineIn = new V2_Pasta(getString("name"), getPasta());
                  } catch (Exception IllegalArgumentException) {
                     paE = true;
                     JOptionPane.showMessageDialog(null, "Error choosing your pasta", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                  }
               } while (paE);
            } else if (selectedOption.equals("CYO Pizza")) {
               do {
                  try {
                     cPE = false;
                     newDineIn = new V2_CYOPizza(getString("name"), getToppings());
                  } catch (Exception IllegalArgumentException) {
                     cPE = true;
                     JOptionPane.showMessageDialog(null, "Error choosing your pizza", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                  }
               } while (cPE);
            } else if (selectedOption.equals("CYO Pasta")) {
               do {
                  try {
                     cpaE = false;
                     newDineIn = new V2_CYOPasta(getString("name"), getIngredients());
                  } catch (Exception IllegalArgumentException) {
                     cpaE = true;
                     JOptionPane.showMessageDialog(null, "Error choosing your pasta", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                  }
               } while (cpaE);
            }
            JOptionPane.showMessageDialog(null, "Order added", "Order Complete", JOptionPane.INFORMATION_MESSAGE);
         } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Error creating your dine-in order", "Error",
               	JOptionPane.ERROR_MESSAGE);
         }
      } while (error);
   
      return newDineIn;
   }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * The addDineIn method populates Online order menu options (i.e., Pizza, Pasta,
	 * CYO Pizza or CYO Pasta)
	 * 
	 * @return Menu Items
	 */
   public static V2_MenuItems addOnline() {
      V2_MenuItems newOnline = null;
      String name, pizza;
      boolean error, pE, paE, cPE, cpaE;// pizza error, pasta error, CYO pizza error, CYO pasta error;
   
      Object[] options = { "Pizza", "Pasta", "CYO Pizza", "CYO Pasta" };
      Object selectedOption = null;
      do {
         try
         {
            selectedOption = JOptionPane.showInputDialog(null, "What are you ordering?", "Available Options",
               	JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            error = false;
            if (selectedOption.equals("Pizza")) {
               do {
                  try {
                     pE = false;
                     newOnline = new V2_Pizza(getString("name"), getString("phone number"), getString("address"),
                        	getPizza());
                  } catch (Exception IllegalArgumentException) {
                     pE = true;
                     JOptionPane.showMessageDialog(null, "Error choosing your pizza", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                  }
               } while (pE);
            } else if (selectedOption.equals("Pasta")) {
               do {
                  try {
                     paE = false;
                     newOnline = new V2_Pizza(getString("name"), getString("phone number"), getString("address"),
                        	getPasta());
                  } catch (Exception IllegalArgumentException) {
                     paE = true;
                     JOptionPane.showMessageDialog(null, "Error choosing your pizza", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                  }
               } while (paE);
            } else if (selectedOption.equals("CYO Pizza")) {
               do {
                  try {
                     cPE = false;
                     newOnline = new V2_CYOPizza(getString("name"), getString("phone number"),
                        	getString("address"), getToppings());
                  } catch (Exception IllegalArgumentException) {
                     cPE = true;
                     JOptionPane.showMessageDialog(null, "Error choosing your pizza", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                  }
               } while (cPE);
            } else if (selectedOption.equals("CYO Pasta")) {
               do {
                  try {
                     cpaE = false;
                     newOnline = new V2_CYOPasta(getString("name"), getString("phone number"),
                        	getString("address"), getIngredients());
                  } catch (Exception IllegalArgumentException) {
                     cpaE = true;
                     JOptionPane.showMessageDialog(null, "Error choosing your pizza", "Error",
                        	JOptionPane.ERROR_MESSAGE);
                  }
               } while (cpaE);
            } else
               JOptionPane.showMessageDialog(null, "Error selecting a menu item", "Error",
                  	JOptionPane.ERROR_MESSAGE);
         } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Error creating your online order", "Error",
               	JOptionPane.ERROR_MESSAGE);
         }
      } while (error);
   
      return newOnline;
   }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Removes the selected order based on the order number
	 * 
	 * @param order An array of Menu Items object
	 */
   public static void removeOrder(V2_MenuItems[] order) {
      String orderList = "";
      boolean found = false, error;
      int foundIndex = 0, orderToRemove = 0;
   
      for (int i = 0; i < V2_MenuItems.getNumOfOrders(); i++) {
         orderList += "Order: #" + (i + 1) + "\n" + order[i].toString() + "\n" + "__________________________________"
            	+ "\n";
      }
   
      do {
         try {
            error = false;
            orderToRemove = Integer
               	.parseInt(JOptionPane.showInputDialog("Enter the order number to remove\n" + orderList));
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter numeric values only", "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
         }
      } while (error);
   
      while (!found && foundIndex < V2_MenuItems.getNumOfOrders()) {
         if (order[foundIndex].getId() == orderToRemove) {
            found = true;
            break;
         } else
            foundIndex++;
      }
   
      if (found) {
         order[foundIndex] = order[V2_MenuItems.getNumOfOrders() - 1];
         order[V2_MenuItems.getNumOfOrders() - 1] = null;
         V2_MenuItems.decNumberOfOrders();
      }
      JOptionPane.showMessageDialog(null, "Order removed", null, JOptionPane.INFORMATION_MESSAGE);
   }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Prints the final receipt
	 * 
	 * @param order array of V2_MenuItems
	 */
   public static void printReceipt(V2_MenuItems[] order) {
      String output = "**RECEIPT**\n";
   
      if (V2_MenuItems.getNumOfOrders() > 0) {
         for (int i = 0; i < V2_MenuItems.getNumOfOrders(); i++) {
            output += "Order: #" + (i + 1) + "\n" + order[i].toString() + "\n"
               	+ "__________________________________" + "\n";
         }
         JOptionPane.showMessageDialog(null, output);
      } else
         JOptionPane.showMessageDialog(null, "Cannot display order receipt", "Error", JOptionPane.ERROR_MESSAGE);
   }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   public static void Quit() {
      JOptionPane.showMessageDialog(null, "Thank you for using our Pizzeria\nPlease come back!", "Horray!",
         	JOptionPane.INFORMATION_MESSAGE);
      System.exit(1);
   }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   public static String getString(String prompt) {
      String output = "";
      boolean error;
   
      do {
         try {
            error = false;
            output = JOptionPane.showInputDialog("Enter your " + prompt);
         
            if (output.equals(null) || output.equals("") || output.length() < 0) {
               error = true;
               JOptionPane.showMessageDialog(null, prompt + " cannot be empty", "Error",
                  	JOptionPane.ERROR_MESSAGE);
            }
         } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, prompt + " cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
         }
      } while (error);
      return output;
   }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * A drop down menu, where the user can select from a list of available Pizza
	 * 
	 * @return concatenated string of selected pizza(s)
	 */
   public static String getPizza() {
      String output = "";
      Object[] PIZZA_OPTIONS = { "Pepperoni Pizza", "Cheese Pizza", "Hawaiian Pizza", "Greek Pizza",
         	"MeatLovers Pizza" };
      Object selectedPizza = null;
      selectedPizza = JOptionPane.showInputDialog(null, "Choose Pizza", "Available Options",
         	JOptionPane.INFORMATION_MESSAGE, null, PIZZA_OPTIONS, PIZZA_OPTIONS[0]);
      output = (String) selectedPizza;
      return output;
   }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * A drop down menu, where the user can select from a list of available Pasta
	 * 
	 * @return concatenated string of selected Pasta(s)
	 */
   public static String getPasta() {
      String output = "";
      Object[] PASTA_OPTIONS = { "Chicken Penne", "Shrimp Carbonara", "Meatball Pomodoro", "Chicken Bacon Alfredo",
         	"Shrimp Scampi" };
      Object selectedPasta = null;
      selectedPasta = JOptionPane.showInputDialog(null, "Choose Pasta", "Available Options",
         	JOptionPane.INFORMATION_MESSAGE, null, PASTA_OPTIONS, PASTA_OPTIONS[0]);
      output = (String) selectedPasta;
      return output;
   }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * A drop down menu, where the user can select from a list of available Pasta
	 * 
	 * @return concatenated string of selected pizza toping(s)
	 */
   public static String getToppings() {
      String output = "";
      int counter = 0, extra = 0;
      Object[] PIZZA_TOPPINGS = { "Pepporoni", "Sausage", "Chicken", "Ham", "Pineapple" };
      Object selectedToppings = null;
   
      do {
         selectedToppings = JOptionPane.showInputDialog(null, "Choose Pizza Toppings", "Available Options",
            	JOptionPane.INFORMATION_MESSAGE, null, PIZZA_TOPPINGS, PIZZA_TOPPINGS[0]);
         output += (String) selectedToppings + "\n";
         counter++;
      } while (JOptionPane.showConfirmDialog(null, "Enter another topping?", null,
      		JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
   
      return output;
   }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * A drop down menu, where the user can select from a list of available pasta
	 * ingredients
	 * 
	 * @return concatenated string of selected pasta ingredient(s)
	 */
   public static String getIngredients() {
      String output = "";
      int counter = 0, extra = 0;
      Object[] PASTA_INGREDIENTS = { "Angel Hair", "Penne", "Meatballs", "Shrimp", "Chicken" };
      Object selectedIngredients = null;
   
      do {
         selectedIngredients = JOptionPane.showInputDialog(null, "Choose Pasta Ingredients", "Available Options",
            	JOptionPane.INFORMATION_MESSAGE, null, PASTA_INGREDIENTS, PASTA_INGREDIENTS[0]);
         output += (String) selectedIngredients + "\n";
         counter++;
      } while (JOptionPane.showConfirmDialog(null, "Enter another ingredient?", null,
      		JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
   
      return output;
   }
}