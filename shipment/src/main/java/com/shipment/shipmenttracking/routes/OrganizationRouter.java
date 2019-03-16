package com.shipment.shipmenttracking.routes;

import com.shipment.shipmenttracking.dtos.OrganizationDto;
import com.shipment.shipmenttracking.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by Vahagn.Petrosyan on 3/16/2019.
 */
@Configuration
@ComponentScan("com.shipment.shipmenttracking")
public class OrganizationRouter {

    @Autowired
    private OrganizationService organizationService;

    @Bean
    public RouterFunction<?> routerFunction() {
        return route(GET("/organizations"),
                serverRequest -> ok().body(this.organizationService.getAll(), OrganizationDto.class));
    }
}
