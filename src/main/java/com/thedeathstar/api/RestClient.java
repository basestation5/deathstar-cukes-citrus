package com.thedeathstar.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.thedeathstar.model.DeathStars;

/**
 * Created by Jeremy on 6/27/17.
 */
public class RestClient {

    //private static final RestTemplate restTemplate;

    public String GetDeathStars()
    {
        String url = "https://deathstar-service.cfapps.io/deathstars";
        String result;
        String deathStars;

        RestTemplate restTemplate = new RestTemplate();
        deathStars = restTemplate.getForObject(url, String.class);

        return deathStars;
    }
}

