package com.creheart.platform.service;

import com.creheart.domain.PlatFunc;
import com.creheart.platform.repository.PlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny on 2017/2/26.
 */
@Component
public class PlatformService {

    @Autowired
    private PlatRepository platRepository;

    public List<PlatFunc> allPlatFunces() {
        return platRepository.allPlatFunces();
    }
}
