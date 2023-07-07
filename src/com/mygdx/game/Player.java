package com.mygdx.game;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private Tanks tank;
    private String name;
    private Boolean won;
    private int player_health;
    private int player_fuel;
    private Missile missile;

    private int pos_x;
    private int pos_y;
    private int nossle_pos_x;
    private int nossle_pos_y;

    public static ArrayList<Player> players = new ArrayList<Player>();

    public Player(Tanks tank, Boolean won, int player_health, int player_fuel, Missile missile,String name) {
        this.tank = tank;
        this.won = won;
        this.player_health = tank.getTank_health();
        this.player_fuel = tank.getTank_fuel();
        this.missile = missile;
        this.name = name;
    }


    public Tanks getTank() {
        return tank;
    }

    public void setTank(Tanks tank) {
        this.tank = tank;
    }

    public Boolean getWon() {
        return won;
    }

    public void setWon(Boolean won) {
        this.won = won;
    }

    public int getPlayer_health() {
        return player_health;
    }

    public void setPlayer_health(int player_health) {
        this.player_health = player_health;
    }

    public int getPlayer_fuel() {
        return player_fuel;
    }

    public void setPlayer_fuel(int player_fuel) {
        this.player_fuel = player_fuel;
    }

    public Missile getMissile() {
        return missile;
    }

    public void setMissile(Missile missile) {
        this.missile = missile;
    }
    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public int getNossle_pos_x() {
        return nossle_pos_x;
    }

    public void setNossle_pos_x(int nossle_pos_x) {
        this.nossle_pos_x = nossle_pos_x;
    }

    public int getNossle_pos_y() {
        return nossle_pos_y;
    }

    public void setNossle_pos_y(int nossle_pos_y) {
        this.nossle_pos_y = nossle_pos_y;
    }
}
