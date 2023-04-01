package ca.bcit.comp2522.termproje.game;

import java.util.ArrayList;
import java.util.Random;

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
    private int hunger;
    private ArrayList items;

    private String name;
    /**
     * Creates an instance of player class.
     */
    public Player(){
        name = null;
        happiness = 10;
        energy = 10;
        speed = 1;
        strength = 1;
        money = 10;
        hunger = 10;
        days = 1;
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
     * Gets player name.
     * @return player name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the player's name
     * @param name a string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Decrease player energy by 5
     */
    public void useEnergy() {
        this.energy -= 5;
    }

    /**
     * Decrease player money by 2
     */
    public void useMoney() {
        this.money -= 2;
    }

    /**
     * Increase player money by 2
     */
    public void earnMoney() {
        this.money += 2;
    }

    /**
     * Update player speed by given amount
     * @param amount an integer between 1-3
     */
    public void updateSpeed(int amount) {
        this.speed += amount;
    }

    /**
     * Update player strength by given amount
     * @param amount an integer between 1-3
     */
    public void updateStrength(int amount) {
        this.strength += amount;
    }

    /**
     * Decrease player hunger by 5.
     */
    public void decreaseHunger() {
        this.hunger -= 5;
    }

    /**
     * Increase player hunger by 5.
     */
    public void increaseHunger() {
        this.hunger += 5;
    }

    public void decreaseHappiness(int amount) {
        this.happiness -= amount;
    }

    public void increaseHappiness(int amount) {
        this.happiness += amount;
    }

    /**
     * Update player's speed and strength by 1-3.
     * Use energy and hunger.
     * Decrease happiness.
     */
    public void trainPlayer() {
        Random random = new Random();
        updateSpeed(random.nextInt(3)+1);
        updateStrength(random.nextInt(3)+1);
        useEnergy();
        decreaseHunger();
    }

    /**
     * Increase day by 1 and reset energy to 10.
     */
    public void sleep() {
        this.days += 1;
        setEnergy(10);
    }

    public void hangout() {
        Random random = new Random();
        increaseHappiness(random.nextInt(3)+1);
        useMoney();
        useEnergy();
    }
    public void eat() {
        Random random = new Random();
        increaseHappiness(random.nextInt(3)+1);
        useMoney();
        increaseHunger();
    }
}
