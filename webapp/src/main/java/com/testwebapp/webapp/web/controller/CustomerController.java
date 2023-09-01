package com.testwebapp.webapp.web.controller;
import com.testwebapp.webapp.dao.CustomerDao;
import com.testwebapp.webapp.exception.PermitException;
import com.testwebapp.webapp.model.Customer;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController // traite les requetes definies, chaque methode va renvoyer directement la reponse JSON à l'utilisateur
public class CustomerController {

    RestTemplate restTemplate = new RestTemplate();

    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    @ApiOperation(value = "Récupère la liste de tous les clients")
    @GetMapping("/customer")
    public List<Customer> listCustomer() {
        return customerDao.findAll();
    }

    @ApiOperation(value = "Récupère un client par son id")
    @GetMapping(value = "/customer/{id}")
    public Customer showCustomer(@PathVariable int id) {
        return customerDao.findById(id);
    }

    @ApiOperation(value = "Ajouter un client")
    @PostMapping(value = "/customer")
    public void addCustomer(@RequestBody Customer customer) {
        validPermit(customer.getPermitnumber());
        customerDao.save(customer);
    }

    @ApiOperation(value = "Modifier un client")
    @PutMapping(value = "/customer/{id}")
    public void updateCustom (@PathVariable int id, @RequestBody Customer customer) {
        validPermit(customer.getPermitnumber());
        customerDao.updateCustomer(id, customer);
    }

    @ApiOperation(value = "Supprimer un client")
    @DeleteMapping(value = "/customer/{id}")
    public void deleteCustom (@PathVariable int id) {
        customerDao.deleteCustomer(id);
    }

    public void validPermit (String permitnumber){
        Boolean isValid = restTemplate.getForObject("http://localhost:8081/licenses/" + permitnumber, Boolean.class);
        if (isValid == null || !isValid) {
            throw new PermitException();
        }
    }
}


//    @PostMapping(value = "/customer")
//    public Customer addCustomer(Customer customer) {
//        return customerDao.save(customer);
//    }

//    private final CustomerDao customerDao;
//
//    public CustomerControler(CustomerDao customerDao){
//        this.customerDao =
//    }
//
//    @GetMapping("/customer")
//    public ArrayList<Customer> listCustomer() {
//        return listCustomer;
//    }

//    public Date extractdate(String date) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date newDate = sdf.parse(date);
//    }

//    ArrayList<Customer> listCustomer = new ArrayList<Customer>() {
//        {
//          add(new Customer(0, "Zakuross", "emulatos", new Date(2000, Calendar.DECEMBER, 25), "aaa000"));
//          add(new Customer(1, "Matis", "legrand", new Date(2050, Calendar.DECEMBER, 24), "baa000"));
//          add(new Customer(2, "Hich", "lesorcier", new Date(1050, Calendar.DECEMBER, 23), "caa000"));
//        }
//    };
//
//    @GetMapping("/customer/{id}")
//    public Customer showCustomer(@PathVariable int id) {
//        Customer findCustomer = null;
//        for(int i =0; i < listCustomer.size(); i++){
//            if (listCustomer.get(i).getId() == id) {
//                findCustomer = listCustomer.get(i);
//                return findCustomer;
//            }
//        }
//        return findCustomer;
//    }



//    @GetMapping("/Salut/{id}")
//    public Customer showOneCustomer(@PathVariable int id) {
//
//        Customer findClients = null;
//
//        for(Customer bastien : listCustomer){
//
//            if(bastien.getId() == id){
//                findClients = bastien;
//                return findClients;
//            }
//
//        }
//        return findClients;
//    }
// }




