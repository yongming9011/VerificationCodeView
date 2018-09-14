package com.zhangym.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.zhangym.R;

import java.util.Random;

/**
 * 验证码控件
 * Created by zhangyongming on 2017/1/14.
 */
public class VerificationCodeView extends View {
    /**
     * 验证码文本
     */
    private String mVerificationText;

    /**
     * 验证码文本的颜色,默认为黑色
     */
    private int mTextColor = Color.BLACK;

    /**
     * 验证码文本大小，默认为16
     */
    private int mTextSize = 16;

    /**
     * 是否有下划线
     */
    private boolean isUnderLine;

    /**
     * 文本是否为粗体
     */
    private boolean isTextBold;

    /**
     * 文本的倾斜度，正数为左斜，负数为右斜，默认0f
     */
    private float mTextSkewX = 0f;

//    /**
//     * 文字风格
//     */
//    private int mTypeFace;

    /**
     * 文字宽度
     */
    private float mStrokeWidth;

    /**
     * 是否显示干扰线条，默认true
     */
    private boolean isShowInterferenceLines = true;

    /**
     * 干扰线条的数量,默认10条
     */
    private int mInterferenceLinesCount = 10;

    /**
     * 干扰线条的颜色,默认为黑色
     */
    private int mInterferenceLinesColor = Color.BLACK;

    /**
     * 干扰线条的宽度，默认3
     */
    private float mInterferenceLinesWidth = 3f;

    /**
     * 是否显示干扰圆点，默认为true
     */
    private boolean isShowInterferenceCircles = true;

    /**
     * 干扰圆点的数量，默认100个
     */
    private int mInterferenceCirclesCount = 100;

    /**
     * 干扰圆点的颜色，默认黑色
     */
    private int mInterferenceCirclesColor = Color.BLACK;

    /**
     * 干扰圆点的半径，默认为5
     */
    private float mInterferenceCirclesRadius = 5f;

    /**
     * 验证码的背景色
     */
    private int mVerificationCodeBackground = Color.GRAY;

    /**
     * 干扰圆点的颜色是否随机，如果手动设置了了mInterferenceCircleColor的值，该值为false
     */
    private boolean isCircleColorRandom = true;

    /**
     * 干扰线的颜色是否随机，如果手动设置了了mInterferenceLinesColor的值，该值为false
     */
    private boolean isLineColorRandom = true;

    /**
     * 画笔
     */
    private Paint mPaint = new Paint();

    /**
     * 随机函数
     */
    private Random mRandom = new Random();

    /**
     * 文本的绘制区域
     */
    private Rect mTextRect = new Rect();

    /**
     * 是否在刷新的时候调用requestLayout()方法重新计算控件宽高，
     * 如果首次未设置mVerificationText的值，然后再次设置mVerificationText的值的时候刷新则需要重新计算控件宽高
     */
    private boolean isNeedRequesLayout = false;

    /**
     * 是否显示干扰线条
     *
     * @return 是否显示干扰线条的boolean值
     */
    public boolean isShowInterferenceLines() {
        return isShowInterferenceLines;
    }

    /**
     * 设置是否显示干扰线条
     *
     * @param showInterferenceLines 是否显示干扰线条的boolean值
     */
    public void setShowInterferenceLines(boolean showInterferenceLines) {
        isShowInterferenceLines = showInterferenceLines;
    }

    /**
     * 是否显示干扰圆点
     *
     * @return 是否显示干扰圆点的boolean值
     */
    public boolean isShowInterferenceCircles() {
        return isShowInterferenceCircles;
    }

    /**
     * 设置是否显示干扰圆点
     *
     * @param showInterferenceCircles 是否显示干扰圆点的boolean值
     */
    public void setShowInterferenceCircles(boolean showInterferenceCircles) {
        isShowInterferenceCircles = showInterferenceCircles;
    }

    /**
     * 文本是否为粗体
     *
     * @return 文本是否为粗体的boolean值
     */
    public boolean isTextBold() {
        return isTextBold;
    }

    /**
     * 设置文本是否为粗体
     *
     * @param textBold 文本是否为粗体的boolean值
     */
    public void setTextBold(boolean textBold) {
        isTextBold = textBold;
    }

    /**
     * 获取干扰圆点的颜色是否随机
     *
     * @return 干扰圆点的颜色是否随机的boolean值
     */
    public boolean isCircleColorRandom() {
        return isCircleColorRandom;
    }

