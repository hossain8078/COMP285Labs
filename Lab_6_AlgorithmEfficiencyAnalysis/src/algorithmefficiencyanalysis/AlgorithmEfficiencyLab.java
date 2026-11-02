/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algorithmefficiencyanalysis;

import java.util.Arrays;
import java.util.Random;
import algorithmefficiencyanalysis.collections.ArrayManager;
import algorithmefficiencyanalysis.collections.LinkedList;

/** Demonstrates the assignment and checks both implementations without JUnit. */
public class AlgorithmEfficiencyLab {
    private static int checks;
    public static void main(String[] args) {
        int[] sample = {1,3,4,5,3,4,3,4,1,2,5,6};
        ArrayManager array = new ArrayManager(sample);
        LinkedList list = new LinkedList(sample);
        System.out.println("Before: " + Arrays.toString(sample));
        array.removeAllOccurances(4);
        list.removeAllOccurances(4);
        System.out.println("ArrayManager: " + Arrays.toString(array.toArray()));
        System.out.println("LinkedList:   " + Arrays.toString(list.toArray()));
        check(sample, 4);
        check(new int[]{}, 4);
        check(new int[]{4}, 4);
        check(new int[]{1}, 4);
        check(new int[]{4,4,4,4}, 4);
        check(new int[]{4,4,1,4,4,2,4,4}, 4);
        check(new int[]{1,2,3}, 4);
        check(new int[]{0,4,0,-1,4}, 0);
        check(sample, null);
        check(sample, "4");
        check(sample, Long.valueOf(4));
        Random random = new Random(258);
        for (int test = 0; test < 1000; test++) {
            int[] data = new int[random.nextInt(60)];
            for (int i = 0; i < data.length; i++) data[i] = random.nextInt(7)-3;
            check(data, random.nextInt(7)-3);
        }
        LinkedList cursor = new LinkedList(new int[]{1,4,4,2});
        cursor.advance();
        cursor.removeAllOccurances(4);
        require(cursor.getCurrent() == 2, "cursor selects next survivor");
        cursor = new LinkedList(new int[]{1,4,4});
        cursor.advance(); cursor.removeAllOccurances(4);
        require(!cursor.hasCurrent(), "removed tail cursor becomes null");
        cursor = new LinkedList(new int[]{1,4,2});
        cursor.removeAllOccurances(4);
        require(cursor.getCurrent() == 1, "surviving cursor retained");
        cursor = new LinkedList(new int[]{4,4});
        cursor.removeAllOccurances(4); cursor.addAfter(9);
        require(cursor.getCurrent() == 9 && cursor.getSize() == 1, "reuse empty list");
        array = new ArrayManager(new int[]{4,4});
        array.removeAllOccurances(4); array.add(9);
        require(Arrays.equals(array.toArray(), new int[]{9}), "reuse empty array");
        System.out.println("PASS: " + checks + " checks, including 1000 randomized cases.");
    }
    private static void check(int[] data, Object target) {
        int[] expected = Arrays.stream(data)
            .filter(value -> !Integer.valueOf(value).equals(target)).toArray();
        ArrayManager array = new ArrayManager(data);
        LinkedList list = new LinkedList(data);
        array.removeAllOccurances(target); list.removeAllOccurances(target);
        require(Arrays.equals(expected, array.toArray()), "array contents");
        require(Arrays.equals(expected, list.toArray()), "list contents");
        require(array.size() == expected.length, "array size");
        require(list.getSize() == expected.length, "list size");
        array.removeAllOccurances(target); list.removeAllOccurances(target);
        require(Arrays.equals(expected, array.toArray()), "array repeated call");
        require(Arrays.equals(expected, list.toArray()), "list repeated call");
    }
    private static void require(boolean condition, String message) {
        checks++;
        if (!condition) throw new AssertionError(message);
    }
}

