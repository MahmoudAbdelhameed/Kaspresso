package android.support.test.espresso.web.assertion

import android.support.test.espresso.web.model.Atom
import android.support.test.espresso.web.webdriver.WebDriverAtomScriptsProvider
import android.webkit.WebView
import com.kaspersky.kaspresso.interceptors.view.WebAssertionInterceptor
import org.hamcrest.Matcher
import org.hamcrest.StringDescription

/**
 * A proxy-wrapper of [WebAssertion] for interceptors calls.
 */
class WebAssertionProxy<E>(
    private val webAssertion: WebAssertion<E>,
    private val matcher: Matcher<*>,
    private val interceptors: List<WebAssertionInterceptor>
) : WebAssertion<E>(webAssertion.atom) {

    /**
     * Calls interceptors before [WebViewAssertions.ResultCheckingWebAssertion.checkResult] on wrapped [webAssertion] is
     * called.
     *
     * @param view a WebView that the Atom was evaluated on.
     * @param result a result of atom evaluation.
     */
    override fun checkResult(view: WebView?, result: E) {
        interceptors.forEach { it.intercept(this, view, result as Any) }
        (webAssertion as WebViewAssertions.ResultCheckingWebAssertion).checkResult(view, result)
    }

    /**
     * @return a string description of [WebAssertion].
     */
    fun describe(): String {
        val builder = StringBuilder("web assertion")

        if (webAssertion is WebViewAssertions.ResultCheckingWebAssertion<*>) {
            val resultMatcher: Matcher<*> =
                webAssertion.javaClass
                    .getDeclaredField("resultMatcher")
                    .apply { isAccessible = true }
                    .get(webAssertion) as Matcher<*>

            builder.append(" \"")
            resultMatcher.describeTo(StringDescription(builder))
            builder.append("\"")
        }


        builder.append("${webAssertion.atom.getActionDescription()} on webview ")
        matcher.describeTo(StringDescription(builder))
        return builder.toString()
    }

    private fun Atom<*>.getActionDescription(): String {
        return with(WebDriverAtomScriptsProvider) {
            when (script) {
                GET_VISIBLE_TEXT_ANDROID -> " with action=\"get visible text\""
                CLEAR_ANDROID -> " with action=\"clear\""
                CLICK_ANDROID -> " with action=\"click on element\""
                SCROLL_INTO_VIEW_ANDROID -> " with action=\"scroll into view\""
                SEND_KEYS_ANDROID -> " with action=\"end keys\""
                ACTIVE_ELEMENT_ANDROID -> " with action=\"active element\""
                FRAME_BY_ID_OR_NAME_ANDROID -> " with action=\"frame by id or name\""
                FRAME_BY_INDEX_ANDROID -> " with action=\"frame by index android\""
                FIND_ELEMENT_ANDROID -> " with action=\"find element\""
                FIND_ELEMENTS_ANDROID -> " with action=\"find elements\""
                else -> ""
            }
        }
    }
}