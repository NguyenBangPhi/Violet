/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.DAO;

import java.util.List;

/**
 *
 * @author Admin
 */
public abstract class VioletDichVuDAO<EntityType, KeyType, KeyType2> {
    abstract public void insert(EntityType entity);
    abstract public void update(EntityType entity);
    abstract public void delete(KeyType id1, KeyType2 id2);
    abstract public EntityType selectById(KeyType id1,KeyType2 id2);
    abstract public List<EntityType> selectAll();
    abstract protected List<EntityType> selectBySql(String sql,Object... args);
}
