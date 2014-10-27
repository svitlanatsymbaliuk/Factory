package factory.employee.data;

public final class HomeAddress {

	private final String town;
	private final String street;
	private final int houseNumber;

	public HomeAddress(String town, String street, int houseNumber) {
		this.town = town;
		this.street = street;
		this.houseNumber = houseNumber;
	}

	public String getTown() {
		return town;
	}

	public String getStreet() {
		return street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

}
