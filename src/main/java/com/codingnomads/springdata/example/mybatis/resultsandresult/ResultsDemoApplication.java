/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.resultsandresult;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResultsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultsDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper, CamelMapper camelMapper) {
        return (args) -> {
            // notice the setter names have changed to match Java naming conventions
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbumName("Bon Iver");
            song1.setArtistName("Bon Iver");
            song1.setSongLength(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbumName("Orca");
            song2.setArtistName("Gus Dapperton");
            song2.setSongLength(279);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

            Song song3 = songMapper.getSongById(1L);
            System.out.println(song3.toString());

            Camel camel1 = new Camel();
            camel1.setName("Joe");
            camel1.setHumpAmount(2);

            Camel camel2 = new Camel();
            camel2.setName("Some Other Famous Camel, IDK");
            camel2.setHumpAmount(1);

            camelMapper.insertNewCamel(camel1);
            camelMapper.insertNewCamel(camel2);

            System.out.println(camelMapper.getCamelById(camel1.getId()));

            List<Camel> camelsNamedJoe = camelMapper.getCamelsByName("Joe");
            camelsNamedJoe.forEach(System.out::println);

            List<Camel> camelsWith1Hump = camelMapper.getCamelsByHumpAmount(1);
            camelsWith1Hump.forEach(System.out::println);

        };
    }
}
