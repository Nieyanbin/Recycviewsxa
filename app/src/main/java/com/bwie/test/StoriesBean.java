package com.bwie.test;

import java.util.List;

/**
 * Created by dell on 2017/9/20.
 */
public  class StoriesBean {
    /**
     * images : ["https://pic2.zhimg.com/v2-c685b99f69dc97a1fe160f7c64262e59.jpg"]
     * type : 0
     * id : 9617425
     * ga_prefix : 091808
     * title : 为什么天上的星星除了月球外，肉眼看大小都差不多？
     */

    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    private List<String> images;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
