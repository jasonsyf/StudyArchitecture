package cn.syf.studyarchitecture.java;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月28日16时55分
 * E-mail  : jason_sunyf@163.com
 */
public class JavaCustomPageDataSource extends PageKeyedDataSource<Integer, JavaDataBean> {
    private JavaDataRepository repository;

    JavaCustomPageDataSource(JavaDataRepository repository) {
        this.repository = repository;
    }


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params,
                            @NonNull LoadInitialCallback<Integer, JavaDataBean> callback) {
        List<JavaDataBean> data = repository.loadData(params.requestedLoadSize);
        callback.onResult(data, null, 2);
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params,
                          @NonNull LoadCallback<Integer, JavaDataBean> callback) {
        List<JavaDataBean> data = repository.loadPageData(params.key, params.requestedLoadSize);
        if (data != null) {
            callback.onResult(data, params.key + 1);
        }
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params,
                           @NonNull LoadCallback<Integer, JavaDataBean> callback) {
        List<JavaDataBean> data = repository.loadPageData(params.key, params.requestedLoadSize);
        if (data != null) {
            callback.onResult(data, params.key - 1);
        }
    }
}
