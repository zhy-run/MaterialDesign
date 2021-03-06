package com.yechaoa.materialdesign.activity

import android.content.Intent
import android.view.Menu
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.yechaoa.materialdesign.R
import com.yechaoa.materialdesign.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.recycleView
import kotlinx.android.synthetic.main.fragment_fragment4.*

class MainActivity : ToolbarActivity() {

    private var mList: MutableList<String> = mutableListOf()
    private lateinit var mAdapter: MainAdapter

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setToolbar() {}

    override fun initView() {
        mToolbar.navigationIcon = null

        //回调刷新toolbar的menu，页面初始化或者在需要的时候调用
        invalidateOptionsMenu()

        mList.add(getString(R.string.swipe_refresh_layout))
        mList.add(getString(R.string.floating_action_button))
        mList.add(getString(R.string.snack_bar))
        mList.add(getString(R.string.tab_layout))
        mList.add(getString(R.string.card_view))
        mList.add(getString(R.string.bottom_navigation))
        mList.add(getString(R.string.collapsing_toolbar))
        mList.add(getString(R.string.text_input_layout))
        mList.add(getString(R.string.search_view))
        mList.add(getString(R.string.tab_layout_custom_view))
        mList.add(getString(R.string.drawer_layout))
        mList.add(getString(R.string.bottom_sheet))

        recycleView.layoutManager = GridLayoutManager(this, 2)
        mAdapter = MainAdapter(this, mList)
        recycleView.adapter = mAdapter

        setListener()
    }

    private fun setListener() {
        mAdapter.setOnItemClickListener(object : MainAdapter.OnItemClickListener {
            override fun onItemClick(v: View, position: Int) {
                when (position) {
                    0 -> openActivity(SwipeRefreshLayoutActivity::class.java)
                    1 -> openActivity(FloatingActionButtonActivity::class.java)
                    2 -> openActivity(SnackbarActivity::class.java)
                    3 -> openActivity(TabLayoutActivity::class.java)
                    4 -> openActivity(CardViewActivity::class.java)
                    5 -> openActivity(BottomNavigationActivity::class.java)
                    6 -> openActivity(CollapsingToolbarActivity::class.java)
                    7 -> openActivity(TextInputLayoutActivity::class.java)
                    8 -> openActivity(SearchViewActivity::class.java)
                    9 -> openActivity(TabLayoutCustomViewActivity::class.java)
                    10 -> openActivity(DrawerLayoutActivity::class.java)
                    11 -> openActivity(BottomSheetActivity::class.java)
                }
            }
        })
    }

    /**
     * 重写onPrepareOptionsMenu，处理toolbar的menu，此处把搜索按钮去掉
     */
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        //menu.findItem(R.id.action_search).setVisible(false);
        return super.onPrepareOptionsMenu(menu)
    }

    private fun openActivity(targetActivityClass: Class<*>) {
        startActivity(Intent(this@MainActivity, targetActivityClass))
    }
}