package com.example.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * 
 * ElasticScrollView有弹性的ScrollView
 * 
 *
 * @author chenyu   Email:981214993@qq.com  T:15921892585
 * @version 2016/12/15 17:15
 * 
 */
public class ElasticScrollView extends ScrollView {
   private View inner;
   private float y;
   private Rect normal = new Rect();
   private boolean DOWN = true;

   public ElasticScrollView(Context context) {
      super(context);
   }

   public ElasticScrollView(Context context, AttributeSet attrs) {
      super(context, attrs);
   }

   @Override
   protected void onFinishInflate() {
      super.onFinishInflate();
      if (getChildCount() > 0) {
         inner = getChildAt(0);
      }
   }

   @Override
   public boolean onTouchEvent(MotionEvent ev) {
      if (inner == null) {
         return super.onTouchEvent(ev);
      } else {
         switch (ev.getAction()) {
         // case MotionEvent.ACTION_DOWN:
         // y = ev.getY();
         // break;
         case MotionEvent.ACTION_UP:
            if (!normal.isEmpty()) {
               // 开启移动动画
               TranslateAnimation ta = new TranslateAnimation(0, 0,
                     inner.getTop(), normal.top);
               ta.setDuration(200);
               inner.startAnimation(ta);
               // 设置回到正常的布局位置
               inner.layout(normal.left, normal.top, normal.right,
                     normal.bottom);
               normal.setEmpty();
            }
            DOWN = true;
            break;
         case MotionEvent.ACTION_MOVE:
            if (DOWN) {
               y = ev.getY();
               DOWN = false;
            }
            final float preY = y;
            float nowY = ev.getY();
            int deltaY = (int) (preY - nowY);
            // 滚动
            scrollBy(0, deltaY);
            y = nowY;
            // 当滚动到最上或者最下时就不会再滚动，这时移动布局
            if (isNeedMove(ev)) {
               if (normal.isEmpty()) {
                  // 保存正常的布局位置
                  normal.set(inner.getLeft(), inner.getTop(),
                        inner.getRight(), inner.getBottom());
               }
               // 移动布局
               inner.layout(inner.getLeft(), inner.getTop() - deltaY,
                     inner.getRight(), inner.getBottom() - deltaY);
            }
            break;
         default:
            break;
         }
      }
      return super.onTouchEvent(ev);
   }

   // 是否需要移动布局
   public boolean isNeedMove(MotionEvent ev) {
      int offset = inner.getMeasuredHeight() - getHeight();
      int scrollY = getScrollY();
      if (scrollY == 0 || scrollY == offset) {
         return true;
      }
      return false;
   }
}