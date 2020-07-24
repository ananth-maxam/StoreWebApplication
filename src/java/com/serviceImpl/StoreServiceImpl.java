/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceImpl;

import com.dao.StoreDao;
import com.daoImpl.StoreDaoImpl;
import com.pojo.StoreDetails;
import com.service.StoreService;

/**
 *
 * @author Lenin Ananth
 */
public class StoreServiceImpl implements StoreService {

    private StoreDao storeDao = new StoreDaoImpl();

    @Override
    public int addStoreDetails(StoreDetails storeDetails) {

        int result = storeDao.addStoreDetails(storeDetails);

        return result;
    }

    @Override
    public StoreDetails editStore() {

        StoreDetails storeDetails = storeDao.editStore();
        
        return storeDetails;
    }

}
