package com.sdufe.thea.guo.view;

import com.sdufe.thea.guo.R;

import android.R.array;
import android.R.integer;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomCircle extends View {

	private int firstColor;
	private int secondColor;
	private int thirdColor;
	private int firstAngle;
	private int secondAngle;
	private int thirdAngle;
	private Paint mPaint;

	public CustomCircle(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		mPaint=new Paint();

		TypedArray mArray = context.obtainStyledAttributes(attrs,
				R.styleable.CustomCircle, defStyleAttr, 0);
		firstColor = mArray.getColor(R.styleable.CustomCircle_firstColor,
				Color.BLUE);
		secondColor = mArray.getColor(R.styleable.CustomCircle_secondColor,
				Color.GREEN);
		thirdColor = mArray.getColor(R.styleable.CustomCircle_thirdColor,
				Color.RED);
		firstAngle=mArray.getInt(R.styleable.CustomCircle_firstAngle, 90);
		secondAngle=mArray.getInt(R.styleable.CustomCircle_secondAngle, 180);
		thirdAngle=mArray.getInt(R.styleable.CustomCircle_thirdAngle, 120);
		
		mArray.recycle();
	}

	public CustomCircle(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomCircle(Context context) {
		this(context, null);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		int center=getWidth()/2;
		int radius=center/2;
		mPaint.setColor(Color.GRAY);
		mPaint.setStrokeWidth(center);
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.STROKE);
		canvas.drawCircle(center, center, radius, mPaint);
		mPaint.setColor(firstColor);
		RectF rectF=new RectF(center-radius, center-radius, center+radius, center+radius);
		canvas.drawArc(rectF, 0, firstAngle, false, mPaint);
		mPaint.setColor(secondColor);
		canvas.drawArc(rectF, firstAngle, secondAngle, false, mPaint);
		mPaint.setColor(thirdColor);
		canvas.drawArc(rectF, secondAngle, thirdAngle, false, mPaint);
	}
}
