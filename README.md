# LottieText
Lottie 现在已经引用的很广泛了
动画中有文字的情况非常常见，如何更新Lottie中的文字呢？

## 1、使用Lottie的TextDelagate
这可能是最省事的方法，但却有一个问题，就是在导出动画的时候，如果有文字，就必须得选择字体，导出的时候也会带上字体库，就会很麻烦



## 2、就是本工程所使用的方法
把文字绘制成图片
详细请看 LottieAnimationCtrl 这个类
