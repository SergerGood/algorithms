package homework.MergeSortRecursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeSortRecursionTest {

    static Stream<Arguments> providerMergeTwoListsTest() {
        var l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        var l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        return Stream.of(
                Arguments.of(l1, l2, 6),
                Arguments.of(null, new ListNode(5), 1),
                Arguments.of(null, null, 0)
        );
    }

    static Stream<Arguments> providerMergeThreeListsTest() {
        var l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        var l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        var l3 = new ListNode(2);
        l3.next = new ListNode(4);
        l3.next.next = new ListNode(6);

        return Stream.of(
                Arguments.of(l1, l2, l3, 9),
                Arguments.of(null, new ListNode(5), null, 1),
                Arguments.of(new ListNode(1), new ListNode(5), null, 2),
                Arguments.of(null, null, null, 0)
        );
    }

    static private boolean isSorted(ListNode head)
    {
        if (head == null || head.next == null)
            return true;
        return (head.val <= head.next.val && isSorted(head.next));
    }

    static private int getListLength(ListNode node)
    {
        if (node == null) return 0;
        return 1 + getListLength(node.next);
    }

    @DisplayName("Merge 2 sorted LinkedList")
    @ParameterizedTest
    @MethodSource("providerMergeTwoListsTest")
    void possibleMessagesTest(ListNode l1, ListNode l2, int size) {
        var actual = MergeSortRecursion.mergeTwoLists(l1, l2);

        assertTrue(isSorted(actual));
        assertEquals(size, getListLength(actual));
    }

    @DisplayName("Merge 3 sorted LinkedList")
    @ParameterizedTest
    @MethodSource("providerMergeThreeListsTest")
    void possibleMessagesTest(ListNode l1, ListNode l2, ListNode l3, int size) {
        var actual = MergeSortRecursion.mergeThreeLists(l1, l2, l3);

        assertTrue(isSorted(actual));
        assertEquals(size, getListLength(actual));
    }
}
