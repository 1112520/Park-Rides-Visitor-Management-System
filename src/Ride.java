/**
 * 主题公园中的游乐项目。
 * 实现 RideInterface。
 *
 * 本类当前只完成基础属性和构造方法，
 * 队列、历史记录和 I/O 的具体逻辑将在后续提交中实现。
 */
public class Ride implements RideInterface {

    private String name;         // 项目名称，例如 "Super Coaster"
    private String type;         // 项目类型，例如 "Roller Coaster"
    private double minHeight;    // 最低身高限制（米）
    private Employee operator;   // 负责操作该项目的员工

    private int maxRider;        // 每轮最多可以搭乘的游客数量（Part 5）
    private int numOfCycles;     // 已经运行的轮数（Part 5）

    public Ride() {
        this.numOfCycles = 0;
    }

    public Ride(String name, String type, double minHeight,
                Employee operator, int maxRider) {
        this();
        this.name = name;
        this.type = type;
        this.minHeight = minHeight;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // ------------- Getter / Setter -------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type cannot be null or blank");
        }
        this.type = type;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(double minHeight) {
        if (minHeight < 0) {
            throw new IllegalArgumentException("minHeight cannot be negative");
        }
        this.minHeight = minHeight;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        if (maxRider <= 0) {
            throw new IllegalArgumentException("maxRider must be > 0");
        }
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        if (numOfCycles < 0) {
            throw new IllegalArgumentException("numOfCycles cannot be negative");
        }
        this.numOfCycles = numOfCycles;
    }

    // ------------- 接口方法的占位实现 -------------

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        // 占位实现：后续在 Part 3 中真正使用 Queue 来实现。
        System.out.println("[TODO] addVisitorToQueue will be implemented in Part 3.");
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        // 占位实现：后续在 Part 3 中真正从队列中移除。
        System.out.println("[TODO] removeVisitorFromQueue will be implemented in Part 3.");
        return null;
    }

    @Override
    public void printQueue() {
        // 占位实现：后续在 Part 3 中打印队列内容。
        System.out.println("[TODO] printQueue will be implemented in Part 3.");
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // 占位实现：后续在 Part 4A 中用 LinkedList 记录历史。
        System.out.println("[TODO] addVisitorToHistory will be implemented in Part 4A.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // 占位实现：后续在 Part 4A 中真正检查历史。
        System.out.println("[TODO] checkVisitorFromHistory will be implemented in Part 4A.");
        return false;
    }

    @Override
    public int numberOfVisitors() {
        // 占位实现：后续在 Part 4A 中返回历史中游客数量。
        System.out.println("[TODO] numberOfVisitors will be implemented in Part 4A.");
        return 0;
    }

    @Override
    public void printRideHistory() {
        // 占位实现：后续在 Part 4A 中使用 Iterator 打印历史。
        System.out.println("[TODO] printRideHistory will be implemented in Part 4A.");
    }

    @Override
    public void runOneCycle() {
        // 占位实现：后续在 Part 5 中实现完整逻辑。
        System.out.println("[TODO] runOneCycle will be implemented in Part 5.");
    }

    @Override
    public String toString() {
        return "Ride{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", minHeight=" + minHeight +
                ", operator=" + (operator != null ? operator.getFullName() : "none") +
                ", maxRider=" + maxRider +
                ", numOfCycles=" + numOfCycles +
                '}';
    }
}

