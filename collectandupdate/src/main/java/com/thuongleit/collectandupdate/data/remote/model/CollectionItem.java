package com.thuongleit.collectandupdate.data.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by thuongle on 2/25/16.
 */
public class CollectionItem {

    @JsonProperty("collection1")
    List<Link> mLinks;

    public List<Link> getItems() {
        return mLinks;
    }

    public void setItems(List<Link> links) {
        this.mLinks = links;
    }
}
