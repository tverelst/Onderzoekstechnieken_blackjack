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
    private boolean stands;
    
    public Player(String name){
        this.name = name;
        hand = new Hand();
        stands = false;
    }
   
    public void hit(Card card){
        card.flip();
        hand.addCard(card);
        
    }
    public void setStands(boolean stands){
        this.stands=stands;
    }
    public boolean getStands(){
        return stands;
    }
    
    public String getName(){
        return name;
    }
    
    public Hand getHand(){
        return hand;
    }
    
    @Override
    public String toString(){
        return this.hand.toString();
    }
    

    
}
