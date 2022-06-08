public class ListNode {
    Pupil value;
    ListNode next;

    ListNode(Pupil p) {
        value = p;
        next = null;
    }
    public void setNext(ListNode n) {
        next = n;
    }

    public ListNode getNext() {
        return next;
    }
    public void display(){
        System.out.println(value.getFirstName());
    }
}
