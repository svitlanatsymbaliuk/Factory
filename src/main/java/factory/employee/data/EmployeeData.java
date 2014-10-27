package factory.employee.data;

public interface EmployeeData {
	
	String getBirthDate();

	HomeAddress getHomeAddress();

	Position getPosition();

	Genger getGender();

	enum Genger {
		MALE, FEMALE
	};

	enum Position {
		WORKER, DIRECTOR, COUNTER, HEAD_OF_PRODUCTIOM
	};
	
}
