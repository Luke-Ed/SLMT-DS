package sample;

public class CyclicLinkedList {
  private int size = 0;
  public Node start;
  public Node end;

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
  }

  public void addNode(String data){
    //There is only a need to be able to add notes to the end of the list, as we will only be accessing this list from one end.
    Node NewNode = new Node(data);
    if (size == 0){
      start = NewNode;
      end = NewNode;
      NewNode.next = end;
      NewNode.previous = start;
      size++;
    }
    else {
      end.next = NewNode;
      NewNode.previous = end;
      end = NewNode;
      end.next = start;
      size++;
    }
  }
  public void moveEndToHead(){
    Node temp = start;
    end.next = temp;
    start = end;
    end = end.previous;
  }
}
