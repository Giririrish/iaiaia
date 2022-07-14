import java.util.ArrayList;

public class LinkedList {
    private ListNode head;

    public LinkedList(Register reg){
        ListNode n = new ListNode(reg.getPupil(0));
        head = n;
        for (int i =  1 ; i < reg.getSize(); i++){
            n.next = new ListNode(reg.getPupil(i));
            n = n.next;
        }
    }

    public ListNode getHead() {
        return head;
    }
    public void setHead(Pupil p){
        ListNode h = new ListNode(p);
        ListNode temp = head;
        head = h;
        h.setNext(temp);
    }
    public void addItem(Pupil p){
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
    public void add(Pupil p , int index){
        ListNode pupil = new ListNode(p);
        ListNode current = head;
        ListNode previous = null;
        for(int i = 0 ; i < index ; i++){ //if the construct is offset put -1 here
            previous = current;
            current = current.getNext();
        }
        previous.setNext(pupil);
        pupil.setNext(current);
    }
    public int Size(){
        int sizeCounter = 0;
        ListNode n = head;
        while(n.getNext() != null){
            sizeCounter++;
            n = n.getNext();
        }
        return  sizeCounter;
    }
    public void DisplayAll(){
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            previous = current;
            current = current.getNext();
            previous.display();
        }
    }

}
