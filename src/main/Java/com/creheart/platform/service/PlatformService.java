package com.creheart.platform.service;

import com.creheart.domain.PlatFunc;
import com.creheart.platform.repository.PlatRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny on 2017/2/26.
 */
@Component
public class PlatformService {

    private Logger logger = Logger.getLogger(PlatformService.class);

    @Autowired
    private PlatRepository platRepository;

    public List<PlatFunc> allPlatFunces() {
        try {
            return platRepository.allPlatFunces();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

        return null;
    }
}
