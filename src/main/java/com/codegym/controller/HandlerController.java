package com.codegym.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandlerController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error_404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error_500";
            }
        }
        return "error";
    }

    @RequestMapping("/error404")
    public String handleError404(HttpServletRequest request){
        return "error_404";
    }

    @RequestMapping("/errorr")
    public String handleError0(HttpServletRequest request){
        return "error";
    }

    @RequestMapping("/error500")
    public String handleError500(HttpServletRequest request){
        return "error_500";
    }
}