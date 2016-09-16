package com.gx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import com.gx.model.ObjUser;

public interface ObjUserDao {

	/**
	 * 添加新用户
	 * @param user
	 * @return
	 */
	public int insertUser(ObjUser user);
	
    public int updatePassword(ObjUser user);
    
    public int delete(ObjUser user); 
       
}