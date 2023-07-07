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
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class tank_selection implements Screen {
    private Texture background;
//    Rectangle r1;
//    Rectangle r2;
    private TextureRegion background_texture;
    private SpriteBatch batch;
    private Viewport viewport;

    private initial game;
    private OrthographicCamera camera;

//    Texture viewtank;
    private Texture helios;
    private Texture Helios_b;
    private Texture Helios_wb;

    private Texture T_32;
    private Texture T_32_b;
    private Texture T_32_wb;

    private Texture atomic;
    private Texture atomic_b;
    private Texture atomic_wb;
//    Texture helios;
//    Texture t_32;
    private Texture select_b;
    private Texture select_wb;
    private Texture player1;
    private Texture player2;
    private Texture player1_wb;
    private Texture player2_wb;
    private ImageButton helios_button;
    private ImageButton t_32_button;
    private ImageButton atomic_button;
    private Image tankImage;
    private ImageButton select_button;
    private ImageButton player_1;
    private ImageButton player_2;
//    private Player p1 = Player.players.get(0);
    private Stage stage;
    int choose= 1;
    int flag = 0;
//    Stage stage2;

    public tank_selection(initial game){

        this.game = game;
        batch = new SpriteBatch();
        background = new Texture("blur_bg2.png");
//        viewtank = new Texture("helios.png");
        helios = new Texture("helios.png");
        T_32 = new Texture("T-32.png");
        atomic = new Texture("helios.png");

        Helios_b = new Texture("Helios_border.png");
        Helios_wb = new Texture("Helios_button.png");
        T_32_b = new Texture("T-32_border.png");
        T_32_wb = new Texture("T-32_button.png");
        atomic_b = new Texture("atomic_border.png");
        atomic_wb = new Texture("atomic_button.png");
        select_b = new Texture("select_button_b.png");
        select_wb = new Texture("select_button_wb.png");
        player1 = new Texture("player1_yellow.png");
        player2 = new Texture("player2_yellow.png");
        player1_wb = new Texture("player1_yellow_wb.png");
        player2_wb = new Texture("player2_yellow_wb.png");

        background_texture = new TextureRegion(background,0,0,1920,1000);

        ImageButton.ImageButtonStyle helios_button_style = new ImageButton.ImageButtonStyle();
        helios_button_style.up = new TextureRegionDrawable(new TextureRegion(Helios_wb));
        helios_button_style.down = new TextureRegionDrawable(new TextureRegion(Helios_b));
        helios_button = new ImageButton(helios_button_style);

        ImageButton.ImageButtonStyle t_32_button_style = new ImageButton.ImageButtonStyle();
        t_32_button_style.up = new TextureRegionDrawable(new TextureRegion(T_32_wb));
        t_32_button_style.down = new TextureRegionDrawable(new TextureRegion(T_32_b));
        t_32_button = new ImageButton(t_32_button_style);

        ImageButton.ImageButtonStyle atomic_button_style = new ImageButton.ImageButtonStyle();
        atomic_button_style.up = new TextureRegionDrawable(new TextureRegion(atomic_wb));
        atomic_button_style.down = new TextureRegionDrawable(new TextureRegion(atomic_b));
        atomic_button = new ImageButton(atomic_button_style);

        ImageButton.ImageButtonStyle select_button_style = new ImageButton.ImageButtonStyle();
        select_button_style.up = new TextureRegionDrawable(new TextureRegion(select_wb));
        select_button_style.down = new TextureRegionDrawable(new TextureRegion(select_b));
        select_button = new ImageButton(select_button_style);

        ImageButton.ImageButtonStyle player_1_style = new ImageButton.ImageButtonStyle();
        player_1_style.up = new TextureRegionDrawable(new TextureRegion(player1_wb));
        player_1_style.down = new TextureRegionDrawable(new TextureRegion(player1));
        player_1 = new ImageButton(player_1_style);

        ImageButton.ImageButtonStyle player_2_style = new ImageButton.ImageButtonStyle();
        player_2_style.up = new TextureRegionDrawable(new TextureRegion(player2_wb));
        player_2_style.down = new TextureRegionDrawable(new TextureRegion(player2));
        player_2 = new ImageButton(player_2_style);


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1000);
        viewport = new FitViewport(Main_game.V_WIDTH,Main_game.V_HEIGHT,camera);

        stage = new Stage();
        Table table1 = new Table();
        table1.setFillParent(true);
        table1.right();
        table1.add(helios_button).padBottom(50).padTop(50);
        table1.row();
        table1.add(t_32_button).padBottom(50);
        table1.row();
        table1.add(atomic_button).padBottom(50);
        table1.row();
//        table1.add(select_button).padRight(500);
        stage.addActor(table1);

        tankImage = new Image(new TextureRegionDrawable(new TextureRegion(helios)));
//        stage2 = new Stage();
        Table table2 = new Table();
        table2.left();
        table2.setFillParent(true);
//        table2.setPosition(0,0);
        table2.add(tankImage).padLeft(300);
        table2.row();
//        toable2.add(select_button).padLeft();
        stage.addActor(table2);

        Table table3 = new Table();
        table3.bottom();
        table3.setFillParent(true);
        table3.add(player_1).padRight(50);
        table3.add(player_2).padLeft(50);
        table3.add(select_button).padRight(70);
        stage.addActor(table3);
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear((GL20.GL_COLOR_BUFFER_BIT));

        ScreenUtils.clear(0, 0, 0, 0);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);
        game.getBatch().begin();
        game.getBatch().draw(background_texture, 0, 0, 1920, 1000);
        game.getBatch().end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        helios_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                choose = 1;
                tankImage.setDrawable(new TextureRegionDrawable(new TextureRegion(helios)));

            }
        });

        t_32_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                choose = 2;
                tankImage.setDrawable(new TextureRegionDrawable(new TextureRegion(T_32)));
            }
        });

        atomic_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                choose = 3;
                tankImage.setDrawable(new TextureRegionDrawable(new TextureRegion(helios)));
            }
        });

        player_1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (choose == 1) {
//                        System.out.println();
                    Player.players.get(0).setTank(Tanks.tanks.get(0));
                    Player.players.get(0).setPlayer_health(Tanks.tanks.get(0).getTank_health());
                    Player.players.get(0).setPlayer_fuel(Tanks.tanks.get(0).getTank_fuel());
//                        System.out.println(0);
//                        System.out.println(Player.players.get(0).getTank().getTank_health());
                } else if (choose == 2) {
                    Player.players.get(0).setTank(Tanks.tanks.get(1));
                    Player.players.get(0).setPlayer_health(Tanks.tanks.get(1).getTank_health());
                    Player.players.get(0).setPlayer_fuel(Tanks.tanks.get(1).getTank_fuel());
//                        System.out.println(0);

//                        System.out.println(Player.players.get(0).getTank().getTank_health());
                } else if (choose == 3) {
                    Player.players.get(0).setTank(Tanks.tanks.get(2));
                    Player.players.get(0).setPlayer_health(Tanks.tanks.get(2).getTank_health());
                    Player.players.get(0).setPlayer_fuel(Tanks.tanks.get(2).getTank_fuel());
//                        System.out.println(0);
                }
            }
        });
        player_2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (choose == 1) {
//                        System.out.println();
                    Player.players.get(1).setTank(Tanks.tanks.get(0));
                    Player.players.get(1).setPlayer_health(Tanks.tanks.get(0).getTank_health());
                    Player.players.get(1).setPlayer_fuel(Tanks.tanks.get(0).getTank_fuel());
//                        System.out.println(0);
//                        System.out.println(Player.players.get(0).getTank().getTank_health());
                } else if (choose == 2) {
                    Player.players.get(1).setTank(Tanks.tanks.get(1));
                    Player.players.get(1).setPlayer_health(Tanks.tanks.get(1).getTank_health());
                    Player.players.get(1).setPlayer_fuel(Tanks.tanks.get(1).getTank_fuel());
//                        System.out.println(0);

//                        System.out.println(Player.players.get(0).getTank().getTank_health());
                } else if (choose == 3) {
                    Player.players.get(1).setTank(Tanks.tanks.get(2));
                    Player.players.get(1).setPlayer_health(Tanks.tanks.get(2).getTank_health());
                    Player.players.get(1).setPlayer_fuel(Tanks.tanks.get(2).getTank_fuel());
//                        System.out.println(0);
                }
            }
        });
