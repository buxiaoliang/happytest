package test1;

public class ListNode implements Comparable {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int compareTo(Object o) {
        ListNode node = (ListNode) o;
        return value.compareTo(node.value);
    }

}
