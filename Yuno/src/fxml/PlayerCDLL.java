package fxml;

public class PlayerCDLL {
  private int size = 0;
  private Node start;
  private Node end;


  public static class Node{
    private Player player;
    Node next;
    Node previous;

    Node(Player player){
      this.player = player;
    }
    Player getPlayer(){
      return player;
    }
    String getPlayerName(){
      return player.getName();
    }
  }

  void addNode(Player player){
    Node NewNode = new Node(player);
    if (size==0){
      start = NewNode;
      end = NewNode;
      NewNode.next = end;
      NewNode.previous = start;
      start.previous = end;
    }
    else {
      end.next = NewNode;
      NewNode.previous = end;
      end = NewNode;
      end.next = start;
      start.previous = end;
    }
    size++;
  }

  int getSize(){
    return size;
  }

  Node getStart(){
    return start;
  }
}

