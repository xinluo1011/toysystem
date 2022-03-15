package com.example.demo.controller;

import com.example.demo.pojo.Toy;
import com.example.demo.service.ToyService;
import com.example.demo.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class ToyController {

    @Autowired
    ToyService toyService;

    @CrossOrigin
    @GetMapping("/toys")
    public List<Toy> list() throws Exception{
        return toyService.list();
    }

    @CrossOrigin
    @PostMapping("/toys")
    public String addToy(@RequestBody Toy toy) throws Exception{
        int i=toyService.addToy(toy);
        if (i==0){
            return "error";
        }else{
            return "success";
        }
    }

    @CrossOrigin
    @PostMapping("/edittoy")
    public String editToy(@RequestBody Toy toy)throws Exception{
        int i=toyService.editToy(toy);
        if(i==0){
            return "error";
        }else{
            return "success";
        }
    }

    @CrossOrigin
    @PostMapping("/delete")
    public void  delete(@RequestBody Toy toy) throws Exception{
        toyService.deleteById(toy.getToyid());
    }

    @CrossOrigin
    @PostMapping("/deleteid")
    public void  deleteByUserId(@RequestBody Toy toy) throws Exception{
        toyService.deleteByUserId(toy.getId());
    }

    @CrossOrigin
    @GetMapping("/cid/{cid}/toy")
    public List<Toy> listByCategory(@PathVariable("cid") int cid) throws Exception{
        if(0!=cid){
            if(cid==2000){
                return toyService.list();
            }
            return toyService.listByCategory(cid);
        }else{
            return null;
        }
    }

    @CrossOrigin
    @GetMapping("/id/{id}/toy")
    public List<Toy> listByUser(@PathVariable("id") int id) throws Exception{
        if(0!=id){
            if(id==2000){
                return toyService.list();
            }
            return toyService.listByUser(id);
        }else{
            return null;
        }
    }

    @CrossOrigin
    @RequestMapping("/toyid")
    public Toy findToyById(Toy toy) throws Exception{
        return toyService.findToyById(toy.getToyid());
    }

    @CrossOrigin
    @RequestMapping("/search")
    public List<Toy> searchResult(@RequestParam("keywords") String keywords){
        //关键词为空查出全部用户
        if("".equals(keywords)){
            return toyService.list();
        }else{
            return toyService.Search(keywords);
        }
    }

    @CrossOrigin
    @PostMapping("/photo")
    public String coversUpload(MultipartFile file) throws Exception{
        String folder ="C:/Users/星络/Desktop/workspace/img";
        File imageFolder =new File(folder);
        File f=new File(imageFolder, StringUtils.getRandomString(6)+file.getOriginalFilename()
        .substring(file.getOriginalFilename().length()-4));
        if(!f.getParentFile().exists()) f.getParentFile().mkdirs();
        try{
            file.transferTo(f);
            String imgURL ="http://localhost:9000/file/"+f.getName();
            return imgURL;
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }
}
