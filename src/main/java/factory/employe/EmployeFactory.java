package factory.employe;

import factory.employe.Employe.Position;

public class EmployeFactory {

	public static Employe getInstance(Position position) {
			return new EmployeImpl(position);
	}

}
