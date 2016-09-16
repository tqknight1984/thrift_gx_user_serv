package com.gx.dao;

import com.gx.model.ObjEntProductClass;
import com.gx.model.ObjEntProductClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjEntProductClassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int countByExample(ObjEntProductClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int deleteByExample(ObjEntProductClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int insert(ObjEntProductClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int insertSelective(ObjEntProductClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    List<ObjEntProductClass> selectByExample(ObjEntProductClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    ObjEntProductClass selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByExampleSelective(@Param("record") ObjEntProductClass record, @Param("example") ObjEntProductClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByExample(@Param("record") ObjEntProductClass record, @Param("example") ObjEntProductClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByPrimaryKeySelective(ObjEntProductClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByPrimaryKey(ObjEntProductClass record);
}