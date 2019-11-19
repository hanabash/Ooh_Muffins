package item_decorations;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

    private Drawable divider;

    // default divider will be used
    public DividerItemDecoration(Context context) {
        final TypedArray styledAtrributes = context.obtainStyledAttributes(ATTRS);
        divider = styledAtrributes.getDrawable(0);
        styledAtrributes.recycle();
    }

    // custom divider will be used
    public DividerItemDecoration(Context context, int resId) {
        divider = ContextCompat.getDrawable(context, resId);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for(int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int botttom = top + divider.getIntrinsicHeight();

            divider.setBounds(left, top, right, botttom);
            divider.draw(c);
        }

    }

}
