package com.example.demo.user.dao.entity;

import com.example.demo.user.dao.entity.mallUser;
import com.example.demo.user.dao.repo.OrderRepo;
import com.example.demo.user.dao.repo.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/html/imazon")
@SpringBootApplication
@CrossOrigin(origins = "*")
public class userControllers {
    private final Set<String> mallUsers;

    public userControllers() {
        mallUsers = new HashSet<>();
    }


    @Resource
    UserRepository userRepository;
    @Resource
    OrderRepo orderRepo;

    @RequestMapping(value = "/Sign_up", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseStatus(HttpStatus.CREATED)
    public Result users(@RequestBody @Validated mallUserParam user) {
        Result result = new Result();
        mallUser mallUser = new mallUser();
        mallUser.getUserId();

        System.out.println(user.getUserName());
        System.out.println(user.getUserRealName());
        System.out.println(user.getPassword());
        if (!mallUsers.contains(user.getUserName())) {
            mallUser.setUserName(user.getUserName());
            mallUser.setPassword(user.getPassword());
            mallUser.setUserRealName(user.getUserRealName());
            //mallUser.setUserId(user.getUserId());
            mallUsers.add(user.getUserName());
            mallUser = userRepository.save(mallUser);
 
            result.setCode("200");
            result.setMsg("Success");
            return result;
        } else {
            result.setCode("400");
            result.setMsg("Failed");
            return result;
        }

    }

    @RequestMapping(value = "/Sign_In", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseStatus(HttpStatus.CREATED)
    public Result users1(@RequestBody @Validated userLogin user) {
        Result result = new Result();
        mallUser mallUser = new mallUser();
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        if (mallUsers.contains(user.getUserName())) {
            mallUser = userRepository.findUserByName(user.getUserName());
            if (mallUser.getPassword().equals(user.getPassword())) {
                result.setCode("200");
                result.setMsg("");
                result.setData(mallUser);
                return result;
            } else {
                result.setCode("400");
                result.setMsg("Failed, password incorrect");
                return result;
            }
        }
        else {
            result.setCode("400");
            result.setMsg("Failed");
            return result;
        }
    }
    @RequestMapping(value = "/shopping-cart", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result orders(@RequestBody @Validated List<orderParam> orders){
        Result result = new Result();
        List<userOrder> userOrders = new ArrayList<>();

        for (orderParam item : orders) {
            userOrder userOrder = new userOrder();
            String itemUserName = item.getUserName(); // Assuming getName() is a getter method in the Item class
            // do something with itemName
            int quantity = item.getCount();
            String itemName = item.getName();
            double price = item.getPrice();
            System.out.println(itemUserName);
            System.out.println(itemName);
            userOrder.getOrderId();
            userOrder.setUserName(itemUserName);
            userOrder.setOrders(quantity);
            userOrder.setOrder_name(itemName);
            userOrder.setOrder_price(price);
            userOrders.add(userOrder);
        }
        userOrders = orderRepo.saveAll(userOrders);
        result.setCode("200");
        result.setMsg("");
        result.setData(userOrders);
        return result;
    }
}




