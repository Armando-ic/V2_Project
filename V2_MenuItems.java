public abstract class V2_MenuItems {

   private String name;
   private String pNumber;
   private String address;
   private static int numOfOrders;
   private int id = 0;
   private static int nextID = 1;

   public V2_MenuItems(String name) 
   {
   
      if (name == null || name.equals("")) 
      {
         throw new IllegalArgumentException("Please provide your name.");
      }
      this.name = name;
      this.numOfOrders++;
      this.id = nextID++;
   }

   public V2_MenuItems(String name, String pNumber, String address) 
   {
      this(name);
      
      if (pNumber == null || name.equals("")) 
      {
         throw new IllegalArgumentException("Please provide the phone number.");
      }
      if (address == null || name.equals("")) 
      {
         throw new IllegalArgumentException("Please provide the address.");
      }
      this.pNumber = pNumber;
      this.address = address;
   }
   
   public int getId()
   {
      return this.id;
   }
   public void setId(int id)
   {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public String getpNumber() {
      return pNumber;
   }

   public String getAddress() {
      return address;
   }

   public static int getNumOfOrders() {
      return numOfOrders;
   }
	
   public static void decNumberOfOrders() {
      numOfOrders--;
   }
   public static void incrementNumberOfOrders()
   {
      numOfOrders++;
   }
	
   public abstract double calculateCost();
   
   @Override
   public String toString(){
      if (this.getpNumber() == null || this.getpNumber().equals(""))
      {
         return "Customer Name: " + name + "\n";
      }
      else
         return "Customer Name: " + name + "\nPhone #: " + pNumber + "\nAddress: " + address + "\n";
   }
}


