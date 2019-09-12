package com.kaspersky.kaspressample.web_tests

import android.Manifest
import android.support.test.espresso.web.webdriver.DriverAtoms
import android.support.test.espresso.web.webdriver.Locator
import android.support.test.rule.ActivityTestRule
import android.support.test.rule.GrantPermissionRule
import android.support.test.runner.AndroidJUnit4
import com.kaspersky.kaspressample.MainActivity
import com.kaspersky.kaspressample.screen.MainScreen
import com.kaspersky.kaspressample.screen.WebViewScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WebViewTest : TestCase() {

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun test() {

        before {
            activityTestRule.launchActivity(null)
        }.after {
        }.run {

            step("Open WebView Screen") {
                MainScreen {
                    webViewButton {
                        hasAnyText()
                        click()
                    }
                }
            }

            step("Find \"Sign in\" button") {
                WebViewScreen {

                    webView {
                        withElement(
                            Locator.CLASS_NAME,
                            "btn"
                        ) {
                            containsText("Sign in")
                            web.withElement(ref).perform(DriverAtoms.getText())
                        }

                        withElement(
                            Locator.XPATH,
                            "//*[@id=\"app\"]/section[1]/div/div/h2"
                        ) {
                            containsText("Protect your data")
                        }

                        withElement(
                            Locator.XPATH,
                            "//*[@id=\"app\"]/header/section/div[3]/div[2]/button"
                        ) {
                            hasText("Sign in")
                        }
                    }
                }
            }

            step("Click \"Ask question\" button") {
                WebViewScreen {
                    webView {

                        withElement(
                            Locator.XPATH,
                            "//*[@id=\"app\"]/section[5]/div/div/div[2]/div[3]/button"
                        ) {
                            compose(this@webView) {
                                or {
                                    containsText("fffuuuuu")
                                    hasText("fuck")
                                }
                                or {
                                    containsText("Ask questiop")
                                    hasText("Ask questio")
                                }
                                or {
                                    containsText("Ask question")
                                    hasText("Ask question")
                                }
                            }
                        }

                        compose {
                            orWithElement(
                                Locator.XPATH,
                                "//*[@id=\"app\"]/section[5]/div/div/div[2]/div[3]/button"
                            ) {
                                hasText("TRATATATA")
                            }
                            orWithElement(
                                Locator.XPATH,
                                "//*[@id=\"app\"]/section[5]/div/div/div[2]/div[3]/button"
                            ) {
                                hasText("Ask question")
                                click()
                            }
                        }
                    }
                }
            }
        }
    }
}