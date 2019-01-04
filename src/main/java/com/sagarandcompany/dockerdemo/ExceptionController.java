package com.sagarandcompany.dockerdemo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView internalServerError() {
        ModelAndView modelAndView = new ModelAndView("error_500");
        return modelAndView;
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ModelAndView recordNotFoundException(RecordNotFoundException e, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error_404");
        String url = ((ServletWebRequest) request).getRequest().getRequestURL().toString();
        modelAndView.addObject("message", e.getMessage());
        modelAndView.addObject("url", url);
        return modelAndView;
    }

}
