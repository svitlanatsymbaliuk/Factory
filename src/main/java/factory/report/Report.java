package factory.report;

import java.util.List;

import factory.employees.SalaryInfo;
import factory.employees.data.EmployeeData;

public interface Report {

	int getWomenCountForGreeting(List<EmployeeData> employeesList);

	String getHomeAddressViolators(List<EmployeeData> employeesList);

	double getSalaryAllEmployees(List<EmployeeData> employeesList, SalaryInfo salaryInfo);

	enum ReportType {
		MONTHLY
	};
}
