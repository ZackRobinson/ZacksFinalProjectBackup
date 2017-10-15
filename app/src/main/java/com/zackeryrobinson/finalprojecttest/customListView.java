package com.zackeryrobinson.finalprojecttest;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by ios on 10/12/17.
 */

public class customListView extends ListView {

    private android.view.ViewGroup.LayoutParams params;
    private int oldCount = 0;

    public customListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if (getCount() != oldCount)
        {
            int height = getChildAt(0).getHeight() + 1 ;
            oldCount = getCount();
            params = getLayoutParams();
            params.height = getCount() * height;
            setLayoutParams(params);
        }

        super.onDraw(canvas);
    }

}
