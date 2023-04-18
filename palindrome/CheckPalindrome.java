package week2;

import java.util.LinkedList;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        LinkedList<String> ll= new LinkedList<>();
        ll.add("hi");
        ll.add("is");
        ll.add("is");
        ll.add("hello");

        int count= ll.size();
        Stack<String> s= new Stack<>();

        for(int i=0;i<count;i++)
        {
            s.add(ll.get(i));
        }

        for(int i=0;i<count;i++)
        {
            String element= s.peek();
            if(ll.get(i) == element)
            {
                s.pop();
            }
            else
                break;
          
        }
        System.out.println(ll);
        if(s.isEmpty())
            System.out.println("is palindrome");
        else
            System.out.println("not palindrome");

    }
}
