package factory.employee.accounting;

public class EmployeeMonthAccounting {

	private int timeHours;
	private int lateTimesCount;
	private int drunkTimesCount;
	private int detailsCount;
	private boolean isFactoryExetutedPlan;

	public EmployeeMonthAccounting() {
		this.timeHours = 0;
		this.lateTimesCount = 0;
		this.drunkTimesCount = 0;
		this.detailsCount = 0;
		this.isFactoryExetutedPlan = false;
	}

	public int getTimeHours() {
		return timeHours;
	}

	public void setTimeHours(int timeHours) {
		this.timeHours = timeHours;
	}

	public int getLateTimesCount() {
		return lateTimesCount;
	}

	public void setLateTimesCount(int lateTimeCount) {
		this.lateTimesCount = lateTimeCount;
	}

	public int getDrunkTimesCount() {
		return drunkTimesCount;
	}

	public void setDrunkTimesCount(int drunkTimeCount) {
		this.drunkTimesCount = drunkTimeCount;
	}

	public int getDetailsCount() {
		return detailsCount;
	}

	public void setDetailsCount(int detailsCount) {
		this.detailsCount = detailsCount;
	}

	public boolean isFactoryExetutedPlan() {
		return isFactoryExetutedPlan;
	}

	public void setFactoryExetutedPlan(boolean isFactoryExetutedPlan) {
		this.isFactoryExetutedPlan = isFactoryExetutedPlan;
	}

}
