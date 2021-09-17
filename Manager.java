
//A manager is a salaried employee who also receives a bonus.

public class Manager extends SalariedEmployee
{
   private double weeklyBonus;

      //Constructs a manager with a given name, annual salary and weekly bonus.

   public Manager(String name, int id, String position, double salary, double bonus)
   {
      super(name, id, position, salary);
      weeklyBonus = bonus;
   }

   public double weeklyPay(int hoursWorked)
   {
      return super.weeklyPay(hoursWorked) + weeklyBonus;
   }
}

