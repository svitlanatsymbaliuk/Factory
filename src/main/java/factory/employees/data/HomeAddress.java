package factory.employees.data;

public class HomeAddress {

	private final String town;
	private final String street;
	private final int houseNum;

	public HomeAddress(String town, String street, int houseNum) {
		this.town = town;
		this.street = street;
		this.houseNum = houseNum;
	}

	public String getTown() {
		return town;
	}

	public String getStreet() {
		return street;
	}

	public int getHouseNum() {
		return houseNum;
	}

	@Override
	public String toString() {
		return "HomeAddress [town=" + town + ", street=" + street
				+ ", houseNum=" + houseNum + "]";
	}

}
