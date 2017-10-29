import javax.lang.model.type.TypeVisitor;
import javax.swing.text.NavigationFilter;
import java.util.*;

/**
 * Created by Дмитрий on 29.10.2017.
 */
public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static List newArrayList() {
        return new ArrayList();
    }

    public static <T> int indexOf(List<? super T> source, T o) {
        return source.indexOf(o);
    }

    public static <T extends Comparable<? super T>> List<T> limit(List<T> source, int size) {
        List<T> list = new ArrayList<>(source);
        Collections.sort(list);
        list.subList(0, size);
        return list;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        Set<? super T> s1 = new HashSet<>(c1);
        Set<? extends T> s2 = new HashSet<>(c2);
        s1.retainAll(s2);
        return !s1.isEmpty();
    }

    public static <T extends Comparable<T>> List<? super T> range(List<T> list, T min, T max) {
        NavigableSet<T> set = new TreeSet<>(list);
        List<T> list1 = new ArrayList<>(set.subSet(min, true, max, true));
        return list1;
    }

    public static <T> List<T> range(List<T> list, T min, T max, Comparator<T> comparator) {
        NavigableSet<T> set = new TreeSet<>(comparator);
        set.addAll(list);
        List<T> list1 = new ArrayList<>(set.subSet(min, true, max, true));
        return list1;
    }

    public static void main(String[] args) {
//        System.out.println(range(Arrays.asList(8, 1, 3, 5, 6, 4), 3, 6, Comparator.comparingInt(o -> o)));
        List<Integer> s1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> s2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> s3 = new ArrayList<>(Arrays.asList(1,21,31,14,15));
        System.out.println(containsAny(s1,s3));
    }
}
