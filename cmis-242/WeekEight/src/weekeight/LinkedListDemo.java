
package weekeight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author rolandcarter
 */

import java.util.LinkedList;

public class LinkedListDemo {

   public static void main(String[] args) {

      LinkedList<String> llist=new LinkedList<>();

      llist.add("purple");
      llist.add("red");
      llist.add("green");
      llist.add("blue");
      llist.add("green");
      llist.add("yellow");

      System.out.println("Size:"+llist.size());
      System.out.println("Contents of the link list "+llist);

      llist.addFirst("Black");
      llist.addLast("White");

      System.out.println("Size:"+llist.size());
      System.out.println("Contents of the link list "+llist);

      llist.removeLast();
      
      System.out.println("Contents of the link list "+llist);
      
      llist.remove(2);
      
      System.out.println("Contents of the link list "+llist);

      System.out.println("Size:"+llist.size());
      System.out.println("Contents of the link list "+llist);
   }

}