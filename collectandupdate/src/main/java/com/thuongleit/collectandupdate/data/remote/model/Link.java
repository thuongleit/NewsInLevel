package com.thuongleit.collectandupdate.data.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thuongleit.collectandupdate.vo.News;

public class Link {
    @JsonProperty("link")
    News mItem;

    public News getItem() {
        return mItem;
    }

    public void setItem(News item) {
        this.mItem = item;
    }
}