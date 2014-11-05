package factory.employee;

import factory.employee.Employee.Position;

public class EmployeeFactory {

	public static Employee getInstance(Position position) {
			return new EmployeeImpl(position);
	}

}
