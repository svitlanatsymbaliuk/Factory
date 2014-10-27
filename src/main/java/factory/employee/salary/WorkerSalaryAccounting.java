package factory.employee.salary;

import factory.employee.accounting.EmployeeMonthAccounting;

public class WorkerSalaryAccounting implements SalaryAccounting {

	private static final int FIRE = 200;
	private double salaryPerDetail;
	private EmployeeMonthAccounting employeeMonthAccounting;

	public WorkerSalaryAccounting(double salaryPerDetail,
			EmployeeMonthAccounting employeeMonthAccounting) {
		this.salaryPerDetail = salaryPerDetail;
		this.employeeMonthAccounting = employeeMonthAccounting;
	}

	@Override
	public double getSalary() {
		double salary = salaryPerDetail
				* employeeMonthAccounting.getDetailsCount();
		int fireForDelay = employeeMonthAccounting.getLateTimesCount() * FIRE;
		int fireForDrunk = employeeMonthAccounting.getDrunkTimesCount() * FIRE;
		return (salary - fireForDelay - fireForDrunk);
	}

}
