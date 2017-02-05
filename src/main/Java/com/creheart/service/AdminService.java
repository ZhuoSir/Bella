package com.creheart.service;

import com.creheart.repository.AdminRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by sunny on 2017/2/5.
 */
@Service("adminService")
public class AdminService {

    @Resource(name = "adminRepository")
    private AdminRepository adminRepository;

}
