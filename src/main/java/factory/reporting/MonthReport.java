package factory.reporting;

import java.util.ArrayList;
import java.util.List;

import factory.employee.data.HomeAddress;
import factory.employee.data.EmployeeData.Genger;
import factory.employee.data.EmployeeData.Position;

public class MonthReport {

	private static List<Employee> employeesList = new ArrayList<Employee>();
	private static List<HomeAddress> employeesHomeAddressList = new ArrayList<HomeAddress>();
	
	public static int getWomanCount(){
		int womanCount = 0;
		for(int i = 0; i < employeesList.size(); ++i){
			if(employeesList.get(i).getEmployeeData().getGender() == Genger.FEMALE){
				++womanCount;
			}
		}
		return womanCount;
	}
	
	public static void getHomeAddressViolators(){
		for(int i = 0; i < employeesList.size(); ++i){
			employeesHomeAddressList.add(employeesList.get(i).getEmployeeData().getHomeAddress());
		}
	}
	
	public static void showHomeAddress(){
		for(int i = 0; i < employeesHomeAddressList.size(); ++i){
			System.out.println("Home Address ¹" + (i+1));
			System.out.println("Town " + employeesHomeAddressList.get(i).getTown());
			System.out.println("Street " + employeesHomeAddressList.get(i).getStreet());
			System.out.println("House num " + employeesHomeAddressList.get(i).getHouseNumber());
		}
	}
	
	public static double getAllEmployeesSalary(){
		double salary = 0;
		for(int i = 0; i < employeesList.size(); ++i){
			salary += employeesList.get(i).getEmployeeSalary();
//			System.out.println(employeesList.get(i).getEmployeeSalary());
		}
		return salary;
	}
	
	
	public static void main(String[] args) {
		
		Employee worker1 = new Employee();
		worker1.setEmployeeData("01/02/1982", "Kyiv", "Lomonosova", 1, Genger.MALE, Position.WORKER);
		worker1.setWorkerMonthAccounting(0, 2, 50, true);
		worker1.setSalaryPerDetail(100);
		employeesList.add(worker1);
		
		Employee worker2 = new Employee();
		worker2.setEmployeeData("02/03/1983", "Kyiv", "Vasylkivska", 2, Genger.MALE, Position.WORKER);
		worker2.setWorkerMonthAccounting(0, 2, 70, true);
		worker2.setSalaryPerDetail(100);
		employeesList.add(worker2);
		
		Employee director = new Employee();
		director.setEmployeeData("15/06/1987", "Kyiv", "Saksahanskoho", 3, Genger.MALE, Position.DIRECTOR);
		director.setBossMonthAccounting(160, 0, 0, true);
		director.setSalaryPerHour(160);
		employeesList.add(director);
		
		Employee counter = new Employee();
		counter.setEmployeeData("26/08/1988", "Kyiv", "Horkoho", 4, Genger.FEMALE, Position.COUNTER);
		counter.setBossMonthAccounting(170, 3, 0, true);
		counter.setSalaryPerHour(160);
		employeesList.add(counter);
		
		Employee headOfProduction = new Employee();
		headOfProduction.setEmployeeData("12/03/1989", "Kyiv", "Fizkultury", 5, Genger.FEMALE, Position.HEAD_OF_PRODUCTIOM);
		headOfProduction.setBossMonthAccounting(180, 3, 0, true);
		headOfProduction.setSalaryPerHour(160);
		employeesList.add(headOfProduction);
		
		// Reports
		System.out.println("Get count of woman " + getWomanCount());
		
		getHomeAddressViolators();
		showHomeAddress();
		
		System.out.println("Get salary all employee for month " + getAllEmployeesSalary());		
	}

}
