package com.braisedpanda.shirotest.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //这里设置没有登录时，跳转界面
        shiroFilterFactoryBean.setLoginUrl("/");
        //这里是没有授权时，跳转的界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/userlist/**", "roles[dg]");

        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/layui/**", "anon");
        filterChainDefinitionMap.put("/lib/**", "anon");
        filterChainDefinitionMap.put("/toregist/**", "anon");
        filterChainDefinitionMap.put("/regist/**", "anon");

        filterChainDefinitionMap.put("/student/delete/**","perms[delete]");
        filterChainDefinitionMap.put("/student/toadd/**", "perms[create]");
        filterChainDefinitionMap.put("/user/delete/**","perms[delete]");
        filterChainDefinitionMap.put("/user/toadd/**", "perms[create]");
        filterChainDefinitionMap.put("/student/toeditstudent/**", "perms[update]");



        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
        filterChainDefinitionMap.put("/**", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(customRealm());
        return defaultSecurityManager;
    }

    @Bean
    public CustomRealm customRealm() {
        CustomRealm customRealm = new CustomRealm();
        return customRealm;
    }

    //注解
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
