package xws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * test
 * Created by xws on 5/20/17.
 */

@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public List<ServiceInstance> serviceInstancesByApplicationName() {
        return this.discoveryClient.getInstances("a-bootiful-client");
    }

}
