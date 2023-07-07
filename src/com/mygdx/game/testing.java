package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class testing implements Screen {

    private World world;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera camera;
    public testing(){
//        System.out.println("testing");
    }

    @Override
    public void show() {
        world = new World(new Vector2(0,-9.18f),true);
        debugRenderer = new Box2DDebugRenderer();

//        t1 t = new t1(world);
        camera = new OrthographicCamera(Gdx.graphics.getWidth()/30,Gdx.graphics.getHeight()/30);

        BodyDef balldef = new BodyDef();
        balldef.type = BodyDef.BodyType.DynamicBody;
        balldef.position.set(0,1);

        CircleShape ballshape = new CircleShape();
        ballshape.setRadius(0.5f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = ballshape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f;

        Body ball = world.createBody(balldef);
        ball.createFixture(fixtureDef);

        ballshape.dispose();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        debugRenderer.render(world,camera.combined);

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
        dispose();
    }

    @Override
    public void dispose() {
        world.dispose();
        debugRenderer.dispose();
    }
}
