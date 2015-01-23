package factory.employee;

public class EmployeeImpl implements Employee {

	private String dateOfBirth;
	private HomeAddress homeAddress;
	private Genger gender;
	private Position position;
	private int lateTimesCount;
	private int drunkTimesCount;
	private boolean isFactoryExecutedPlan;
	private int workingTimeHours;
	private int detailsCount;
	private double salaryPerHour;
	private double salaryPerDetail;
	private double salaryPerMonth;
	
	public EmployeeImpl(Position position) {
		this.position = position;
	}

	@Override
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public void setHomeAddress(String town, String street, int numberOfHouse) {
		this.homeAddress = new HomeAddress(town, street, numberOfHouse);
	}

	@Override
	public String getHomeAddress() {
		return homeAddress.toString();
	}

	@Override
	public void setGender(Genger gender) {
		this.gender = gender;
	}

	@Override
	public Genger getGender() {
		return gender;
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setLateTimesCountPerMonth(int lateTimesCount) {
		this.lateTimesCount = lateTimesCount;
	}

	@Override
	public int getLateTimesCountPerMonth() {
		return lateTimesCount;
	}

	@Override
	public void setDrunkTimesCountPerMonth(int drunkTimesCount) {
		this.drunkTimesCount = drunkTimesCount;
	}

	@Override
	public int getDrunkTimesCountPerMonth() {
		return drunkTimesCount;
	}

	@Override
	public void setFactoryExecutedPlanPerMonth(boolean isFactoryExecutedPlan) {
		this.isFactoryExecutedPlan = isFactoryExecutedPlan;
	}

	@Override
	public boolean isFactoryExecutedPlanPerMonth() {
		return isFactoryExecutedPlan;
	}

	@Override
	public void setWorkingTimeHoursPerMonth(int workingTimeHours) {
		this.workingTimeHours = workingTimeHours;
	}

	@Override
	public int getWorkingTimeHoursPerMonth() {
		return workingTimeHours;
	}

	@Override
	public void setDetailsCountPerMonth(int detailsCount) {
		this.detailsCount = detailsCount;
	}

	@Override
	public int getDetailsCountPerMonth() {
		return detailsCount;
	}

	@Override
	public void setSalaryPerHour(double salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}

	@Override
	public double getSalaryPerHour() {
		return salaryPerHour;
	}

	@Override
	public void setSalaryPerDetail(double salaryPerDetail) {
		this.salaryPerDetail = salaryPerDetail;
	}

	@Override
	public double getSalaryPerDetail() {
		return salaryPerDetail;
	}

	@Override
	public double getSalaryPerMonth() {
		if(position == Position.WORKER){
			salaryPerMonth = (salaryPerDetail * detailsCount) - ((lateTimesCount + drunkTimesCount) * FIRE);
		} else if ((position == Position.DIRECTOR) && (isFactoryExecutedPlan == true)){
			salaryPerMonth = (salaryPerHour * workingTimeHours) + BONUS;
		}
		else{
			salaryPerMonth = salaryPerHour * workingTimeHours;
		}
		return salaryPerMonth;
	}

}
