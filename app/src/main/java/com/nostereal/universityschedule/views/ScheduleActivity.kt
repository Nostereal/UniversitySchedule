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
import com.nostereal.universityschedule.extensions.hideKeyboard
import com.nostereal.universityschedule.extensions.showKeyboard
import com.nostereal.universityschedule.models.ScheduleResponse
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

    }

    /* ——— Interface's functions ——— */
    override fun showError(errorText: String) {
        Snackbar.make(schedule_activity, "Error: $errorText", Snackbar.LENGTH_LONG).show()
    }

    override fun showSchedule(schedule: ScheduleResponse) {
        Toast.makeText(this, schedule.group.groupName, Toast.LENGTH_SHORT).show()
        TODO("implement showSchedule()")
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
                presenter?.loadSchedule(group_search_edit_text.text.toString()/*, isSession */)
                this.hideKeyboard()
                handled = true
            }
            handled
        }
    }

    override fun openGroupSearchLabel() {
        current_group.visibility = View.GONE

        group_search_edit_text.setText(current_group.text)
        group_search_edit_text.visibility = View.VISIBLE
        group_search_edit_text.requestFocus()

        this.showKeyboard()
    }

    override fun closeGroupSearchLabel() {
        current_group.text = group_search_edit_text.text
        group_search_edit_text.visibility = View.GONE

        current_group.visibility = View.VISIBLE
    }

    // TODO: implement loadings
    override fun startLoading() {
        Log.d("M_ScheduleActivity", "Loading started")
    }

    override fun endLoading() {
        Log.d("M_ScheduleActivity", "Loading ended")
    }
}
