import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 主题公园中的游乐项目。
 * 实现 RideInterface，包含：
 * - 等待队列（Queue<Visitor> waitingLine） —— Part 3
 * - 游玩历史（LinkedList<Visitor> rideHistory） —— Part 4A/4B
 * - 运行一轮游乐项目 —— Part 5
 * - 导入导出历史记录 —— Part 6/7
 */
public class Ride implements RideInterface {

    // ---------- 基本属性（Part 1） ----------
    private String name;         // 项目名称，例如 "Super Coaster"
    private String type;         // 项目类型，例如 "Roller Coaster"
    private double minHeight;    // 最低身高限制（米）
    private Employee operator;   // 负责操作该项目的员工

    // ---------- 运行属性（Part 5） ----------
    private int maxRider;        // 每轮最多可以搭乘的游客数量
    private int numOfCycles;     // 已经运行的轮数

    // ---------- 集合：等待队列（Part 3） ----------
    private Queue<Visitor> waitingLine;

    // ---------- 集合：游玩历史（Part 4A/4B） ----------
    private LinkedList<Visitor> rideHistory;

    // ---------- 构造方法 ----------

    /**
     * 默认构造方法（作业要求必须有）
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

    /**
     * 只读访问 rideHistory，用于排序和演示
     */
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
     * 使用 Iterator 打印历史记录（作业明确要求）
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

    // ---------- Part 4B：排序历史记录 ----------

    /**
     * 使用给定的 Comparator 对历史记录排序。
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.isEmpty()) {
            System.out.println("Cannot sort ride history for " + name + " because it is empty.");
            return;
        }
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history for " + name + " has been sorted.");
    }

    // ---------- Part 5：运行一轮游乐项目 ----------

    @Override
    public void runOneCycle() {
        // 从等待队列中取出最多 maxRider 个游客，加入历史记录
        if (operator == null) {
            System.out.println("Cannot run " + name + " because there is no operator assigned.");
            return;
        }
        if (waitingLine.isEmpty()) {
            System.out.println("Cannot run " + name + " because there are no waiting visitors.");
            return;
        }
        if (maxRider <= 0) {
            System.out.println("Cannot run " + name + " because maxRider is not set properly.");
            return;
        }

        int ridersThisCycle = Math.min(maxRider, waitingLine.size());
        System.out.println("Running one cycle of " + name
                + " for " + ridersThisCycle + " visitors.");

        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor v = waitingLine.poll();
            if (v != null) {
                addVisitorToHistory(v);
            }
        }

        numOfCycles++;
        System.out.println(name + " has now run " + numOfCycles + " cycle(s).");
    }

    // ---------- Part 6：导出历史记录到 CSV 文件 ----------

    /**
     * 将 rideHistory 导出为简单的 CSV 文件。
     * 每行格式：id,fullName,age,ticketType,fastPass
     */
    public void exportRideHistory(String fileName) {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in ride history of " + name + " to export.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // 写表头（可选）
            writer.write("id,fullName,age,ticketType,fastPass");
            writer.newLine();

            for (Visitor v : rideHistory) {
                String line = String.format("%s,%s,%d,%s,%b",
                        v.getId(),
                        v.getFullName(),
                        v.getAge(),
                        v.getTicketType(),
                        v.isFastPass());
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Ride history for " + name + " has been exported to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting ride history to file: " + e.getMessage());
        }
    }

    // ---------- Part 7：从 CSV 文件导入历史记录 ----------

    /**
     * 从 CSV 文件导入 rideHistory，文件格式需与 exportRideHistory 输出一致。
     * 导入前会清空当前历史记录。
     */
    public void importRideHistory(String fileName) {
        rideHistory.clear(); // 先清空当前历史

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine(); // 先读掉表头

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length != 5) {
                    System.out.println("Invalid line in file, skipped: " + line);
                    continue;
                }

                String id = parts[0];
                String fullName = parts[1];
                int age;
                try {
                    age = Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age value for line, skipped: " + line);
                    continue;
                }
                String ticketType = parts[3];
                boolean fastPass = Boolean.parseBoolean(parts[4]);

                Visitor v = new Visitor(id, fullName, age, ticketType, fastPass);
                addVisitorToHistory(v);
            }

            System.out.println("Ride history for " + name + " has been imported from file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error importing ride history from file: " + e.getMessage());
        }
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