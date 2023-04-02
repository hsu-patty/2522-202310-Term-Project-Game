package ca.bcit.comp2522.termproje.game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Player class.
 * @author Patty Hsu & Tim Lee
 * @version 202310
 */
public class Player {
    private int happiness;
    private int energy;
    private int speed;
    private int strength;
    private int money;
    private int days;
    private int hunger;
    private String name;
    /**
     * Creates an instance of player class.
     */
    public Player() {
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
    public void setHappiness(final int happiness) {
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
    public void setEnergy(final int energy) {
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
    public void setSpeed(final int speed) {
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
    public void setStrength(final int strength) {
        this.strength = strength;
    }
    /**
     * Gets the players current money amount.
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

    public int getHunger() {
        return this.hunger;
    }
    /**
     * Update player's speed and strength by 1-3.
     * Use energy and hunger.
     * Decrease happiness.
     */
    public void trainPlayer() {
        Random random = new Random();
        //increase speed between 1-3
        this.speed += random.nextInt(3)+1;
        //increase strength between 1-3
        this.strength += random.nextInt(3)+1;
        //decrease happiness
        this.happiness -= random.nextInt(3)+1;
        //decrease energy
        this.energy -= 5;
        //decrease hunger
        this.hunger += 3;
    }

    /**
     * Increase day by 1 and reset energy to 10.
     */
    public void sleep() {
        this.days += 1;
        setEnergy(10);
    }
    /**
     * Simulates player going to hang out with friends.
     * Increases happiness and decreases money and energy.
     */
    public void hangout() {
        Random random = new Random();
        //increase happiness between 1-3
        this.happiness += random.nextInt(3)+1;
        //decrease money
        this.money -= 2;
        //decrease energy
        this.energy -= 5;
        this.hunger += 3;
    }
    /**
     * Simulates player eating.
     * Increases happiness.
     * Decreases money and hunger.
     */
    public void eat() {
        Random random = new Random();
        //increase happiness between 1-3
        this.happiness += random.nextInt(3)+1;
        //decrease money
        this.money -= 2;
        //increase hunger
        this.hunger -= 5;
    }
    /**
     * Simulates player Working.
     * Increases money and hunger.
     * Decreases happiness, energy.
     */
    public void work() {
        Random random = new Random();
        //decrease happiness
        this.happiness -= random.nextInt(3) + 1;
        //increase money
        this.money += 4;
        // decrease energy
        this.energy -= 5;
        this.hunger += 5;
    }
}
