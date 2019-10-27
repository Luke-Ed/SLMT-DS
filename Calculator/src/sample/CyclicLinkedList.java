package sample;

public class CyclicLinkedList {
  public int size = 0;
  public Node start;
  public Node end;

  public static class Node{
    String data;
    Node next;
    Node previous;
    public Node(String data){
      this.data=data;
    }
  }

  public void addNode(String data){
    //There is only a need to be able to add notes to the end of the list, as we will only be accessing this list from one end.
    Node NewNode = new Node(data);
    if (size == 0){
      start = NewNode;
      end = NewNode;
      NewNode.next = end;
      NewNode.previous = start;
    }
    else {
      end.next = NewNode;
      NewNode.previous = end;
    }
  }
}