    /**
     * 设置干扰圆点的颜色是否随机
     *
     * @param circleColorRandom 干扰圆点的颜色是否随机的boolean值
     */
    public void setCircleColorRandom(boolean circleColorRandom) {
        isCircleColorRandom = circleColorRandom;
    }

    /**
     * 获取线条颜色是否随机
     *
     * @return 线条颜色是否随机的boolean
     */
    public boolean isLineColorRandom() {
        return isLineColorRandom;
    }

    /**
     * 设置线条颜色是否随机
     *
     * @param lineColorRandom 线条颜色是否随机的boolean
     */
    public void setLineColorRandom(boolean lineColorRandom) {
        isLineColorRandom = lineColorRandom;
    }

    /**
     * 获取验证码文本
     *
     * @return 验证码文本的String值
     */
    public String getVerificationText() {
        return mVerificationText;
    }

    /**
     * 设置验证码文本
     *
     * @param verificationText 验证码文本的String值
     */
    public void setVerificationText(String verificationText) {
        if (getVerificationText() == null || "".equals(getVerificationText())) {
            isNeedRequesLayout = true;
        }

        mVerificationText = verificationText;

        // 刷新控件
        if (isNeedRequesLayout) {
            this.requestLayout();
            isNeedRequesLayout = false;
        }
        postInvalidate();
    }

    /**
     * 获取控件的背景色
     *
     * @return int类型的color值
     */
    public int getVerificationCodeBackground() {
        return mVerificationCodeBackground;
    }

    /**
     * 设置控件的背景色
     *
     * @param verificationCodeBackground int类型的color值
     */
    public void setVerificationCodeBackground(int verificationCodeBackground) {
        mVerificationCodeBackground = verificationCodeBackground;
    }

    /**
     * 获取干扰线条的数量
     *
     * @return 线条数量
     */
    public int getInterferenceLinesCount() {
        return mInterferenceLinesCount;
    }

    /**
     * 设置干扰线条的数量
     *
     * @param interferenceLinesCount 线条数量
     */
    public void setInterferenceLinesCount(int interferenceLinesCount) {
        mInterferenceLinesCount = interferenceLinesCount;
    }

    /**
     * 设置干扰线条的颜色
     *
     * @param interferenceLinesColor 干扰线条的颜色int值
     */
    public void setInterferenceLinesColor(int interferenceLinesColor) {
        // 关闭颜色随机
        isLineColorRandom = false;
        mInterferenceLinesColor = interferenceLinesColor;
    }

    /**
     * 获取干扰线条的宽度
     *
     * @return 线条的宽度值
     */
    public float getInterferenceLinesWidth() {
        return mInterferenceLinesWidth;
    }

    /**
     * 设置干扰线条的宽度
     *
     * @param interferenceLinesWidth 线条的宽度值
     */
    public void setInterferenceLinesWidth(float interferenceLinesWidth) {
        mInterferenceLinesWidth = interferenceLinesWidth;
    }

    /**
     * 获取干扰圆点的数量
     *
     * @return 干扰圆点的数量
     */
    public int getInterferenceCirclesCount() {
        return mInterferenceCirclesCount;
    }

    /**
     * 设置干扰圆点的数量
     *
     * @param interferenceCirclesCount 干扰圆雕的数量
     */
    public void setInterferenceCirclesCount(int interferenceCirclesCount) {
        mInterferenceCirclesCount = interferenceCirclesCount;
    }

    /**
     * 设置干扰圆点的颜色
     *
     * @param interferenceCirclesColor 干扰圆点的颜色
     */
    public void setInterferenceCirclesColor(int interferenceCirclesColor) {
        // 关闭颜色随机
        isCircleColorRandom = false;
        mInterferenceCirclesColor = interferenceCirclesColor;
    }

    /**
     * 获取干扰圆点的半径
     *
     * @return 干扰圆点的半径
     */
    public float getInterferenceCirclesRadius() {
        return mInterferenceCirclesRadius;
    }

    /**
     * 设置干扰圆点的半径
     *
     * @param interferenceCirclesRadius 干扰圆点的半径
     */
    public void setInterferenceCirclesRadius(float interferenceCirclesRadius) {
        mInterferenceCirclesRadius = interferenceCirclesRadius;
    }

    /**
     * 获取验证码文本颜色
     *
     * @return 验证码文本颜色
     */
    public int getTextColor() {
        return mTextColor;
    }

    /**
     * 设置验证码文本颜色
     *
     * @param textColor 验证码文本颜色
     */
    public void setTextColor(int textColor) {
        mTextColor = textColor;
    }

