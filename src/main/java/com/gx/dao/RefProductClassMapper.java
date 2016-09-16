package com.gx.dao;

import com.gx.model.RefProductClass;
import com.gx.model.RefProductClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefProductClassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int countByExample(RefProductClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int deleteByExample(RefProductClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int insert(RefProductClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int insertSelective(RefProductClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    List<RefProductClass> selectByExample(RefProductClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    RefProductClass selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByExampleSelective(@Param("record") RefProductClass record, @Param("example") RefProductClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByExample(@Param("record") RefProductClass record, @Param("example") RefProductClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByPrimaryKeySelective(RefProductClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_product_class
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByPrimaryKey(RefProductClass record);
}