//
            select_button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
//                game.setScreen(new Main_game(game));
                game.setScreen(new Main_game(game));
            }
        });
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

    public Texture getBackground() {
        return background;
    }

    public void setBackground(Texture background) {
        this.background = background;
    }

    public TextureRegion getBackground_texture() {
        return background_texture;
    }

    public void setBackground_texture(TextureRegion background_texture) {
        this.background_texture = background_texture;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public initial getGame() {
        return game;
    }

    public void setGame(initial game) {
        this.game = game;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public Texture getHelios() {
        return helios;
    }

    public void setHelios(Texture helios) {
        this.helios = helios;
    }

    public Texture getHelios_b() {
        return Helios_b;
    }

    public void setHelios_b(Texture helios_b) {
        Helios_b = helios_b;
    }

    public Texture getHelios_wb() {
        return Helios_wb;
    }

    public void setHelios_wb(Texture helios_wb) {
        Helios_wb = helios_wb;
    }

    public Texture getT_32() {
        return T_32;
    }

    public void setT_32(Texture t_32) {
        T_32 = t_32;
    }

    public Texture getT_32_b() {
        return T_32_b;
    }

    public void setT_32_b(Texture t_32_b) {
        T_32_b = t_32_b;
    }

    public Texture getT_32_wb() {
        return T_32_wb;
    }

    public void setT_32_wb(Texture t_32_wb) {
        T_32_wb = t_32_wb;
    }

    public Texture getAtomic() {
        return atomic;
    }

    public void setAtomic(Texture atomic) {
        this.atomic = atomic;
    }

    public Texture getAtomic_b() {
        return atomic_b;
    }

    public void setAtomic_b(Texture atomic_b) {
        this.atomic_b = atomic_b;
    }

    public Texture getAtomic_wb() {
        return atomic_wb;
    }

    public void setAtomic_wb(Texture atomic_wb) {
        this.atomic_wb = atomic_wb;
    }

    public Texture getSelect_b() {
        return select_b;
    }

    public void setSelect_b(Texture select_b) {
        this.select_b = select_b;
    }

    public Texture getSelect_wb() {
        return select_wb;
    }

    public void setSelect_wb(Texture select_wb) {
        this.select_wb = select_wb;
    }

    public ImageButton getHelios_button() {
        return helios_button;
    }

    public void setHelios_button(ImageButton helios_button) {
        this.helios_button = helios_button;
    }

    public ImageButton getT_32_button() {
        return t_32_button;
    }

    public void setT_32_button(ImageButton t_32_button) {
        this.t_32_button = t_32_button;
    }

    public ImageButton getAtomic_button() {
        return atomic_button;
    }

    public void setAtomic_button(ImageButton atomic_button) {
        this.atomic_button = atomic_button;
    }

    public Image getTankImage() {
        return tankImage;
    }

    public void setTankImage(Image tankImage) {
        this.tankImage = tankImage;
    }

    public ImageButton getSelect_button() {
        return select_button;
    }

    public void setSelect_button(ImageButton select_button) {
        this.select_button = select_button;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
