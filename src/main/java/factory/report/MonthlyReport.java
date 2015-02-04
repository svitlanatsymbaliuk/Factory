package factory.report;

public class MonthlyReport implements Report {

	private final int womenCount;
	private final String homeAddressViolators;
	private final double salaryAllEmployees;

	public MonthlyReport(int womenCount, String homeAddressViolators, double salaryAllEmployees) {
		this.womenCount = womenCount;
		this.homeAddressViolators = homeAddressViolators;
		this.salaryAllEmployees = salaryAllEmployees;
	}

	@Override
	public int getWomenCountForGreeting() {
		return womenCount;
	}

	@Override
	public String getHomeAddressViolators() {
		return homeAddressViolators;
	}

	@Override
	public double getSalaryAllEmployees() {
		return salaryAllEmployees;
	}
}
