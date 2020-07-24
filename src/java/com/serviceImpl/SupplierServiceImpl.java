/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceImpl;

import com.dao.SupplierDao;
import com.daoImpl.SupplierDaoImpl;
import com.pojo.Supplier;
import com.service.SupplierService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenin Ananth
 */
public class SupplierServiceImpl implements SupplierService {

    private SupplierDao supplierDao = new SupplierDaoImpl();

    @Override
    public int saveSupplier(Supplier supplier) {

        int result = supplierDao.saveSupplier(supplier);
        return result;
    }

    @Override
    public List<Supplier> getSupplierList() {
        List<Supplier> supplierList = new ArrayList<>();

        supplierList = supplierDao.getSupplierList();

        return supplierList;
    }

    @Override
    public String supplierdelete(int id) {

        String message = supplierDao.supplierdelete(id);
        return message;
    }

    @Override
    public Supplier editSupplier(int id) {

        Supplier supplier = supplierDao.editSupplier(id);

        return supplier;
    }

    @Override
    public int updateSuppllier(Supplier supplier) {

        int result = supplierDao.updateSuppllier(supplier);
        return result;
    }

}
