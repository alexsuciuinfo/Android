package com.alex0x123.baloonboom;

/**
 * Created by Alex0x123 on 27/06/2015.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Random;



public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    public static final int WIDTH = 1660;
    public static final int HEIGHT = 450;
    public static final int MOVESPEED = -5;
    private long missileStartTime;
    private MainThread thread;
    private Background bg;
    private Player player;
    private ArrayList<Missile> missiles;
    private ArrayList<TopBorder> topborder;
    private ArrayList<BotBorder> botborder;
    private Random rand = new Random();
    private int maxBorderHeight = 2;
    private int minBorderHeight = 2;
    private boolean topDown = true;
    private boolean botDown = true;
    private boolean newGameCreated;
    private int image = 0;
    private SharedPreferences prefs;


    private ArrayList<Integer> myImageList;

    //Characters
    private ArrayList<Character> characters;

    //increase to slow down difficulty progression, decrease to speed up difficulty progression
    private int progressDenom = 20;

    private Explosion explosion;
    private long startReset;
    private boolean reset;
    private boolean dissapear;
    private boolean started;
    private int best;



    public GamePanel(Context context)
    {
        super(context);


        prefs = context.getSharedPreferences("saves",Context.MODE_PRIVATE);

        best = prefs.getInt("score",0);

        //add the callback to the surfaceholder to intercept events
        getHolder().addCallback(this);



        //make gamePanel focusable so it can handle events
        setFocusable(true);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        int counter = 0;
        while(retry && counter<1000)
        {
            counter++;
            try{thread.setRunning(false);
                thread.join();
                retry = false;
                thread = null;

            }catch(InterruptedException e){e.printStackTrace();}

        }

    }



    public int getCaracter() {
        return prefs.getInt("caracter", 1);
    }

    public void setBestScore(int score) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("score", score);
        editor.commit();
    }

    public void setCoins(int coins) {

        SharedPreferences.Editor editor = prefs.edit();
        int x = prefs.getInt("money",0) + coins;
        editor.putInt("money",x);
        editor.commit();
    }


    public void surfaceCreated(SurfaceHolder holder){


        characters = new ArrayList<Character>();
        characters.add(new Character(R.drawable.biiirrrd,64,54,4));
        characters.add(new Character(R.drawable.buttterflyy,57,37,7));
        characters.add(new Character(R.drawable.bbbeeee,55,52,3));
        characters.add(new Character(R.drawable.dragggooon,99,70,5));
        characters.add(new Character(R.drawable.horssseee,116,97,6));
        characters.add(new Character(R.drawable.baattt,71,57,4));



        int i = getCaracter() - 1;
        int draw = characters.get(i).draw;
        int w = characters.get(i).wid;
        int h = characters.get(i).hei;
        int num = characters.get(i).num;


        bg = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.background1));
        player = new Player(BitmapFactory.decodeResource(getResources(), draw), w, h, num);
        missiles = new ArrayList<Missile>();
        topborder = new ArrayList<TopBorder>();
        botborder = new ArrayList<BotBorder>();
        missileStartTime = System.nanoTime();

        myImageList = new ArrayList<Integer>();
        myImageList.add(R.drawable.balloonx);
        myImageList.add(R.drawable.balloonx1);
        myImageList.add(R.drawable.balloonx2);
        myImageList.add(R.drawable.balloonsx);

        thread = new MainThread(getHolder(), this);
        //we can safely start the game loop
        thread.setRunning(true);
        thread.start();

    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            if(!player.getPlaying() && newGameCreated && reset)
            {
                player.setPlaying(true);
                player.setUp(true);
            }
            if(player.getPlaying())
            {

                if(!started)started = true;
                reset = false;
                player.setUp(true);
            }
            return true;
        }
        if(event.getAction()==MotionEvent.ACTION_UP)
        {
            player.setUp(false);
            return true;
        }

        return super.onTouchEvent(event);
    }

    public void update()

    {
        if(player.getPlaying()) {

            if(botborder.isEmpty())
            {
                player.setPlaying(false);
                return;
            }
            if(topborder.isEmpty())
            {
                player.setPlaying(false);
                return;
            }

            bg.update();
            player.update();


            //check bottom border collision
            for(int i = 0; i<botborder.size(); i++)
            {
                if(collision(botborder.get(i), player))
                    player.setPlaying(false);
            }

            //check top border collision
            for(int i = 0; i <topborder.size(); i++)
            {
                if(collision(topborder.get(i),player))
                    player.setPlaying(false);
            }

            //update top border
            //this.updateTopBorder();

            //udpate bottom border
            //this.updateBottomBorder();

            //add missiles on timer
            long missileElapsed = (System.nanoTime()-missileStartTime)/1000000;
            if(missileElapsed >(2000 - player.getScore()/4)){


                //first missile always goes down the middle
                if(missiles.size()==0)
                {

                    image = rand.nextInt(4);
                    missiles.add(new Missile(BitmapFactory.decodeResource(getResources(),myImageList.get(image)
                    ),WIDTH + 10, HEIGHT/2, 50, 53, player.getScore(), 1));
                }
                else
                {
                    image = rand.nextInt(3);
                    missiles.add(new Missile(BitmapFactory.decodeResource(getResources(),myImageList.get(image)),
                            WIDTH+10, (int)(rand.nextDouble()*(HEIGHT - (maxBorderHeight * 2))+maxBorderHeight),50,53, player.getScore(),1));
                }

                //reset timer
                missileStartTime = System.nanoTime();
            }
            //loop through every missile and check collision and remove
            for(int i = 0; i<missiles.size();i++)
            {
                //update missile
                missiles.get(i).update();

                if(collision(missiles.get(i),player))
                {
                    missiles.remove(i);
                    player.setPlaying(false);
                    break;
                }
                //remove missile if it is way off the screen
                if(missiles.get(i).getX()<-100)
                {
                    missiles.remove(i);
                    break;
                }
            }

        }

        else{
            player.resetDY();
            if(!reset)
            {
                newGameCreated = false;
                startReset = System.nanoTime();
                reset = true;
                dissapear = true;
                explosion = new Explosion(BitmapFactory.decodeResource(getResources(),R.drawable.explosss),player.getX(),
                        player.getY()-30, 100, 100, 11);
            }

            explosion.update();
            long resetElapsed = (System.nanoTime()-startReset)/1000000;

            if(resetElapsed > 2500 && !newGameCreated)
            {
                newGame();
            }


        }

    }
    public boolean collision(GameObject a, GameObject b)
    {
        if(Rect.intersects(a.getRectangle(), b.getRectangle()))
        {
            return true;
        }
        return false;
    }
    @Override
    public void draw(Canvas canvas)
    {
        final float scaleFactorX = getWidth()/(WIDTH*1.f);
        final float scaleFactorY = getHeight()/(HEIGHT*1.f);

        if(canvas!=null) {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            bg.draw(canvas);
            if(!dissapear) {
                player.draw(canvas);
            }
            //draw missiles
            for(Missile m: missiles)
            {
                m.draw(canvas);
            }


            //draw topborder
            for(TopBorder tb: topborder)
            {
                tb.draw(canvas);
            }

            //draw botborder
            for(BotBorder bb: botborder)
            {
                bb.draw(canvas);
            }
            //draw explosion
            if(started)
            {
                explosion.draw(canvas);
            }
            drawText(canvas);
            canvas.restoreToCount(savedState);

        }
    }

    public void newGame()
    {
        dissapear = false;

        botborder.clear();
        topborder.clear();

        missiles.clear();

        minBorderHeight = 5;
        maxBorderHeight = 30;

        if(player.getScore()>best)
        {
            best = player.getScore();
            setBestScore(best);
        }

        int ban = player.getScore()/100;
        setCoins(ban);

        player.resetDY();
        player.resetScore();
        player.setY(HEIGHT/2);



        //create initial borders

        //initial top border
        for(int i = 0; i*500<WIDTH+40;i++)
        {
            //first top border create
            if(i==0)
            {
                topborder.add(new TopBorder(BitmapFactory.decodeResource(getResources(),R.drawable.brick1
                ),i*500,0,2));
            }
            else
            {
                topborder.add(new TopBorder(BitmapFactory.decodeResource(getResources(),R.drawable.brick1
                ),i*500,0, 2));
            }
        }
        //initial bottom border
        for(int i = 0; i*500<WIDTH+40; i++)
        {
            //first border ever created
            if(i==0)
            {
                botborder.add(new BotBorder(BitmapFactory.decodeResource(getResources(),R.drawable.brick)
                        ,i*500,HEIGHT - 2));
            }
            //adding borders until the initial screen is filed
            else
            {
                botborder.add(new BotBorder(BitmapFactory.decodeResource(getResources(), R.drawable.brick),
                        i * 500, HEIGHT - 2));
            }
        }

        newGameCreated = true;


    }
    public void drawText(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        canvas.drawText("SCORE: " + (player.getScore()), 10, HEIGHT - 10, paint);
        canvas.drawText("BEST: " + best, WIDTH - 215, HEIGHT - 10, paint);

        if(!player.getPlaying()&&newGameCreated&&reset)
        {
            Paint paint1 = new Paint();
            paint1.setTextSize(35);
            paint1.setColor(-16711936);
            paint1.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
            canvas.drawText("PRESS AND PLAY THE GAME !", WIDTH/2-50, HEIGHT/2, paint1);

        }
    }

}