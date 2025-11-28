/**
 * 主题公园的游客。
 * 继承自 Person，增加票种和是否快速通行等属性。
 */
public class Visitor extends Person {

    private String ticketType; // 如 "Adult", "Child", "VIP"
    private boolean fastPass;  // 是否持有快速通行证

    public Visitor() {
        super();
    }

    public Visitor(String id, String fullName, int age,
                   String ticketType, boolean fastPass) {
        super(id, fullName, age);
        // 使用 setter 保证校验
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

