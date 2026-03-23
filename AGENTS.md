# VerificationCodeView - Project Knowledge Base

**Generated:** 2026-03-23
**Commit:** 6d62752
**Branch:** master

## OVERVIEW

Android 验证码自定义视图库，支持干扰线、干扰圆点、倾斜文字等效果。
- **类型**: Android Library + Demo App
- **语言**: Java
- **SDK**: 34 (Android 14)
- **构建**: Gradle 6.7.1 + AGP 4.2.2

## STRUCTURE

```
.
├── library/                    # 验证码库模块
│   └── src/main/java/com/zhangym/customview/
│       └── VerificationCodeView.java    # 核心自定义视图
├── app/                        # 演示应用
│   └── src/main/java/com/zhangym/verificationcodeview/
│       └── MainActivity.java              # 示例 Activity
├── gradle/wrapper/             # Gradle wrapper 配置
└── build.gradle               # 根构建脚本
```

## WHERE TO LOOK

| 任务 | 位置 | 说明 |
|------|------|------|
| 核心自定义视图 | `library/src/main/java/com/zhangym/customview/VerificationCodeView.java` | 验证码绘制逻辑 |
| 自定义属性定义 | `library/src/main/res/values/attrs.xml` | XML 属性声明 |
| 演示代码 | `app/src/main/java/com/zhangym/verificationcodeview/MainActivity.java` | 使用示例 |
| 布局示例 | `app/src/main/res/layout/activity_main.xml` | 布局文件 |
| 构建配置 | `build.gradle`, `library/build.gradle`, `app/build.gradle` | Gradle 配置 |

## CONVENTIONS

### 命名
- **类**: PascalCase (`VerificationCodeView`)
- **方法**: camelCase (`setVerificationText`)
- **成员变量**: `m` 前缀匈牙利命名法 (`mVerificationText`, `mTextColor`)
- **常量**: UPPER_SNAKE_CASE
- **包名**: 小写反域名 (`com.zhangym.customview`)

### 导入顺序
1. `android.*`
2. `java.*`
3. 第三方库
4. 项目内部

### 格式
- 4 空格缩进（无 Tab）
- 行宽最大 100 字符
- 左大括号不换行
- 即使单行也使用大括号

### 注释
- 使用中文注释
- 公有 API 使用 Javadoc: `/** ... */`
- 复杂逻辑使用行内注释: `// ...`
- 注释解释"为什么"而非"做什么"

### 自定义视图模式
- 必须实现 `onMeasure()` 正确测量
- 修改视觉属性后调用 `invalidate()`
- 尺寸变化时调用 `requestLayout()`
- 支持 XML 和代码两种初始化方式

### 错误处理
- 无效参数抛出 `IllegalArgumentException`
- 方法入口验证输入
- TypedArray 使用后必须调用 `array.recycle()`

## ANTI-PATTERNS (THIS PROJECT)

- **禁止**: Kotlin（项目使用纯 Java）
- **禁止**: 使用 Support Library（已迁移到 AndroidX）
- **禁止**: `compile` 配置（使用 `implementation`）
- **禁止**: 修改成员变量后不刷新视图（忘记 `invalidate()`/`requestLayout()`）

## COMMANDS

```bash
# 构建
./gradlew assembleDebug
./gradlew assembleRelease

# 清理
./gradlew clean

# 测试
./gradlew test
./gradlew test --tests "com.zhangym.verificationcodeview.ExampleUnitTest"
./gradlew connectedAndroidTest

# 模块构建
./gradlew :library:assembleDebug
./gradlew :app:assembleDebug
```

## NOTES

- **最小 SDK**: 21 (Android 5.0)
- **目标 SDK**: 34 (Android 14)
- **依赖**: AndroidX AppCompat 1.6.1
- **测试框架**: JUnit 4.13.2, Espresso 3.5.1
- **技术债务**: 测试覆盖率低，可迁移到 Kotlin
