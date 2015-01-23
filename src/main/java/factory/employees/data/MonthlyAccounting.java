package factory.employees.data;

public class MonthlyAccounting {

	private final boolean isFactoryExecutedPlan;
	private final int drunkTimesCount;
	private final int lateTimesCount;
	private final int workingHours;
	private final int detailsCount;

	public static class Builder {
		private boolean isFactoryExecutedPlan;
		private int drunkTimesCount;
		private int lateTimesCount;
		private int workingHours;
		private int detailsCount;

		public Builder isFactoryExecutedPlan(boolean isFactoryExecutedPlan) {
			this.isFactoryExecutedPlan = isFactoryExecutedPlan;
			return this;
		}

		public Builder setDrunkTimesCount(int drunkTimesCount) {
			this.drunkTimesCount = drunkTimesCount;
			return this;
		}

		public Builder setLateTimesCount(int lateTimesCount) {
			this.lateTimesCount = lateTimesCount;
			return this;
		}

		public Builder setWorkingHours(int workingHours) {
			this.workingHours = workingHours;
			return this;
		}

		public Builder setDetailsCount(int detailsCount) {
			this.detailsCount = detailsCount;
			return this;
		}

		public MonthlyAccounting build() {
			return new MonthlyAccounting(this);
		}
	}

	private MonthlyAccounting(Builder builder) {
		this.isFactoryExecutedPlan = builder.isFactoryExecutedPlan;
		this.drunkTimesCount = builder.drunkTimesCount;
		this.lateTimesCount = builder.lateTimesCount;
		this.workingHours = builder.workingHours;
		this.detailsCount = builder.detailsCount;
	}

	public boolean isFactoryExecutedPlan() {
		return isFactoryExecutedPlan;
	}

	public int getDrunkTimesCount() {
		return drunkTimesCount;
	}

	public int getLateTimesCount() {
		return lateTimesCount;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public int getDetailsCount() {
		return detailsCount;
	}

}
