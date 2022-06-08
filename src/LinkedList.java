import java.util.ArrayList;

public class LinkedList {
    private ListNode head;

    public LinkedList(ArrayList<Pupil> reg){
        ListNode n = new ListNode(reg.get(0));
        head = n;
        for (int i =  1 ; i < reg.size(); i++){
            n.next = new ListNode(reg.get(i));
            n = n.next;
        }
    }

    public ListNode getHead() {
        return head;
    }

    public void AddItem(Pupil p){
        ListNode item = new ListNode(p);
        if (head == null) {
            head = item ;
        } else {
            // walk the list to the end
            ListNode current = head;
            ListNode previous = null;
            while (current != null) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(item);
        }
    }



}
