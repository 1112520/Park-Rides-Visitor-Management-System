import java.util.Comparator;

/**
 * 用于对 Visitor 进行多字段排序的比较器（Part 4B）。
 *
 * 排序优先级：
 *  1) fastPass = true 的排在前面；
 *  2) ticketType 优先级：VIP -> Adult -> Child -> 其他；
 *  3) 年龄从大到小（年龄大的排前面）；
 *  4) fullName 按字母顺序升序（忽略大小写）。
 */
public class VisitorComparator implements Comparator<Visitor> {

    /**
     * 给不同的票种一个“排序权重”，值越小优先级越高。
     */
    private int ticketRank(String ticketType) {
        if (ticketType == null) {
            return Integer.MAX_VALUE; // 票种未知的排在最后
        }
        String t = ticketType.trim().toUpperCase();
        switch (t) {
            case "VIP":
                return 0;
            case "ADULT":
                return 1;
            case "CHILD":
                return 2;
            default:
                return 3;
        }
    }

    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 处理同一对象或 null 的情况
        if (v1 == v2) {
            return 0;
        }
        if (v1 == null) {
            return 1; // null 视为“最大”，排最后
        }
        if (v2 == null) {
            return -1;
        }

        // 1) fastPass 优先：有 fastPass 的排前面
        if (v1.isFastPass() && !v2.isFastPass()) {
            return -1;
        }
        if (!v1.isFastPass() && v2.isFastPass()) {
            return 1;
        }

        // 2) ticketType 优先级：VIP -> Adult -> Child -> 其他
        int t1 = ticketRank(v1.getTicketType());
        int t2 = ticketRank(v2.getTicketType());
        if (t1 != t2) {
            return Integer.compare(t1, t2);
        }

        // 3) 年龄从大到小（年龄大的在前）
        int ageCompare = Integer.compare(v2.getAge(), v1.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }

        // 4) 按 fullName 字母顺序升序（忽略大小写）
        String n1 = v1.getFullName();
        String n2 = v2.getFullName();
        if (n1 == n2) {
            return 0;
        }
        if (n1 == null) {
            return 1;
        }
        if (n2 == null) {
            return -1;
        }
        return n1.compareToIgnoreCase(n2);
    }
}

