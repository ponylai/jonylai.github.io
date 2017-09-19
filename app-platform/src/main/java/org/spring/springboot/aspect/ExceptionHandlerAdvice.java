package org.spring.springboot.aspect;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by wei.li12 on 2017/5/15.
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    public void exception(Exception exception, WebRequest request){
        exception.printStackTrace();
        logger.debug("test exception");
    }

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","test @ModelAttribute");
    }

}
