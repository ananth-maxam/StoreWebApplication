/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.StoreDetails;

/**
 *
 * @author Lenin Ananth
 */
public interface StoreDao {
    public int addStoreDetails(StoreDetails storeDetails);
    public StoreDetails editStore();
    
}
