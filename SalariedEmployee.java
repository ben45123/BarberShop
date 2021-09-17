
//A salaried employee is paid the same amount independent of the hours worked.

public class SalariedEmployee extends Employee
{
   private double annualSalary;


   //Constructs a salaried employee with a given name and annual salary.
 
   public SalariedEmployee(String name, int id, String position, double salary)
   {
      setName(name);
      setId(id);
      setPosition(position);
      annualSalary = salary;
   }

   public double weeklyPay(int hoursWorked) 
   {
      final int WEEKS_PER_YEAR = 52;
      return annualSalary / WEEKS_PER_YEAR;
   }
   

}
