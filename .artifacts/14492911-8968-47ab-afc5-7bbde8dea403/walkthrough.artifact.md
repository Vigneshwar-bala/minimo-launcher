# Calculator Feature Implementation Walkthrough

The calculator feature allows users to perform quick calculations directly from the app drawer's search bar. When a valid math expression is typed, the result is displayed as the first item in the search results. Tapping the result replaces the search query with the result itself.

## Changes Made

### 1. Dependencies
- Added `net.objecthunter:exp4j:0.4.8` to [build.gradle.kts](file:///C:/Users/vigne/Downloads/minimo-launcher/app/build.gradle.kts) for robust math expression evaluation.

### 2. State Management
- Added `calculatorResult: String?` to [HomeScreenState.kt](file:///C:/Users/vigne/Downloads/minimo-launcher/app/src/main/java/com/minimo/launcher/ui/home/HomeScreenState.kt) to hold the current calculation result.

### 3. Logic Implementation
- Updated [HomeViewModel.kt](file:///C:/Users/vigne/Downloads/minimo-launcher/app/src/main/java/com/minimo/launcher/ui/home/HomeViewModel.kt):
    - Added `evaluateExpression(expr: String)` helper method using `exp4j`.
    - Added `onCalculatorResultClick(result: String)` to handle user interaction with the result.
    - Updated `onSearchTextChange` to trigger evaluation on every keystroke if the input matches a math regex.

### 4. UI Components
- Created [CalculatorResultItem.kt](file:///C:/Users/vigne/Downloads/minimo-launcher/app/src/main/java/com/minimo/launcher/ui/home/components/CalculatorResultItem.kt): A simple Composable to display the calculation result at the top of the search list.
- Integrated the new item into [AppDrawerScreen.kt](file:///C:/Users/vigne/Downloads/minimo-launcher/app/src/main/java/com/minimo/launcher/ui/home/AppDrawerScreen.kt) within the `LazyColumn`.

## Verification Results

### Automated Tests
- Verified the build via Gradle: `:app:assembleDebug` passed successfully.

### Manual Verification
1. Open the App Drawer.
2. Type a math expression in the search bar (e.g., `2 + 2 * 3`).
3. Observe the result `2 + 2 * 3 = 8` appearing at the top of the list.
4. Tap the result and verify the search text changes to `8`.
5. Verify that typing non-math queries (like app names) continues to show app search results correctly.
6. Verify that typing just a number (e.g., `42`) does not trigger the calculator result `42 = 42`.
