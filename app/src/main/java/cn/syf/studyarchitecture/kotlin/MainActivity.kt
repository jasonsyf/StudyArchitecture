package cn.syf.studyarchitecture.kotlin

import android.arch.lifecycle.Observer
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import cn.syf.studyarchitecture.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CustomAdapter()
        recycle.adapter = adapter
        recycle.layoutManager = LinearLayoutManager(applicationContext)

        val data = LivePagedListBuilder(CustomPageDataSourceFactory(DataRepository()), PagedList.Config.Builder()
                .setPageSize(20)
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .build()).build()

        data.observe(this, Observer {
            adapter.submitList(it)
        })
    }


}
