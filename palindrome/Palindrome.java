package week2;
class Node{
    String data;
    Node next;

    Node(String value)
    {
        data=value;
        next=null;
    }
}
public class Palindrome {
    Node head;
    
    public void addElement(Node node){
        if(head==null)
        {
            head=node;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=node;
        return;
    }

    public void printElement(Node node){
        Node temp=node;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println("");
    }

   public static boolean listCopmare(Node head, Node head2){
    while(head!=null || head2!=null)
        {
            if(head.data!=head2.data)
                return false;
           
            head=head.next;
            head2= head2.next;
           
        }
        return true;
   }
   private static Node reverseList(Node head) {
        Node prev=null,next=null,curr=head;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static boolean isPalindrome(Node head){
        Node slow= head, fast=head, mid=null;
        if(slow.next==null)
            return true ;
        while(fast!=null && fast.next!=null)
        {   fast=fast.next.next;
            //even number list
            if(fast==null)
            {    
                mid= slow.next;
                break;
            }
            //odd number list
            if(fast.next==null)
            {
                mid=slow.next.next;
                break;
            }

            slow=slow.next;
        }
            slow.next=null;

        Node reverseHead2= reverseList(mid);
        return listCopmare(head, reverseHead2);
      
    }

    public static void main(String[] args) {
        Palindrome ll= new Palindrome();
        Node head = new Node("jo");
        ll.addElement(head);
        ll.addElement(new Node("jo"));  
        ll.addElement(new Node("is"));
        ll.addElement(new Node("is"));
        ll.addElement(new Node("jo"));
        ll.addElement(new Node("jo"));
     
        ll.printElement(head);
        if(isPalindrome(head))
            System.out.println("is palindrome");
        else
            System.out.println("not palindrome");
        
    }
}
