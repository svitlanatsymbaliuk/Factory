package factory.employees.data;

public class PersonalData {

	private final String dateOfBirth;
	private final Gender gender;
	private final HomeAddress homeAddres;
	private final Position position;

	public PersonalData(String dateOfBirth, Gender gender,
			HomeAddress homeAddress, Position position) {
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.homeAddres = new HomeAddress(homeAddress.getTown(),
				homeAddress.getStreet(), homeAddress.getHouseNum());
		this.position = position;
	}

	public enum Gender {
		MALE, FEMALE
	};

	public enum Position {
		WORKER, HEAD_OF_PRODUCTIOM, COUNTER, DIRECTOR
	};

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public String getHomeAddres() {
		return homeAddres.toString();
	}

	public Position getPosition() {
		return position;
	}

}
