package com.codingnomads.springdata.example.mybatis.oneandmany.mappers;

import com.codingnomads.springdata.example.mybatis.oneandmany.models.Album;
import com.codingnomads.springdata.example.mybatis.oneandmany.models.Song;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AlbumMapper {

    @Insert("INSERT INTO mybatis.albums (name, year) VALUES (#{name}, #{year});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewAlbum(Album album);

    @Select("SELECT * FROM mybatis.albums WHERE id = #{param1};")
    Album getAlbumById(Long id);

    @Select("SELECT * " + "FROM mybatis.albums " + "WHERE artist_id = #{param1};")
    @ResultMap("songResultMap")
    List<Album> getAlbumsByArtistId(Long artistId);

}
