package com.example.mycodeschoolhomeworks.customView

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.example.mycodeschoolhomeworks.R

class MyCustomView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var mShowText: Boolean
    private var textPos: Int
    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MyCustomView,
            0, 0).apply {
            try {
                mShowText = getBoolean(R.styleable.MyCustomView_showText, false)
                textPos = getInteger(R.styleable.MyCustomView_labelPosition, 0)
            } finally {
                recycle()
            }
        }
    }

    fun isShowText():Boolean{
        return mShowText
    }

    fun setShowText(showText: Boolean){
        mShowText =showText
        invalidate()
        requestLayout()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(200, 200)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.apply {

        }
    }
}