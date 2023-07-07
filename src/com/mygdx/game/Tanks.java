package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Tanks implements Screen {
    private int tank_health;
//    int tank_damage;
    private int tank_fuel;
    private Texture tank_img;
    private String name;
    public static ArrayList<Tanks> tanks = new ArrayList<Tanks>();

    public Tanks(String name,int tank_health, int tank_fuel, String tank_image){
        this.tank_health = tank_health;
        this.tank_fuel = tank_fuel;
        this.tank_img = new Texture(Gdx.files.internal(tank_image));
        this.name = name;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public int getTank_health() {
        return tank_health;
    }

    public void setTank_health(int tank_health) {
        this.tank_health = tank_health;
    }

    public int getTank_fuel() {
        return tank_fuel;
    }

    public void setTank_fuel(int tank_fuel) {
        this.tank_fuel = tank_fuel;
    }

    public Texture getTank_img() {
        return tank_img;
    }

    public void setTank_img(Texture tank_img) {
        this.tank_img = tank_img;
    }
}
