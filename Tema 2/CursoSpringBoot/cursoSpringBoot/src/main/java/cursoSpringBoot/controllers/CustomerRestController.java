package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerRestController {

    private List<Customer> customers  = new ArrayList<>(Arrays.asList(
            new Customer(123, "Adrian Rana", "Adri-0906", "adri1234"),
            new Customer(456, "Javier Carrillo", "JaviBol", "javi1234"),
            new Customer(789, "Oscar Fernadez", "oscarfh", "oscar1234"),
            new Customer(234, "Jaime Bonilla", "JaimeBonBol", "jaime1234")
    ));

    @GetMapping
    // @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("/{username}")
    // @RequestMapping(value = "{/username}", method = RequestMethod.GET)
    public Customer getCliente(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }

    @PostMapping
    // @RequestMapping(method = RequestMethod.POST)
    public Customer postCliente(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @PutMapping
    // @RequestMapping(method = RequestMethod.PUT)
    public Customer putCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setNombre(customer.getNombre());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    // @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Customer deleteCliente(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    @PatchMapping
    // @RequestMapping(method = RequestMethod.PATCH)
    public Customer patchCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                if (customer.getNombre() != null) {
                    c.setNombre(customer.getNombre());
                }
                if (customer.getUsername() != null) {
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }

                return c;
            }
        }
        return null;
    }

}
