package com.nostereal.universityschedule.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.EventLog
import android.view.InputEvent
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import com.nostereal.universityschedule.R
import com.nostereal.universityschedule.adapters.ScheduleViewPagerAdapter
import com.nostereal.universityschedule.views.ScheduleView
import kotlinx.android.synthetic.main.activity_schedule.*
import kotlinx.android.synthetic.main.bottom_bar.*
import kotlinx.android.synthetic.main.viewpager_layout.*
import kotlinx.coroutines.*
import java.security.Key
import kotlin.coroutines.CoroutineContext

class ScheduleActivity : AppCompatActivity(), ScheduleView {
    override fun showError(errorText: String) {
        Snackbar.make(schedule_activity, "Error: $errorText", Snackbar.LENGTH_LONG)
    }

    override fun showSchedule() {
        TODO()
    }

    override fun openSettings() {
        val intent = Intent(applicationContext, SettingsActivity::class.java)
        startActivity(intent)
    }

    override fun openGroupSearchLabel() {
        current_group.visibility = View.GONE

        group_search_edit_text.setText(current_group.text)
        group_search_edit_text.visibility = View.VISIBLE
        group_search_edit_text.requestFocus()
        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(group_search_edit_text, InputMethodManager.SHOW_IMPLICIT)
    }

    override fun closeGroupSearchLabel() {
        current_group.text = group_search_edit_text.text
        group_search_edit_text.visibility = View.GONE

        current_group.visibility = View.VISIBLE
    }

    override fun startLoading() {
        TODO()
    }

    override fun endLoading() {
        TODO()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        viewPager1.adapter = ScheduleViewPagerAdapter(supportFragmentManager)

        setting_btn.setOnClickListener {
            openSettings()
        }

        current_group.setOnClickListener {
            openGroupSearchLabel()
        }

        group_search_edit_text.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                closeGroupSearchLabel()
            }
        }

        // TODO: handle keyboard events
        group_search_edit_text.setOnEditorActionListener { _, actionId, _ ->
            var handled: Boolean = false
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                TODO("perform request to rasp.dmami.ru")
                handled = true
            }
            handled
        }

        /*
        group_search_edit_text.addTextChangedListener(object : TextWatcher {
            var lastTextChangeMillis: Long = 0

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length ?: 0 > 6) {
                    CoroutineScope(Dispatchers.IO).launch {
                        TODO("check if last char was written N millis ago")
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // nothing to do
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // nothing to do
            }

        })
        */
    }
}
