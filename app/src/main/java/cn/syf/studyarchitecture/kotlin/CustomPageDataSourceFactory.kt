package cn.syf.studyarchitecture.kotlin

import android.arch.paging.DataSource

/**
 * @author : Jason_Sunyf
 * @date   : 2018年06月28日16时22分
 * E-mail  : jason_sunyf@163.com
 */
class CustomPageDataSourceFactory(val repository: DataRepository) : DataSource.Factory<Int, DataBean>() {
    override fun create(): DataSource<Int, DataBean> {
        return CustomPageDataSource(repository)
    }
}