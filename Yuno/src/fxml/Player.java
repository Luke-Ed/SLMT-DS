package fxml;

import java.util.ArrayList;

public class Player {
  private String name;
  private Deck deck;
  private Deck discard;
  private boolean hasCalledYuno;
  private ArrayList<Card> hand = new ArrayList<>();

  public Player(String name, Deck deck, Deck discard) {
    this.name = name;
    this.deck = deck;
    this.discard = discard;
    for (int i=0; i<7; i++) {
      this.draw();
    }
    this.hasCalledYuno = false;
  }

  ArrayList<Card> getHand(){
    return hand;
  }
  String getName() {
    return name;
  }
  void draw() {
    hand.add(deck.draw());
    setHasCalledYuno(false);
  }

  void draw(int numCards) {
    for (int i = 0; i<numCards; i++){
      hand.add(deck.draw());
    }
  }

  void play(Card c) {
    if (deck.size()<5){
      deck.refillDeck(deck, discard);
    }
    discard.add(c);
    hand.remove(c);
  }

  boolean hasCalledYuno(){
    return hasCalledYuno;
  }

  void setHasCalledYuno(boolean val){
    hasCalledYuno = val;
  }
}
