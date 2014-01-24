/*-
 * Copyright (c) 2004-2014 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package com.tt.sabamiso.user.presentation;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tt.sabamiso.domain.User;
import com.tt.sabamiso.user.service.UserService;

/**
 * @author usr160056
 * @since 2014/01/15
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        logger.info("Welcome user!");
        model.addAttribute("users", userService.getAllUser());

        return "user/users";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        User user = new User();
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute(value = "user") @Valid User user, BindingResult result) {
        ModelAndView mv = new ModelAndView("user");
        if (!result.hasErrors()) {
            user.setEntryDate(new Date());
            userService.saveUser(user);
            user = new User();
            mv.addObject("user", user);
        }
        mv.addObject("users", userService.getAllUser());
        return mv;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute(value = "user") User user, BindingResult result) {
        ModelAndView mv = new ModelAndView("user");
        if (!result.hasErrors()) {
            user.setUpdateDate(new Date());
            userService.updateUser(user);
            user = new User();
            mv.addObject("user", user);
        }
        mv.addObject("users", userService.getAllUser());
        return mv;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delete(@ModelAttribute(value = "user") User user, BindingResult result) {
        ModelAndView mv = new ModelAndView("user");
        if (!result.hasErrors()) {
            userService.deleteUser(user.getUserId());
            user = new User();
            mv.addObject("user", user);
        }
        mv.addObject("users", userService.getAllUser());
        return mv;
    }
}
