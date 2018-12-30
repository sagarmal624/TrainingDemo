package com.sagarandcompany.dockerdemo;

import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UtilValidator {
    public static ResponseDTO getErrors(BindingResult bindingResult, MessageSource messageSource) {
        List<String> errors = new ArrayList<>();
        for (Object object : bindingResult.getAllErrors()) {
            if (object instanceof FieldError) {
                FieldError fieldError = (FieldError) object;
                String message = messageSource.getMessage(fieldError, Locale.US);
                errors.add(message);
            }
        }
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(false);
        responseDTO.setData(errors);
        return responseDTO;
    }
}
