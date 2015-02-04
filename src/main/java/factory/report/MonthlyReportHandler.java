package factory.report;

import java.util.ArrayList;
import java.util.List;

import factory.employees.SalaryInfo;
import factory.employees.data.EmployeeData;
import factory.employees.data.PersonalData.Gender;
import factory.employees.data.PersonalData.Position;

public class MonthlyReportHandler {
	private final List<EmployeeData> employeesList;
	private final SalaryInfo salaryInfo;
	private final MonthlyReport monthlyReport;
	private int womenCount;
	private List<String> homeAddressViolatorsList = new ArrayList<String>();
	private double salaryAllEmployees;

	public MonthlyReportHandler(List<EmployeeData> employeesList,
			SalaryInfo salaryInfo) {
		this.employeesList = employeesList;
		this.salaryInfo = salaryInfo;

		calcWomenCountForGreeting();
		calcHomeAddressViolators();
		calcSalaryAllEmployees();

		monthlyReport = new MonthlyReport(womenCount,
				homeAddressViolatorsList.toString(), salaryAllEmployees);
	}

	public MonthlyReport getMonthlyReport() {
		return monthlyReport;
	}

	private void calcWomenCountForGreeting() {
		womenCount = 0;
		for (EmployeeData employeeData : employeesList) {
			if (employeeData.getPersonalData().getGender() == Gender.FEMALE) {
				++womenCount;
			}
		}
	}

	private void calcHomeAddressViolators() {
		homeAddressViolatorsList.clear();
		for (EmployeeData employeeData : employeesList) {
			if ((employeeData.getMonthAccounting().getDrunkTimesCount() > 0)
					|| (employeeData.getMonthAccounting().getLateTimesCount() > 0)) {
				homeAddressViolatorsList.add(employeeData.getPersonalData()
						.getHomeAddres());
			}
		}
	}

	private void calcSalaryAllEmployees() {
		salaryAllEmployees = 0;
		Position position;
		for (EmployeeData employeeData : employeesList) {
			position = employeeData.getPersonalData().getPosition();
			if (position == Position.WORKER) {
				salaryAllEmployees += getWorkerSalary(employeeData);
			} else if (position == Position.DIRECTOR) {
				salaryAllEmployees += getDirectorSalary(employeeData);
			} else {
				salaryAllEmployees += employeeData.getMonthAccounting()
						.getWorkingHours() * salaryInfo.getSumPerHour();
			}
		}
	}

	private double getWorkerSalary(EmployeeData employeeData) {
		double workerSalary;
		workerSalary = (employeeData.getMonthAccounting().getDetailsCount() * salaryInfo
				.getSumPerDetail())
				- ((employeeData.getMonthAccounting().getDrunkTimesCount() + employeeData
						.getMonthAccounting().getLateTimesCount()) * salaryInfo
						.getFineInfo());
		return workerSalary;
	}

	private double getDirectorSalary(EmployeeData employeeData) {
		double directorSalary;
		directorSalary = employeeData.getMonthAccounting().getWorkingHours();
		salaryInfo.getSumPerHour();
		if (employeeData.getMonthAccounting().isFactoryExecutedPlan() == true) {
			directorSalary += salaryInfo.getBonusInfo();
		}
		return directorSalary;
	}

}
