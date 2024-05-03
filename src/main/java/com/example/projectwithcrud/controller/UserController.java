package com.example.projectwithcrud.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.projectwithcrud.dto.RequestResponse;
import com.example.projectwithcrud.dto.UserModel;
import com.example.projectwithcrud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class UserController {
    @Autowired
    UserService userService;

    // @GetMapping("path")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }


    @GetMapping("/fetch/{id}")
    public RequestResponse getMethodName(@PathVariable Long id) {
        RequestResponse response=userService.fetchData(id);
        return response;
    }

    @PutMapping("/update/{id}")
    public RequestResponse putMethodName(@PathVariable Long id, @RequestBody UserModel userModel) {  
        RequestResponse response=userService.updateData(userModel,id);
        return response;
    }
    
    @PostMapping("/save")
    public RequestResponse savedata(@RequestBody UserModel userModel) {
        RequestResponse requestResponse=userService.savedata(userModel);
        return requestResponse;
    }

    @DeleteMapping("/delete/{id}")
    public RequestResponse deleteData(@PathVariable Long id){
        RequestResponse response= userService.deleteData(id);
        return response;
    }
    
    
    
}
