package factory.employees;

import java.util.ArrayList;
import java.util.List;

import factory.employees.data.EmployeeData;

public class FactoryEmployees {

	private List<EmployeeData> employeesList = new ArrayList<EmployeeData>();
	
	public FactoryEmployees(){
		employeesList.clear();
	}

	public void addEmployeeToList(EmployeeData employee){
		employeesList.add(employee);
	}
	
	public List<EmployeeData> getEmployeesList(){
		return employeesList;
	}
}
