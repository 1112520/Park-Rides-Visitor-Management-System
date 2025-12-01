/**
 * Visitors to the theme park.
 * Inherits from Person, adding attributes for ticket type and whether they have a fast pass.
 */
public class Visitor extends Person {

    private String ticketType; // e.g., "Adult", "Child", "VIP"
    private boolean fastPass;  // Whether the visitor has a fast pass

    public Visitor() {
        super();
    }

    public Visitor(String id, String fullName, int age,
                   String ticketType, boolean fastPass) {
        super(id, fullName, age);
        // Use setters to ensure validation
        setTicketType(ticketType);
        setFastPass(fastPass);
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        if (ticketType == null || ticketType.isBlank()) {
            throw new IllegalArgumentException("ticketType cannot be null or blank");
        }
        this.ticketType = ticketType;
    }

    public boolean isFastPass() {
        return fastPass;
    }

    public void setFastPass(boolean fastPass) {
        this.fastPass = fastPass;
    }

    @Override
    public String getDescription() {
        return "Visitor: " + getFullName() +
                " (ticketType=" + ticketType +
                ", fastPass=" + fastPass + ")";
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", age=" + getAge() +
                ", ticketType='" + ticketType + '\'' +
                ", fastPass=" + fastPass +
                '}';
    }
}

