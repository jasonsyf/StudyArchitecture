package cn.syf.studyarchitecture.java;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import cn.syf.studyarchitecture.R;

/**
 * @author : Jason_Sunyf
 * @date   : 2018年06月28日16时18分
 * E-mail  : jason_sunyf@163.com
 */

public class JavaMainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private JavaCustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycle);
    }

    private void initData() {
        mAdapter = new JavaCustomAdapter(JavaCustomAdapter.diffCallback());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        LiveData<PagedList<JavaDataBean>> data = new LivePagedListBuilder<>(new JavaCustomPageDataSourceFactory(new JavaDataRepository())
                , new PagedList.Config.Builder().setPageSize(20)
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .build()).build();

        data.observe(this, new Observer<PagedList<JavaDataBean>>() {
                    @Override
                    public void onChanged(@Nullable PagedList<JavaDataBean> javaDataBeans) {
                        mAdapter.submitList(javaDataBeans);
                    }
                }
        );
//        LiveData<JavaDataBean> data =new LivePagedListBuilder(JavaCustomPageDataSourceFactory(JavaDataRepository()), PagedList.Config.Builder()
//                .setPageSize(20)
//                .setEnablePlaceholders(true)
//                .setInitialLoadSizeHint(20)
//                .build()).build();

    }

    private void initEvent() {

    }
}
