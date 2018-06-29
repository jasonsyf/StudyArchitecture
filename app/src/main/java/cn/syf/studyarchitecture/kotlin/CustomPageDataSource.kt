package cn.syf.studyarchitecture.kotlin

import android.arch.paging.PageKeyedDataSource

/**
 * @author : Jason_Sunyf
 * @date   : 2018年06月28日16时18分
 * E-mail  : jason_sunyf@163.com
 */
class CustomPageDataSource(val repository: DataRepository) : PageKeyedDataSource<Int, DataBean>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, DataBean>) {
        val data = repository.loadData(params.requestedLoadSize)
        callback.onResult(data, null, 2)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataBean>) {
        val data = repository.loadPageData(params.key,params.requestedLoadSize)
        data?.let {
            callback.onResult(data, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataBean>) {
        val data = repository.loadPageData(params.key,params.requestedLoadSize)
        data?.let {
            callback.onResult(data, params.key - 1)
        }
    }

}