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
public class BlackJackGame {
    private ArrayList<Player> players;
    private Player player;
    private Dealer dealer;
    private boolean winner;
    
    public BlackJackGame(String playerName, int decks){
        player = new Player(playerName);
        this.dealer = new Dealer(decks);
        winner = false;
    }
    
    public BlackJackGame(int aantalSpelers, int decks){
        players = new ArrayList<>();
        for(int i=0;i<aantalSpelers;i++){
            players.add(new Player("Speler"+ i));
        }
        this.dealer = new Dealer(decks);
        winner = false;
    }
    public void welcomePlayers(){
        players.stream().forEach(p -> System.out.println("Welkom " + p.getName() + "!"));        
    }
    public boolean hasWinner(){
        return winner;
    }
    public boolean setWinner(){
        winner = true;
        return winner;
    }
    
    public void startGameBasic(){
        this.dealer.startGameBasic(player);
        printHandsBasic();
    }
    
    public void printHandsBasic(){
        System.out.println("De dealer heeft als hand " + dealer.toString());
        System.out.println("Player " + player.getName() + " heeft als hand " + player.toString());
        System.out.println("");
    }
        
    public void checkPlayerBasic(String move){       
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
    
    public void checkPlayersBasic(String move){
        checkPlayerBasic(move);
        checkDealer();        
        while(player.getStands() && !dealer.getStands())
            checkDealer();
        if(dealer.getStands() && player.getStands())
            winner = true;
        printHandsBasic();
        
    }
         
    public void checkDealer(){        
        if(dealer.getHand().getValue() <= 17)
            dealer.dealSelf();
        else
            dealer.setStands(true);
        
        if(dealer.getHand().checkBust())
            winner = true;
        
    }
    
    public void getWinnerBasic(){
        dealer.showHand();
        printHandsBasic();
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
    
    public void startGame(){
        this.dealer.startGame(players);
    }
    public void checkPlayers(){
        while(!areAllPlayersStanding()&&!winner){
            for(Player pl:players){
            checkPlayer(pl);            
            }
            checkDealer();
        }
        while(!dealer.getStands()){
            checkDealer();
        }
        
        printHands();
    }
    public boolean areAllPlayersStanding(){        
        for(Player pl:players){
            if(!pl.getStands()) return false;                
        }
        return true;
    }
    //soft hit 18
    public void checkPlayer(Player pl){
        if(pl.getHand().getValue()<=18)
            dealer.dealCard(pl);
        else
            pl.setStands(true);
    }
    
    public void printHands(){
        players.stream().forEach(p -> System.out.println("Player " + p.getName() + " heeft waarde " + p.getHand().getValue() + " en heeft als hand " + p.toString()));
        System.out.println("De dealer heeft waarde " + dealer.getHand().getValue() + " en heeft als hand " + dealer.toString());
        System.out.println("");
    }
    
    public void checkWinners(){
        dealer.showHand();
        printHands();
        if(dealer.getHand().checkBust()){
            System.out.println(" Dealer BUSTED! Iedereen wint!!!!!");
        }
        else if(dealer.getHand().checkBlackJack()){
            System.out.println(" Dealer heeft BlackJack, dealer wint!");
        }
        else{
            for(Player pl:players){
                if(pl.getHand().checkBust()){
                    System.out.println(pl.getName()+ " BUSTED! Better luck next time");
                }
                else if(pl.getHand().checkBlackJack()){
                    System.out.println(pl.getName() + " got a !!!!!!!!!!!BLACKJACK!!!!!!!!!!!!!!!!!");
                }
                else if(pl.getHand().getValue()<=dealer.getHand().getValue()){
                    System.out.println(pl.getName() + " has a lower amount as the dealer. Better luck next time");
                }
                else{
                    System.out.println(" Proficiat" + pl.getName() +". U heeft gewonnen!");
                }
            }
        }
    }
}
