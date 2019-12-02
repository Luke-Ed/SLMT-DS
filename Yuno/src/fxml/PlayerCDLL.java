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
  }
  void addNode(Player player){
    Node NewNode = new Node(player);
  }
}
