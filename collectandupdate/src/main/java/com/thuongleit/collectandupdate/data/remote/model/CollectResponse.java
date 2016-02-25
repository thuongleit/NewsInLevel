package com.thuongleit.collectandupdate.data.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

/**
 * Created by thuongle on 2/25/16.
 */
public class CollectResponse {
    @JsonProperty("results")
    CollectionItem mCollection;

    public CollectionItem getCollection() {
        return mCollection;
    }

    public void setCollection(CollectionItem collection) {
        this.mCollection = collection;
    }

    public List<Link> getCollectItems() {
        if (this.mCollection != null) {
            return this.mCollection.getItems();
        }
        return Collections.EMPTY_LIST;
    }
}
