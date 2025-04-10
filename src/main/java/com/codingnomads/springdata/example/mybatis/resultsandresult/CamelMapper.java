package com.codingnomads.springdata.example.mybatis.resultsandresult;

import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CamelMapper {

    @Insert("INSERT INTO mybatis.camels " + "(name, hump_amount) "
            + "VALUES (#{name}, #{humpAmount});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewCamel(Camel camel);

    @Select("SELECT * " + "FROM mybatis.camels " + "WHERE id = #{param1};")
    Camel getCamelById(Long id);

    @Select("SELECT * " + "FROM mybatis.camels " + "WHERE name = #{param1};")
    List<Camel> getCamelsByName(String name);

    @Select("SELECT * " + "FROM mybatis.camels " + "WHERE hump_amount = #{param1};")
    List<Camel> getCamelsByHumpAmount(int humpAmount);

}
