
//An employee has a name and a mechanism for computing weekly pay.

public abstract class Employee
{
   private String name;
   private int id;
   private String position;
   private double weeklyPay;

   //Constructs an employee with an empty name.

   public Employee()
   {
      name = "";
      id = 0;
      weeklyPay=0;
      position = "";
   }


   //Sets the ID of this employee.
     
   public void setId(int id)
   {
      this.id=id;
   }


   public int getId()
   {
      return id; 
   }
   
   //Sets the name of this employee.
   
   public void setName(String employeeName)
   {
      name = employeeName;
   }

   
   //Gets the name of this employee.

   public String getName()
   {
      return name; 
   }

   //Sets the position of this employee.
   
   public void setPosition(String position)
   {
      this.position=position;
   }
   
   public String getPosition()
   {
      return position;
   }
   
   //Computes the pay for one week of work.
      
   public abstract double weeklyPay(int hoursWorked);

public double getWeeklyPay() {
	return weeklyPay;
}





}

