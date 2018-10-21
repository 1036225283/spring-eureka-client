package xws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * test
 * Created by xws on 5/20/17.
 */

@RestController
public class ConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String serviceInstancesByApplicationName() {
        return restTemplate.getForEntity("http://a-test-client/user/register", String.class).getBody();
    }

}
