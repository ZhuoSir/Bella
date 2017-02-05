package com.creheart.service;

import com.creheart.bean.User;
import com.creheart.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunny on 2017/2/5.
 */
@Service("userService")
public class UserService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    public int save(User user) throws Exception {
        return userRepository.save(user);
    }

    public List<User> allUser() throws Exception {
        return userRepository.allUser().toBeanList(User.class);
    }
}
