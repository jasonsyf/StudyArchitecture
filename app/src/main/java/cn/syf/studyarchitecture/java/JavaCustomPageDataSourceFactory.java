package cn.syf.studyarchitecture.java;

import android.arch.paging.DataSource;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月28日17时06分
 * E-mail  : jason_sunyf@163.com
 */
public class JavaCustomPageDataSourceFactory extends DataSource.Factory<Integer, JavaDataBean> {

    private JavaDataRepository mDataRepository;

    JavaCustomPageDataSourceFactory(JavaDataRepository dataRepository) {
        mDataRepository = dataRepository;
    }

    @Override
    public DataSource<Integer, JavaDataBean> create() {
        return new JavaCustomPageDataSource(mDataRepository);
    }
}
