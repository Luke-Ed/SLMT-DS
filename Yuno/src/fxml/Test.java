package fxml;

public class Test {
  public static void main(String[] args) {
//		testSingle();
    testTwo();
  }

  private static void testSingle() {
    System.out.println("Test single player");
    Deck deck = new Deck();
    deck.fill();
    Deck discard = new Deck();
    System.out.println("The deck size is "+deck.size());
    System.out.println("discard deck has "+ discard.size());
    Player Shelby = new Player("Shelby", deck, discard);
    System.out.println("fxml.Player's name is "+Shelby.getName());
    System.out.println("Their hand size is:\n"+ Shelby.getHand().size());
    //System.out.println("Their hand has:\n"+ Shelby.handToString());
    System.out.println("The deck size is "+deck.size());
    System.out.println("Draw card");
    Shelby.draw();
    System.out.println("Their hand size is:\n"+ Shelby.getHand().size());
    System.out.println("The deck size is "+deck.size());
    //System.out.println("New hand is "+ Shelby.handToString());
    discard.add(deck.draw());
    System.out.println("Discard size "+discard.size());
    System.out.println("The deck size is "+deck.size());
  }

  private static void testTwo() {
    System.out.println("Test two players");
    Deck deck = new Deck();
    deck.fill();
    Deck discard = new Deck();
    System.out.println("Initial deck size is "+deck.size());
    System.out.println("Initial discard has "+ discard.size());
    System.out.println("Build two players");
    Player Shelby = new Player("Shelby", deck, discard);
    System.out.println("p1 name is "+Shelby.getName());
    System.out.println("p1 hand size is:\n"+ Shelby.getHand().size());
    //System.out.println("p1 hand has:\n"+ Shelby.handToString());
    Player test2 = new Player("test2", deck, discard);
    System.out.println("p2 name is "+test2.getName());
    System.out.println("p2 hand size is:\n"+ test2.getHand().size());
    //System.out.println("p2 hand has:\n"+ test2.handToString());
    System.out.println("The deck size is "+deck.size());
    System.out.println("Draw cards");
    Shelby.draw();
    test2.draw();
    System.out.println("p1 hand size is:\n"+ Shelby.getHand().size());
    System.out.println("p2 hand size is:\n"+ test2.getHand().size());
    System.out.println("The deck size is "+deck.size());
    //System.out.println("New hand is "+ Shelby.handToString());
    //System.out.println("New hand is "+ test2.handToString());
    discard.add(deck.draw());
    System.out.println("Discard size "+discard.size());
    System.out.println("The deck size is "+deck.size());
  }

}
