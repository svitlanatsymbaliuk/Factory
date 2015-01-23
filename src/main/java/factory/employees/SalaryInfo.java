package factory.employees;

public class SalaryInfo {

	private final double bonusInfo;
	private final double fineInfo;
	private final double sumPerHour;
	private final double sumPerDetail;

	public SalaryInfo(double bonusInfo, double fineInfo, double sumPerHour,
			double sumPerDetail) {
		this.bonusInfo = bonusInfo;
		this.fineInfo = fineInfo;
		this.sumPerHour = sumPerHour;
		this.sumPerDetail = sumPerDetail;
	}

	public double getBonusInfo() {
		return bonusInfo;
	}

	public double getFineInfo() {
		return fineInfo;
	}

	public double getSumPerHour() {
		return sumPerHour;
	}

	public double getSumPerDetail() {
		return sumPerDetail;
	}
}
