public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("Park Rides Visitor Management System initialised.");

        // 按作业要求：在 main 里创建 AssignmentTwo 对象，然后依次调用各个 part 方法
        AssignmentTwo demo = new AssignmentTwo();
        demo.partThree();
        demo.partFourA();
        demo.partFourB();
        demo.partFive();   // Part 5：runOneCycle 演示
        demo.partSix();    // Part 6：导出 CSV
        demo.partSeven();  // Part 7：导入 CSV
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
     * Part 5：演示 runOneCycle 的行为：
     *  - 创建一个 Ride，设置 maxRider
     *  - 向等待队列加入多于一轮的游客（例如 7 个，maxRider=3）
     *  - 连续运行几轮，观察队列与历史记录的变化
     */
    public void partFive() {
        System.out.println("\n===== Part 5: Demonstrating runOneCycle =====");

        Employee operator = new Employee("E301", "Nina Operator", 32,
                "Ride Operator", 31.5);

        // maxRider 设为 3，这样一轮最多 3 人
        Ride ride = new Ride("Thunder Drop", "Free Fall",
                1.3, operator, 3);

        // 向队列添加 7 个游客
        ride.addVisitorToQueue(new Visitor("C001", "Tom Rider",    19, "Adult",  true));
        ride.addVisitorToQueue(new Visitor("C002", "Bella Rider",  21, "Adult",  false));
        ride.addVisitorToQueue(new Visitor("C003", "Chris Rider",  16, "Teen",   true));
        ride.addVisitorToQueue(new Visitor("C004", "Dora Rider",   11, "Child",  false));
        ride.addVisitorToQueue(new Visitor("C005", "Ethan Rider",  35, "Adult",  false));
        ride.addVisitorToQueue(new Visitor("C006", "Fiona Rider",  28, "Adult",  true));
        ride.addVisitorToQueue(new Visitor("C007", "George Rider", 14, "Teen",   false));

        System.out.println("Initial waiting line:");
        ride.printQueue();

        // 第一轮
        System.out.println("\n-- Running first cycle --");
        ride.runOneCycle();
        System.out.println("Waiting line after first cycle:");
        ride.printQueue();
        System.out.println("Ride history after first cycle:");
        ride.printRideHistory();

        // 第二轮
        System.out.println("\n-- Running second cycle --");
        ride.runOneCycle();
        System.out.println("Waiting line after second cycle:");
        ride.printQueue();
        System.out.println("Ride history after second cycle:");
        ride.printRideHistory();

        // 第三轮（可能此时队列不足一整轮）
        System.out.println("\n-- Running third cycle --");
        ride.runOneCycle();
        System.out.println("Waiting line after third cycle:");
        ride.printQueue();
        System.out.println("Ride history after third cycle:");
        ride.printRideHistory();
    }

    // ------------------- Part 6：导出历史记录到 CSV -------------------

    /**
     * Part 6：演示 exportRideHistory：
     *  - 创建一个 Ride
     *  - 向历史记录添加若干游客
     *  - 调用 exportRideHistory("rideHistory.csv")
     */
    public void partSix() {
        System.out.println("\n===== Part 6: Exporting ride history to CSV =====");

        Employee operator = new Employee("E401", "Oscar Operator", 29,
                "Ride Operator", 29.0);

        Ride ride = new Ride("Ocean Spin", "Family Ride",
                1.1, operator, 5);

        // 准备一些已经玩过的游客
        ride.addVisitorToHistory(new Visitor("H101", "Alice Ocean", 26, "Adult",  true));
        ride.addVisitorToHistory(new Visitor("H102", "Bob Ocean",    7, "Child",  false));
        ride.addVisitorToHistory(new Visitor("H103", "Cindy Ocean", 34, "Adult",  false));
        ride.addVisitorToHistory(new Visitor("H104", "David Ocean", 15, "Teen",   true));

        System.out.println("Current ride history before export:");
        ride.printRideHistory();

        String filePath = "rideHistory.csv";
        ride.exportRideHistory(filePath);
    }

    // ------------------- Part 7：从 CSV 导入历史记录 -------------------

    /**
     * Part 7：演示 importRideHistory：
     *  - 创建一个新的 Ride（历史记录为空）
     *  - 调用 importRideHistory("rideHistory.csv")
     *  - 打印导入后的历史记录
     *
     * 注意：需要先在 Part 6 中成功导出 rideHistory.csv 文件。
     */
    public void partSeven() {
        System.out.println("\n===== Part 7: Importing ride history from CSV =====");

        Employee operator = new Employee("E402", "Paula Operator", 27,
                "Ride Operator", 28.0);

        Ride ride = new Ride("Ocean Spin (Imported)", "Family Ride",
                1.1, operator, 5);

        String filePath = "rideHistory.csv";
        ride.importRideHistory(filePath);

        System.out.println("Ride history after import:");
        ride.printRideHistory();
        ride.numberOfVisitors();
    }
}
