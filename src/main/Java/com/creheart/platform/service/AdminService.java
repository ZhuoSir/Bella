package com.creheart.platform.service;

import com.chen.StringUtil;
import com.creheart.domain.PlatAdmin;
import com.creheart.platform.repository.AdminRepository;
import com.creheart.util.SessonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * Created by sunny-chen on 2017/3/12.
 */
@Component
public class AdminService {

    private Logger logger = Logger.getLogger(AdminService.class);

    @Autowired
    private AdminRepository adminRepository;

    public void loginService(String userName) {
        try {
            PlatAdmin admin = adminRepository.queryAdminByName(userName);
            SessonUtil.setAttributeInSession("platAdmin", admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addAdmin(PlatAdmin admin) {
        try {
            // 对密码进行md5加密；
            String mdPwd = StringUtil.EncodeByMD5(admin.getPassword());
            admin.setPassword(mdPwd);

            adminRepository.save("plat_admin", admin);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    public boolean isExistOfAdmin(String userName) {
        boolean ret = false;

        try {
            String sql = "select count(ID) from plat_admin where adminName = '" + userName + "'";
            long count = (long) adminRepository.query(sql).getObjectAtCoordinate(0,0);

            ret = count > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    public String validate(String userName, String pwd) {
        try {
            String vPwd = adminRepository.queryPwdofAdmin(userName);
            if (StringUtil.isNotNullOrEmpty(vPwd)
                    && StringUtil.isNotNullOrEmpty(pwd)) {
                if (vPwd.equals(pwd)) {
                    return "success";
                } else {
                    return "fail";
                }

            } else {
                return "密码输入异常";
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return e.toString();
        }
    }
}