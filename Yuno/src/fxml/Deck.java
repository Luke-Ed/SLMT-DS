package fxml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
  private Stack<Card> deck = new Stack<>();

  public Deck() {
  }

  void fill() {
    ArrayList<Card> orderedDeck = new ArrayList<>();
    for(int s=0; s<2; s++) {
      for (int i=0; i<4; i++) {
        for (int j=0; j<10; j++) {
          String[] colors = {"purple", "blue", "pink", "green"};
          orderedDeck.add(new Card((j+""), colors[i]));
        }
      }
    }
    for (int i=0; i<4; i++){
      String[] colors = {"purple", "blue", "pink", "green"};
      orderedDeck.add(new WildCard("skip", colors[i]));
      for (int j=0; j<3; j++){
        orderedDeck.add(new WildCard("+2",colors[i]));
      }
      orderedDeck.add(new WildCard("wild", "wild"));
      orderedDeck.add(new WildCard("wild +4", "wild"));
    }
    Collections.shuffle(orderedDeck);
    deck.addAll(orderedDeck);
  }

  Card draw() {
    return deck.pop();
  }

  int size() {
    return deck.size();
  }

  void add(Card c) {
    deck.push(c);
  }

  Card top() {
    return deck.peek();
  }
}
