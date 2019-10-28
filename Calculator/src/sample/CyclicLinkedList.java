package sample;

public class CyclicLinkedList {
  private int size = 0;
  public Node start;
  public Node end;
  private Node finalStart;
  private Node finalEnd;

  public int getSize() {
    return size;
  }

  public static class Node{
    private String data;
    Node next;
    Node previous;
    public Node(String data){
      this.data=data;
    }
    public String getData(){
      return data;
    }
    @Override
    public String toString() {
      return getData();
    }
  }

  public void addNode(String data){
    //There is only a need to be able to add notes to the end of the list, as we will only be accessing this list from one end.
    Node NewNode = new Node(data);
    if (size == 0){
      start = NewNode;
      end = NewNode;
      finalStart = NewNode;
      finalEnd = NewNode;
      NewNode.next = end;
      NewNode.previous = start;
      size++;
    }
    else {
      end.next = NewNode;
      NewNode.previous = end;
      end = NewNode;
      finalEnd = NewNode;
      end.next = start;
      size++;
    }
  }
  void moveEndToStart(){
    Node temp = start;
    if(end==finalStart){
      return;
    }
    else {
      end.next = temp;
      start = end;
      end = end.previous;
    }
  }
  void moveStartToEnd(){
    Node temp = end;
    if (start == finalEnd){
      return;
    }
    else {
      start.previous = temp;
      end = start;
      start = start.next;
    }
  }
}
