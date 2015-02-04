package factory.report;

import java.util.List;

import factory.employees.SalaryInfo;
import factory.employees.data.EmployeeData;

public class ReportFactory {
	public static Report getInstance(ReportType reportType,
			List<EmployeeData> employeesList, SalaryInfo salaryInfo) {
		if (reportType.equals(ReportType.MONTHLY)) {
			MonthlyReportHandler monthlyReportHandler = new MonthlyReportHandler(
					employeesList, salaryInfo);
			MonthlyReport monthlyReport = monthlyReportHandler.getMonthlyReport();
			return monthlyReport;
		} else {
			throw new IllegalArgumentException("No such type of report");
		}
	}
}
