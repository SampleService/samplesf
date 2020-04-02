package com.septemberhx.sf.controller;

import com.septemberhx.common.bean.MResponse;
import com.septemberhx.mclient.annotation.MFuncDescription;
import com.septemberhx.sf.utils.MBaseUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SeptemberHX
 * @version 0.1
 * @date 2020/3/31
 */
@Controller
public class MainController {

    private Logger logger = LogManager.getLogger(this);

    @PostMapping(path = "/delivery")
    @ResponseBody
    @MFuncDescription(value = "delivery", level = 2)
    public MResponse delivery(@RequestBody MResponse params, HttpServletRequest request) {
        boolean r = MBaseUtils.verDepRequest("navigation", 9, request, logger);

        if (!r) {
            return MResponse.failResponse();
        }
        return MBaseUtils.generateResInKBSize(13);
    }

    @PostMapping(path = "/PDelivery")
    @ResponseBody
    @MFuncDescription(value = "PDelivery", level = 1)
    public MResponse pdelivery(@RequestBody MResponse params, HttpServletRequest request) {

        boolean r = MBaseUtils.verDepRequest("navigation", 9, request, logger)
                && MBaseUtils.verDepRequest("pay", 20, request, logger);

        if (!r) {
            return MResponse.failResponse();
        }
        return MBaseUtils.generateResInKBSize(5);
    }
}
