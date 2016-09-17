package com.gx.dao;

import com.gx.model.ObjUserInvoice;
import com.gx.model.ObjUserInvoiceExample;
import com.gx.model.ObjUserShipAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserInvoiceMapper {

    int insertSelective(ObjUserInvoice record);

    int pro_set_def_invoice(Map param);
}