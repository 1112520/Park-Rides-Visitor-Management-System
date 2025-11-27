public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("Park Rides Visitor Management System initialised.");

        // 创建员工和游客
        Employee operator = new Employee("E001", "Alice Operator", 30,
                "Ride Operator", 30.0);

        Ride demoRide = new Ride("Super Coaster", "Roller Coaster",
                1.4, operator, 4);

        Visitor visitor1 = new Visitor("V001", "Bob Visitor", 20,
                "Adult", true);
        Visitor visitor2 = new Visitor("V002", "Charlie Visitor", 25,
                "Adult", false);
        Visitor visitor3 = new Visitor("V003", "Dave Visitor", 22,
                "Child", false);

        // 演示添加游客到队列
        partThree(demoRide, visitor1, visitor2, visitor3);
    }

    // Part 3：队列演示
    public static void partThree(Ride ride, Visitor... visitors) {
        System.out.println("Part 3: Demonstrating Visitor Queue...");

        // 添加游客到队列
        for (Visitor v : visitors) {
            ride.addVisitorToQueue(v);
        }

        // 打印当前队列
        ride.printQueue();

        // 移除一个游客
        ride.removeVisitorFromQueue();

        // 打印队列
        ride.printQueue();
    }
}

