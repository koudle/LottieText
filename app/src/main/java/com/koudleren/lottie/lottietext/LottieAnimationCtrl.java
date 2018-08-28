package com.koudleren.lottie.lottietext;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.airbnb.lottie.LottieAnimationView;
/**
 * Lottie Animation 控制类
 * 可以更新Lottie动画中的文字部分
 */
public class LottieAnimationCtrl {
    private LottieAnimationView mLottieAnimationView;

    public LottieAnimationCtrl(LottieAnimationView lottieAnimationView){
        this.mLottieAnimationView = lottieAnimationView;
    }

    /**
     * 设置动画资源文件
     * @param fileName
     */
    public void setAnimation(String fileName) {
        if(mLottieAnimationView == null) return;
        mLottieAnimationView.setAnimation(fileName, LottieAnimationView.CacheStrategy.Weak);
    }

    /**
     * 设置图片资源文件夹
     * @param imageFolder
     */
    public void setImageAssetsFolder(String imageFolder){
        if(mLottieAnimationView == null) return;
        mLottieAnimationView.setImageAssetsFolder(imageFolder);
    }

    /**
     * 设置带动画资源文件
     * @param fileName
     * @param imageFolder
     */
    public void setAnimation(String fileName, String imageFolder) {
        setAnimation(fileName);
        setImageAssetsFolder(imageFolder);
    }

    /**
     * 从头开始播放动画
     */
    public void playAnimation() {
        playAnimation(false);
    }

    /**
     * 是否从暂停的地方继续开始
     * @param resume
     */
    public void playAnimation(boolean resume){
        if (resume){
            mLottieAnimationView.playAnimation();
        }else {
            mLottieAnimationView.setProgress(0);
            mLottieAnimationView.playAnimation();
        }
    }

    /**
     * 暂停动画
     */
    public void pauseAnimation() {
        mLottieAnimationView.pauseAnimation();
    }

    /**
     * 取消动画
     */
    public void cancelAnimation() {
        mLottieAnimationView.cancelAnimation();
    }

    /**
     * 监听动画的状态变化
     * @param listener
     */
    public void addAnimatorListener(Animator.AnimatorListener listener) {
        mLottieAnimationView.addAnimatorListener(listener);
    }

    /**
     * 监听动画的更新
     * @param listener
     */
    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener listener) {
        mLottieAnimationView.addAnimatorUpdateListener(listener);
    }

    /**
     * 设置动画是否循环播放
     * @param isLoop
     */
    public void setLoop(boolean isLoop){
        mLottieAnimationView.loop(isLoop);
    }


    /**
     * 设置动画的进度
     * @param progress
     */
    public void setProgress(float progress){
        mLottieAnimationView.setProgress(progress);
    }

    /**
     * 更新元素的图片
     * @param id 元素id
     * @param bitmap 图片
     */
    public void updateBitmap(String id,Bitmap bitmap){
        mLottieAnimationView.updateBitmap(id,bitmap);
    }

    /**
     * 更新文字内容
     * @param id 元素id
     * @param text 文字内容,需要定制颜色的，请使用SpannableString
     * @param textSize 大小为像素
     */
    public void updateText(String id,CharSequence text,int textSize){
        Bitmap bitmap = getTextBitmap(text,textSize);
        if(bitmap != null){
            mLottieAnimationView.updateBitmap(id,bitmap);
        }
    }

    private Bitmap getTextBitmap(CharSequence text,int textSize){
        TextPaint textPaint = new TextPaint();

        textPaint.setTextSize(textSize);

        StaticLayout layout = new StaticLayout(text, textPaint, textSize * text.length(),
                Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        Bitmap bitmap = Bitmap.createBitmap(layout.getWidth(),
                layout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.TRANSPARENT);

        layout.draw(canvas);
        return bitmap;

    }

}

