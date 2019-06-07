package com.Sean.mapper;

import com.Sean.pojo.Animecharacter;
import com.Sean.pojo.AnimecharacterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnimecharacterMapper {
    int countByExample(AnimecharacterExample example);

    int deleteByExample(AnimecharacterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Animecharacter record);

    int insertSelective(Animecharacter record);

    List<Animecharacter> selectByExample(AnimecharacterExample example);

    Animecharacter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Animecharacter record, @Param("example") AnimecharacterExample example);

    int updateByExample(@Param("record") Animecharacter record, @Param("example") AnimecharacterExample example);

    int updateByPrimaryKeySelective(Animecharacter record);

    int updateByPrimaryKey(Animecharacter record);
}