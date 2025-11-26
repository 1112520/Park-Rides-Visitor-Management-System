/**
 * Ride 的接口，定义了等待队列、历史记录和运行一轮等操作。
 * 对应作业 Part 2 中的接口要求。
 */
public interface RideInterface {

    // Part 3：排队队列
    void addVisitorToQueue(Visitor visitor);

    Visitor removeVisitorFromQueue();

    void printQueue();

    // Part 4A：历史记录
    void addVisitorToHistory(Visitor visitor);

    boolean checkVisitorFromHistory(Visitor visitor);

    int numberOfVisitors();

    void printRideHistory();

    // Part 5：运行一轮
    void runOneCycle();
}

