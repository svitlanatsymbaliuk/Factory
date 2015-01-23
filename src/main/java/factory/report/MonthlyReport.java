package factory.report;

import java.util.ArrayList;
import java.util.List;

import factory.employees.SalaryInfo;
import factory.employees.data.EmployeeData;
import factory.employees.data.PersonalData.Gender;
import factory.employees.data.PersonalData.Position;

public class MonthlyReport implements Report {

	private int womenCount;
	private List<String> homeAddressViolatorsList = new ArrayList<String>();
	private double salaryAllEmployees;

	public MonthlyReport() {
		womenCount = 0;
		homeAddressViolatorsList.clear();
		salaryAllEmployees = 0;
	}

	@Override
	public int getWomenCountForGreeting(List<EmployeeData> employeesList) {
		womenCount = 0;
		for (EmployeeData employeeData : employeesList) {
			if (employeeData.getPersonalData().getGender() == Gender.FEMALE) {
				++womenCount;
			}
		}
		return womenCount;
	}

	@Override
	public String getHomeAddressViolators(List<EmployeeData> employeesList) {
		homeAddressViolatorsList.clear();
		for (EmployeeData employeeData : employeesList) {
			if ((employeeData.getMonthAccounting().getDrunkTimesCount() > 0)
					|| (employeeData.getMonthAccounting().getLateTimesCount() > 0)) {
				homeAddressViolatorsList.add(employeeData.getPersonalData()
						.getHomeAddres());
			}
		}
		return homeAddressViolatorsList.toString();
	}

	@Override
	public double getSalaryAllEmployees(List<EmployeeData> employeesList,
			SalaryInfo salaryInfo) {
		salaryAllEmployees = 0;
		Position position;
		for (EmployeeData employeeData : employeesList) {
			position = employeeData.getPersonalData().getPosition();
			if (position == Position.WORKER) {
				salaryAllEmployees += getWorkerSalary(employeeData, salaryInfo);
			} else if (position == Position.DIRECTOR) {
				salaryAllEmployees += getDirectorSalary(employeeData,
						salaryInfo);
			} else {
				salaryAllEmployees += employeeData.getMonthAccounting()
						.getWorkingHours() * salaryInfo.getSumPerHour();
			}
		}
		return salaryAllEmployees;
	}

	private double getWorkerSalary(EmployeeData employeeData,
			SalaryInfo salaryInfo) {
		double workerSalary;
		workerSalary = (employeeData.getMonthAccounting().getDetailsCount() * salaryInfo
				.getSumPerDetail())
				- ((employeeData.getMonthAccounting().getDrunkTimesCount() + employeeData
						.getMonthAccounting().getLateTimesCount()) * salaryInfo
						.getFineInfo());
		return workerSalary;
	}

	private double getDirectorSalary(EmployeeData employeeData,
			SalaryInfo salaryInfo) {
		double directorSalary;
		directorSalary = employeeData.getMonthAccounting().getWorkingHours()
				* salaryInfo.getSumPerHour();
		if (employeeData.getMonthAccounting().isFactoryExecutedPlan() == true) {
			directorSalary += salaryInfo.getBonusInfo();
		}
		return directorSalary;
	}
}
