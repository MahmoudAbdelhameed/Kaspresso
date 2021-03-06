[kautomator](../../index.md) / [com.kaspersky.components.kautomator.component.bottomnav](../index.md) / [UiBottomNavigationViewAssertions](./index.md)

# UiBottomNavigationViewAssertions

`interface UiBottomNavigationViewAssertions : `[`UiBaseAssertions`](../../com.kaspersky.components.kautomator.component.common.assertions/-ui-base-assertions/index.md)

Provides assertions for BottomNavigationview

### Types

| Name | Summary |
|---|---|
| [UiBottomNavigationViewAssertionType](-ui-bottom-navigation-view-assertion-type/index.md) | `enum class UiBottomNavigationViewAssertionType : `[`UiOperationType`](../../com.kaspersky.components.kautomator.intercept.operation/-ui-operation-type/index.md) |

### Functions

| Name | Summary |
|---|---|
| [hasNotSelectedItemWithId](has-not-selected-item-with-id.md) | Checks if the view's selected menu item id does not match given one.`open fun hasNotSelectedItemWithId(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [hasNotSelectedItemWithIndex](has-not-selected-item-with-index.md) | Checks if the view's selected menu item index does not match given one. Note that this method uses view hierarchy which could be changed at any time.`open fun hasNotSelectedItemWithIndex(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [hasNotSelectedItemWithTitle](has-not-selected-item-with-title.md) | Checks if the view's selected menu item title does not match given one. Note that this method uses view hierarchy which could be changed at any time.`open fun hasNotSelectedItemWithTitle(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [hasSelectedItemWithId](has-selected-item-with-id.md) | Checks if the view's selected menu item id matches given one`open fun hasSelectedItemWithId(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [hasSelectedItemWithIndex](has-selected-item-with-index.md) | Checks if the view's selected menu item index matches given one. Note that this method uses view hierarchy which could be changed at any time.`open fun hasSelectedItemWithIndex(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [hasSelectedItemWithTitle](has-selected-item-with-title.md) | Checks if the view's selected menu item title matches given one. Note that this method uses view hierarchy which could be changed at any time.`open fun hasSelectedItemWithTitle(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [UiBottomNavigationView](../-ui-bottom-navigation-view/index.md) | View for acting and asserting on BottomNavigationView`class UiBottomNavigationView : `[`UiBaseView`](../../com.kaspersky.components.kautomator.component.common.views/-ui-base-view/index.md)`<`[`UiBottomNavigationView`](../-ui-bottom-navigation-view/index.md)`>, `[`UiBottomNavigationViewActions`](../-ui-bottom-navigation-view-actions/index.md)`, `[`UiBottomNavigationViewAssertions`](./index.md) |
