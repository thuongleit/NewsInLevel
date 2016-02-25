package com.thuongleit.collectandupdate.data.local;

import com.raizlabs.android.dbflow.sql.language.Insert;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.thuongleit.collectandupdate.data.remote.model.Link;
import com.thuongleit.collectandupdate.vo.News;
import com.thuongleit.collectandupdate.vo.News_Table;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by thuongle on 2/25/16.
 */
public class NewsModel extends BaseModel {

    @Inject
    public NewsModel() {
    }

    public void insertOrUpdateItems(List<Link> items) {
        for (Link item : items) {
            News news = item.getItem();
            Insert<News> collectItemInsert = SQLite
                    .insert(News.class)
                    .orIgnore()
                    .columnValues(News_Table.title.eq(news.getTitle()),
                            News_Table.url.eq(news.getUrl()));
            Timber.i(collectItemInsert.getQuery());
            collectItemInsert.execute();
        }
    }
}
