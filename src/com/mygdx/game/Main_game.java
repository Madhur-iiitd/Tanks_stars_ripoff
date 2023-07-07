package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import jdk.tools.jmod.Main;

public class Main_game implements Screen {

    private TextureRegion b;
    private OrthographicCamera camera;
    private initial game;
    private int health1 = 0;
    private int health2 = 0;
//    Texture background;
    private SpriteBatch batch;
    private BitmapFont font;
    private Texture pause;
    private ImageButton pause_button;
    private Image player1;
    private Image player2;
    private Texture player1_texture;
    private Texture player2_texture;
    private Stage stage;
    private int fuel1=100;
    private int fuel2=100;
    public static final int V_WIDTH = 1920;
    public static final int V_HEIGHT = 1000;
    private Viewport viewport;
    private World world;
    private Box2DDebugRenderer debugrenderer;
    private Body ball;
    private Body ball2;
    private final int velIter = 8;
    private final int posIter = 3;
    private Vector2 mv = new Vector2();
    private Vector2 mv2 = new Vector2();
    public Main_game(initial game){

        world = new World(new Vector2(0,-9.18f), true);
        debugrenderer = new Box2DDebugRenderer();
        this.game = game;
        batch = new SpriteBatch();
        font = new BitmapFont();
        pause = new Texture(Gdx.files.internal("pause.png"));
        player1_texture = new Texture("Player1.png");
        player2_texture = new Texture("Player2.png");
        viewport = new FitViewport(Main_game.V_WIDTH, Main_game.V_HEIGHT, camera);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1000);
        camera.position.set(viewport.getWorldWidth()/10,viewport.getWorldHeight()/10,0);


        //body def
        BodyDef bodydef = new BodyDef();
        bodydef.type = BodyDef.BodyType.DynamicBody;
        bodydef.position.set(-700,100);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(30,10);

        //fixture def
        FixtureDef fdef = new FixtureDef();
        fdef.density = 1f;
        fdef.friction = 0.4f;
        fdef.restitution = 0;
        fdef.shape = shape;

        ball = world.createBody(bodydef);
        ball.createFixture(fdef);
        shape.dispose();


        //cicle2
        bodydef.type = BodyDef.BodyType.DynamicBody;
        bodydef.position.set(700,200);


        PolygonShape shape2 = new PolygonShape();
        shape2.setAsBox(30,10);

        fdef.shape = shape2;
        fdef.density = 1f;
        fdef.friction = 0.4f;
        fdef.restitution = 0;

        ball2 = world.createBody(bodydef);
        ball2.createFixture(fdef);
        shape2.dispose();

        //ground
        bodydef.type = BodyDef.BodyType.StaticBody;
        bodydef.position.set(0,0);

        //ground shape
        ChainShape groundshape = new ChainShape();
        groundshape.createChain(new Vector2[]{new Vector2(-800,1000),new Vector2(-800,0), new Vector2(-400,0),new Vector2(-200,100),new Vector2(-100,100),new Vector2(0,0),new Vector2(300,0),new Vector2(600,100),new Vector2(1200,100),new Vector2(1200,1000)});

        //fixture definition
        fdef.shape = groundshape;
        fdef.friction = .5f;
        fdef.restitution = 0;

        world.createBody(bodydef).createFixture(fdef);

        font.setColor(Color.RED);

        pause_button = new ImageButton(new TextureRegionDrawable(new TextureRegion(pause)));

