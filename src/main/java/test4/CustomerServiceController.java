package test4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import test4.db.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerServiceController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private UserServiceRepository userServiceRepository;

    @PostMapping(path="/addUser") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/users")
    public String getAllUsers(Model model) {
        // This returns a JSON or XML with the users
        Iterable<User> users = userRepository.findAll();
        List list = new ArrayList();
        for (User user : users) {
            list.add(user);
        }
        model.addAttribute("userList", list);
        return "customers";
    }

    @PostMapping(path="/addService") // Map ONLY POST Requests
    public @ResponseBody String addNewService (@RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Service s = new Service();
        s.setName(name);
        serviceRepository.save(s);
        return "Saved";
    }

    @GetMapping(path="/services")
    public String getAllServices(Model model) {
        // This returns a JSON or XML with the users
        Iterable<Service> services = serviceRepository.findAll();
        List list = new ArrayList();
        for (Service service : services) {
            list.add(service);
        }
        model.addAttribute("serviceList", list);
        return "services";
    }

    @GetMapping(path="/addCustomerService") // Map ONLY POST Requests
    public String addCustomerService (@RequestParam String userId, @RequestParam String userName, Model model) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        // This returns a JSON or XML with the users
        Iterable<Service> services = serviceRepository.findAll();
        List list = new ArrayList();
        for (Service service : services) {
            list.add(service);
        }
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userName);
        model.addAttribute("serviceList", list);
        return "subscribeService";
    }

    @GetMapping(path="/removeCustomerService") // Map ONLY POST Requests
    public String removeCustomerService (@RequestParam String userId, @RequestParam String userName, Model model) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        // This returns a JSON or XML with the users
        Iterable<Service> services = serviceRepository.findAll();
        List list = new ArrayList();
        for (Service service : services) {
            list.add(service);
        }
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userName);
        model.addAttribute("serviceList", list);
        return "unsubscribeService";
    }

    @GetMapping("/service-customer")
    public String serviceCustomer(Model model) {
        // This returns a JSON or XML with the users
        Iterable<User> users = userRepository.findAll();
        List<UserVO> list = new ArrayList<UserVO>();
        for (User user : users) {
            UserVO userVO = new UserVO();
            userVO.setId(user.getId());
            userVO.setName(user.getName());
            List<UserService> userServices = userServiceRepository.findByUserInfoId(user.getId());
            for (UserService us : userServices) {
                Optional<Service> s = serviceRepository.findById(us.getServiceInfoId());
                if (s.isPresent()) {
                    userVO.addService(s.get());
                }
            }
            list.add(userVO);
        }
        model.addAttribute("userList", list);

        return "service-customer";
    }

    @PostMapping(path="/subscribe") // Map ONLY POST Requests
    public String addNewService (@RequestParam String userId, @RequestParam String serviceId) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        UserService us = new UserService();
        us.setUserInfoId(Integer.valueOf(userId));
        us.setServiceInfoId(Integer.valueOf(serviceId));
        userServiceRepository.save(us);
        return "service-customer";
    }

    @PostMapping(path="/unsubscribe") // Map ONLY POST Requests
    public String removeNewService (@RequestParam String userId, @RequestParam String serviceId) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        UserService us = new UserService();
        us.setUserInfoId(Integer.valueOf(userId));
        us.setServiceInfoId(Integer.valueOf(serviceId));
        userServiceRepository.delete(us);
        return "service-customer";
    }
}
