package com.example.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View

/**
 * Listing 4-15: Creating a new View
 */
class MyView : View {
    // Constructor required for in-code creation
    constructor(context: Context?) : super(context) {}

    // Constructor required for inflation from resource file
    constructor(context: Context?, ats: AttributeSet?, defaultStyle: Int) : super(
        context,
        ats,
        defaultStyle
    ) {
    }

    //Constructor required for inflation from resource file
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    //  @Override
    //  protected void onMeasure(int wMeasureSpec, int hMeasureSpec) {
    //    int measuredHeight = measureHeight(hMeasureSpec);
    //    int measuredWidth = measureWidth(wMeasureSpec);
    //
    //    // MUST make this call to setMeasuredDimension
    //    // or you will cause a runtime exception when
    //    // the control is laid out.
    //    setMeasuredDimension(measuredHeight, measuredWidth);
    //  }
    //
    //  private int measureHeight(int measureSpec) {
    //    int specMode = MeasureSpec.getMode(measureSpec);
    //    int specSize = MeasureSpec.getSize(measureSpec);
    //
    //     // [ ... Calculate the view height ... ]
    //
    //     return specSize;
    //  }
    //
    //  private int measureWidth(int measureSpec) {
    //    int specMode = MeasureSpec.getMode(measureSpec);
    //    int specSize = MeasureSpec.getSize(measureSpec);
    //
    //     // [ ... Calculate the view width ... ]
    //
    //     return specSize;
    //  }
    //
    //  @Override
    //  protected void onDraw(Canvas canvas) {
    //    // [ ... Draw your visual interface ... ]
    //  }
    /**
     * Listing 4-16: Drawing a custom View
     */
    override fun onDraw(canvas: Canvas) {
        // Get the size of the control based on the last call to onMeasure.
        val height = measuredHeight
        val width = measuredWidth

        // Find the center
        val px = width / 2
        val py = height / 2

        // Create the new paint brushes.
        // NOTE: For efficiency this should be done in
        // the views's constructor
        val mTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mTextPaint.color = Color.WHITE

        // Define the string.
        val displayText = "Hello World!"

        // Measure the width of the text string.
        val textWidth = mTextPaint.measureText(displayText)

        // Draw the text string in the center of the control.
        canvas.drawText(displayText, px - textWidth / 2, py.toFloat(), mTextPaint)
    }

    /**
     * Listing 4-17: A typical View measurement implementation
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val measuredHeight = measureHeight(heightMeasureSpec)
        val measuredWidth = measureWidth(widthMeasureSpec)
        setMeasuredDimension(measuredHeight, measuredWidth)
    }

    private fun measureHeight(measureSpec: Int): Int {
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        //  Default size if no limits are specified.
        var result = 500
        if (specMode == MeasureSpec.AT_MOST) {
            // Calculate the ideal size of your
            // control within this maximum size.
            // If your control fills the available
            // space return the outer bound.
            result = specSize
        } else if (specMode == MeasureSpec.EXACTLY) {
            // If your control can fit within these bounds return that value.
            result = specSize
        }
        return result
    }

    private fun measureWidth(measureSpec: Int): Int {
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        //  Default size if no limits are specified.
        var result = 500
        if (specMode == MeasureSpec.AT_MOST) {
            // Calculate the ideal size of your control
            // within this maximum size.
            // If your control fills the available space
            // return the outer bound.
            result = specSize
        } else if (specMode == MeasureSpec.EXACTLY) {
            // If your control can fit within these bounds return that value.
            result = specSize
        }
        return result
    }

    /**
     * Listing 4-18: Input event handling for Views
     */
    override fun onKeyDown(keyCode: Int, keyEvent: KeyEvent): Boolean {
        // Return true if the event was handled.
        return true
    }

    override fun onKeyUp(keyCode: Int, keyEvent: KeyEvent): Boolean {
        // Return true if the event was handled.
        return true
    }

    override fun onTrackballEvent(event: MotionEvent): Boolean {
        // Get the type of action this event represents
        val actionPerformed = event.action
        // Return true if the event was handled.
        return true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Get the type of action this event represents
        val actionPerformed = event.action
        // Return true if the event was handled.
        return true
    }
}