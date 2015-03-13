/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Thomas
 */
public class Shoe {
    private ArrayList<Card> shoe;
    
    public Shoe(int aantalDecks){
        shoe = new ArrayList<>();
        for(int i=0; i<aantalDecks;i++){
            shoe.addAll(new Deck().getCards());
        }
        this.shuffle();
    }
    
    public void shuffle(){
        Collections.shuffle(this.shoe);
    }
    
    public Card drawCard(){
        return shoe.remove(0);
    }
    
}