        player1 = new Image(new TextureRegionDrawable(new TextureRegion(player1_texture)));
        player2 = new Image(new TextureRegionDrawable(new TextureRegion(player2_texture)));
        stage = new Stage();
        Table table = new Table();
        table.setFillParent(true);
        table.top();
        table.add(player1);
        table.add(pause_button);
        table.add(player2);
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setInputProcessor(new input(){
            @Override
            public boolean keyDown(int keycode) {
//                if(keycode == Input.Keys.ESCAPE){
//                    game.setScreen(new pause(game));
//                }
                switch(keycode){
                    case Input.Keys.A:
                        ball.applyLinearImpulse(-10000,0,ball.getPosition().x,ball.getPosition().y,true);
//                        mv.x = -speed;
                        break;

                    case Input.Keys.D:
//                        mv.x = speed;
                        ball.applyLinearImpulse(10000,0,ball.getPosition().x,ball.getPosition().y,true);
                        break;

                    case Input.Keys.RIGHT:
//                        mv2.x = speed;
                        ball2.applyLinearImpulse(10000,0,ball2.getPosition().x,ball2.getPosition().y,true);
                        break;

                    case Input.Keys.LEFT:
//                        mv2.x = -speed;
                        ball2.applyLinearImpulse(-10000,0,ball2.getPosition().x,ball2.getPosition().y,true);
                        break;
                }
                return true;
            }

//            @Override
//            public boolean keyUp(int keycode) {
//                switch(keycode){
//                    case Input.Keys.A:
//                        mv.x = 0;
//                        break;
//
//                    case Input.Keys.D:
//                        mv.x = 0;
//                        break;
//
//                    case Input.Keys.RIGHT:
//                        mv2.x = 0;
//                        break;
//
//                    case Input.Keys.LEFT:
//                        mv2.x = 0;
//                        break;
//                }
//                return true;
//            }
        });
    }

    @Override
    public void show() {

    }

    public void handleInput(float dt){

    }

    public void update(float dt){
        handleInput(dt);
        world.step(1/60f, 6, 2);
        camera.update();
    }

    @Override
    public void render(float delta){

        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        debugrenderer.render(world, camera.combined);
        world.step(1/60f, velIter, posIter);
        batch.setProjectionMatrix(camera.combined);
        ball.applyForceToCenter(mv,true);
        ball2.applyForceToCenter(mv2,true);

        game.getBatch().begin();
//        game.getBatch().setProjectionMatrix(camera.combined);
        health1 = Player.players.get(0).getPlayer_health();
        health2 = Player.players.get(1).getPlayer_health();
        font.getData().setScale(2);
        font.draw(game.getBatch(), "HEALTH->"+health1, 60, 900);
        font.draw(game.getBatch(), "FUEL->"+fuel1, 60, 850);
        font.draw(game.getBatch(), "HEALTH->"+health2, 1700, 900);
        font.draw(game.getBatch(), "FUEL->"+fuel2, 1700, 850);

        game.getBatch().end();

        debugrenderer.render(world, camera.combined);
        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());
        pause_button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new pause_menu(game));
            }
        });
    }

    @Override
    public void resize(int width, int height) {
//        camera.viewportWidth = width;
//        camera.viewportHeight = height;
//        camera.update();
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
    public void dispose(){
        batch.dispose();
        stage.dispose();
        world.dispose();
        debugrenderer.dispose();
    }

    public TextureRegion getB() {
        return b;
    }

    public void setB(TextureRegion b) {
        this.b = b;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public initial getGame() {
        return game;
    }

    public void setGame(initial game) {
        this.game = game;
    }

    public int getHealth1() {
        return health1;
    }

    public void setHealth1(int health1) {
        this.health1 = health1;
    }

    public int getHealth2() {
        return health2;
    }

    public void setHealth2(int health2) {
        this.health2 = health2;
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

    public Texture getPause() {
        return pause;
    }

    public void setPause(Texture pause) {
        this.pause = pause;
    }

    public ImageButton getPause_button() {
        return pause_button;
    }

    public void setPause_button(ImageButton pause_button) {
        this.pause_button = pause_button;
    }

    public Image getPlayer1() {
        return player1;
    }

    public void setPlayer1(Image player1) {
        this.player1 = player1;
    }

    public Image getPlayer2() {
        return player2;
    }

    public void setPlayer2(Image player2) {
        this.player2 = player2;
    }

    public Texture getPlayer1_texture() {
        return player1_texture;
    }

    public void setPlayer1_texture(Texture player1_texture) {
        this.player1_texture = player1_texture;
    }

    public Texture getPlayer2_texture() {
        return player2_texture;
    }

    public void setPlayer2_texture(Texture player2_texture) {
        this.player2_texture = player2_texture;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getFuel1() {
        return fuel1;
    }

    public void setFuel1(int fuel1) {
        this.fuel1 = fuel1;
    }

    public int getFuel2() {
        return fuel2;
    }

    public void setFuel2(int fuel2) {
        this.fuel2 = fuel2;
    }

//    public TmxMapLoader getMapLoader() {
//        return mapLoader;
//    }
//
//    public void setMapLoader(TmxMapLoader mapLoader) {
//        this.mapLoader = mapLoader;
//    }
//
//    public TiledMap getMap() {
//        return map;
//    }
//
//    public void setMap(TiledMap map) {
//        this.map = map;
//    }
//
//    public OrthogonalTiledMapRenderer getRenderer() {
//        return renderer;
//    }
//
//    public void setRenderer(OrthogonalTiledMapRenderer renderer) {
//        this.renderer = renderer;
//    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }
}
