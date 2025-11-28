public class TestRunner {

    public static void main(String[] args) {
        // 依次运行两个简单测试
        SimpleTest.main(args);
        VisitorComparatorTest.main(args);
        System.out.println("All manual tests finished.");
    }
}
