/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.mapperslesson;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyBatisDemoApplication {

    /* Before running this app, be sure to:

       * create a new empty schema in the mysql database named "mybatis"

       * execute the SQL found "songs_table.sql" on the mybatis schema

       * update the "spring.datasource.url" property in your application.properties file to
         jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

    */

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            Song song4 = new Song();
            song4.setName("Bill Bill Bill Bill");
            song4.setAlbum_name("Bill Nye the Science Guy Soundtrack");
            song4.setArtist_name("Mike Greene");
            song4.setSong_length(47);

            Song song5 = new Song();
            song5.setName("Main Title / Rebel Blockade Runner (Medley)");
            song5.setAlbum_name("Star Wars (1977) Motion Picture Soundtrack");
            song5.setArtist_name("John Williams");
            song5.setSong_length(134);

            Song song6 = new Song();
            song6.setName("Coding Nomads Jingle");
            song6.setArtist_name("Unknown");
            song6.setSong_length(6);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);
            songMapper.insertNewSong(song4);

            Song song3 = songMapper.getSongById(1L);

            List<Song> longSongs = songMapper.getSongsWithLengthGreaterThan(250);

            longSongs.forEach(System.out::println);

            System.out.println(song3.toString());

            List<Song> songsByJohnWilliams = songMapper.getSongsByArtist("John Williams");

            songsByJohnWilliams.forEach(System.out::println);

            System.out.println(songMapper.getSongsByName("Post Humorous"));

            List<Song> shortSongs = songMapper.getSongsWithLengthLessThan(60);

            shortSongs.forEach(System.out::println);

            List<Song> songsFromStarWars = songMapper.getSongsByAlbumAndArtist(
                    "John Williams",
                    "Star Wars (1977) Motion Picture Soundtrack");

            song4.setName("Bill Nye the Science Guy Theme Song");

            songMapper.updateSong(song4);

            System.out.println(song4);

            songMapper.deleteSongById(song2.getId());

            songMapper.deleteSongByArtist("Bon Iver");

            songMapper.deleteSongsByAlbumAndArtist("Bon Iver", "Orca");
        };
    }
}
