package factory.reporting;

import factory.employee.accounting.EmployeeMonthAccounting;
import factory.employee.data.EmployeeDataImpl;
import factory.employee.data.HomeAddress;
import factory.employee.data.EmployeeData.*;
import factory.employee.salary.BossSalaryAccouning;
import factory.employee.salary.WorkerSalaryAccounting;

public class Employee {

	EmployeeDataImpl employeeData;
	EmployeeMonthAccounting monthAccounting;
	BossSalaryAccouning bossSalaryAccouning;
	WorkerSalaryAccounting workerSalaryAccounting;
	double salaryPerHour;
	double salaryPerDetail;

	public void setEmployeeData(String birthDate, String town, String street,
			int houseNum, Genger gender, Position position) {
		employeeData = new EmployeeDataImpl(birthDate, new HomeAddress(town,
				street, houseNum), gender, position);
	}

	public EmployeeDataImpl getEmployeeData() {
		return employeeData;
	}

	public void setWorkerMonthAccounting(int lateTimesCount,
			int drunkTimesCount, int detailsCount, boolean isFactoryExetutedPlan) {
		monthAccounting = new EmployeeMonthAccounting();
		monthAccounting.setDetailsCount(detailsCount);
		monthAccounting.setLateTimesCount(lateTimesCount);
		monthAccounting.setDrunkTimesCount(drunkTimesCount);
		monthAccounting.setFactoryExetutedPlan(isFactoryExetutedPlan);
	}

	public void setBossMonthAccounting(int timeHours, int lateTimesCount,
			int drunkTimesCount, boolean isFactoryExetutedPlan) {
		monthAccounting = new EmployeeMonthAccounting();
		monthAccounting.setTimeHours(timeHours);
		monthAccounting.setLateTimesCount(lateTimesCount);
		monthAccounting.setDrunkTimesCount(drunkTimesCount);
		monthAccounting.setFactoryExetutedPlan(isFactoryExetutedPlan);
	}

	public EmployeeMonthAccounting getMonthAccounting() {
		return monthAccounting;
	}

	public double getEmployeeSalary() {
		Position position = employeeData.getPosition();
		if (position == Position.WORKER) {
			workerSalaryAccounting = new WorkerSalaryAccounting(
					salaryPerDetail, monthAccounting);
			return workerSalaryAccounting.getSalary();
		} else if (position == Position.DIRECTOR) {
			bossSalaryAccouning = new BossSalaryAccouning(salaryPerHour,
					monthAccounting);
			if (monthAccounting.isFactoryExetutedPlan() == true) {
				return (bossSalaryAccouning.getSalary() + BossSalaryAccouning.BONUS);
			} else {
				return bossSalaryAccouning.getSalary();
			}
		} else if ((position == Position.COUNTER)
				|| (position == Position.HEAD_OF_PRODUCTIOM)) {
			bossSalaryAccouning = new BossSalaryAccouning(salaryPerHour,
					monthAccounting);
			return bossSalaryAccouning.getSalary();
		} else {
			return 0;
		}
	}

	public double getSalaryPerHour() {
		return salaryPerHour;
	}

	public void setSalaryPerHour(double salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}

	public double getSalaryPerDetail() {
		return salaryPerDetail;
	}

	public void setSalaryPerDetail(double salaryPerDetail) {
		this.salaryPerDetail = salaryPerDetail;
	}

}