    /**
     * 获取验证码文本大小
     *
     * @return 验证码文本大小
     */
    public int getTextSize() {
        return mTextSize;
    }

    /**
     * 设置验证码文本大小
     *
     * @param textSize 验证码文本大小
     */
    public void setTextSize(int textSize) {
        mTextSize = textSize;
    }

    /**
     * 验证码文本是否有下划线
     *
     * @return 返回是否有下划线的boolean值
     */
    public boolean isUnderLine() {
        return isUnderLine;
    }

    /**
     * 设置验证码是否有下划线
     *
     * @param underLine 是否有下划线
     */
    public void setUnderLine(boolean underLine) {
        isUnderLine = underLine;
    }

    /**
     * 获取文本的倾斜值
     *
     * @return 返回一个float类型的倾斜值
     */
    public float getTextSkewX() {
        return mTextSkewX;
    }

    /**
     * 设置文本的倾斜值
     *
     * @param textSkewX 文本的倾斜值
     */
    public void setTextSkewX(float textSkewX) {
        mTextSkewX = textSkewX;
    }

    /**
     * 获取文本的宽度值
     *
     * @return 返回一个float类型的宽度值
     */
    public float getStrokeWidth() {
        return mStrokeWidth;
    }

    /**
     * 设置文本的宽度
     *
     * @param strokeWidth 文本的宽度值
     */
    public void setStrokeWidth(float strokeWidth) {
        mStrokeWidth = strokeWidth;
    }

    public VerificationCodeView(Context context) {
        this(context, null);
    }

