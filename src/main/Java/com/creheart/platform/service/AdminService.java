package com.creheart.platform.service;

import com.chen.StringUtil;
import com.creheart.domain.PlatAdmin;
import com.creheart.platform.exception.PlatformException;
import com.creheart.platform.exception.ServiceException;
import com.creheart.platform.repository.AdminRepository;
import com.creheart.util.SessonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/3/12.
 */
@Component
public class AdminService {

    private Logger logger = Logger.getLogger(AdminService.class);

    @Autowired
    private AdminRepository adminRepository;

    public void loginService(final String userName) {
        try {
            PlatAdmin admin = adminRepository.queryAdminByName(userName);
            SessonUtil.setAttributeInSession("platAdmin", admin);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    public void addAdmin(final String adminName,
                         final String pwd,
                         final int adminType,
                         final int status,
                         final int creatorID) throws PlatformException {
        if (StringUtil.isNullOrEmpty(adminName))
            throw new PlatformException("管理员名不能为空");

        if (StringUtil.isNullOrEmpty(pwd))
            throw new PlatformException("密码不能为空");

        PlatAdmin admin = new PlatAdmin(adminName, StringUtil.EncodeByMD5(pwd), adminType, status, creatorID);
        admin.setAddTime(new Date());

        try {
            adminRepository.save(admin);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    @Deprecated
    public int addAdmin(PlatAdmin admin) throws Exception {
        // 对密码进行md5加密；
        String mdPwd = StringUtil.EncodeByMD5(admin.getPassword());
        admin.setPassword(mdPwd);

        return adminRepository.save(admin);
    }

    public boolean isExistOfAdmin(final int id) {

        try {
            String sql = "select exists (select ID from plat_admin where ID = ?);";
            return (long) adminRepository.querySingleOne(sql, id) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

        return false;
    }

    public boolean isExistOfAdmin(final String userName) throws ServiceException {
        if (StringUtil.isNullOrEmpty(userName))
            throw new ServiceException("userName 不能为空");

        try {
            String sql = "select exists (select ID from plat_admin where adminName = ?);";
            return (long) adminRepository.querySingleOne(sql, userName) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

        return false;
    }

    public String validate(final String userName, final String pwd) {
        try {
            String vPwd = adminRepository.queryPwdofAdmin(userName);
            if (StringUtil.isNotNullOrEmpty(vPwd)
                    && StringUtil.isNotNullOrEmpty(pwd)) {
                return vPwd.equals(StringUtil.EncodeByMD5(pwd)) ? "success" : "fail";
            } else {
                return "密码输入异常";
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return e.toString();
        }
    }

    public List<PlatAdmin> queryAdminsByName(final String adminName) throws Exception {
        if (StringUtil.isNullOrEmpty(adminName))
            return null;

        return adminRepository.querAdminsByName(adminName);
    }

    public PlatAdmin queryAdminByName(final String adminName) throws Exception {
        if (StringUtil.isNullOrEmpty(adminName))
            return null;

        return adminRepository.queryAdminByName(adminName);
    }

    public PlatAdmin queryAdminById(final String id) throws Exception {
        return adminRepository.queryAdminById(Integer.parseInt(id));
    }

    public PlatAdmin queryAdminById(final int id) throws Exception {
        return adminRepository.queryAdminById(id);
    }
}