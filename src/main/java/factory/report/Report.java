package factory.report;

import factory.employe.Employe;

public interface Report {

	void addEmployeeToReportList(Employe employee);
	
	int getWomanCountForGreetings();

	String getHomeAddressViolators();

	double getAllEmployeesSalary();

	enum ReportType {
		MONTH
	};
}
