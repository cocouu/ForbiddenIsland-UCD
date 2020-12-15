package com.esr.service.game.data;

import com.esr.service.game.Game;
import com.esr.service.game.GameData;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description
 * @Author William
 * @Date 2020/12/8
 * @Version 1.0
 **/
public class FloodDeck {
    private ArrayList<Integer> floodDeck;
    private ArrayList<Integer> discardPile;
    private ArrayList<Integer> displayedCards;
    private ArrayList<Integer> removedFloodCard;
    private int displayNum;
    private boolean isInit;

    public FloodDeck() {
        floodDeck = new ArrayList<>();
        discardPile = new ArrayList<>();
        displayedCards = new ArrayList<>();
        removedFloodCard = new ArrayList<>();
        isInit = true;
        for (int i = 1; i <= 24; i++) {
            floodDeck.add(i);
        }
        Collections.shuffle(floodDeck);
    }

    public ArrayList<Integer> getNFlood(){
        if (isInit){ this.displayNum = 6; }
        else { this.displayNum = GameData.getWaterMeterLevel(); }
        CheckAvailability(this.displayNum);
        displayedCards.clear();
        displayedCards.addAll(floodDeck.subList(0,this.displayNum));
        return displayedCards;
    }

    public void Discard(){
        for (int i = 0; i < displayNum; i++) {
            discardPile.add(floodDeck.get(0));
            floodDeck.remove(0);
        }
//        System.out.println("DP: " + discardPile);
//        System.out.println("FD: " + floodDeck);
    }

    public void PutBack2Top(){
        Collections.shuffle(discardPile);
        discardPile.addAll(floodDeck);
        floodDeck.clear();
        floodDeck.addAll(discardPile);
        discardPile.clear();
    }

    public void PutBack(){
        Collections.shuffle(discardPile);
        floodDeck.clear();
        floodDeck.addAll(discardPile);
        discardPile.clear();
    }

    public void RemoveFloodCard(int removedTile){
        removedFloodCard.add(floodDeck.get(removedTile));
        floodDeck.remove((Integer) removedTile);
    }

    private void CheckAvailability(int n){
        if (floodDeck.size() < n){
            Collections.shuffle(discardPile);
            floodDeck.addAll(discardPile);
            discardPile.clear();
        }
    }

    public void setToNorm(){
        this.isInit = false;
    }

}
