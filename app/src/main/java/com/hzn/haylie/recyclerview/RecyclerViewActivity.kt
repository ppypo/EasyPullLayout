package com.hzn.haylie.recyclerview

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.hzn.haylie.R
import com.hzn.haylie.RvAdapter
import com.hzn.lib.EasyPullLayout
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerViewActivity : AppCompatActivity() {

    companion object {
        const val START_FRACTION = 0.5f
        const val REFRESHING_TIME = 5000L
    }

    var list: List<String> = (1..30).map { "item_string $it" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        initRecyclerView()
        initEasyPullLayout()
        epl.autoRefresh(EasyPullLayout.TYPE_EDGE_TOP)
    }

    private fun initRecyclerView() {
        rv.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        rv.adapter = RvAdapter(this, list)
    }

    private fun initEasyPullLayout() {

        epl.setOnPullListener { type, fraction, changed ->
            topView.setFraction(START_FRACTION, fraction)
            if (fraction == 1f)
                topView.ready()
            else
                topView.idle()
        }
        epl.setOnTriggerListener {
            topView.triggered()
            simulateLoading()
        }
    }

    private fun simulateLoading() {
        Handler().postDelayed({
            Toast.makeText(this, getString(R.string.finish), Toast.LENGTH_SHORT).show()
            epl.stop()
            topView.stop()
        }, REFRESHING_TIME)
    }
}
