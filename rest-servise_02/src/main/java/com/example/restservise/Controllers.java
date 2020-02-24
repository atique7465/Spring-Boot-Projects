package com.example.restservise;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class Controllers {
    @Autowired
    private CustomersRepo c_repo;

    @RequestMapping(value = "customer", method = RequestMethod.GET)
    public List<Customers> list() {
        return c_repo.findAll();
    }

    @RequestMapping(value = "customer", method = RequestMethod.POST)
    public Customers create(@RequestBody Customers c) {
        return c_repo.saveAndFlush(c);
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.GET)
    public Optional<Customers> get(@PathVariable int id) {
        return c_repo.findById(id);
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.PUT)
    public Customers update(@PathVariable int id, @RequestBody Customers c) {
        Optional<Customers> exist_c = c_repo.findById(id);
        BeanUtils.copyProperties(c, exist_c);
        return c_repo.saveAndFlush(c);
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.DELETE)
    public Optional<Customers> delete(@PathVariable int id) {
        Optional<Customers> exist_c = c_repo.findById(id);
        c_repo.deleteById(id);
        return exist_c;
    }

}
