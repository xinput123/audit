package com.zuul;

import com.netflix.zuul.FilterProcessor;
import com.zuul.filter.WanhuFilterProcessor;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {
	
    public static void main(String[] args) {
        FilterProcessor.setProcessor(new WanhuFilterProcessor());
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

}
