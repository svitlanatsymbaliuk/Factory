package factory.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import factory.employe.Employe;
import factory.employe.Employe.Genger;

public class MonthReport implements Report {

	private List<Employe> employeeList;
	private Vector<String> homeAddressViolatorsArray;
	private int womanCount;
	private double allEmployeesSalary;

	public MonthReport() {
		employeeList = new ArrayList<Employe>();
		homeAddressViolatorsArray = new Vector<String>();
		womanCount = 0;
		allEmployeesSalary = 0;
	}

	@Override
	public void addEmployeeToReportList(Employe employee) {
		employeeList.add(employee);
	}

	@Override
	public String getHomeAddressViolators() {
		for (int i = 0; i < employeeList.size(); ++i) {
			Employe employee = employeeList.get(i);
			if ((employee.getDrunkTimesCountPerMonth() > 0)
					|| (employee.getLateTimesCountPerMonth() > 0)) {
				homeAddressViolatorsArray.add(employee.getHomeAddress());
			}
		}
		return homeAddressViolatorsArray.toString();
	}

	@Override
	public int getWomanCountForGreetings() {
		for (int i = 0; i < employeeList.size(); ++i) {
			if (employeeList.get(i).getGender() == Genger.FEMALE) {
				++womanCount;
			}
		}
		return womanCount;
	}

	@Override
	public double getAllEmployeesSalary() {
		for (int i = 0; i < employeeList.size(); ++i) {
			allEmployeesSalary += employeeList.get(i).getSalaryPerMonth();
		}
		return allEmployeesSalary;
	}

}
