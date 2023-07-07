package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Tank_star implements Screen{
	private SpriteBatch batch;
	//	Sprite sprite;
	private Texture tank_stars;
	private Texture new_game;
	private Texture exit_game;
	private Texture load_game;
	private Texture new_game_border;
	private Texture load_game_border;
	private Texture exit_game_border;
	private OrthographicCamera camera;
	//	SpriteBatch batch;
	private initial game;
	private TextureRegion background_texture;
	private ImageButton new_game_button;
	private ImageButton load_game_button;
	private ImageButton exit_game_button;
	private Viewport viewport;
//	private Rectangle rectangle;
	private Stage stage;
//	public Tank_star(final starting game){
//		this.game = game;
//	}
	public Tank_star(initial game) {
		this.game = game;
		batch = new SpriteBatch();
		tank_stars = new Texture(Gdx.files.internal("prty.png"));
		background_texture = new TextureRegion(tank_stars,0,0,1920,1000);
		new_game = new Texture(Gdx.files.internal("new_game_button.png"));
		load_game = new Texture(Gdx.files.internal("load_game_button.png"));
		exit_game = new Texture(Gdx.files.internal("exit_game_button.png"));
		new_game_border = new Texture(Gdx.files.internal("new_game_border.png"));
		load_game_border = new Texture(Gdx.files.internal("load_game_border.png"));
		exit_game_border = new Texture(Gdx.files.internal("exit_game_border.png"));

//		rectangle = new Rectangle(1450,500,430,100);

		ImageButton.ImageButtonStyle styleNewGameButton = new ImageButton.ImageButtonStyle();
		styleNewGameButton.up = new TextureRegionDrawable(new TextureRegion(new_game));
		styleNewGameButton.down = new TextureRegionDrawable(new TextureRegion(new_game_border));

		ImageButton.ImageButtonStyle styleLoadGameButton = new ImageButton.ImageButtonStyle();
		styleLoadGameButton.up = new TextureRegionDrawable(new TextureRegion(load_game));
		styleLoadGameButton.down = new TextureRegionDrawable(new TextureRegion(load_game_border));

		ImageButton.ImageButtonStyle styleExitGameButton = new ImageButton.ImageButtonStyle();
		styleExitGameButton.up = new TextureRegionDrawable(new TextureRegion(exit_game));
		styleExitGameButton.down = new TextureRegionDrawable(new TextureRegion(exit_game_border));

		new_game_button = new ImageButton(styleNewGameButton);
		load_game_button = new ImageButton(styleLoadGameButton);
		exit_game_button = new ImageButton(styleExitGameButton);
		camera = new OrthographicCamera();
		viewport = new FitViewport(Main_game.V_WIDTH,Main_game.V_HEIGHT,camera);
		camera.setToOrtho(false, 1920, 1000);

//		load_game_button = new ImageButton(styleLoadGameButton);
		stage = new Stage();
		Table table = new Table();
		table.setFillParent(true);
		table.right();
		table.add(new_game_button).padBottom(50).padTop(50);
		table.row();
//		table.row();
		table.add(load_game_button).padBottom(50);
		table.row();
//		table.row();
		table.add(exit_game_button);
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
//		tank_stars.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//		sprite = new Sprite(tank_stars);
	}

//	public void try1(){
//		if(Gdx.input.justTouched()){
//			Vector3 touchPos = new Vector3();
//			touchPos.set(Gdx.input.getX(),Gdx.input.getY(),0);
//			camera.unproject(touchPos);
//			if(rectangle.contains(touchPos.x,touchPos.y)){
////				System.out.println("new game");
//				game.setScreen(new tank_selection(game));
//				dispose();
//			}



//			game.setScreen(new Main_game(game));
//			dispose();
//		}
//	}
//	public void render(float delta) {
//
//		ScreenUtils.clear(0, 0, 0, 0);
//		camera.update();
//		batch.begin();
//		batch.draw(background_texture, 0, 0,1920,1080);
//		batch.draw(new_game,1300,600);
//		batch.draw(exit_game,1300,450);
//		batch.draw(load_game,1300,300);
//		batch.end();
////		if(Gdx.input.isTouched());
//	}

	public void show() {
//		new_game_button.addListener()
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,0,0,1);
		Gdx.gl.glClear((GL20.GL_COLOR_BUFFER_BIT));

		ScreenUtils.clear(0, 0, 0, 0);
		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);
		game.getBatch().begin();
		game.getBatch().draw(background_texture, 0, 0,1920,1000);
