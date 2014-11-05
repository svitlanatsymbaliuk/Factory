package factory.report;

import factory.employee.Employee;

public interface Report {

	void addEmployeeToReportList(Employee employee);
	
	int getWomanCountForGreetings();

	String getHomeAddressViolators();

	double getAllEmployeesSalary();

	enum ReportType {
		MONTH
	};
}
