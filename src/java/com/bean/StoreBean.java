/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.pojo.StoreDetails;
import com.service.StoreService;
import com.serviceImpl.StoreServiceImpl;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Lenin Ananth
 */
@ManagedBean(name = "storebean")
public class StoreBean {

    private StoreDetails storeDetails = new StoreDetails();
    private StoreDetails deepCopy = new StoreDetails();
    private StoreService storeService = new StoreServiceImpl();

    public StoreDetails getDeepCopy() {
        return deepCopy;
    }

    public void setDeepCopy(StoreDetails deepCopy) {
        this.deepCopy = deepCopy;
    }
    

    public StoreDetails getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(StoreDetails storeDetails) {
        this.storeDetails = storeDetails;
    }

    public int addStoreDetails(StoreDetails storeDetails) {
        int result = 0;
        result = storeService.addStoreDetails(storeDetails);

        return result;
    }

    public StoreDetails editStore() throws CloneNotSupportedException {

        try {
            storeDetails = storeService.editStore();
            deepCopy = (StoreDetails) storeDetails.clone();
        } catch (Exception e) {
            System.out.println(e);
        }
        return deepCopy;
    }
}
