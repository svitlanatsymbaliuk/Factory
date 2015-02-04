package factory;

import factory.employees.FactoryEmployees;
import factory.employees.SalaryInfo;
import factory.employees.data.EmployeeData;
import factory.employees.data.HomeAddress;
import factory.employees.data.MonthlyAccounting;
import factory.employees.data.PersonalData;
import factory.employees.data.PersonalData.Gender;
import factory.employees.data.PersonalData.Position;
import factory.report.Report;
import factory.report.ReportFactory;
import factory.report.ReportType;

public class Client {

	public static void main(String[] args) {

		// Set all data about employees
		PersonalData worker_1 = new PersonalData("01/01/1981", Gender.MALE,
				new HomeAddress("Kyiv", "Antonovycha", 1), Position.WORKER);
		MonthlyAccounting worker_1_Accounting = new MonthlyAccounting.Builder()
				.setDrunkTimesCount(2).setDetailsCount(80).build();

		PersonalData worker_2 = new PersonalData("02/02/1982", Gender.MALE,
				new HomeAddress("Kyiv", "Lomonosova", 2), Position.WORKER);
		MonthlyAccounting worker_2_Accounting = new MonthlyAccounting.Builder()
				.setDrunkTimesCount(2).setDetailsCount(82).build();

		PersonalData counter = new PersonalData("03/03/1983", Gender.FEMALE,
				new HomeAddress("Kyiv", "Saksahanskoho", 3), Position.COUNTER);
		MonthlyAccounting counterAccounting = new MonthlyAccounting.Builder()
				.setLateTimesCount(3).setWorkingHours(160).build();

		PersonalData headOfProduction = new PersonalData("04/04/1984",
				Gender.FEMALE, new HomeAddress("Kyiv", "Vasylkivska", 4),
				Position.HEAD_OF_PRODUCTIOM);
		MonthlyAccounting headOfProdAccounting = new MonthlyAccounting.Builder()
				.setLateTimesCount(3).setWorkingHours(170).build();

		PersonalData director = new PersonalData("05/05/1985", Gender.MALE,
				new HomeAddress("Kyiv", "Hlushkova", 5), Position.DIRECTOR);
		MonthlyAccounting directorAccounting = new MonthlyAccounting.Builder()
				.isFactoryExecutedPlan(true).setWorkingHours(180).build();

		// Add employee to list
		FactoryEmployees factoryEmployees = new FactoryEmployees();
		factoryEmployees.addEmployeeToList(new EmployeeData(worker_1,
				worker_1_Accounting));
		factoryEmployees.addEmployeeToList(new EmployeeData(worker_2,
				worker_2_Accounting));
		factoryEmployees.addEmployeeToList(new EmployeeData(counter,
				counterAccounting));
		factoryEmployees.addEmployeeToList(new EmployeeData(headOfProduction,
				headOfProdAccounting));
		factoryEmployees.addEmployeeToList(new EmployeeData(director,
				directorAccounting));

		// Set information about salary on factory
		SalaryInfo salaryInfo = new SalaryInfo(50000, 200, 100, 100);

		// Get monthly report
		Report monthlyReport = ReportFactory.getInstance(ReportType.MONTHLY,
				factoryEmployees.getEmployeesList(), salaryInfo);

		System.out.println("Count of women "
				+ monthlyReport.getWomenCountForGreeting());

		System.out.println("Home address of Violators"
				+ monthlyReport.getHomeAddressViolators());

		System.out.println("Salary all employees "
				+ monthlyReport.getSalaryAllEmployees());

	}
}
