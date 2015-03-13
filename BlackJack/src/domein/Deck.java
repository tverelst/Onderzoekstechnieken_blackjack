
package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Thomas
 */
public class Deck {
    
    private ArrayList<Card> deck;
    public static final String[] values = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static final String[] suits ={"Hearts", "Spades", "Clubs", "Diamonds"};
    
    public Deck(){
        this.makeDeck();
        this.shuffleDeck();
    }
    
    public ArrayList<Card> getDeck(){
        return deck;
    }
    
    public void makeDeck(){
        deck = new ArrayList<>();
        for(String v:values){
            for(String s:suits){
                deck.add(new Card(v,s));
            }            
        }
    }
    
    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
    
    public ArrayList<Card> getCards(){
        return deck;
    }
        
}
