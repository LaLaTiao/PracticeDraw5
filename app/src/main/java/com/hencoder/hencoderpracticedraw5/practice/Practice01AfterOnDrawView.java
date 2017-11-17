package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.hencoder.hencoderpracticedraw5.R;

public class Practice01AfterOnDrawView extends AppCompatImageView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice01AfterOnDrawView(Context context) {
        super(context);
    }

    public Practice01AfterOnDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01AfterOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setColor(Color.parseColor("#FFC107"));
        paint.setTextSize(28);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 在 super.onDraw() 的下方插入绘制代码，让绘制内容盖住原主体内容
        // 由于这期的重点是绘制代码的位置而不是绘制代码本身，所以直接给出绘制代码，你只要解除注释就好
        // 爽吧？
        /**
         * 顺序是:
         *              drawBackground()     ==>不可重写,只能在xml配置background属性
         * ViewGroup    onDraw()
         * View         onDraw()
         * ViewGroup    diaspathDraw()
         * View         dispathDraw()       ==>由于 View 是没有子 View 的，所以一般来说 dispatchDraw() 这个方法只对 ViewGroup（以及它的子类）有意义。
         *              onDrawForeground
         *
         * Draw()是在整合了他们4个方法.
         * 如果写在super.draw()前面就是写在drawBackground()前面
         * 如果写在super.draw()后面,那么就是写在onDrawForeground后面.
         */
        Drawable drawable = getDrawable();
        if (drawable != null) {
            canvas.save();
            canvas.concat(getImageMatrix());
            Rect bounds = drawable.getBounds();
            canvas.drawText(getResources().getString(R.string.image_size, bounds.width(), bounds.height()), 20, 40, paint);
            canvas.restore();
        }
    }
}