package com.zht.service;


import com.zht.pojo.coach;
import com.zht.pojo.order;
import com.zht.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class coachDetailsService implements UserDetailsService {

    @Autowired
    private CoachService coachService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        coach user = coachService.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
        authorities.add(new SimpleGrantedAuthority("ROLE_user"));

        return new User(
                user.getName(),
                // 因为数据库是明文，所以这里需加密密码
                passwordEncoder.encode(user.getPhone()),
                authorities
        );
    }
}
