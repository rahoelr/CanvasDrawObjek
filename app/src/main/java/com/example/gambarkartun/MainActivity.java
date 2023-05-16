package com.example.gambarkartun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Canvas canvas;
    private Paint paint = new Paint();
    private Paint paintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);

    private Paint paintCircle = new Paint();
    private Bitmap bitmap;
    private ImageView imageView;

    private Rect rect = new Rect();
    private Rect bounds = new Rect();
    private static final int OFFSET = 120;
    private int offset = OFFSET;
    private static final int MULTIPLIER = 100;

    private int colorHair;
    private int colorRectangle;
    private int colorOne;
    private int colorTwo;
    private int colorThree;
    private int colorFour;
    private int colorFive;
    private int colorSix;
    private int colorBg;
    private int colorBg2;

    private int colorBlack;
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorRectangle = ResourcesCompat.getColor(getResources(), R.color.colorRectangle, null);
        colorOne = ResourcesCompat.getColor(getResources(), R.color.colorOne, null);
        colorTwo = ResourcesCompat.getColor(getResources(), R.color.colorTwo, null);
        colorThree = ResourcesCompat.getColor(getResources(), R.color.colorThree, null);
        colorFour = ResourcesCompat.getColor(getResources(), R.color.colorFour, null);
        colorFive = ResourcesCompat.getColor(getResources(), R.color.colorFive, null);
        colorSix = ResourcesCompat.getColor(getResources(), R.color.colorSix, null);
        colorBg = ResourcesCompat.getColor(getResources(), R.color.colorBg, null);
        colorBg2 = ResourcesCompat.getColor(getResources(), R.color.colorBg2, null);
        colorBlack = ResourcesCompat.getColor(getResources(), R.color.black, null);

        imageView = findViewById(R.id.image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawSomething(v, count);
                count += 1;
            }
        });
    }

    public void drawSomething(View v, int count){
        int width = v.getWidth();
        int height = v.getHeight();
        int halfWidth = v.getWidth()/2;
        int halfHeight = v.getHeight()/2;
        float radius = (float) (Math.min(width/6, height/6));

        if(count == 0) {
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            imageView.setImageBitmap(bitmap);
            canvas = new Canvas(bitmap);
        }

        else if(count == 1){
            //bg
            paint.setColor(colorBg);
            Point k = new Point(halfWidth-1000, halfHeight-1000);
            Point l = new Point(halfWidth+1000, halfHeight-1000);
            Point m = new Point(halfWidth+1000, halfHeight+1000);
            Point n = new Point(halfWidth-1000, halfHeight+1000);

            Path bg = new Path();
            bg.setFillType(Path.FillType.EVEN_ODD);
            bg.lineTo(k.x, k.y);
            bg.lineTo(l.x, l.y);
            bg.lineTo(m.x, m.y);
            bg.lineTo(n.x, n.y);
            bg.lineTo(k.x, k.y);
            bg.close();

            canvas.drawPath(bg, paint);
        }

        else if(count == 2) {
            //bawah
            paint.setColor(colorFour);
            Point o = new Point(halfWidth - 800, halfHeight + 800);
            Point p = new Point(halfWidth + 800, halfHeight + 800);
            Point q = new Point(halfWidth + 800, halfHeight + 1000);
            Point r = new Point(halfWidth - 800, halfHeight + 1000);

            Path bg2 = new Path();
            bg2.setFillType(Path.FillType.EVEN_ODD);
            bg2.lineTo(o.x, o.y);
            bg2.lineTo(p.x, p.y);
            bg2.lineTo(q.x, q.y);
            bg2.lineTo(r.x, r.y);
            bg2.lineTo(o.x, o.y);
            bg2.close();

            canvas.drawPath(bg2, paint);
        }

        else if(count == 3) {
            //tembok
            paint.setColor(colorTwo);
            RectF rect3 = new RectF(halfWidth-400, halfHeight+800, halfWidth+400, halfHeight+30);
            canvas.drawRect(rect3, paint);
        }

        else if (count == 4) {
            //pintu
            paint.setColor(colorOne);
            RectF rect3 = new RectF(halfWidth-200, halfHeight+800, halfWidth+200, halfHeight+400);
            canvas.drawRect(rect3, paint);
        }

        else if (count == 5) {
            //jendela kiri
            paint.setColor(colorThree);
            RectF rect3 = new RectF(halfWidth-100, halfHeight+120, halfWidth-300, halfHeight+320);
            canvas.drawRect(rect3, paint);
        }

        else if (count == 6) {
            //jendela kanan
            paint.setColor(colorThree);
            RectF rect3 = new RectF(halfWidth+100, halfHeight+120, halfWidth+300, halfHeight+320);
            canvas.drawRect(rect3, paint);
        }

        else if (count == 7) {
            //jendela gagang pintu
            paint.setColor(colorBlack);
            canvas.drawCircle(halfWidth+130, halfHeight+600,32,paint);
        }

        v.invalidate();
    }
}
