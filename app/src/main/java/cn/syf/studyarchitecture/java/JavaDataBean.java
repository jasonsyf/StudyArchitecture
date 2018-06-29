package cn.syf.studyarchitecture.java;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月28日16时43分
 * E-mail  : jason_sunyf@163.com
 */
public class JavaDataBean {
    private long id;
    private String name;

    JavaDataBean(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
