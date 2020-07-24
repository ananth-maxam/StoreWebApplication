/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.pojo.Supplier;
import com.service.SupplierService;
import com.serviceImpl.SupplierServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Lenin Ananth
 */
@ManagedBean(name = "supplierbaen")
public class SupplierBean {

    private Supplier supplier = new Supplier();
    private SupplierService supplierService = new SupplierServiceImpl();
    private List<Supplier> supplierList = new ArrayList<>();
    private Supplier deepCopy = new Supplier();

    public Supplier getDeepCopy() {
        return deepCopy;
    }

    public void setDeepCopy(Supplier deepCopy) {
        this.deepCopy = deepCopy;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int saveSupplier() {
        int result = supplierService.saveSupplier(supplier);

        return result;
    }

    public List<Supplier> getSupplierList() {

        supplierList = supplierService.getSupplierList();

        return supplierList;
    }

    public String supplierdeletedelete(int id) {

        String result = supplierService.supplierdelete(id);
        return result;
    }

    public Supplier editSupplier(int id) throws CloneNotSupportedException {

        try {
            supplier = supplierService.editSupplier(id);

            deepCopy = (Supplier) supplier.clone();
//        Customer copy = (Customer)((Customer)customer).clone();
        } catch (Exception e) {
            System.out.println(e);
        }

        return deepCopy;
    }

    public int updateSupplier(Supplier supplier) {
        int result = 0;
        try {
            result = supplierService.updateSuppllier(supplier);
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

}
