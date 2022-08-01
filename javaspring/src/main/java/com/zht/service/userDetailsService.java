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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class userDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        user user = userService.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
        authorities.add(new SimpleGrantedAuthority("ROLE_user"));

        return new User(
                user.getUsername(),
                // 因为数据库是明文，所以这里需加密密码
                passwordEncoder.encode(user.getPassword()),
                authorities
        );
//        if(CoachService.getUser(username) !=null){
//            coach user = CoachService.getUser(username);
//            authorities.add(new SimpleGrantedAuthority("ROLE_coach"));
//            return new User(
//                    user.getName(),
//                    // 因为数据库是明文，所以这里需加密密码
//                    user.getPhone(),
//                    authorities
//            );
//        }
    }
}
