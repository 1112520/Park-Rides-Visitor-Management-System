/**
 * Theme Park Employees
 * Inherits from Person, with additional attributes such as job position and hourly wage。
 */
public class Employee extends Person {

    private String position;   // Job position: e.g., "Ride Operator"
    private double hourlyRate; // Hourly wage

    public Employee() {
        super();
    }

    public Employee(String id, String fullName, int age,
                    String position, double hourlyRate) {
        super(id, fullName, age);
        this.position = position;
        this.hourlyRate = hourlyRate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position == null || position.isBlank()) {
            throw new IllegalArgumentException("position cannot be null or blank");
        }
        this.position = position;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("hourlyRate cannot be negative");
        }
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String getDescription() {
        return "Employee: " + getFullName() +
                " (" + position + ", $" + hourlyRate + "/hour)";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", age=" + getAge() +
                ", position='" + position + '\'' +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}

