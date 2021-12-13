package com.innopolis.carrentapp.controller;

import com.innopolis.carrentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/users")
@RequiredArgsConstructor
public class UserFrontendController {

    private final UserService userService;


}
