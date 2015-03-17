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
public class Dealer {   
    private Hand hand;
    private Shoe shoe;
    private boolean stands;
    
    public Dealer(int decks){        
        this.hand = new Hand();
        this.shoe = new Shoe(decks);
    }
   
    public void startGameBasic(Player player){           
        dealCard(player);
        dealSelfFaceUp();
        dealCard(player);
        dealSelf();        
    }
    
    public void startGame(ArrayList<Player> players){
        players.stream().forEach(p->dealCard(p));
        dealSelfFaceUp();
        players.stream().forEach(p->dealCard(p));
        dealSelf();
    }
    
    public void dealCard(Player player){
        player.hit(shoe.drawCard()); 
    }
    
    public void dealSelfFaceUp(){
        this.hand.addCard(shoe.drawCard());
        this.hand.revealCards();
    }
    
    public void dealSelf(){
        this.hand.addCard(shoe.drawCard());
    }
    
    public void setStands(boolean stands){
        this.stands = stands;
    }
   
    public boolean getStands(){
        return stands;
    }
    
    public Hand getHand(){
        return hand;
    }
    
    public void showHand(){
        hand.revealCards();
    }
    
    @Override
    public String toString(){
        return this.hand.toString();
    }
}
