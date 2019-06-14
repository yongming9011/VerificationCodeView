# 兄弟们，哥们早从Android脱坑了，入了后台的坑，该项目早已停止维护，要用于生产环境的请慎重！

# 一、添加依赖

1. **Android Studio**：在项目的根目录下build.gradle里的allprojects下添加如下引用：

```groovy
   allprojects {
   	repositories {
   		...
   		maven { url 'https://jitpack.io' }
   	}
   }
```

   然后在app目录下 build.gradle 下添加依赖

```groovy
   dependencies {
   	   compile 'com.github.yongming9011:VerificationCodeView:v1.0'
   }
```

   ​

2. **Eclipse**：下载项目，将library里面的VerificationCodeView.java跟res/values/attrs.xml文件拷贝进项目。

# 二、用法

- 在布局中集成，注意需要在布局的根节点添加命名`xmlns:zhangym="http://schemas.android.com/apk/res-auto"` 方可使用自定义属性。

  ```xml
   <com.zhangym.customview.VerificationCodeView
          android:id="@+id/verificationCodeView"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_centerInParent="true"
          android:padding="20dp"
          zhangym:interferenceCirclesCount="40"
          zhangym:interferenceCirclesRadius="5"
          zhangym:interferenceLinesCount="10"
          zhangym:isShowInterferenceCircles="true"
          zhangym:isShowInterferenceLines="true"
          zhangym:isTextBold="true"
          zhangym:textSize="50sp"
          zhangym:textSkewX="0"
          zhangym:verificationText="9D27" />
  ```


- 对应属性说明如下：

  ```xml
          <!-- 验证码文本 -->
          <attr name="verificationText" format="string" />
          <!-- 设置验证码文本的颜色 -->
          <attr name="textColor" format="color" />
          <!-- 设置验证码文本尺寸 -->
          <attr name="textSize" format="dimension" />
          <!-- 设置验证码是否有下划线 -->
          <attr name="isUnderLine" format="boolean" />
          <!-- 验证码字体是否为粗体-->
          <attr name="isTextBold" format="boolean" />
          <!-- 设置文本的倾斜度，默认为0 ,正数左斜，负数右斜-->
          <attr name="textSkewX" format="float" />
          <!-- 设置验证码字体风格，暂时先不要使用，后续完善 -->
          <attr name="typeFace" format="integer" />
          <!-- 设置验证码文字宽度-->
          <attr name="strokeWidth" format="float" />
          <!-- 是否显示干扰线条,默认为true -->
          <attr name="isShowInterferenceLines" format="boolean" />
          <!-- 设置干扰线条的数量，默认10条 -->
          <attr name="interferenceLinesCount" format="integer" />
          <!-- 设置干扰线条的颜色，如果不设置，默认为随机生成的颜色-->
          <attr name="interferenceLinesColor" format="color" />
          <!--设置干扰线条的宽度，默认为3-->
          <attr name="interferenceLinesWidth" format="float" />
          <!-- 设置是否显示干扰圆点，默认为true -->
          <attr name="isShowInterferenceCircles" format="boolean" />
          <!-- 设置干扰圆点的数量，默认100个-->
          <attr name="interferenceCirclesCount" format="integer" />
          <!-- 设置干扰圆点的颜色，如果不设置，默认为随机生成的颜色-->
          <attr name="interferenceCirclesColor" format="color" />
          <!--设置干扰圆点的半径，默认为5-->
          <attr name="interferenceCirclesRadius" format="float" />
          <!-- 设置验证码背景色，默认为灰色-->
          <attr name="verificationCodeBackground" format="color" />
  ```

以上属性均有对应的 setter方法，也可以在Java代码中进行设置。



# 三、对应方法的说明

|                    方法                    |             说明             |
| :--------------------------------------: | :------------------------: |
| setShowInterferenceLines(boolean showInterferenceLines) |      设置是否显示干扰线条，默认显示       |
| setShowInterferenceCircles(boolean showInterferenceCircles) |      设置是否显示干扰圆点，默认显示       |
|      setTextBold(boolean textBold)       |     设置验证码文本是否加粗，默认不加粗      |
| setCircleColorRandom(boolean circleColorRandom) |    设置干扰圆点是否为随机颜色，默认为随机     |
| setLineColorRandom(boolean lineColorRandom) |    设置干扰线条颜色是否为随机，默认为随机     |
| setVerificationText(String verificationText) |         设置验证码文本内容          |
| setVerificationCodeBackground(int verificationCodeBackground) |      设置验证码的背景色，默认为灰色       |
| setInterferenceLinesCount(int interferenceLinesCount) |      设置干扰线条的数量，默认为10条      |
| setInterferenceLinesColor(int interferenceLinesColor) |  设置干扰线条的颜色，如果设置了颜色，则颜色不再   |
| setInterferenceLinesWidth(float interferenceLinesWidth) |       设置干扰线条的宽度，默认为3       |
| setInterferenceCirclesCount(int interferenceCirclesCount) |         设置干扰圆点的数量          |
| setInterferenceCirclesColor(int interferenceCirclesColor) |    设置干扰圆点的颜色，如果设置，则不再随机    |
| setInterferenceCirclesRadius(float interferenceCirclesRadius) |       设置干扰圆点的半径，默认为5       |
|       setTextColor(int textColor)        |        设置验证码文本，默认黑色        |
|        setTextSize(int textSize)         |         设置验证码文本大小          |
|     setUnderLine(boolean underLine)      |       设置验证码文本是否有下划线        |
|      setTextSkewX(float textSkewX)       | 设置验证码文本的倾斜值，正数左斜，负数右斜，默认为0 |
|    setStrokeWidth(float strokeWidth)     |         设置验证码文本的宽度         |



# 四、效果图

![效果图](https://ww1.sinaimg.cn/large/006y8lValy1fbxzq88636g309t0injss.gif)


# 五、联系方式

- [我的博客](http://zhangym.xyz/)
- **Gmail**:yongming9011@gmail.com
