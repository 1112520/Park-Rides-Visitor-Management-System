/**
 * 主入口类，用于按部分演示各个功能。
 * 后续会在 partThree ~ partSeven 中补充演示代码。
 */
public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("Park Rides Visitor Management System initialised.");

        // 这里暂时只做一个简单的测试，验证类可以正常创建。
        Employee operator = new Employee("E001", "Alice Operator", 30,
                "Ride Operator", 30.0);

        Ride demoRide = new Ride("Super Coaster", "Roller Coaster",
                1.4, operator, 4);

        Visitor visitor = new Visitor("V001", "Bob Visitor", 20,
                "Adult", true);

        System.out.println(operator.getDescription());
        System.out.println(visitor.getDescription());
        System.out.println(demoRide);
    }

    // Part 3：队列演示（之后提交再实现）
    public void partThree() {
        // TODO: 在后续提交中实现本方法的演示逻辑（队列管理）
    }

    // Part 4A：历史记录演示
    public void partFourA() {
        // TODO: 在后续提交中实现本方法的演示逻辑（LinkedList + Iterator）
    }

    // Part 4B：排序演示
    public void partFourB() {
        // TODO: 在后续提交中实现本方法的演示逻辑（Comparator 排序）
    }

    // Part 5：runOneCycle 演示
    public void partFive() {
        // TODO: 在后续提交中实现本方法的演示逻辑（运行一轮）
    }

    // Part 6：导出文件演示
    public void partSix() {
        // TODO: 在后续提交中实现本方法的演示逻辑（exportRideHistory）
    }

    // Part 7：导入文件演示
    public void partSeven() {
        // TODO: 在后续提交中实现本方法的演示逻辑（importRideHistory）
    }
}
