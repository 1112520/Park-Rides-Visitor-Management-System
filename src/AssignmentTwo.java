public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("Park Rides Visitor Management System initialised.\n");

        AssignmentTwo a2 = new AssignmentTwo();
        a2.partThree();
        a2.partFourA();
        a2.partFourB();
        a2.partFive();
        a2.partSix();
        a2.partSeven();
    }

    // ------------------- Part 3：队列演示 -------------------

    /**
     * Part 3：等待队列（Queue）演示。
     * 在方法内部创建 Ride 和 Visitors，展示：
     *  - 向队列中添加至少 5 个游客
     *  - 移除队首一个游客
     *  - 打印队列
     */
    public void partThree() {
        System.out.println("\n===== Part 3: Demonstrating Visitor Queue =====");

        // 创建一个员工和一个项目
        Employee operator = new Employee("E001", "Alice Operator", 30,
                "Ride Operator", 30.0);

        Ride ride = new Ride("Super Coaster", "Roller Coaster",
                1.4, operator, 4);

        // 创建至少 5 个游客并加入队列
        Visitor v1 = new Visitor("Q001", "Bob Visitor", 20, "Adult", true);
        Visitor v2 = new Visitor("Q002", "Charlie Visitor", 25, "Adult", false);
        Visitor v3 = new Visitor("Q003", "Daisy Visitor", 16, "Child", false);
        Visitor v4 = new Visitor("Q004", "Eric Visitor", 35, "VIP", false);
        Visitor v5 = new Visitor("Q005", "Frank Visitor", 28, "Adult", true);

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        System.out.println("Queue after adding visitors:");
        ride.printQueue();

        // 移除队首一个游客
        ride.removeVisitorFromQueue();

        System.out.println("Queue after removing one visitor:");
        ride.printQueue();
    }

    // ------------------- Part 4A：历史记录演示 -------------------

    /**
     * Part 4A：历史记录（LinkedList + Iterator）演示。
     * 在方法内部创建 Ride 和 Visitors，展示：
     *  - 向历史记录中添加至少 5 个游客
     *  - 检查某个游客是否在历史记录中
     *  - 打印历史记录中的游客数量
     *  - 使用 Iterator 打印历史记录
     */
    public void partFourA() {
        System.out.println("\n===== Part 4A: Demonstrating Ride History (LinkedList + Iterator) =====");

        Employee operator = new Employee("E101", "Olivia Operator", 29,
                "Ride Operator", 32.0);

        Ride ride = new Ride("River Rapids", "Water Ride",
                1.2, operator, 6);

        // 至少 5 个乘坐过该项目的游客
        Visitor v1 = new Visitor("H001", "Henry Visitor", 22, "Adult", false);
        Visitor v2 = new Visitor("H002", "Ivy Visitor", 18, "Student", false);
        Visitor v3 = new Visitor("H003", "Jack Visitor", 30, "Adult", true);
        Visitor v4 = new Visitor("H004", "Kelly Visitor", 12, "Child", false);
        Visitor v5 = new Visitor("H005", "Leo Visitor", 40, "VIP", true);

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("Ride history (original insertion order):");
        ride.printRideHistory();    // 要求：必须用 Iterator 打印（在 Ride 类里已经实现）

        // 打印历史记录中的游客数量
        ride.numberOfVisitors();

        // 检查某个游客是否在历史记录中（这里检查 v3）
        ride.checkVisitorFromHistory(v3);
    }

    // ------------------- Part 4B：多字段排序演示 -------------------

    /**
     * Part 4B：使用 Comparator 对历史记录进行多字段排序。
     * 要求：
     *  - 使用实现 Comparator 接口的 VisitorComparator
     *  - 在 Ride 类中提供 sortRideHistory(Comparator) 方法并在此处调用
     *  - 排序前后各打印一次历史记录
     */
    public void partFourB() {
        System.out.println("\n===== Part 4B: Sorting Ride History with VisitorComparator (multi-field) =====");

        Employee operator = new Employee("E201", "Peter Operator", 33,
                "Ride Operator", 31.0);

        Ride ride = new Ride("Galaxy Spinner", "Thrill Ride",
                1.3, operator, 8);

        // 构造一组有明显差异的游客，方便观察排序结果
        Visitor v1 = new Visitor("S001", "Alice",   25, "Adult",   false);
        Visitor v2 = new Visitor("S002", "Bob",     20, "Adult",   true);
        Visitor v3 = new Visitor("S003", "Charlie", 15, "Child",   false);
        Visitor v4 = new Visitor("S004", "Daisy",   30, "VIP",     true);
        Visitor v5 = new Visitor("S005", "Eve",     18, "Student", false);

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("Ride history BEFORE sorting:");
        ride.printRideHistory();

        // 在 Ride 中使用 Collections.sort(list, comparator)
        ride.sortRideHistory(new VisitorComparator());

        System.out.println("\nRide history AFTER sorting (according to VisitorComparator):");
        ride.printRideHistory();
    }

    // ------------------- Part 5：runOneCycle 演示 -------------------

    /**
     * Part 5：演示 runOneCycle 的行为
     * 按照作业要求创建10个Visitor并演示完整流程
     */
    public void partFive() {
        System.out.println("\n===== Part 5: Demonstrating runOneCycle =====");

        Employee op = new Employee("E100", "Operator One", 30,
                "Ride Operator", 5); // 按你自己的 Employee 构造器来
        Ride ride = new Ride("Cyclone", "Roller Coaster", 1.2, op, 4); 
        // maxRider = 4，表示每轮最多 4 人

        // 1. 加 10 个游客进队列
        ride.addVisitorToQueue(new Visitor("P001", "Visitor 1", 20, "Adult", false));
        ride.addVisitorToQueue(new Visitor("P002", "Visitor 2", 22, "Adult", true));
        ride.addVisitorToQueue(new Visitor("P003", "Visitor 3", 11, "Child", false));
        ride.addVisitorToQueue(new Visitor("P004", "Visitor 4", 35, "Adult", false));
        ride.addVisitorToQueue(new Visitor("P005", "Visitor 5", 28, "Adult", true));
        ride.addVisitorToQueue(new Visitor("P006", "Visitor 6", 17, "Student", false));
        ride.addVisitorToQueue(new Visitor("P007", "Visitor 7", 40, "VIP", true));
        ride.addVisitorToQueue(new Visitor("P008", "Visitor 8", 15, "Child", false));
        ride.addVisitorToQueue(new Visitor("P009", "Visitor 9", 19, "Student", false));
        ride.addVisitorToQueue(new Visitor("P010", "Visitor 10", 27, "Adult", false));

        System.out.println("\nQueue BEFORE running one cycle:");
        ride.printQueue();

        // 2. 跑一轮
        System.out.println();
        ride.runOneCycle();

        // 3. 再打印队列和历史记录
        System.out.println("\nQueue AFTER running one cycle:");
        ride.printQueue();

        System.out.println("\nRide history AFTER running one cycle:");
        ride.printRideHistory();
    }

    // ------------------- Part 6：导出历史记录到 CSV -------------------

    /**
     * Part 6：演示 exportRideHistory
     */
    public void partSix() {
        System.out.println("\n===== Part 6: Export ride history to file =====");

        Employee op = new Employee("E200", "File Operator", 32,
                "Ride Operator", 4);
        Ride ride = new Ride("File Ride", "Water Ride", 1.0, op, 4);

        // 往历史里直接加至少 5 个游客
        ride.addVisitorToHistory(new Visitor("F001", "File Visitor 1", 21, "Adult", false));
        ride.addVisitorToHistory(new Visitor("F002", "File Visitor 2", 30, "Adult", true));
        ride.addVisitorToHistory(new Visitor("F003", "File Visitor 3", 16, "Student", false));
        ride.addVisitorToHistory(new Visitor("F004", "File Visitor 4", 12, "Child", false));
        ride.addVisitorToHistory(new Visitor("F005", "File Visitor 5", 40, "VIP", true));

        // 导出到当前工程目录下的一个 csv 文件
        String fileName = "ride_history.csv";
        ride.exportRideHistory(fileName);
    }

    // ------------------- Part 7：从 CSV 文件导入历史记录 -------------------

    /**
     * Part 7：演示 importRideHistory
     */
    public void partSeven() {
        System.out.println("\n===== Part 7: Import ride history from file =====");

        Employee op = new Employee("E201", "Import Operator", 29,
                "Ride Operator", 4);
        Ride ride = new Ride("Import Ride", "Family Ride", 1.1, op, 4);

        String fileName = "ride_history.csv"; // 要和 partSix 里保持一致

        ride.importRideHistory(fileName);

        System.out.println("\nNumber of visitors imported into ride history:");
        ride.numberOfVisitors();

        System.out.println("\nVisitors imported into ride history:");
        ride.printRideHistory();
    }
}