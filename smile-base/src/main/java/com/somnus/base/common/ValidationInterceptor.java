package com.somnus.base.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import java.util.Set;

import com.somnus.message.Message;

@Aspect
public class ValidationInterceptor {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private javax.validation.Validator validator;        //Match any public methods in a class annotated with @AutoValidating

    @SuppressWarnings("deprecation")
    @Around("execution(public * *(..)) && @within(org.springframework.validation.annotation.Validated)")
    public Object validateMethodInvocation(ProceedingJoinPoint pjp) throws Throwable {
        Object result;
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        try{
            org.hibernate.validator.method.MethodValidator methodValidator = validator.unwrap(org.hibernate.validator.method.MethodValidator.class);
            Set< org.hibernate.validator.method.MethodConstraintViolation<Object>> parametersViolations = methodValidator.validateAllParameters(pjp.getTarget(), signature.getMethod(), pjp.getArgs());
            if (!parametersViolations.isEmpty()) {
                throw new org.hibernate.validator.method.MethodConstraintViolationException(parametersViolations);
            }
            result = pjp.proceed(); //Execute the method

            Set< org.hibernate.validator.method.MethodConstraintViolation<Object>> returnValueViolations = methodValidator.validateReturnValue(pjp.getTarget(), signature.getMethod(), result);
            if (!returnValueViolations.isEmpty()) {
                throw new org.hibernate.validator.method.MethodConstraintViolationException(returnValueViolations);
            }
        }catch (Throwable throwable){
            log.error("接口数据验证不通过：",throwable);
            Message message=(Message)signature.getReturnType().newInstance();
            message.setRepCode("999999");
            message.setRepMsg("处理失败了");
            result=exceptionHandle(throwable,message);
        }

        return result;
    }

    @SuppressWarnings("deprecation")
    private Message exceptionHandle(Throwable throwable,Message message){
        if(throwable instanceof ValidationException){
            if(throwable instanceof  org.hibernate.validator.method.MethodConstraintViolationException){
                for (ConstraintViolation constraintViolation : ((org.hibernate.validator.method.MethodConstraintViolationException)throwable).getConstraintViolations()) {
                    String path=constraintViolation.getPropertyPath().toString();
                    int index=  path.indexOf('.');
                    if(index>0){
                        index=index+1;
                    }else{
                        index=0;
                    }
                    message.setRepCode("112211");
                    message.setRepMsg(path.substring(index).concat(" ").concat(constraintViolation.getMessage()));
                    break;
                }
            }
        }
        return message;
    }

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }
}