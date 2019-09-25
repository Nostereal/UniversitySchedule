package com.nostereal.universityschedule.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.nostereal.universityschedule.R
import com.nostereal.universityschedule.adapters.ScheduleViewPagerAdapter
import com.nostereal.universityschedule.contracts.ScheduleContract
import com.nostereal.universityschedule.presenters.SchedulePresenter
import kotlinx.android.synthetic.main.activity_schedule.*
import kotlinx.android.synthetic.main.bottom_bar.*
import kotlinx.android.synthetic.main.viewpager_layout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScheduleActivity : AppCompatActivity(), ScheduleContract.View {

    private var presenter: SchedulePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        presenter = SchedulePresenter(this)
    }

    override fun onStart() {
        super.onStart()

        // just for tests
        CoroutineScope(Dispatchers.IO).launch {
            val response = presenter?.getSchedule("181-721")

            if (response == null) {
                launch(Dispatchers.Main) { showError("Response is null :(") }
                return@launch
            }

            withContext(Dispatchers.Main) {
                Toast.makeText(applicationContext, response.group.groupName, Toast.LENGTH_LONG).show()
            }
        }
    }

    /* ——— Interface's functions ——— */
    override fun showError(errorText: String) {
        Snackbar.make(schedule_activity, "Error: $errorText", Snackbar.LENGTH_LONG).show()
    }

    override fun showSchedule() {
        TODO()
    }

    override fun openSettings() {
        val intent = Intent(applicationContext, SettingsActivity::class.java)
        startActivity(intent)
    }

    override fun initView() {
        viewPager1.adapter = ScheduleViewPagerAdapter(supportFragmentManager)

        setting_btn.setOnClickListener { openSettings() }

        current_group.setOnClickListener { openGroupSearchLabel() }

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

    override fun openGroupSearchLabel() {
        current_group.visibility = View.GONE

        group_search_edit_text.setText(current_group.text)
        group_search_edit_text.visibility = View.VISIBLE
        group_search_edit_text.requestFocus()
        // open keyboard
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
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
}
