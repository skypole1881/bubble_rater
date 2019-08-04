package com.bubble.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.bubble.dto.LoginDTO;
import com.bubble.dto.LoginResultDTO;
import com.bubble.enums.ErrorMessageEnum;
import com.bubble.enums.HttpCodeEnum;
import com.bubble.exception.BusinessException;
import com.bubble.util.CommonResult;
import com.bubble.util.CommonResultMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;


@Path("/permissions")
public class PermissionRest {

//	@Autowired
//	private IPermissionService permissionService;
//
//	@Autowired
//	private IUserService userService;
//
//	@Autowired
//	IPersonalInfoService personalInfoService;

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(LoginDTO dto) {
		CommonResultMap map = new CommonResultMap();
		try {
			System.out.print(dto.getPassword());
			LoginResultDTO loginResultDTO = new LoginResultDTO();
			map.setResult(CommonResult.SUCCESS);
			map.setData(loginResultDTO);
		} catch (Exception e) {
			e.printStackTrace();
			map.setResult(CommonResult.ERROR, e.getMessage());
		}
		return Response.status(HttpCodeEnum.OK.getCode()).entity(map).build();
	}

//	@GET
//	@Path("/role/{roleId}/module/{moduleId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getRolePermission(@PathParam("roleId") Integer roleId, @PathParam("moduleId") Integer moduleId) {
//		CommonResultMap map = new CommonResultMap();
//		try {
//			RolePermissionDTO rolePermissionDto = permissionService.getRolePermission(roleId, moduleId);
//			map.setData(rolePermissionDto);
//			map.setResult(CommonResult.SUCCESS);
//		} catch (Exception e) {
//			e.printStackTrace();
//			map.setResult(CommonResult.ERROR, e.getMessage());
//		}
//		return Response.status(HttpCodeEnum.OK.getCode()).entity(map).build();
//	}
//
//	@POST
//	@Path("/role")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response createRolePermission(RolePermissionDTO rolePermissionDto) {
//		CommonResultMap map = new CommonResultMap();
//		try {
//			Integer permission = rolePermissionDto.generateRolePermission();
//			RolePermission rolePermission = new RolePermission();
//
//			if (null == rolePermissionDto.getRoleId()
//					|| StringUtils.isEmpty(rolePermissionDto.getRoleId().toString())) {
//				throw new Exception();
//			}
//
//			if (null == rolePermissionDto.getModuleId()
//					|| StringUtils.isEmpty(rolePermissionDto.getModuleId().toString())) {
//				throw new BusinessException(ErrorMessageEnum.Auth_User_Has_No_Access);
//			}
//
//			rolePermission.setRoleId(Integer.valueOf(rolePermissionDto.getRoleId()));
//			rolePermission.setModuleId(Integer.valueOf(rolePermissionDto.getModuleId()));
//			rolePermission.setPermissionString(permission);
//			permissionService.saveOrUpdateRolePermission(rolePermission);
//			map.setResult(CommonResult.SUCCESS, "Create permission success");
//		} catch (Exception e) {
//			e.printStackTrace();
//			map.setResult(CommonResult.ERROR, e.getMessage());
//		}
//		return Response.status(HttpCodeEnum.OK.getCode()).entity(map).build();
//	}

}
