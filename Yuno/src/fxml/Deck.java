package fxml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
  private Stack<Card> deck = new Stack<Card>();

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
    //ToDo: for loop to build special cards, will need x12 +2s, x6 wild +4, x6 wild plain(?)
    // store special types in "special" string[], build them through with loop
    // values will be "+2+, "+4", and "wild" (if i have to tell you what goes where, i wont)
    ArrayList<Card> orderedDeck = new ArrayList<Card>(deck);
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
