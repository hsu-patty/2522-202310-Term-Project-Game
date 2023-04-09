package ca.bcit.comp2522.termproje.game;

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

    private int hits;
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
        money = 5;
        hunger = 5;
        days = 1;
    }
    /**
     * Creates a new instance of the player class based on previous saved file.
     * @param newName player's previous name as a string
     * @param newSpeed player's previous speed as an int
     * @param newStrength player's previous strength as an int
     * @param newEnergy player's previous energy as an int
     * @param newHappiness player's previous happiness as an int
     * @param newMoney player's previous money as an int
     * @param newHunger player's previous hunger as an int
     * @param newDays player's previous days as an int
     * @param newHits player's previous hits as an int
     */
    public Player(final String newName, final int newSpeed, final int newStrength, final int newEnergy,
                  final int newHappiness, final int newMoney, final int newHunger, final int newDays,
                  final int newHits) {
        name = newName;
        speed = newSpeed;
        strength = newStrength;
        energy = newEnergy;
        happiness = newHappiness;
        money = newMoney;
        hunger = newHunger;
        days = newDays;
        hits = newHits;
    }

    /**
     * Gets the players current happiness.
     * @return integer representing player happiness
     */
    public int getHappiness() {
        return happiness;
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
     * Gets the players current strength stats.
     * @return integer representing player strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Gets the players current money amount.
     * @return integer representing player money
     */
    public int getMoney() {
        return money;
    }
    /**
     * Gets the players current day.
     * @return integer representing player day.
     */
    public int getDays() {
        return days;
    }

    /**
     * Gets player name.
     * @return player name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the player's name.
     * @param name a string
     */
    public void setName(final String name) {
        this.name = name;
    }
    /**
     * Gets the player's current hunger.
     * @return integer representing player's current hunger
     */
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
        this.speed += random.nextInt(3) + 1;
        //increase strength between 1-3
        this.strength += random.nextInt(3) + 1;
        //decrease happiness
        this.happiness -= random.nextInt(3) + 1;
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
        this.happiness += random.nextInt(3) + 1;
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
        this.happiness += random.nextInt(3) + 1;
        //decrease money
        this.money -= 2;
        //increase hunger
        this.hunger -= 5;
        this.energy -= 5;
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
    /**
     * Increases player's current hits.
     */
    public void increaseHits() {
        this.hits++;
    }
    /**
     * Returns player's current hits.
     * @return int representing player's current hits
     */
    public int getHits() {
        return hits;
    }
}
