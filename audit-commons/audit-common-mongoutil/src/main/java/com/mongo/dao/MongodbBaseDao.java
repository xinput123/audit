package com.mongo.dao;

import java.util.List;

import com.mongo.page.PageInfo;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * 基础查询类
 *
 * Query 中封装查询条件和排序规则
 */
public abstract class MongodbBaseDao<T> {

    /**
     * spring mongodb　集成操作类　
     */
    protected MongoTemplate mongoTemplate;

    /**
     * 获取需要操作的实体类class
     */
    protected abstract Class<T> getEntityClass();

    /** 注入mongodbTemplate */
    protected abstract void setMongoTemplate(MongoTemplate mongoTemplate);

    /** 保存一个对象到mongodb */
    public T save(T bean) {
        this.mongoTemplate.save(bean);
        return bean;
    }

    public T insert(T bean) {
        this.mongoTemplate.insert(bean);
        return bean;
    }

    /** 保存实体到指定的集合 */
    public T save(T bean, String collectionName) {
        this.mongoTemplate.save(bean, collectionName);
        return bean;
    }

    public T insert(T bean, String collectionName) {
        this.mongoTemplate.insert(bean, collectionName);
        return bean;
    }

    /** 批量新增 */
    public void insertAll(List<T> beans){
        this.mongoTemplate.insertAll(beans);
    }

    /** 批量新增 */
    public void insert(List<T> beans){
        this.mongoTemplate.insert(beans);
    }

    public void insert(List<T> beans, String collectName){
        this.mongoTemplate.insert(beans,collectName);
    }

    /** 根据ID获取记录 */
    public T getBeanById(String id){
        return this.mongoTemplate.findById(id, this.getEntityClass());
    }

    /** 根据ID获取指定集合的记录 */
    public T getBeanById(String id, String collectionName) {
        return this.mongoTemplate.findById(id, this.getEntityClass(), collectionName);
    }

    /** 根据Query查询唯一实体  */
    public T findBeanByQuery(Query query) {
        return this.mongoTemplate.findOne(query, this.getEntityClass());
    }

    /** 根据Query查询指定集合中的唯一实体 */
    public T findBeanByQuery(Query query, String collectionName) {
        return this.mongoTemplate.findOne(query, this.getEntityClass(), collectionName);
    }

    /** 查询所有数据 */
    public List<T> findAll() {
        return this.mongoTemplate.findAll(getEntityClass());
    }

    /** 查询指定集合所有数据  */
    public List<T> findAll(String collectionName) {
        return this.mongoTemplate.findAll(getEntityClass(), collectionName);
    }

    /** 根据条件查询实体的集合 */
    public List<T> find(Query query) {
        return this.mongoTemplate.find(query, this.getEntityClass());
    }

    /** 根据条件查询指定集合名称实体的集合 */
    public List<T> find(Query query, String collectionName) {
        return this.mongoTemplate.find(query, this.getEntityClass(), collectionName);
    }

    /** 根据条件查询出来后 再去删除 */
    public T findAndModify(Query query){
        return this.mongoTemplate.findAndRemove(query, this.getEntityClass());
    }

    /** 根据条件查询出来后 再去删除 */
    public T findAndModify(Query query, String collectionName){
        return this.mongoTemplate.findAndRemove(query, this.getEntityClass(), collectionName);
    }

    /** 按条件修改 */
    public void updateBean( Query query, Update update){
        this.mongoTemplate.updateFirst(query, update, this.getEntityClass());
    }

    public void updateBean(Query query, Update update, String collectionName){
        this.mongoTemplate.updateFirst(query, update, this.getEntityClass(),collectionName);
    }

    /** 批量修改 */
    public void updateList(Query query, Update update){
        this.mongoTemplate.updateMulti(query, update, this.getEntityClass());
    }

    public void updateList(Query query, Update update, String collectionName){
        this.mongoTemplate.updateMulti(query, update, this.getEntityClass(), collectionName);
    }

    /**
     * 通过条件查询更新数据
     * upsert 先查询，如果没有符合条件的，会执行插入，插入的值是查询值 ＋ 更新值。
     */
    public void update(Query query, Update update) {
        this.mongoTemplate.upsert(query, update, this.getEntityClass());
    }

    public void update(Query query, Update update, String collectionName) {
        this.mongoTemplate.upsert(query, update, this.getEntityClass(), collectionName);
    }

    // 查询并且修改记录
    public T findAndModify(Query query, Update update) {
        return this.mongoTemplate.findAndModify(query, update, this.getEntityClass());
    }

    // 按条件查询,并且删除记录
    public T findAndRemove(Query query) {
        return this.mongoTemplate.findAndRemove(query, this.getEntityClass());
    }

    public T findAndRemove(Query query, String collectionName) {
        return this.mongoTemplate.findAndRemove(query, this.getEntityClass(),collectionName);
    }

    public List<T> findAllAndRemove(Query query ){
        return this.mongoTemplate.findAllAndRemove(query, this.getEntityClass());
    }

    public List<T> findAllAndRemove(Query query, String collectionName ){
        return this.mongoTemplate.findAllAndRemove(query, this.getEntityClass(),collectionName);
    }

    public void delete(Query query){
        this.mongoTemplate.remove(query,this.getEntityClass());
    }

    public void delete(Query query, String collectionName){
        this.mongoTemplate.remove(query,this.getEntityClass(),collectionName);
    }


    /**
     * 通过条件查询,查询分页结果
     * @param query 查询条件
     * @param count 判断是否计算总数
     * @return
     */
    public PageInfo<T> getPage(Query query, int count, PageInfo<T> pageInfo) {
        if( 1==count){
            pageInfo.setTotalCount(this.mongoTemplate.count(query, this.getEntityClass()));
        }
        query.skip(pageInfo.getSkip());// skip 从那条记录开始
        query.limit(pageInfo.getLimit());// 从skip开始,取 limit 条记录
        List<T> datas = this.find(query);
        pageInfo.setDatas(datas);
        return pageInfo;
    }

    public PageInfo<T> getPage(int count, PageInfo<T> pageInfo){
        Query query = new Query();
        return getPage(query, count, pageInfo);
    }
}
