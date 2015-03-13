/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class Hand {
    private ArrayList<Card> cards;
    private int value;
    
    public Hand(){
        cards = new ArrayList<>();
        value = 0;
    }
    
    public void addCard(Card card){
        cards.add(card);
    }
    
    public boolean checkBlackJack(){
        return value==21;
    }
    
    public boolean checkBust(){
        return value>21;
    }
    
    public int getValue(){
        return value;
    }
}
