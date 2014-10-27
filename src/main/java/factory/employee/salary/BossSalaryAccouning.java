package factory.employee.salary;

import factory.employee.accounting.EmployeeMonthAccounting;

public class BossSalaryAccouning implements SalaryAccounting {

	public static final int BONUS = 50000;
	private double salaryPerHour;
	private EmployeeMonthAccounting employeeMonthAccounting;

	public BossSalaryAccouning(double salaryPerHour,
			EmployeeMonthAccounting employeeMonthAccounting) {
		super();
		this.salaryPerHour = salaryPerHour;
		this.employeeMonthAccounting = employeeMonthAccounting;
	}

	@Override
	public double getSalary() {
		return (salaryPerHour * employeeMonthAccounting.getTimeHours());
	}

}
