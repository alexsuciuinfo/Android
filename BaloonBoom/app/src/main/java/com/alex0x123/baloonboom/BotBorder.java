package com.alex0x123.baloonboom;

/**
 * Created by Alex0x123 on 27/06/2015.
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class BotBorder extends GameObject{

    private Bitmap image;
    public BotBorder(Bitmap res, int x, int y)
    {
        height = 4;
        width = 500;

        this.x = x;
        this.y = y;
        dx = GamePanel.MOVESPEED;

        image = Bitmap.createBitmap(res, 0, 0, width, height);

    }
    public void update()
    {
        x +=dx;

    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y, null);

    }
}
