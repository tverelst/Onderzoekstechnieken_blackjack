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
    
    //Aas moet nog aangepast worden
    public void addCard(Card card){
        cards.add(card);
        switch (card.getValue()){
            case "J": value+=10;
                break;
            case "Q": value+=10;
                break;
            case "K": value+=10;
                break;
            case "A": value+=11;
                break;
            default: value+=Integer.parseInt(card.getValue());
        }
        //Als 21 wordt overschreden wordt de aas 1
        if(value>21 && cards.stream().filter(c -> c.getValue().equals("A")).count()==1){
            value-=10;
        }
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
    public void revealCards(){
        for(Card card:cards)
            card.setFaceUp();
    }
    
    @Override
    public String toString(){
        StringBuilder hand = new StringBuilder();
        for(Card card:cards){
            if(card.isFaceUp()){
                hand.append(card.toString());
            }
            else{
                hand.append("[]");
            }
            hand.append(" ");            
        }
        return hand.toString();
    }
}
