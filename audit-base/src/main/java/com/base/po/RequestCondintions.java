package com.base.po;

/**
 * 封装前台传过来的查询条件，适用于同参数
 */
public class RequestCondintions {

    private String where; // 存在此参数时，按照查询参数过滤
    private Integer skip; // 存在是参数时，返回列表跳过skip项
    private Integer limit; // 存在此参数时，返回列表最大返回limit项，如果为0时不返回任何项
    private Integer count; // 存在此参数=1时，返回符合查询的数量（全部数量,忽略skip与limit）
    private String order; // 存在此参数时，使用参数排序。不存在按创建时间倒序

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
