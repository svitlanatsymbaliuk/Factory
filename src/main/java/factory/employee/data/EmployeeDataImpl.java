package factory.employee.data;

public class EmployeeDataImpl implements EmployeeData {

	private String birthDate;
	private HomeAddress homeAddress;
	private Genger gender;
	private Position position;

	public EmployeeDataImpl(String birthDate, HomeAddress homeAddress,
			Genger gender, Position position) {
		this.birthDate = birthDate;
		this.homeAddress = homeAddress;
		this.gender = gender;
		this.position = position;
	}

	@Override
	public String getBirthDate() {
		return birthDate;
	}

	@Override
	public HomeAddress getHomeAddress() {
		return homeAddress;
	}

	@Override
	public Genger getGender() {
		return gender;
	}

	@Override
	public Position getPosition() {
		return position;
	}

}
