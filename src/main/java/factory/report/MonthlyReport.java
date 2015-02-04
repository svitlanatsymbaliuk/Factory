package factory.report;

import java.util.ArrayList;
import java.util.List;
import factory.employees.data.EmployeeData;
import factory.employees.data.PersonalData.Gender;
import factory.employees.data.PersonalData.Position;

public class MonthlyReport implements Report {

	private MonthlyReportData reportData;
	private int womenCount;
	private List<String> homeAddressViolatorsList = new ArrayList<String>();
	private double salaryAllEmployees;

	public MonthlyReport(MonthlyReportData reportData) {
		this.reportData = reportData;
		womenCount = 0;
		homeAddressViolatorsList.clear();
		salaryAllEmployees = 0;
	}

	@Override
	public int getWomenCountForGreeting() {
		womenCount = 0;
		for (EmployeeData employeeData : reportData.getEmployeesList()) {
			if (employeeData.getPersonalData().getGender() == Gender.FEMALE) {
				++womenCount;
			}
		}
		return womenCount;
	}

	@Override
	public String getHomeAddressViolators() {
		homeAddressViolatorsList.clear();
		for (EmployeeData employeeData : reportData.getEmployeesList()) {
			if ((employeeData.getMonthAccounting().getDrunkTimesCount() > 0)
					|| (employeeData.getMonthAccounting().getLateTimesCount() > 0)) {
				homeAddressViolatorsList.add(employeeData.getPersonalData()
						.getHomeAddres());
			}
		}
		return homeAddressViolatorsList.toString();
	}

	@Override
	public double getSalaryAllEmployees() {
		salaryAllEmployees = 0;
		Position position;
		for (EmployeeData employeeData : reportData.getEmployeesList()) {
			position = employeeData.getPersonalData().getPosition();
			if (position == Position.WORKER) {
				salaryAllEmployees += getWorkerSalary(employeeData);
			} else if (position == Position.DIRECTOR) {
				salaryAllEmployees += getDirectorSalary(employeeData);
			} else {
				salaryAllEmployees += employeeData.getMonthAccounting()
						.getWorkingHours()
						* reportData.getSalaryInfo().getSumPerHour();
			}
		}
		return salaryAllEmployees;
	}

	private double getWorkerSalary(EmployeeData employeeData) {
		double workerSalary;
		workerSalary = (employeeData.getMonthAccounting().getDetailsCount() * reportData
				.getSalaryInfo().getSumPerDetail())
				- ((employeeData.getMonthAccounting().getDrunkTimesCount() + employeeData
						.getMonthAccounting().getLateTimesCount()) * reportData
						.getSalaryInfo().getFineInfo());
		return workerSalary;
	}

	private double getDirectorSalary(EmployeeData employeeData) {
		double directorSalary;
		directorSalary = employeeData.getMonthAccounting().getWorkingHours();
		reportData.getSalaryInfo().getSumPerHour();
		if (employeeData.getMonthAccounting().isFactoryExecutedPlan() == true) {
			directorSalary += reportData.getSalaryInfo().getBonusInfo();
		}
		return directorSalary;
	}
}
