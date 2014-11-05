package factory.employe;

public interface Employe {

	void setDateOfBirth(String dateOfBirth);

	String getDateOfBirth();

	void setHomeAddress(String town, String street, int numberOfHouse);

	String getHomeAddress();

	void setGender(Genger gender);

	Genger getGender();

	void setPosition(Position position);

	Position getPosition();

	void setLateTimesCountPerMonth(int lateTimesCount);

	int getLateTimesCountPerMonth();

	void setDrunkTimesCountPerMonth(int drunkTimesCount);

	int getDrunkTimesCountPerMonth();

	void setFactoryExecutedPlanPerMonth(boolean isFactoryExecutedPlan);

	boolean isFactoryExecutedPlanPerMonth();

	void setWorkingTimeHoursPerMonth(int workingTimeHours);
	
	int getWorkingTimeHoursPerMonth();

	void setDetailsCountPerMonth(int detailsCount);
	
	int getDetailsCountPerMonth();

	void setSalaryPerHour(double salaryPerHour);
	
	double getSalaryPerHour();

	void setSalaryPerDetail(double salaryPerDetail);

	double getSalaryPerDetail();
	
	double getSalaryPerMonth();

	enum Genger {
		MALE, FEMALE
	};

	enum Position {
		WORKER, COUNTER, HEAD_OF_PRODUCTION, DIRECTOR
	};
	
	static final int BONUS = 50000;
	static final int FIRE = 200;
	
}
