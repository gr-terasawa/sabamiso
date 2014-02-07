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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    /**
     * formモデルのバインダーの初期化。リクエストパラメタをモデルに変換するたびに呼ばれる。
     */
    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        logger.info("UserController#initBinder");
        binder.setDisallowedFields("user.enabled", "user.entryDate", "user.updateDate");
    }

    /**
     * モデルオブジェクトの初期化
     */
    @ModelAttribute("form")
    public Form newRequest(@RequestParam(required = false, value = "user.userId") Integer userId) {
        logger.info("UserController#newRequest");
        Form form = new Form();
        //
        User user = null;
        if (userId == null) {
            user = new User();
        } else {
            user = this.userService.getUser(Integer.valueOf(userId));
        }
        //
        form.setUser(user);
        return form;
    }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input(Form form, Model model) {
        // 既にnewRequestでモデルをDBから取り出し、設定しているので何もする必要がない
        return "user.input";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Form form, BindingResult result, RedirectAttributes attributes) throws Exception {
        if (result.hasErrors()) {
            return "user.input";
        }
        // データ更新
        form.user.setEnabled(true);
        form.user.setEntryDate(new Date());
        this.userService.saveUser(form.user);
        attributes.addFlashAttribute("message", "ユーザーの登録が完了しました。");
        return "redirect:/user/input";
    }

//    @ModelAttribute("user")
//    public User newRequest(@RequestParam(required=false, value="user.userId") Integer id) {
//        logger.info("UserController#newRequest");
//        if (id == null) {
//            return null;
//        }
//        return this.userService.getUser(id);
//    }

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String list(Model model) {
//        logger.info("UserController#list");
//        model.addAttribute("users", userService.getAllUser());
//
//        return "user/users";
//    }

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

    // フォーム(HTML用のパラメタを受け取れるように作っておいた方がよいと思います)
    public static class Form {

        @Valid
        private User user;

        private String message;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        
        /**
         * @return the message
         */
        public String getMessage() {
            return message;
        }

        
        /**
         * @param message the message to set
         */
        public void setMessage(String message) {
            this.message = message;
        }

    }

}
