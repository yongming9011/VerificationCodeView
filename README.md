# VerificationCodeView - Android 验证码控件

> **⚠️ 近期所有提交均为AI开发及修改！**

## ⚠️ 更新说明

本项目已全面适配最新 Android SDK 34 (Android 14)，并迁移到 AndroidX 支持库。

### 版本要求
- **minSdk**: 21 (Android 5.0)
- **compileSdk**: 34 (Android 14)
- **targetSdk**: 34
- **Java**: 8 或更高版本
- **Gradle**: 6.7.1
- **Android Gradle Plugin**: 4.2.2

## 一、添加依赖

### 方式一：Maven Central（推荐）

在项目的根目录 `build.gradle` 里的 `allprojects` 下添加：

```groovy
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
```

在 `app` 目录的 `build.gradle` 下添加依赖：

```groovy
dependencies {
    implementation 'com.zhangym:verificationcodeview:2.0.0'
}
```

### 方式二：本地依赖

将 `library` 模块作为子模块导入你的项目：

```groovy
dependencies {
    implementation project(':library')
}
```

### 方式三：直接使用源码

下载项目，将 `library/src/main/java/com/zhangym/customview/VerificationCodeView.java` 和 `res/values/attrs.xml` 文件拷贝进你的项目。

## 二、布局集成

在布局中集成，注意需要在布局的根节点添加命名空间：

```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <com.zhangym.customview.VerificationCodeView
        android:id="@+id/verificationCodeView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:padding="20dp"
        app:interferenceCirclesCount="40"
        app:interferenceCirclesRadius="5"
        app:interferenceLinesCount="10"
        app:isShowInterferenceCircles="true"
        app:isShowInterferenceLines="true"
        app:isTextBold="true"
        app:textSize="50sp"
        app:textSkewX="0"
        app:verificationText="9D27" />
</LinearLayout>
```

## 三、可用属性

| 属性名 | 类型 | 说明 | 默认值 |
|--------|------|------|--------|
| `verificationText` | string | 验证码文本 | - |
| `textColor` | color | 验证码文本颜色 | #000000（黑色） |
| `textSize` | dimension | 验证码文本尺寸 | 16sp |
| `isUnderLine` | boolean | 是否显示下划线 | false |
| `isTextBold` | boolean | 字体是否为粗体 | false |
| `textSkewX` | float | 文本倾斜度（正数左斜，负数右斜） | 0 |
| `strokeWidth` | float | 文字描边宽度 | 0 |
| `isShowInterferenceLines` | boolean | 是否显示干扰线条 | true |
| `interferenceLinesCount` | integer | 干扰线条数量 | 10 |
| `interferenceLinesColor` | color | 干扰线条颜色（不设置则随机） | 随机 |
| `interferenceLinesWidth` | float | 干扰线条宽度 | 3 |
| `isShowInterferenceCircles` | boolean | 是否显示干扰圆点 | true |
| `interferenceCirclesCount` | integer | 干扰圆点数量 | 100 |
| `interferenceCirclesColor` | color | 干扰圆点颜色（不设置则随机） | 随机 |
| `interferenceCirclesRadius` | float | 干扰圆点半径 | 5 |
| `verificationCodeBackground` | color | 验证码背景色 | #808080（灰色） |

## 四、方法说明

### 设置方法

