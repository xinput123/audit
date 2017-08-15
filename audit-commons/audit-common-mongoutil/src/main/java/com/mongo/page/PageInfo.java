package com.mongo.page;

import java.util.List;

/**
 * 自定义 mongo 分页
 */
public class PageInfo<T> {
    /** 一页数据默认10条 */
    private int limit;

    /** 默认跳过多少页 */
    private int skip;

     /**  一共有多少条数据 */
    private long totalCount;

     /**  数据集合 */
    private List<T> datas;

    public PageInfo() {
    }

    public PageInfo(int skip, int limit) {
        this.setSkip(skip);
        this.setLimit(limit);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "limit=" + limit +
                ", skip=" + skip +
                ", totalCount=" + totalCount +
                ", datas=" + datas +
                '}';
    }
}
