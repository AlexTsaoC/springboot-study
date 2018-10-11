package com.tsao.blog.shiro;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import com.tsao.blog.dao.UserDao;
import com.tsao.blog.entity.Permission;
import com.tsao.blog.entity.Role;
import com.tsao.blog.entity.User;
import com.tsao.blog.service.PermissionService;
import com.tsao.blog.service.RoleService;
import com.tsao.blog.service.UserService;

import groovy.transform.builder.InitializerStrategy.SET;

@Service("authRealm")
public class AuthRealm extends AuthorizingRealm{

	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "roleService")
	private RoleService roleService;
	
	@Resource(name = "permissionService")
	private PermissionService permissionService;
	
	@Resource(name = "credentialsMatcher")
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher){
        super.setCredentialsMatcher(credentialsMatcher);
    }
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String username = (String) principals.getPrimaryPrincipal();
		User user = this.userService.getByUsername(username);
		Role role = this.roleService.detail(user.getRoleId());
		Set<String> rolenames = new HashSet<String>();
		rolenames.add(role.getRoleName());
		List<Permission> permissions = this.permissionService.queryByRoleId(role.getId());
		Set<String> permissionNames = new HashSet<String>();
		for(Permission permission: permissions){
			permissionNames.add(permission.getPermname());
		}
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.setRoles(rolenames);
		simpleAuthorizationInfo.setStringPermissions(permissionNames);
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String) token.getPrincipal();
		User user = this.userService.getByUsername(username);
		AuthenticationInfo authenticationInfo = null;
		if(user != null){
			authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getUsername()), this.getClass().getName());
		}
		return authenticationInfo;
	}

}