    public VerificationCodeView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.VerificationCodeView, 0, 0);
        for (int i = 0; i < array.getIndexCount(); i++) {
            int attr = array.getIndex(i);

            if (attr == R.styleable.VerificationCodeView_verificationText) {
                // 验证码文本
                mVerificationText = array.getString(attr);

            } else if (attr == R.styleable.VerificationCodeView_isUnderLine) {
                // 验证码文字是否具有下划线
                isUnderLine = array.getBoolean(attr, false);

            } else if (attr == R.styleable.VerificationCodeView_isTextBold) {
                // 文本是否加黑
                isTextBold = array.getBoolean(attr, false);

            } else if (attr == R.styleable.VerificationCodeView_strokeWidth) {
                // 验证码字体的宽度
                mStrokeWidth = array.getFloat(attr, 0);

            } else if (attr == R.styleable.VerificationCodeView_textColor) {
                // 验证码文本的颜色,默认为黑色
                mTextColor = array.getColor(attr, Color.BLACK);

            } else if (attr == R.styleable.VerificationCodeView_textSize) {
                // 验证码文本的大小
                mTextSize = array.getDimensionPixelSize(attr, 16);

            } else if (attr == R.styleable.VerificationCodeView_textSkewX) {
                // 验证码文本的倾斜度
                mTextSkewX = array.getFloat(attr, 0);

            } else if (attr == R.styleable.VerificationCodeView_isShowInterferenceCircles) {
                // 是否显示干扰圆点
                isShowInterferenceCircles = array.getBoolean(attr, true);

            } else if (attr == R.styleable.VerificationCodeView_interferenceCirclesColor) {
                isCircleColorRandom = false;
                // 干扰圆点的颜色
                mInterferenceCirclesColor = array.getColor(attr, Color.BLACK);

            } else if (attr == R.styleable.VerificationCodeView_interferenceCirclesRadius) {
                // 干扰圆点的半径
                mInterferenceCirclesRadius = array.getFloat(attr, 5f);

            } else if (attr == R.styleable.VerificationCodeView_interferenceCirclesCount) {
                // 干扰圆点的数量
                mInterferenceCirclesCount = array.getInt(attr, 100);

            } else if (attr == R.styleable.VerificationCodeView_isShowInterferenceLines) {
                // 是否显示干扰线条
                isShowInterferenceLines = array.getBoolean(attr, true);

            } else if (attr == R.styleable.VerificationCodeView_interferenceLinesColor) {
                isLineColorRandom = false;
                // 干扰线条的颜色
                mInterferenceLinesColor = array.getColor(attr, Color.BLACK);

            } else if (attr == R.styleable.VerificationCodeView_interferenceLinesCount) {
                // 干扰线条的数量
                mInterferenceLinesCount = array.getInt(attr, 10);

            } else if (attr == R.styleable.VerificationCodeView_interferenceLinesWidth) {
                // 干扰线条的宽度
                mInterferenceLinesWidth = array.getFloat(attr, 3f);

            } else if (attr == R.styleable.VerificationCodeView_verificationCodeBackground) {
                // 验证码背景色
                mVerificationCodeBackground = array.getColor(attr, Color.GRAY);

            }
        }

        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;

        // 设置文本大小,此处设置是为了精确测量text的绘制区域
        mPaint.setTextSize(mTextSize);

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            if (mVerificationText != null) {
                // 如果设置了文本，则根据文本的大小确定绘制文本的宽度区域
                mPaint.getTextBounds(mVerificationText, 0, mVerificationText.length(), mTextRect);
                width = getPaddingLeft() + getPaddingRight() + mTextRect.width();
            } else {
                // 如果未设置验证码的文本，则默认一个宽
                width = 200;
            }
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            if (mVerificationText != null) {
                mPaint.getTextBounds(mVerificationText, 0, mVerificationText.length(), mTextRect);
                height = getPaddingBottom() + getPaddingTop() + mTextRect.height();
            } else {
                // 如果未设置验证码的文本，则默认一个高度值
                height = 100;
            }
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画背景色
        canvas.drawColor(mVerificationCodeBackground);

        /*
        绘制文本
         */
        if (mVerificationText != null && mVerificationText.length() > 0) {
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            // 设置文本是否加粗
            if (isTextBold) {
                mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            }
            mPaint.setColor(mTextColor);
            // 设置文本的下划线
            mPaint.setUnderlineText(isUnderLine);
            // 设置文本倾斜度
            mPaint.setTextSkewX(mTextSkewX);
            canvas.drawText(mVerificationText, getWidth() / 2 - mTextRect.width() / 2 - mTextRect.left, getHeight() /
                    2 + mTextRect.height() / 2, mPaint);
        }

        /*
        绘制干扰圆点
         */
        if (isShowInterferenceCircles) {
            mPaint.setStyle(Paint.Style.FILL);
            if (mInterferenceCirclesCount > 0) {
                // 根据控件的长宽，随机获得一个点的坐标进行绘制圆点
                for (int i = 0; i < mInterferenceCirclesCount; i++) {
                    // 干扰圆点的颜色
                    if (isCircleColorRandom) {
                        // 颜色随机
                        mPaint.setColor(Color.parseColor(getRandomColor()));
                    } else {
                        mPaint.setColor(mInterferenceCirclesColor);
                    }
                    float pointX = mRandom.nextFloat() * getWidth();
                    float pointY = mRandom.nextFloat() * getHeight();
                    canvas.drawCircle(pointX, pointY, mInterferenceCirclesRadius, mPaint);
                }
            } else {
                throw new IllegalArgumentException("干扰圆点的数量必须大于0！");
            }
        }

        /*
        绘制干扰线条
         */
        if (isShowInterferenceLines) {
            mPaint.setStyle(Paint.Style.STROKE);
            // 干扰线条的宽度
            mPaint.setStrokeWidth(mInterferenceLinesWidth);
            if (mInterferenceLinesCount > 0) {
                // 画干扰线条
                for (int i = 0; i < mInterferenceLinesCount; i++) {
                    // 干扰线条的颜色
                    if (isLineColorRandom) {
                        // 颜色随机
                        mPaint.setColor(Color.parseColor(getRandomColor()));
                    } else {
                        mPaint.setColor(mInterferenceLinesColor);
                    }
                    float startX = mRandom.nextFloat() * getWidth();
                    float startY = mRandom.nextFloat() * getHeight();
                    float stopX = mRandom.nextFloat() * getWidth();
                    float stopY = mRandom.nextFloat() * getHeight();
                    canvas.drawLine(startX, startY, stopX, stopY, mPaint);
                }
            } else {
                throw new IllegalArgumentException("干扰线条的数量必须大于0！");
            }
        }
    }

    /**
     * 随机生成一个16进制的颜色值
     *
     * @return 生成的16进制的颜色值
     */
    private String getRandomColor() {
        String r, g, b;

        r = Integer.toHexString(mRandom.nextInt(256)).toUpperCase();
        g = Integer.toHexString(mRandom.nextInt(256)).toUpperCase();
        b = Integer.toHexString(mRandom.nextInt(256)).toUpperCase();

        r = r.length() == 1 ? "0" + r : r;
        g = g.length() == 1 ? "0" + g : g;
        b = b.length() == 1 ? "0" + b : b;

        return "#" + r + g + b;
    }
}
