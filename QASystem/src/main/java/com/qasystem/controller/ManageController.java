package com.qasystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.qasystem.domain.Department;
import com.qasystem.service.implement.DepartmentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/manage")
public class ManageController {
    @Autowired
    private DepartmentImpl departmentImpl;

    @RequestMapping(value = "/addDept",method = RequestMethod.POST)
    @ResponseBody
    public Map addDept(@RequestBody JSONObject jsonObject){
        Long Did = jsonObject.getLong("Did");
        String Dname = jsonObject.getString("Dname");
        String Dinfo = jsonObject.getString("Dinfo");
        Department department = new Department();
        department.setDid(Did);
        department.setDname(Dname);
        department.setDinfo(Dinfo);
        departmentImpl.addNewDept(department);
        Map result = new HashMap();
        result.put("result",1);
        return result;
    }
}
