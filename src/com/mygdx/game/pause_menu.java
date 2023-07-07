package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class pause_menu implements Screen {

    private Texture exit;
    private Texture resume;
    private Texture background;
    private SpriteBatch batch;
    private BitmapFont font;
    private OrthographicCamera camera;
    private initial game;

    private ImageButton exit_button;
    private ImageButton resume_button;

    private Stage stage;
    private TextureRegion background_texture;
    private Viewport viewport;

    public pause_menu(initial game){
        this.game = game;
        batch = new SpriteBatch();
        font = new BitmapFont();
        stage = new Stage();
        background = new Texture("main_bg.png");
        exit = new Texture("exit_green (1).png");
        resume = new Texture("resume_green.png");
        exit_button = new ImageButton(new TextureRegionDrawable(new TextureRegion(exit)));
        resume_button = new ImageButton(new TextureRegionDrawable(new TextureRegion(resume)));
        background_texture = new TextureRegion(background,0,0,1920,1000);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1000);
//        exit_button.setPosition(100, 100);
//        resume_button.setPosition(100, 200);
        viewport = new FitViewport(1920,1000, camera);

        Table table = new Table();
        table.setFillParent(true);
        table.center();
        table.add(resume_button);
        table.row();
        table.add(exit_button);
//        stage.addActor(exit_button);
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ScreenUtils.clear(0,0,0,0);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);
        game.getBatch().begin();
        game.getBatch().draw(background_texture, 0, 0, 1920,1000);
        game.getBatch().end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();



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
        batch.dispose();
        stage.dispose();
    }

    public Texture getExit() {
        return exit;
    }

    public void setExit(Texture exit) {
        this.exit = exit;
    }

    public Texture getResume() {
        return resume;
    }

    public void setResume(Texture resume) {
        this.resume = resume;
    }

    public Texture getBackground() {
        return background;
    }

    public void setBackground(Texture background) {
        this.background = background;
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

    public ImageButton getExit_button() {
        return exit_button;
    }

    public void setExit_button(ImageButton exit_button) {
        this.exit_button = exit_button;
    }

    public ImageButton getResume_button() {
        return resume_button;
    }

    public void setResume_button(ImageButton resume_button) {
        this.resume_button = resume_button;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public TextureRegion getBackground_texture() {
        return background_texture;
    }

    public void setBackground_texture(TextureRegion background_texture) {
        this.background_texture = background_texture;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }
}
