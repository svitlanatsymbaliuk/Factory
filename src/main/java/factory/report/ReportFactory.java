package factory.report;

import java.util.List;

import factory.employees.SalaryInfo;
import factory.employees.data.EmployeeData;

public class ReportFactory {
	public static Report getInstance(ReportType reportType,
			List<EmployeeData> employeesList, SalaryInfo salaryInfo) {
		if (reportType.equals(ReportType.MONTHLY)) {
			return new MonthlyReport(new MonthlyReportData(employeesList, salaryInfo));
		}
		throw new IllegalArgumentException("No such type of report");
	}
}
