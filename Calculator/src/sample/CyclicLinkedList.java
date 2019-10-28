package sample;

class CyclicLinkedList {
  private int size = 0;
  private Node start;
  Node end;
  private Node finalStart;
  private Node finalEnd;

  public static class Node{
    private String data;
    Node next;
    Node previous;

    Node(String data){
      this.data=data;
    }

    String getData(){
      return data;
    }

    @Override
    public String toString() {
      return getData();
    }
  }

  void addNode(String data){
    //There is only a need to be able to add notes to the end of the list,
    // as we will only be accessing this list from one end, for the calculator at least.
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
    if(!(end==finalStart)){
      end.next = temp;
      start = end;
      end = end.previous;
    }
  }

  void moveStartToEnd(){
    Node temp = end;
    if (!(start == finalEnd)){
      start.previous = temp;
      end = start;
      start = start.next;
    }
  }
}
