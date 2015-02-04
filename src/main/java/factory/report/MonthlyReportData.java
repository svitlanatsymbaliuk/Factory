package factory.report;

import java.util.List;

import factory.employees.SalaryInfo;
import factory.employees.data.EmployeeData;

public class MonthlyReportData {
	private List<EmployeeData> employeesList;
	private SalaryInfo salaryInfo;

	public MonthlyReportData(List<EmployeeData> employeesList,
			SalaryInfo salaryInfo) {
		this.employeesList = employeesList;
		this.salaryInfo = salaryInfo;
	}

	public List<EmployeeData> getEmployeesList() {
		return employeesList;
	}

	public SalaryInfo getSalaryInfo() {
		return salaryInfo;
	}
}
