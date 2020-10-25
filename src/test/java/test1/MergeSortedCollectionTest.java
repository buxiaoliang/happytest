package test1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MergeSortedCollectionTest {

    @Test
    void merge() {
        ListNode node1 = new ListNode();
        node1.setValue("April");
        ListNode node2 = new ListNode();
        node2.setValue("May");
        ListNode node3 = new ListNode();
        node3.setValue("June");
        List list = new ArrayList();
        list.add(node1);
        list.add(node2);
        list.add(node3);


        ListNode vnode1 = new ListNode();
        vnode1.setValue("Apri");
        ListNode vnode2 = new ListNode();
        vnode2.setValue("Ma");
        ListNode vnode3 = new ListNode();
        vnode3.setValue("Jun");
        List vlist = new ArrayList();
        vlist.add(vnode1);
        vlist.add(vnode2);
        vlist.add(vnode3);

        MergeSortedCollection mergeSortedCollection = new MergeSortedCollection();
        List<ListNode> result = mergeSortedCollection.merge(list, vlist);
        for (ListNode node : result) {
            System.out.println(node.getValue());
        }
    }
}