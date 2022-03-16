package question432;

import java.util.TreeMap;

/**
 * @author Dell
 */
public class Question432 {
    public static void main(String[] args) {
        TreeMap<String, Integer> tree = new TreeMap<>();
        tree.put("b", 2);
        tree.put("a", 6);
        tree.put("c", 3);
        tree.put("d", 4);
        System.out.println(tree.lastKey());
        System.out.println(tree.firstKey());
    }
}
