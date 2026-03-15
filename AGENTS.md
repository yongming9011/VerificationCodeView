# AGENTS.md - VerificationCodeView Project Guidelines

## Project Overview

This is an Android custom view library that renders a verification code (captcha) with customizable interference lines and circles.

**Updated for 2024:**
- Android SDK 34 (Android 14)
- AndroidX support
- Android Gradle Plugin 4.2.2
- Gradle 6.7.1

### Project Structure
- `library/`: The custom VerificationCodeView component
- `app/`: Demo application

### System Requirements
- **minSdk**: 21 (Android 5.0)
- **compileSdk**: 34 (Android 14)
- **targetSdk**: 34
- **Java**: 8 or higher
- **Gradle**: 7.6.3

## Build Commands

### Build the project
```bash
./gradlew assembleDebug
./gradlew assembleRelease
```

### Clean build
```bash
./gradlew clean
```

### Run all tests
```bash
./gradlew test
```

### Run a single unit test
```bash
./gradlew test --tests "com.zhangym.verificationcodeview.ExampleUnitTest"
```

### Run instrumented tests (on device/emulator)
```bash
./gradlew connectedAndroidTest
```

### Build specific module
```bash
./gradlew :library:assembleDebug
./gradlew :app:assembleDebug
```

## Code Style Guidelines

### Language
- Java (not Kotlin)

### Naming Conventions
- **Classes**: PascalCase (e.g., `VerificationCodeView`)
- **Methods**: camelCase (e.g., `setVerificationText`)
- **Member variables**: Hungarian notation with `m` prefix (e.g., `mVerificationText`, `mTextColor`)
- **Constants**: UPPER_SNAKE_CASE
- **Packages**: lowercase, reversed domain (e.g., `com.zhangym.customview`)

### Import Organization
Standard order:
1. `android.*` imports
2. `java.*` imports
3. Third-party imports
4. Project imports

### Formatting
- 4-space indentation (no tabs)
- Line length: 100 characters max
- Opening brace on same line
- One blank line between methods
- Use braces even for single-line statements

### Comments
- Use Chinese comments (项目使用中文注释)
- Javadoc-style for public APIs: `/** ... */`
- Inline comments for complex logic: `// ...`
- Comments should explain "why", not "what"

### Error Handling
- Use `IllegalArgumentException` for invalid parameters
- Validate inputs at method entry points
- Always call `array.recycle()` after using TypedArray

### Android Custom View Patterns
- Always implement `onMeasure()` for proper sizing
- Call `invalidate()` after changing visual properties
- Call `requestLayout()` when dimensions change
- Support both XML and programmatic initialization

### Resources
- Custom attributes in `res/values/attrs.xml`
- Follow Android naming conventions for resources

### Testing
- Unit tests go in `src/test/java/`
- Instrumented tests go in `src/androidTest/java/`
- Test class naming: `*Test.java`
- Test method naming: `testMethodName()`

## Known Issues / Technical Debt
- Could benefit from Kotlin migration
- Limited test coverage
- Documentation could be improved with more examples
