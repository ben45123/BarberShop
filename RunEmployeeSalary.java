import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class RunEmployeeSalary{
	
	public static void main(String[] args){
			
		ArrayList<Employee> staff = new ArrayList <Employee>(); // Making an ArrayList of a created class called Employee

		
		Scanner in = new Scanner(System.in); //Setting up Scanners for Java issues with using the same Scanner
		Scanner in2 = new Scanner(System.in);
		Scanner in3 = new Scanner(System.in);
		Scanner in4 = new Scanner(System.in);
		
		
		
		System.out.println("Ben's Barbershop Payroll: "); //Options to select when running program
		System.out.println("1 - Add new employee");
		System.out.println("2 - Display all employees");
		System.out.println("3 - Search for employee(by id)");
		System.out.println("4 - Search by job title");
		System.out.println("5 - Remove employee(by id)");
		System.out.println("6 - Exit");
		System.out.println("Enter an option(1-6): ");

		int userInput = 0; //initializing variable
		
		boolean trueFalse3 = false;
		while (trueFalse3==false) { //making sure the user doesn't enter a string or double instead of an integer between 1-6
			trueFalse3=true;
			Scanner in7 = new Scanner(System.in);
			try {
				userInput = in7.nextInt();}
			catch(InputMismatchException e) {
				System.out.println("Error, enter an option(1-6): ");
				trueFalse3=false;
				}
		}
		
		String name = "";
		int id = 0;
		String position="";
		double wage=0;
		double salary = 0;
		String salaryOrWage = "";
		double weeklyBonus=0;
		int employeeCounter = 0;
		int searchId = 0;

		while(userInput!=6) { //loop ends when userInput is 6, ends program
			if(userInput==1) { //adds employee
				System.out.println("Enter employee's id: ");
				id = in4.nextInt(); //variable for employee id
				boolean duplicateId = true;
			do { //makes sure there is no employees with the same id
				duplicateId = false;
				for(int i=0; i<staff.size(); i++) {
					if(staff.get(i).getId()==id) {
						System.out.println("ID already taken.");
						duplicateId=true;
						System.out.println("Enter a different ID number:");
						id = in4.nextInt();}
					}
				}
			while(duplicateId==true);

				System.out.println("Enter employee's name (last, first): ");
				name = in2.nextLine(); //variable for employee's name

				System.out.println("If employee is a barber, enter 'B'(works for a yearly salary)"); 
				System.out.println("If employee is a cashier, enter 'C'(works for an hourly wage)");
				System.out.println("If employee is a manager, enter 'M'");

				salaryOrWage=in3.nextLine(); //variable for employee's position
					
				while(!salaryOrWage.equals("B") && !salaryOrWage.equals("C") && !salaryOrWage.equals("M")){
					System.out.println("Error, must enter B, C, or M: ");
					salaryOrWage=in2.nextLine(); 
				}
				if(salaryOrWage.equals("B")) { 
					position = "Barber";
					System.out.println("Enter the employee's yearly salary: ");
					boolean trueFalse = false; 
					while (trueFalse==false) { //error handling loop for when someone puts in a string instead of a double
						trueFalse=true;
						Scanner in5 = new Scanner(System.in);
						try{
							salary = in5.nextDouble();}
						catch(InputMismatchException e) {
							System.out.println("Error, enter a number for the salary.");
							trueFalse=false;
							}}
					staff.add(new SalariedEmployee(name,id,position,salary)); //adds employee to Employee ArrayList from the created SalariedEmployee class

					}
				else if(salaryOrWage.equals("C")) {
					position = "Cashier";
					System.out.println("Enter the employee's hourly wage: ");
					boolean trueFalse = false;
					while (trueFalse==false) {
						trueFalse=true;
						Scanner in5 = new Scanner(System.in);
						try{
							salary = in5.nextDouble();
							}catch(InputMismatchException e) {
							System.out.println("Error, enter a number for the salary.");
							trueFalse=false;
							}}
					staff.add(new HourlyEmployee(name,id,position,salary)); //adds employee to Employee ArrayList from the created HourlyEmployee class
					}
				else if(salaryOrWage.equals("M")) {
					position = "Manager";
					System.out.println("Enter the employee's yearly salary: ");
					boolean trueFalse = false;
					while (trueFalse==false) {
						trueFalse=true;
						Scanner in5 = new Scanner(System.in);
						try{
							salary = in5.nextDouble();
							}catch(InputMismatchException e) {
							System.out.println("Error, enter a number for the salary.");
							trueFalse=false;
							}}
					System.out.println("Enter the employee's weekly bonus: ");
					boolean trueFalse2 = false;
					while (trueFalse2==false) {
						trueFalse2=true;
						Scanner in6 = new Scanner(System.in);
						try{
							weeklyBonus = in6.nextDouble();
							}catch(InputMismatchException e) {
							System.out.println("Error, enter a number for the weekly bonus.");
							trueFalse2=false;
							}}
					staff.add(new Manager(name,id,position,salary,weeklyBonus)); //adds employee to Employee ArrayList from the created Manager class
					}
				}
				else if(userInput==2) { //displays all employee attributes
					for(int i=0; i<staff.size(); i++) {
						double weeklySalary = staff.get(i).weeklyPay(40);
						System.out.print("Id: "+staff.get(i).getId()+", Name: "+staff.get(i).getName()+", Position: "+staff.get(i).getPosition()+", Weekly Pay:$");
						System.out.printf("%.2f%n", weeklySalary);
					}
				}
				else if(userInput==3) { //searches for employee using id and lists all of the employee's attributes
					boolean hasId = false;
					System.out.println("Enter the employee ID you would like to search for: ");
					searchId = in.nextInt();
					for(int i=0; i<staff.size(); i++) {
						if(staff.get(i).getId()==searchId) {
							hasId=true;
							System.out.println("This ID belongs to: " + staff.get(i).getName());
							}
					}
					if(!hasId) {
						System.out.println("Employee not found.");
					}
				}
				else if(userInput==4) { //lists all employee attributes from specified position
					System.out.println("Enter the position you would like to search for (Barber, Cashier, or Manager): ");
					String searchPosition = in4.next(); 
					while (!searchPosition.equals("Barber") && !searchPosition.equals("Cashier") && !searchPosition.equals("Manager") && !searchPosition.equals("barber") && !searchPosition.equals("cashier") && !searchPosition.equals("manager") ) {
						Scanner in5 = new Scanner(System.in);
						System.out.println("Position invalid, try again. ");
						searchPosition = in5.next();
					} //while loop makes sure that the position is correctly entered
					boolean hasPosition = false;
					for(int i=0; i<staff.size(); i++) {
						if(searchPosition.equals(staff.get(i).getPosition())) {
							hasPosition = true;
							System.out.print("Id: "+staff.get(i).getId()+", Name: "+staff.get(i).getName()+", Position: "+staff.get(i).getPosition()+", Weekly Pay: $");
							System.out.printf("%.2f%n", staff.get(i).weeklyPay(40));
						}
					}
					if(!hasPosition) {
						System.out.print("No search results. ");
					}
				}
				else if(userInput==5) { //removes employee from ArrayList
					System.out.println("Enter the ID of the employee you would like to remove.");
					int idSearch = 0;
					boolean trueFalse = false;
					while (trueFalse==false) { //makes sure the user doesn't enter a string or double for the ID number
						trueFalse=true;
						Scanner in7 = new Scanner(System.in);
						try {
							idSearch = in7.nextInt();}
						catch(InputMismatchException e) {
							System.out.println("Error, enter an integer for the ID. ");
							trueFalse=false;
							}
					}
					boolean hasId = false;
					for(int i=0; i<staff.size(); i++) {
						if(idSearch==staff.get(i).getId()) {
							hasId=true;
							staff.remove(i);
							System.out.print("Employee has been removed. ");
						}
					}
					if(!hasId) {
						System.out.println("Id not found.");
					}
				}
				else if(userInput>6 || userInput<1) { //tells the user that they made a mistake picking an integer greater than 6 or less than 1
					System.out.println("Invalid input, try again. ");
				}
				
				
				


				employeeCounter++; //prompts for another input when the previous task is executed
				System.out.println("Enter a new option: ");
				System.out.println("1 - Add new employee");
				System.out.println("2 - Display all employees");
				System.out.println("3 - Search for employee(by id)");
				System.out.println("4 - Search by job title");
				System.out.println("5 - Remove employee(by id)");
				System.out.println("6 - Exit");
				userInput=in.nextInt();
					
				
					
			}
			

	}
}
