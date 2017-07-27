package com.creheart.web.processor;

import com.creheart.web.service.IndexService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Created by sunny-chen on 2017/7/27.
 */
@Controller
@RequestMapping("/index")
public class IndexProcessor {

    private Logger log = Logger.getLogger(IndexProcessor.class);

    @Autowired
    private IndexService indexService;

    @RequestMapping
    public String index() {



        return "/web/main";
    }


}
