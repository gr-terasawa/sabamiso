/*-
 * Copyright (c) 2004-2014 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package com.tt.sabamiso.file.presentation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tt.sabamiso.domain.File;
import com.tt.sabamiso.domain.FileMeta;
import com.tt.sabamiso.integration.FileMapper;

/**
 * @author usr160056
 * @since 2014/01/15
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    FileMapper fileMapper;

    // /**
    // * formモデルのバインダーの初期化。リクエストパラメタをモデルに変換するたびに呼ばれる。
    // */
    // @InitBinder("form")
    // public void initBinder(WebDataBinder binder) {
    // logger.info("UserController#initBinder");
    // binder.setAllowedFields("uploadFile");
    // }

    // /**
    // * モデルオブジェクトの初期化
    // */
    // @ModelAttribute("form")
    // public Form newRequest() {
    // logger.info("UserController#newRequest");
    // Form form = new Form();
    // return form;
    // }

//    LinkedList<FileMeta> files = new LinkedList<FileMeta>();
//    FileMeta fileMeta = null;
    /***************************************************
     * URL: /rest/controller/upload  
     * upload(): receives files
     * @param request : MultipartHttpServletRequest auto passed
     * @param response : HttpServletResponse auto passed
     * @return LinkedList<FileMeta> as json format
     ****************************************************/
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    LinkedList<File> upload(MultipartHttpServletRequest request, HttpServletResponse response) {

        LinkedList<File> files = new LinkedList<File>();

        // 1. build an iterator
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = null;

        // 2. get each file
        while (itr.hasNext()) {

            // 2.1 get next MultipartFile
            mpf = request.getFile(itr.next());
            System.out.println(mpf.getOriginalFilename() + " uploaded! " + files.size());

            // 2.2 if files > 10 remove the first from the list
            if (files.size() >= 10)
                files.pop();

            // 2.3 create new file
//            fileMeta = new FileMeta();
//            fileMeta.setFileName(mpf.getOriginalFilename());
//            fileMeta.setFileSize(mpf.getSize() / 1024 + " Kb");
//            fileMeta.setFileType(mpf.getContentType());

            File file = new File();
            file.setName(mpf.getOriginalFilename());
            file.setSize(mpf.getSize());
            file.setContentType(mpf.getContentType());

            int id = fileMapper.insert(file);
            file.setId(id);
            try {
//                fileMeta.setBytes(mpf.getBytes());

                // copy file to local disk (make sure the path
                // "e.g. D:/temp/files" exists)
                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream("C:/temp/" + mpf.getOriginalFilename()));

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 2.4 add to files
            files.add(file);
        }
        // result will be like this
        // [{"id":"1", "name":"app_engine-85x77.png","size":"8 Kb","contentType":"image/png"},...]
        return files;
    }

    /***************************************************
     * URL: /rest/controller/get/{value}
     * get(): get file as an attachment
     * @param response : passed by the server
     * @param value : value from the URL
     * @return void
     ****************************************************/
    @RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
    public void get(HttpServletResponse response, @PathVariable String value) {
//        File getFile = files.get(Integer.parseInt(value));
//        try {
//            response.setContentType(getFile.getFileType());
//            response.setHeader("Content-disposition", "attachment; filename=\"" + getFile.getFileName() + "\"");
//            FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Model model) {
        return "file.upload";
    }

    @RequestMapping(value = "/uploadaaa", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws Exception {
//        File saveFile = new File("c:/temp/upload.txt");
//        FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
//        attributes.addFlashAttribute("message", "c:/temp/upload.txt");

        return "redirect:/file/";
    }

}