//		game.batch.draw(new_game,1450,500);
//		game.batch.draw(exit_game,1450,350);
//		game.batch.draw(load_game,1450,200);
//		new_game_button.setPosition(1300,600);
		game.getBatch().end();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		new_game_button.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dispose();
				game.setScreen(new tank_selection(game));
			}
		});
		load_game_button.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dispose();
				game.setScreen(new Main_game(game));
			}
		});
		exit_game_button.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
//				dispose();
//				game.setScreen(new Main_game(game));
				Gdx.app.exit();
			}
		});

//		if(Gdx.input.isTouched()){
//			game.setScreen(new Main_game(game));
//			dispose();
//		}
	}


//	public void render(float delta) {
//
//	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width,height);
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
//
//	@Override
//	public void pause() {
//
//	}
//
//	@Override
//	public void resume() {
//
//	}
//
//	@Override
//	public void hide() {
//
//	}

	@Override
	public void dispose () {
		batch.dispose();
		stage.dispose();

//		img.dispose();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public Texture getTank_stars() {
		return tank_stars;
	}

	public Texture getNew_game() {
		return new_game;
	}

	public Texture getExit_game() {
		return exit_game;
	}

	public Texture getLoad_game() {
		return load_game;
	}

	public Texture getNew_game_border() {
		return new_game_border;
	}

	public Texture getLoad_game_border() {
		return load_game_border;
	}

	public Texture getExit_game_border() {
		return exit_game_border;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public initial getGame() {
		return game;
	}

	public TextureRegion getBackground_texture() {
		return background_texture;
	}

	public ImageButton getNew_game_button() {
		return new_game_button;
	}

	public ImageButton getLoad_game_button() {
		return load_game_button;
	}

	public ImageButton getExit_game_button() {
		return exit_game_button;
	}

	public Viewport getViewport() {
		return viewport;
	}

//	public Rectangle getRectangle() {
//		return rectangle;
//	}

	public Stage getStage() {
		return stage;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public void setTank_stars(Texture tank_stars) {
		this.tank_stars = tank_stars;
	}

	public void setNew_game(Texture new_game) {
		this.new_game = new_game;
	}

	public void setExit_game(Texture exit_game) {
		this.exit_game = exit_game;
	}

	public void setLoad_game(Texture load_game) {
		this.load_game = load_game;
	}

	public void setNew_game_border(Texture new_game_border) {
		this.new_game_border = new_game_border;
	}

	public void setLoad_game_border(Texture load_game_border) {
		this.load_game_border = load_game_border;
	}

	public void setExit_game_border(Texture exit_game_border) {
		this.exit_game_border = exit_game_border;
	}

	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}

	public void setGame(initial game) {
		this.game = game;
	}

	public void setBackground_texture(TextureRegion background_texture) {
		this.background_texture = background_texture;
	}

	public void setNew_game_button(ImageButton new_game_button) {
		this.new_game_button = new_game_button;
	}

	public void setLoad_game_button(ImageButton load_game_button) {
		this.load_game_button = load_game_button;
	}

	public void setExit_game_button(ImageButton exit_game_button) {
		this.exit_game_button = exit_game_button;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

//	public void setRectangle(Rectangle rectangle) {
//		this.rectangle = rectangle;
//	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}

//package com.badlogic.drop;
