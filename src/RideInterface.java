/**
 * The interface of Ride defines operations such as waiting queues, history records, and running a round.
 * Corresponds to the interface requirements in Assignment Part 2.
 */
public interface RideInterface {

    // Part 3: Waiting Queue
    void addVisitorToQueue(Visitor visitor);

    Visitor removeVisitorFromQueue();

    void printQueue();

    // Part 4A: Ride History
    void addVisitorToHistory(Visitor visitor);

    boolean checkVisitorFromHistory(Visitor visitor);

    int numberOfVisitors();

    void printRideHistory();

    // Part 5: Running One Cycle
    void runOneCycle();
}

