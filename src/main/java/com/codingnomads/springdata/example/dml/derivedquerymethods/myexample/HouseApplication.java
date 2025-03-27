/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HouseApplication implements CommandLineRunner {

    @Autowired
    HouseRepo houseRepo;

    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

        List<House> houses = Arrays.asList(
                House.builder().address("1234 Coolguy Lane").beds(3).baths(2).build(),
                House.builder().address("1010 Lame Place").beds(0).baths(0).build(),
                House.builder().address("420 Legal Street").beds(2).baths(2).build(),
                House.builder().address("19 Faraway Ave").beds(3).baths(3).build(),
                House.builder().address("16 Going On 17 Hill").beds(6).baths(4).build(),
                House.builder().address("1812 Warof Field").beds(1).baths(1).build(),
                House.builder().address("Shoe").beds(19).baths(1).build(),
                House.builder().address("1 Small Place").beds(1).baths(1).build(),
                House.builder().address("321 Current Date Boulevard").beds(2).baths(5).build(),
                House.builder().address("2001 Birthdate Circle").beds(4).baths(8).build());

        houseRepo.saveAll(houses);

        System.out.println("Hey, how many houses in this great big list have 6 or more bedrooms? Which ones?");
        List<House> findByBedsGreaterThanEqual = houseRepo.findByBedsGreaterThanEqual(6);
        findByBedsGreaterThanEqual.forEach(System.out::println);

        System.out.println();

        System.out.println("Cool! Speaking of cool, which ones are cool?");
        List<House> findByAddressContaining = houseRepo.findByAddressContaining("Cool");
        findByAddressContaining.forEach(System.out::println);

        System.out.println();

        System.out.println("Great! Show me 1234 Coolguy Lane again.");
        House findByAddress = houseRepo.findByAddress("1234 Coolguy Lane");
        System.out.println(findByAddress);

        System.out.println();

        System.out.println("Now which ones have 2 or more bathrooms?");
        List<House> findByBathsGreaterThanEqual = houseRepo.findByBathsGreaterThanEqual(2);
        findByBathsGreaterThanEqual.forEach(System.out::println);

        System.out.println();

        System.out.println("Any of 'em have no beds or no baths? Want to cross those off my list.");
        List<House> findByBedsIsNullOrBathsIsNull = houseRepo.findByBedsIsNullOrBathsIsNull();
        findByBedsIsNullOrBathsIsNull.forEach(System.out::println);

        System.out.println();

        System.out.println("Thanks! All done.");

    }
}
