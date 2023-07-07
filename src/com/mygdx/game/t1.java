package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

public class t1 {
    public World world;
    public Body b2body;

    public t1(World world){
        this.world = world;
        definet1();
    }

    public void definet1(){
        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(100,550);
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
//         rect = new Rectangle(0,0,16,16);
        CircleShape shape = new CircleShape();
        shape.setRadius(30);
        fdef.shape = shape;
        b2body.createFixture(fdef);
    }

}
