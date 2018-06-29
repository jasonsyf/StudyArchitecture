package cn.syf.studyarchitecture.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月28日16时44分
 * E-mail  : jason_sunyf@163.com
 */
public class JavaDataRepository {
    private List<JavaDataBean> mDataList=new ArrayList<>();

    JavaDataRepository() {
        for (int i = 0, size=100; i <size ; i++) {
            JavaDataBean javaDataBean=new JavaDataBean(i,i+"name");
            mDataList.add(javaDataBean);
        }
    }

    public List<JavaDataBean> loadData(int size) {
        return mDataList.subList(0, size);
    }

    public List<JavaDataBean> loadData(int index, int size) {
        if (index >= mDataList.size() - 1 || index < 1) {
            return null;
        }
        if (index + size > mDataList.size()) {
            return mDataList.subList(index + 1, mDataList.size());
        }
        return mDataList.subList(index + 1, index + size);
    }

    public List<JavaDataBean> loadPageData(int page, int size) {

        int totalPage = -1;
        if (mDataList.size() % size == 0) {
            totalPage = mDataList.size() / size;
        }else {
            totalPage = mDataList.size() / size+1;
        }
        if (page > totalPage || page < 1) {
            return null;
        }
        if (page == totalPage) {
            return mDataList.subList((page - 1) * size, mDataList.size());
        }
        return mDataList.subList((page - 1) * size, page * size);
    }

}
