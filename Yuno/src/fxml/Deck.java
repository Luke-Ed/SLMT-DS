package fxml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
  private Stack<Card> deck = new Stack<>();

  public Deck() {
  }

  void fill() {
    for(int s=0; s<2; s++) {
      for (int i=0; i<4; i++) {
        for (int j=0; j<10; j++) {
          String[] colors = {"Purple", "Blue", "Pink", "Green"};
          deck.add(new Card(colors[i], (j+"")));
        }
      }
    }
    for (int i=0; i<4; i++){
      String[] colors = {"Purple", "Blue", "Pink", "Green"};
      String[] special = {"+2", "+4", "Skip"};
      for (int j=0; j<3; j++){
        deck.add(new Card(colors[i], special[j]));
      }
      deck.add(new Card("Wild", "Wild"));
    }

    ArrayList<Card> orderedDeck = new ArrayList<>(deck);
    Collections.shuffle(orderedDeck);
    deck.clear();
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
