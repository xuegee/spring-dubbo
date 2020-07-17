package com.dubbo.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * <p>className: GlobalExceptionHandler</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-17 13:47
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handle(Exception e) {
        ResponseMsg<Object> responseMsg = new ResponseMsg<Object>();
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            if (bindingResult.hasErrors() && bindingResult.hasFieldErrors()) {
                List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                responseMsg.setErrorDesc(this.getErrors(fieldErrors,";"));
                responseMsg.setRetCode(RetCode.PARAMERROR.getCode());
                return new ResponseEntity<>(responseMsg, HttpStatus.OK);
            }
        }
        logger.error(responseMsg.getErrorDesc(),e);
        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }


    /**
     * 此校验错误信息转化为字符，多个错误信息通过参数[splitChars]进行分隔
     */
    private String getErrors(List<FieldError> fieldErrors, String splitChars) {
        if (splitChars == null) {
            splitChars = "";
        }
        StringBuilder result = new StringBuilder();
        for (FieldError vError : fieldErrors) {
            result.append(vError.getDefaultMessage());
            result.append(vError.getField());
            result.append(splitChars);
        }
        if (result.length() > 0) {
            result.delete(result.length() - splitChars.length(), result.length());
        }
        return result.toString();
    }

}