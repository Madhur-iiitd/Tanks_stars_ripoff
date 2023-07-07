package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class initial extends Game {
//    public static ArrayList<Tanks> tanks_array = new ArrayList<>();
//    Tanks tank1 = new Tanks(100, 10, "helios.png");
//    Tanks tank2 = new Tanks(100, 10, "T-32.png");
//    Tanks tank3 = new Tanks(100, 10, "tank3.png");
    private SpriteBatch batch;
//    public Actor font;
    private BitmapFont font;

    @Override
    public void create() {
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
        this.setScreen(new Tank_star(this));
        Tanks tank1 = new Tanks("helios",160, 10, "helios.png");
        Tanks tank2 = new Tanks("T-32",90, 10, "T-32.png");
        Tanks tank3 = new Tanks("tank3",180, 10, "helios.png");
        Tanks.tanks.add(tank1);
        Tanks.tanks.add(tank2);
        Tanks.tanks.add(tank3);

        Missile m1 = new Missile("m1",100,0,0);
        Player p1 = new Player(tank1,false,tank1.getTank_health(),tank1.getTank_fuel(),m1,"p1");
        Player p2 = new Player(tank2,false,tank2.getTank_health(),tank2.getTank_fuel(),m1,"p2");

        Player.players.add(p1);
        Player.players.add(p2);
//        initial.tanks_array.add(tank1);
//        initial.tanks_array.add(tank2);
//        initial.tanks_array.add(tank3);
    }

    public void render(){
        super.render();
    }

    public void dispose(){
        batch.dispose();
        font.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }
}
