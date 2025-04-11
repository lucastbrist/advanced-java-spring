/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.oneandmany.mappers;

import com.codingnomads.springdata.example.mybatis.oneandmany.models.Artist;
import java.util.List;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface ArtistMapper {

    @Insert("INSERT INTO mybatis.artists (name, bio) VALUES (#{name}, #{bio});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewArtist(Artist artist);

    @Select("SELECT * FROM mybatis.artists WHERE id = #{param1};")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(
                property = "songs",
                column = "id",
                javaType = List.class,
                many =
                        @Many(
                                select =
                                        "com.codingnomads.springdata.example.mybatis.oneandmany.mappers.SongMapper.getSongsByArtistId",
                                fetchType = FetchType.LAZY))
    })
    Artist getArtistByIdWithSongs(Long id);

    @Select("SELECT * FROM mybatis.artists WHERE id = #{param1};")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(
                    property = "songs",
                    column = "id",
                    javaType = List.class,
                    many =
                    @Many(
                            select =
                                    "com.codingnomads.springdata.example.mybatis.oneandmany.mappers.AlbumMapper.getAlbumsByArtistId",
                            fetchType = FetchType.LAZY))
    })
    Artist getArtistByIdWithAlbums(Long id);

    @Select("SELECT * FROM mybatis.artists WHERE id = #{param1};")
    Artist getArtistByIdWithoutSongs(Long id);
}
