package factory.report;

import factory.report.Report.ReportType;

public class ReportFactory {
	public static Report getInstance(ReportType reportType){
		if(reportType.equals(ReportType.MONTHLY)){
			return new MonthlyReport();
		}
		throw new IllegalArgumentException("No such type of report");
	}
}
