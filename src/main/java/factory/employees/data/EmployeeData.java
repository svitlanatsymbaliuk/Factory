package factory.employees.data;

public class EmployeeData {

	private final PersonalData personalData;
	private final MonthlyAccounting monthlyAccounting;

	public EmployeeData(PersonalData personalData,
			MonthlyAccounting monthlyAccounting) {
		this.personalData = personalData;
		this.monthlyAccounting = monthlyAccounting;
	}

	public PersonalData getPersonalData() {
		return personalData;
	}

	public MonthlyAccounting getMonthAccounting() {
		return monthlyAccounting;
	}

}
