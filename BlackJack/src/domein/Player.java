/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author Thomas
 */
public class Player {
    private String name;
    private Hand hand;
    
    public Player(String name){
        this.name = name;
        hand = new Hand();
    }
    
    public void hit(Card card){
        hand.addCard(card);
    }
    
    
}
