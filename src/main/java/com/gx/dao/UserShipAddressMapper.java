package com.gx.dao;

import com.gx.model.ObjUserShipAddress;
import com.gx.model.ObjUserShipAddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserShipAddressMapper {

    int insertSelective(ObjUserShipAddress record);


    //int changeDefaultAddress(List<Map<String, String>> changeList);


    public int pro_change_def_ship_address(Map param);


}