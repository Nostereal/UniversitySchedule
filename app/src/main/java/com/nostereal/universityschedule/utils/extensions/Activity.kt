package com.nostereal.universityschedule.utils.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.nostereal.universityschedule.R
import kotlinx.android.synthetic.main.bottom_bar.*
import kotlin.math.roundToInt

private fun Activity.getRootView(): View = this.findViewById<View>(R.id.content)

fun Activity.isKeyboardOpen(): Boolean {
    val visibleBounds = Rect()
    val rootView = this.getRootView()
    rootView.getWindowVisibleDisplayFrame(visibleBounds)

    val heightDiff = rootView.height - visibleBounds.height()
    val marginOfError = this.convertDpToPx(50F).roundToInt()
    return heightDiff > marginOfError
}

fun Activity.isKeyboardClosed(): Boolean = !this.isKeyboardOpen()

fun Activity.hideKeyboard() {
    val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val view = this.currentFocus ?: View(this)

    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Activity.showKeyboard() {
    val imm: InputMethodManager =
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(group_search_edit_text, InputMethodManager.SHOW_IMPLICIT)
}