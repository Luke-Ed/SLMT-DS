package fxml;

import java.util.ArrayList;

public class Player {
  private String name;
  private Deck deck;
  private Deck discard;
  private ArrayList<Card> hand = new ArrayList<>();

  public Player(String name, Deck deck, Deck discard) {
    this.name = name;
    this.deck = deck;
    this.discard = discard;
    for (int i=0; i<7; i++) {
      this.draw();
    }
  }

  ArrayList<Card> getHand(){
    return hand;
  }
  String getName() {
    return name;
  }
  void draw() {
    hand.add(deck.draw());
  }

  void play(Card c) {
    discard.add(c);
    hand.remove(c);
  }
}
