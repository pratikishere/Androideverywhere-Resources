
package com.dragswipewithrecyclerview.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.dragswipewithrecyclerview.R;


public class MTextView extends AppCompatTextView {

    private int defaultDimension = 0;
    private int fontName;

    private int FONT_REG  = 1;
    private int FONT_BOLD = 2;
    private int FONT_SEMIBOLD = 3;
    private int FONT_LIGHT = 4;

    public MTextView(Context context) {
        super(context);
        init(null, 0);
    }
    public MTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }
    public MTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }
    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.custom_font, defStyle, 0);
        fontName = a.getInt(R.styleable.custom_font_name, defaultDimension);
        a.recycle();
        if (fontName == FONT_REG) {
            Typeface arialFont = Typeface
                    .createFromAsset(getContext().getAssets(), getContext().getString(R.string.roboto_reg));
            setFontType(arialFont);
        } else if (fontName == FONT_BOLD) {
            Typeface openSansFont = Typeface
                    .createFromAsset(getContext().getAssets(), getContext().getString(R.string.roboto_bold));
            setFontType(openSansFont);
        }
        else if (fontName == FONT_SEMIBOLD) {
            Typeface openSansFont = Typeface
                    .createFromAsset(getContext().getAssets(), getContext().getString(R.string.roboto_medium));
            setFontType(openSansFont);
        }
        else if (fontName == FONT_LIGHT) {
            Typeface openSansFont = Typeface
                    .createFromAsset(getContext().getAssets(), getContext().getString(R.string.roboto_light));
            setFontType(openSansFont);
        }
    }
    private void setFontType(Typeface font) {
            setTypeface(font);
    }
}
