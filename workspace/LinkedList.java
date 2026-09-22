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
    ListNode node;

    if (temp == null){
      head = new ListNode(line, null);
    }
    else if (temp.getNext() == null){
      if (line.compareTo(temp.getNext().getValue()) < 0){
        head.setValue(line);
        node = temp;
      }
    }

    line.compareTo(temp.getNext().getValue())

  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    return null;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
  
    String vals = "";
    ListNode node = head.getNext();

    vals = vals + head.getValue() + " ";

    while (node.getNext() != null){
      vals = vals + node.getValue() + " ";
      node = node.getNext();
    }

    return vals;
    

  }

  //precondition: the list has been initialized
  
  //postconditions: clears the list.
  public void clear()
  {
  
  }
}