| 方法 | 说明 |
|------|------|
| `setVerificationText(String text)` | 设置验证码文本内容 |
| `setTextColor(int color)` | 设置文本颜色 |
| `setTextSize(int size)` | 设置文本大小 |
| `setTextBold(boolean bold)` | 设置文本是否加粗 |
| `setUnderLine(boolean underline)` | 设置是否显示下划线 |
| `setTextSkewX(float skewX)` | 设置文本倾斜度 |
| `setStrokeWidth(float width)` | 设置文字描边宽度 |
| `setShowInterferenceLines(boolean show)` | 设置是否显示干扰线条 |
| `setInterferenceLinesCount(int count)` | 设置干扰线条数量 |
| `setInterferenceLinesColor(int color)` | 设置干扰线条颜色（设置后不再随机） |
| `setInterferenceLinesWidth(float width)` | 设置干扰线条宽度 |
| `setLineColorRandom(boolean random)` | 设置线条颜色是否随机 |
| `setShowInterferenceCircles(boolean show)` | 设置是否显示干扰圆点 |
| `setInterferenceCirclesCount(int count)` | 设置干扰圆点数量 |
| `setInterferenceCirclesColor(int color)` | 设置干扰圆点颜色（设置后不再随机） |
| `setInterferenceCirclesRadius(float radius)` | 设置干扰圆点半径 |
| `setCircleColorRandom(boolean random)` | 设置圆点颜色是否随机 |
| `setVerificationCodeBackground(int color)` | 设置验证码背景色 |

### 获取方法

| 方法 | 说明 |
|------|------|
| `getVerificationText()` | 获取当前验证码文本 |
| `isShowInterferenceLines()` | 是否显示干扰线条 |
| `isShowInterferenceCircles()` | 是否显示干扰圆点 |
| `isTextBold()` | 文本是否为粗体 |
| `isUnderLine()` | 是否显示下划线 |
| `isLineColorRandom()` | 线条颜色是否随机 |
| `isCircleColorRandom()` | 圆点颜色是否随机 |
| `getInterferenceLinesCount()` | 获取干扰线条数量 |
| `getInterferenceLinesWidth()` | 获取干扰线条宽度 |
| `getInterferenceCirclesCount()` | 获取干扰圆点数量 |
| `getInterferenceCirclesRadius()` | 获取干扰圆点半径 |
| `getTextColor()` | 获取文本颜色 |
| `getTextSize()` | 获取文本大小 |
| `getTextSkewX()` | 获取文本倾斜度 |
| `getStrokeWidth()` | 获取文字描边宽度 |
| `getVerificationCodeBackground()` | 获取背景色 |

## 五、代码示例

```java
import com.zhangym.customview.VerificationCodeView;

public class MainActivity extends AppCompatActivity {
    private VerificationCodeView mCodeView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mCodeView = findViewById(R.id.verificationCodeView);
        
        // 设置验证码文本
        mCodeView.setVerificationText("ABCD");
        
        // 设置文本样式
        mCodeView.setTextColor(Color.BLUE);
        mCodeView.setTextBold(true);
        mCodeView.setTextSize(40);
        mCodeView.setTextSkewX(0.3f);  // 左倾斜
        
        // 设置干扰效果
        mCodeView.setInterferenceLinesCount(15);
        mCodeView.setInterferenceCirclesCount(150);
        mCodeView.setCircleColorRandom(true);
        mCodeView.setLineColorRandom(true);
        
        // 点击刷新验证码
        mCodeView.setOnClickListener(v -> {
            Random random = new Random();
            String code = String.valueOf(random.nextInt(10)) +
                    random.nextInt(10) +
                    random.nextInt(10) +
                    random.nextInt(10);
            mCodeView.setVerificationText(code);
        });
    }
}
```

## 六、效果图

![效果图](https://ww1.sinaimg.cn/large/006y8lValy1fbxzq88636g309t0injss.gif)

## 七、兼容性

- **Android 5.0 (API 21)** 及以上版本
- 完全支持 AndroidX
- 支持深色模式
- 支持 RTL 布局（从右到左）

## 八、历史版本

### v2.0.0 (2024)
- 适配 Android SDK 34 (Android 14)
- 迁移到 AndroidX
- 升级 Gradle 到 8.2.0
- 更新所有依赖到最新稳定版本

### v1.0.0
- 初始版本
- 支持 SDK 25

## 九、联系方式

- **GitHub**: https://github.com/yongming9011/VerificationCodeView
- **Gmail**: yongming9011@gmail.com

## 十、许可证

```
Copyright 2017-2024 Zhang Yongming

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```