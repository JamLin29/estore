package com.briup.estore.mapper;

import com.briup.estore.bean.ShopCar;
import com.briup.estore.bean.ShopCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCarMapper {
    long countByExample(ShopCarExample example);

    int deleteByExample(ShopCarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    List<ShopCar> selectByExample(ShopCarExample example);

    ShopCar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopCar record, @Param("example") ShopCarExample example);

    int updateByExample(@Param("record") ShopCar record, @Param("example") ShopCarExample example);

    int updateByPrimaryKeySelective(ShopCar record);

    int updateByPrimaryKey(ShopCar record);
}