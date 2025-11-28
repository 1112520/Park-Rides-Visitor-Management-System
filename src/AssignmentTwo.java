public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("Park Rides Visitor Management System initialised.");

        // 按作业要求：在 main 里创建 AssignmentTwo 对象，然后依次调用各个 part 方法
        AssignmentTwo demo = new AssignmentTwo();
        demo.partThree();
        demo.partFourA();
        demo.partFourB();

        // 下面三个 Part 会在后续提交中实现
        // demo.partFive();
        // demo.partSix();
        // demo.partSeven();
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

        // 这里不再在 AssignmentTwo 里直接操作 LinkedList，
        // 而是调用 Ride 中的排序方法，符合“在 Ride 中使用 Collections.sort(list, comparator)”的要求
        ride.sortRideHistory(new VisitorComparator());

        System.out.println("\nRide history AFTER sorting (according to VisitorComparator):");
        ride.printRideHistory();
    }

    // ------------------- 占位：Part 5 ~ Part 7 -------------------

    public void partFive() {
        // TODO: 在 Part 5 中实现 runOneCycle 的演示逻辑
    }

    public void partSix() {
        // TODO: 在 Part 6 中实现 exportRideHistory 的演示逻辑
    }

    public void partSeven() {
        // TODO: 在 Part 7 中实现 importRideHistory 的演示逻辑
    }
}

