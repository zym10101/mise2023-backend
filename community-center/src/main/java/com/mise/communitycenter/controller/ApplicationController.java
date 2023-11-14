package com.mise.communitycenter.controller;

import com.mise.communitycenter.domain.vo.Response;
import com.mise.communitycenter.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/applyForCommunity")
    public Response applyForCommunity(@RequestParam long userID, @RequestParam long communityID) {
        boolean result = applicationService.applyForCommunity(userID, communityID);
        if(!result) {
            return Response.failed("申请加入社区失败");
        }
        return Response.success();
    }

    @GetMapping("/exitCommunity")
    public Response exitCommunity(@RequestParam long userID, @RequestParam long communityID) {
        boolean result = applicationService.exitCommunity(userID, communityID);
        if(!result) {
            return Response.failed("退出社区失败");
        }
        return Response.success();
    }

    @GetMapping("/accept")
    public Response accept(@RequestParam long userID, @RequestParam long communityID,
                           @RequestParam long handlerID) {
        boolean result = applicationService.accept(userID, communityID, handlerID);
        if(!result) {
            return Response.failed("处理申请失败");
        }
        return Response.success();
    }

    @GetMapping("/refuse")
    public Response refuse(@RequestParam long userID, @RequestParam long communityID,
                           @RequestParam long handlerID) {
        boolean result = applicationService.refuse(userID, communityID, handlerID);
        if(!result) {
            return Response.failed("处理申请失败");
        }
        return Response.success();
    }
}
