package factory.report;

import factory.report.Report.ReportType;;

public class ReportFactory {
	
	public static Report getInstance(ReportType reportType){
		if(reportType == ReportType.MONTH){
			return new MonthReport();
		}
		else {
			throw new IllegalArgumentException("No such type of report");
		}
	}

}
