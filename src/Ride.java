import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 主题公园中的游乐项目。
 * 实现 RideInterface，包含：
 * - 等待队列（Queue<Visitor> waitingLine） —— Part 3
 * - 游玩历史（LinkedList<Visitor> rideHistory） —— Part 4A
 */
public class Ride implements RideInterface {

    // ---------- 基本属性（Part 1） ----------
    private String name;         // 项目名称，例如 "Super Coaster"
    private String type;         // 项目类型，例如 "Roller Coaster"
    private double minHeight;    // 最低身高限制（米）
    private Employee operator;   // 负责操作该项目的员工

    // ---------- 运行属性（Part 5 会用到） ----------
    private int maxRider;        // 每轮最多可以搭乘的游客数量
    private int numOfCycles;     // 已经运行的轮数

    // ---------- 集合：等待队列（Part 3） ----------
    private Queue<Visitor> waitingLine;

    // ---------- 集合：游玩历史（Part 4A） ----------
    private LinkedList<Visitor> rideHistory;

    // ---------- 构造方法 ----------

    /**
     * 默认构造方法（作业要求必须有）。:contentReference[oaicite:2]{index=2}
     */
    public Ride() {
        this.numOfCycles = 0;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    /**
     * 带参数构造方法，设置所有基本字段。
     */
    public Ride(String name, String type, double minHeight,
                Employee operator, int maxRider) {
        this(); // 调用默认构造，确保队列和历史都初始化
        this.name = name;
        this.type = type;
        this.minHeight = minHeight;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // ---------- Getter / Setter ----------

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

    // （可选）暴露只读的历史列表，用于 Part 4B 排序时使用
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    // ---------- Part 3：等待队列相关实现 ----------

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Cannot add null visitor to the waiting line for " + name + ".");
            return;
        }
        waitingLine.offer(visitor);
        System.out.println("Visitor " + visitor.getFullName()
                + " joined the waiting line for " + name + ".");
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor removed = waitingLine.poll();
        if (removed == null) {
            System.out.println("No visitors in the waiting line for " + name + ".");
        } else {
            System.out.println("Visitor " + removed.getFullName()
                    + " left the waiting line for " + name + ".");
        }
        return removed;
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Waiting line for " + name + " is empty.");
            return;
        }
        System.out.println("Waiting line for " + name + ":");
        int index = 0;
        for (Visitor v : waitingLine) {
            System.out.println("[" + index + "] " + v);
            index++;
        }
    }

    // ---------- Part 4A：游玩历史（LinkedList + Iterator） ----------

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Cannot add null visitor to ride history for " + name + ".");
            return;
        }
        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getFullName()
                + " added to ride history of " + name + ".");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Cannot check null visitor in ride history for " + name + ".");
            return false;
        }
        boolean found = rideHistory.contains(visitor);
        if (found) {
            System.out.println("Visitor " + visitor.getFullName()
                    + " IS in ride history of " + name + ".");
        } else {
            System.out.println("Visitor " + visitor.getFullName()
                    + " is NOT in ride history of " + name + ".");
        }
        return found;
    }

    @Override
    public int numberOfVisitors() {
        int size = rideHistory.size();
        System.out.println("Number of visitors in ride history of "
                + name + ": " + size);
        return size;
    }

    /**
     * 使用 Iterator 打印 —— 作业明确要求。:contentReference[oaicite:3]{index=3}
     */
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in ride history for " + name + ".");
            return;
        }

        System.out.println("Ride history for " + name + ":");
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            System.out.println("[" + index + "] " + v);
            index++;
        }
    }

    // ---------- Part 5：runOneCycle（暂时留空，下一次提交实现） ----------

    @Override
    public void runOneCycle() {
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



