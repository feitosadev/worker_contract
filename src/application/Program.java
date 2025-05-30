package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Department;
import model.entities.HourContract;
import model.entities.Worker;
import model.entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner entry = new Scanner(System.in);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = entry.nextLine();
		System.out.print("Enter worker data.");
		System.out.print("Name: ");
		String workerName = entry.nextLine();
		System.out.println("Enter worker level.");
		String workerLevel = entry.nextLine();
		System.out.print("Enter base salary: ");
		Double baseSalary = entry.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("");
		int numberContracts = entry.nextInt();
		
		for(int i = 0; i <= numberContracts; i++) {
			System.out.println("");
			System.out.println("DD/MM/YYYY");
			Date contractDate = simpleDateFormat.parse(entry.next());
			System.out.print("");
			double valuePerHour = entry.nextDouble();
			System.out.print("");
			int hours = entry.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("");
		String monthAndYear = entry.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " +worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%2f", worker.income(year, month)));
	
	}
}