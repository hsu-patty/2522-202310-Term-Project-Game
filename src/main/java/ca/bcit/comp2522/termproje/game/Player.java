package ca.bcit.comp2522.termproje.game;

import java.util.ArrayList;
/**
 * Player class.
 * @authors Patty Hsu & Tim Lee
 */
public class Player {
    private int happiness;
    private int energy;
    private int speed;
    private int strength;
    private int money;
    private int days;
    private ArrayList items;
    /**
     * Creates an instance of player class.
     */
    public Player(){
        happiness = 10;
        energy = 10;
        speed = 1;
        strength = 1;
        money = 10;
        days = 1;
        items = new ArrayList<>();
    }
    /**
     * Gets the players current happiness.
     * @return integer representing player happiness
     */
    public int getHappiness() {
        return happiness;
    }
    /**
     * Sets the player's happiness.
     * @param happiness integer representing new player happiness
     */
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
    /**
     * Gets the players current energy.
     * @return integer representing player energy
     */
    public int getEnergy() {
        return energy;
    }
    /**
     * Sets the player's energy.
     * @param energy integer representing new player happiness
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    /**
     * Gets the players current speed stats.
     * @return integer representing player speed
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * Sets the player's speed.
     * @param speed integer representing new player speed stat
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    /**
     * Gets the players current strength stats.
     * @return integer representing player strength
     */
    public int getStrength() {
        return strength;
    }
    /**
     * Sets the player's happiness.
     * @param strength integer representing new player strength stat
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }
    /**
     * Gets the players current money amount
     * @return integer representing player money
     */
    public int getMoney() {
        return money;
    }
    /**
     * Sets the player's money amount.
     * @param money integer representing new player money
     */
    public void setMoney(int money) {
        this.money = money;
    }
    /**
     * Gets the players current day.
     * @return integer representing player day.
     */
    public int getDays() {
        return days;
    }
    /**
     * Sets the player's current in game day.
     * @param days integer representing new player day
     */
    public void setDays(int days) {
        this.days = days;
    }
    /**
     * Gets the players current item list.
     * @return an Arraylist of the players current items
     */
    public ArrayList getItems() {
        return items;
    }
    /**
     * Sets the player's item list
     * @param items arraylist of items
     */
    public void setItems(ArrayList items) {
        this.items = items;
    }
}
