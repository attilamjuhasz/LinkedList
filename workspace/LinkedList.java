// Attila Juhasz | 9/29/2026 | This is a linkedlist, where there is a head and each node points to the next node. You can do many things, like adding, clearing, removing, showing, removing, etc.

/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/

public class LinkedList{

  //instance varialbes go here (think about what you need to keep track of!)
  ListNode head;

  //constructors go here

  public LinkedList(){
    head = null;
  }

  public LinkedList(ListNode head){
    this.head = head;
  }


  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    ListNode temp = head;
    ListNode node = new ListNode (null, null);

    if (temp == null){
      head = new ListNode(line, null);
      return head;
    }

    else if (line.compareTo(head.getValue()) < 0){
      node.setValue(head.getValue());
      node.setNext(head.getNext());
      head.setValue(line);
      head.setNext(node);
      return head;
    }
    
    else{
      while ( temp.getNext()!= null  && line.compareTo(temp.getNext().getValue()) >= 0){
        temp = temp.getNext();
      }

      node.setValue(line);
      node.setNext(temp.getNext());
      temp.setNext(node);

      return node;

    }

  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {


    ListNode temp = head;
    ListNode temp2 = null;


    if (line.equals(head.getValue())){
      head = head.getNext();
      return head;
    }
    else{
      while (temp.getNext()!= null && !line.equals(temp.getValue())){
        temp2 = temp;
        temp = temp.getNext();
      }

      if (temp.getNext() == null && !line.equals(temp.getValue())){
        return temp;
      }

      else if (temp.getNext() == null){
        temp2.setNext(null);
      }

      else{
        temp2.setNext(temp.getNext());
      }
    }


    return temp2;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
  
    String vals = "";
    ListNode node = head;

    while (node != null){
      vals = vals + node.getValue() + " ";
      node = node.getNext();
    }

    return vals;
    

  }

  //precondition: the list has been initialized
  
  //postconditions: clears the list.
  public void clear()
  {
    head = null;
  }

  // Precondition: linkedlist is defined and inputted head is also defined
  // Postcondition: sets list's head to new head
  public void setHead(ListNode head){
    this.head = head;
  }

  // Precondition: linkedlist is defined and inputted head is also defined
  // Postcondition: returns list's head
  public ListNode getHead(){
    return head;
  }
  // Precondition: linkedlist is defined and inputted node is also defined
  // Postcondition: adds given node to the end of the list
  public void addToEnd(LinkedList list, ListNode added){
    ListNode node = list.getHead();

    if (node != null){
      while (node.getNext() != null){
        node = node.getNext();
      }

      node.setNext(added);
    }
    else{
      list.setHead(added);
    }
  }
  // Precondition: list is defined and has a head
  // Postcondition: reverses the list
  public LinkedList reverse(LinkedList list){
    
    ListNode prev = null;
    ListNode curr = list.getHead();
    ListNode next = list.getHead().getNext();

    while (curr != null){
      curr.setNext(prev);
      prev = curr;
      curr = next;
      next = next==null ? null : next.getNext();
      
    }
    System.out.println("done reversing");
    head = prev;

    return list;
  }
  // Precondition: list is defined and has a head
  // Postcondition: reverses the list in n sized chunks
public String nReverse(LinkedList original, int n){
  
  LinkedList listOne = new LinkedList(head);
  LinkedList listTwo = new LinkedList(head);
  ListNode headOfNext = head;
  ListNode tailOfCurrent = head;
  int i = 0;
  boolean donzo = false;

  while (headOfNext != null && !donzo){


    int l = 0;
    ListNode temp = headOfNext;
    while (temp != null){
      temp = temp.getNext();
      l++;
    }
    if (l < n){
      n = l;
    }

    ListNode check = headOfNext;
    int count = 0;

    while (check != null && count < n){
      check = check.getNext();
      count++;
    }

    if (count < n){
      if (i == 0){
        original.clear();
      }

      original.addToEnd(original, headOfNext);
      donzo = true;

    }

    else{
      listOne.setHead(headOfNext);
      tailOfCurrent = headOfNext;
      int k = n;

      while (k > 1){
        tailOfCurrent = tailOfCurrent.getNext();
        k--;
      }

      System.out.println("tailOfCurrent: " + tailOfCurrent.getValue());

      int j = n;
      while (j > 0){
        headOfNext = headOfNext.getNext();
        j--;
      }

      if (headOfNext == null){
        donzo = true;
      }

      else{
        System.out.println("headOfNext: " + headOfNext.getValue());
      }

      tailOfCurrent.setNext(null);


      listTwo.setHead(headOfNext);

      listOne = listOne.reverse(listOne);

      if (i == 0){
        original.clear();
      }

      original.addToEnd(original, listOne.getHead());

      System.out.println(listOne.showValues());
      tailOfCurrent = headOfNext;

      i++;

  }

  }

  return original.showValues();

}




}
// add a
// add b
// add c
// add d
// add e
// add f

