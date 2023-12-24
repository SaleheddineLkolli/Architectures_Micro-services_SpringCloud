package org.sid.billingservice.feign;

import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping(path="/customers")
    PagedModel<Customer> pageProducts(
            @RequestParam(value="page") int page,
            @RequestParam(value ="size")int size
    );
    @GetMapping(path="/customers/{id}")
    public Customer getCustomerById(@PathVariable(name= "id") Long id);

}
