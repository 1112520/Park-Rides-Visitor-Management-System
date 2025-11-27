import java.util.LinkedList;
import java.util.Queue;

/**
 * 主题公园中的游乐项目。
 * 实现 RideInterface，并增加游客等待队列的管理。
 */
public class Ride implements RideInterface {

    private String name;
    private String type;
    private double minHeight;
    private Employee operator;
    private int maxRider;
    private int numOfCycles;

    // 队列管理：用 LinkedList 实现 Queue
    private Queue<Visitor> waitingLine;

    public Ride(String name, String type, double minHeight,
                Employee operator, int maxRider) {
        this.name = name;
        this.type = type;
        this.minHeight = minHeight;
        this.operator = operator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.waitingLine = new LinkedList<>(); // 初始化等待队列
    }

    // ----------------- Getter / Setter -----------------

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

    // ----------------- 队列管理方法 -----------------

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Cannot add null visitor to the queue.");
        } else {
            waitingLine.offer(visitor);
            System.out.println(visitor.getFullName() + " added to the waiting line.");
        }
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor removedVisitor = waitingLine.poll();
        if (removedVisitor == null) {
            System.out.println("No visitors in the queue.");
        } else {
            System.out.println(removedVisitor.getFullName() + " removed from the waiting line.");
        }
        return removedVisitor;
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Current waiting line:");
            for (Visitor v : waitingLine) {
                System.out.println("- " + v.getFullName());
            }
        }
    }

    // ----------------- RideInterface 方法 -----------------

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // 留待后续实现
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // 留待后续实现
        return false;
    }

    @Override
    public int numberOfVisitors() {
        // 留待后续实现
        return 0;
    }

    @Override
    public void printRideHistory() {
        // 留待后续实现
    }

    @Override
    public void runOneCycle() {
        // 留待后续实现
    }

    @Override
    public String toString() {
        return "Ride{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", minHeight=" + minHeight +
                ", operator=" + operator.getFullName() +
                ", maxRider=" + maxRider +
                ", numOfCycles=" + numOfCycles +
                '}';
    }
}


