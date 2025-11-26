/**
 * 主题公园的员工。
 * 继承自 Person，增加职位和时薪等属性。
 */
public class Employee extends Person {

    private String position;   // 职位，例如 "Ride Operator"
    private double hourlyRate; // 时薪

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

