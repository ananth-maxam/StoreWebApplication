/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Supplier;
import java.util.List;

/**
 *
 * @author Lenin Ananth
 */
public interface SupplierDao {

    public int saveSupplier(Supplier supplier);

    public List<Supplier> getSupplierList();

    public String supplierdelete(int id);
    
    public Supplier editSupplier(int id);
    
    public int updateSuppllier(Supplier supplier);
}
