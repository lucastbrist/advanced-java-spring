/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.GET.getForObject;

import com.codingnomads.springweb.resttemplate.GET.models.Bored;
import com.codingnomads.springweb.resttemplate.GET.models.Excuse;
import com.codingnomads.springweb.resttemplate.GET.models.QuoteTemplate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GetForObjectDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForObjectDemo.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            QuoteTemplate[] randomQuote;
            randomQuote = restTemplate.getForObject("https://zenquotes.io/api/random/", QuoteTemplate[].class);
            System.out.println(Arrays.toString(randomQuote));

            // submit more requests here

            Excuse[] randomExcuse;
            randomExcuse = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse/3/", Excuse[].class);
            System.out.println(Arrays.toString(randomExcuse));

            Map<String, String> params = new HashMap<>();
            params.put("type", "social");
            params.put("participants","3");

            Bored[] randomBored;
            randomBored = restTemplate.getForObject("https://bored-api.appbrewery.com/filter?type={type}&participants={participants}",Bored[].class, params);
            System.out.println(Arrays.toString(randomBored));

            //        CodingNomadsTasksApiResponse response =
            //                restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users/5",
            //                        CodingNomadsTasksApiResponse.class);
            //
            //        System.out.println(response.toString());

        };
    }
}
