import java.util.Comparator;

/**
 * 用于对 Visitor 进行排序的比较器。
 * 示例规则：
 *  1. fastPass 为 true 的排在前面
 *  2. 如果 fastPass 相同，则按年龄从大到小排序
 */
public class VisitorComparator implements Comparator<Visitor> {

    @Override
    public int compare(Visitor v1, Visitor v2) {
        if (v1 == v2) {
            return 0;
        }
        if (v1 == null) {
            return 1;
        }
        if (v2 == null) {
            return -1;
        }

        // 1. fastPass 为 true 的优先
        if (v1.isFastPass() && !v2.isFastPass()) {
            return -1;
        }
        if (!v1.isFastPass() && v2.isFastPass()) {
            return 1;
        }

        // 2. fastPass 相同，年龄大的排在前面
        return Integer.compare(v2.getAge(), v1.getAge());
    }
}
