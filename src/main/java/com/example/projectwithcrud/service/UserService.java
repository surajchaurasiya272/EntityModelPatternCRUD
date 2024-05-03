package com.example.projectwithcrud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectwithcrud.dto.RequestResponse;
import com.example.projectwithcrud.dto.UserModel;
import com.example.projectwithcrud.entity.User;
import com.example.projectwithcrud.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public RequestResponse deleteData(Long id) {
        RequestResponse response = new RequestResponse();
        try {
            Optional<User> user = userRepository.findById(id);
            User u1 = user.get();
            userRepository.delete(u1);
            response.setStatus("200");
            response.setMessage("User with ID " + id + " deleted successfully");
            response.setMessageDetail("success");
            return response;
        } catch (Exception e) {
            response.setStatus("33");
            response.setMessage("data not found");
            response.setMessageDetail("failed");
        }
        return response;

    }

    public RequestResponse updateData(UserModel userModel, Long id) {
        RequestResponse response = new RequestResponse();
        try {
            Optional<User> users = userRepository.findById(id);
            if (!users.isPresent()) {
                // Handle the case of a non-existent user ID
                response.setStatus("404");
                response.setMessage("User with ID " + id + " not found");
                response.setMessageDetail("failed");
                return response;
            }
            User u1 = users.get();
            u1.setFirstName(userModel.getFirstName());
            u1.setLastName(userModel.getLastName());
            u1.setEmail(userModel.getEmail());
            userRepository.save(u1);
            response.setStatus("200 ok");
            response.setMessage("update data succesfully");
            response.setMessageDetail("success");
            response.setData(u1);

        } catch (Exception e) {
            response.setStatus("33");
            response.setMessage("data not found");
            response.setMessageDetail("failed");
        }
        return response;

    }

    public RequestResponse fetchData(Long id) {
        RequestResponse response = new RequestResponse();
        Optional<User> user = userRepository.findById(id);
        // System.out.println(user);
        if (user.isPresent()) {
            UserModel ss = new UserModel();
            User u1 = user.get();
            ss.setFirstName(u1.getFirstName());
            ss.setLastName(u1.getLastName());
            ss.setEmail(u1.getEmail());
            response.setStatus("200 ok");
            response.setMessage("data inserted succesfully");
            response.setMessageDetail("success");
            response.setData(u1);
        } else {
            response.setStatus("501");
            response.setMessage("data not found");
            response.setMessageDetail("failed");
        }

        return response;

    }

    public RequestResponse savedata(UserModel userModel) {

        RequestResponse response = new RequestResponse();
        User ss = new User();
        // if(!userModel.getFirstName().equals("") || !userModel.getEmail().equals(""))
        // {
        if (!userModel.getFirstName().isEmpty() || !userModel.getEmail().isEmpty()) {
            ss.setFirstName(userModel.getFirstName());
            ss.setLastName(userModel.getLastName());
            ss.setEmail(userModel.getEmail());
            userRepository.save(ss);
            response.setStatus("200 ok");
            response.setMessage("data inserted succesfully");
            response.setMessageDetail("success");
        } else {
            response.setStatus("501");
            response.setMessage("data inserted fail");
            response.setMessageDetail("failed");
        }

        return response;

    }

}
