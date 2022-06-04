package com.example.client;

import com.example.dto.Employee;
import com.example.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "httpS://dummyapi.io",name="EMPLOYEE-CLIENT")

public interface EmployeeClient {


    @GetMapping("data/v1/user?limit=10")
    Employee getEmployee(@RequestHeader("app-id") String id);
}