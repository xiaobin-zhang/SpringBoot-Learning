package com.didispace.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.didispace.domain.Manager;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/manager")
public class ManageController {

	static Map<Long, Manager> managers = Collections.synchronizedMap(new HashMap<Long, Manager>());
	
	@ApiOperation(value = "获取管理员列表")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Manager> getAllManagers(){
		List<Manager> m = new ArrayList<Manager>(managers.values());
		System.out.println(m.toString());
        return m;
	}
	
	
	@ApiOperation(value = "任命管理员", notes = "任命管理员账户")
	@ApiImplicitParam(name = "manager", value = "管理员实体类", required = true, dataType = "Manager")
	@RequestMapping(value = "/appoinManager", method = RequestMethod.POST)
	public Manager appoinManager(@RequestBody Manager manager){
		managers.put(manager.getId(), manager);
		System.out.println(manager.toString());
		return manager;
	}
	
	@ApiOperation(value = "授权", notes = "给管理员付权限")
	@ApiImplicitParams(
			{
				@ApiImplicitParam(name = "power", value="权限", required = true, dataType = "String"),
				@ApiImplicitParam(name = "id", value = "编号", required = true, dataType = "Long")
			}
	)
	@RequestMapping(value = "/authorization", method = RequestMethod.PUT)
	public Manager authorization(@RequestParam String power, @RequestParam Long id){
		System.out.println("put: " + id);
		Manager manager = managers.get(id);
		System.out.println("put: " + manager.toString());
		manager.setPower(manager.getPower() + "|" + power);
		return manager;
	}
}
