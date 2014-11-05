package factory.client;

import factory.employee.Employee;
import factory.employee.EmployeeFactory;
import factory.employee.Employee.Genger;
import factory.employee.Employee.Position;
import factory.report.Report;
import factory.report.ReportFactory;
import factory.report.Report.ReportType;

public class Client {

	public static void main(String[] args) {
		
		Employee director = EmployeeFactory.getInstance(Position.DIRECTOR); 
		director.setDateOfBirth("01/02/1982");
		director.setHomeAddress("Kyiv", "Lomoosova", 1);
		director.setGender(Genger.MALE);
		director.setFactoryExecutedPlanPerMonth(true);
		director.setSalaryPerHour(300);
		director.setWorkingTimeHoursPerMonth(200);
		
		Employee counter = EmployeeFactory.getInstance(Position.COUNTER);
		counter.setDateOfBirth("03/06/1987");
		counter.setHomeAddress("Kyiv", "Vasylkivska", 2);
		counter.setGender(Genger.FEMALE);
		counter.setSalaryPerHour(250);
		counter.setWorkingTimeHoursPerMonth(180);
		counter.setLateTimesCountPerMonth(3);
		
		Employee headOfProduction = EmployeeFactory.getInstance(Position.HEAD_OF_PRODUCTION);
		headOfProduction.setDateOfBirth("04/10/1988");
		headOfProduction.setHomeAddress("Kyiv", "Saksahanskoho", 3);
		headOfProduction.setGender(Genger.FEMALE);
		headOfProduction.setSalaryPerHour(270);
		headOfProduction.setWorkingTimeHoursPerMonth(180);
		headOfProduction.setLateTimesCountPerMonth(3);
		
		Employee worker1 = EmployeeFactory.getInstance(Position.WORKER);
		worker1.setDateOfBirth("15/08/1981");
		worker1.setHomeAddress("Kyiv", "Horkoho", 4);
		worker1.setGender(Genger.MALE);
		worker1.setSalaryPerDetail(200);
		worker1.setDetailsCountPerMonth(100);
		worker1.setDrunkTimesCountPerMonth(2);
		
		Employee worker2 = EmployeeFactory.getInstance(Position.WORKER);
		worker2.setDateOfBirth("19128/1985");
		worker2.setHomeAddress("Kyiv", "Korolenkivska", 5);
		worker2.setGender(Genger.MALE);
		worker2.setSalaryPerDetail(190);
		worker2.setDetailsCountPerMonth(100);
		worker2.setDrunkTimesCountPerMonth(2);
		
		Report monthReport = ReportFactory.getInstance(ReportType.MONTH);
		monthReport.addEmployeeToReportList(director);
		monthReport.addEmployeeToReportList(counter);
		monthReport.addEmployeeToReportList(headOfProduction);
		monthReport.addEmployeeToReportList(worker1);
		monthReport.addEmployeeToReportList(worker2);
		
		System.out.println("Count of woman for greetings " + monthReport.getWomanCountForGreetings());
		System.out.println("Home address of violators: " + monthReport.getHomeAddressViolators());
		System.out.println("Salary all employee " + monthReport.getAllEmployeesSalary());
	}

}
