/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.Scanner;

/**
 *
 * @author Thomas
 */
public class BlackJackGame {
    
    private Player player;
    private Dealer dealer;
    private boolean winner;
    
    public BlackJackGame(String playerName, int decks){
        player = new Player(playerName);
        this.dealer = new Dealer(decks);
        winner = false;
    }
    
    public boolean hasWinner(){
        return winner;
    }
    public boolean setWinner(){
        winner = true;
        return winner;
    }
    
    public void startGame(){
        this.dealer.startGame(player);
        printHands();
    }
    
    public void printHands(){
        System.out.println("De dealer heeft als hand " + dealer.toString());
        System.out.println("Player " + player.getName() + " heeft als hand " + player.toString());
        System.out.println("");
    }
        
    public void checkPlayer(String move){       
       switch(move){
            case "hit": dealer.dealCard(player);
                break;
            case "stand": player.setStands(true);
                break;
        }
       if(player.getHand().checkBust()){
            winner = true;
        }
        
    }
    public void checkPlayers(String move){
        checkPlayer(move);
        checkDealer();        
        while(player.getStands() && !dealer.getStands())
            checkDealer();
        if(dealer.getStands() && player.getStands())
            winner = true;
        printHands();
        
    }
    
    public void checkDealer(){        
        if(dealer.getHand().getValue() <= 17)
            dealer.dealSelf();
        else
            dealer.setStands(true);
        
        if(dealer.getHand().checkBust())
            winner = true;
        
    }
    
    public void getWinner(){
        dealer.showHand();
        printHands();
        if(dealer.getHand().checkBust())
            System.out.println("Dealer busted! Players win!");
        
        else if(dealer.getHand().checkBlackJack())
            System.out.println("Dealer won!");
        
        else if(player.getHand().checkBlackJack())
            System.out.println("!!!!BlackJack!!!!!" + player.getName() + "won!");
        
        else if(player.getHand().checkBust())
            System.out.println("Busted. Dealer won!");
        
        else if(dealer.getHand().getValue() >= player.getHand().getValue())
            System.out.println("Dealer won!");
        
    }
    
}
