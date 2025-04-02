
package com.myTraining.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Model(adaptables = Resource.class)
public class News {

    private static final Logger LOG = LoggerFactory.getLogger(News.class);

    @ValueMapValue
    private String newsHeadline;

    @ValueMapValue
    private String newsDetail;

    @ValueMapValue
    private Date newsPublishDate;

    @ValueMapValue
    private String newsImg;

    @ValueMapValue
    private List<String> newsTitle;


    @PostConstruct
    protected void init() {
        LOG.info("------------inside News model init method----------------");
    }



    public String getNewsDetail() {
        return newsDetail;
    }

    public Date getNewsPublishDate() {
        return newsPublishDate;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public String getNewsHeadline() {
        return newsHeadline;
    }

    public List<String> getNewsTitle() {
        if (newsTitle != null) {
            return new ArrayList<String>(newsTitle);
        } else {
            return Collections.emptyList();
        }
    }
}

