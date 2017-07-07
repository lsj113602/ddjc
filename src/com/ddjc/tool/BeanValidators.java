package com.ddjc.tool;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class BeanValidators
{
    /**
     * ����JSR303��validate����, ��֤ʧ��ʱ�׳�ConstraintViolationException.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void validateWithException(Validator validator, Object object, Class<?> ... groups) throws ConstraintViolationException
    {
        Set constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
    
    /**
     * ��������, ת��ConstraintViolationException�е�Set<ConstraintViolations>��ΪList<message>.
     */
    public static List<String> extractMessage(ConstraintViolationException e)
    {
        return extractMessage(e.getConstraintViolations());
    }
    
    /**
     * ��������, ת��Set<ConstraintViolation>ΪList<message>
     */
    @SuppressWarnings("rawtypes")
    public static List<String> extractMessage(Set<? extends ConstraintViolation> constraintViolations)
    {
        List<String> errorMessages = Lists.newArrayList();
        for (ConstraintViolation violation : constraintViolations)
        {
            errorMessages.add(violation.getMessage());
        }
        return errorMessages;
    }
    
    /**
     * ��������, ת��ConstraintViolationException�е�Set<ConstraintViolations>ΪMap<property, message>.
     */
    public static Map<String, String> extractPropertyAndMessage(ConstraintViolationException e)
    {
        return extractPropertyAndMessage(e.getConstraintViolations());
    }
    
    /**
     * ��������, ת��Set<ConstraintViolation>ΪMap<property, message>.
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, String> extractPropertyAndMessage(Set<? extends ConstraintViolation> constraintViolations)
    {
        Map<String, String> errorMessages = Maps.newHashMap();
        for (ConstraintViolation violation : constraintViolations)
        {
            errorMessages.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return errorMessages;
    }
    
    /**
     * ��������, ת��ConstraintViolationException�е�Set<ConstraintViolations>ΪList<propertyPath message>.
     */
    public static List<String> extractPropertyAndMessageAsList(ConstraintViolationException e)
    {
        return extractPropertyAndMessageAsList(e.getConstraintViolations(), " ");
    }
    
    /**
     * ��������, ת��Set<ConstraintViolations>ΪList<propertyPath message>.
     */
    @SuppressWarnings("rawtypes")
    public static List<String> extractPropertyAndMessageAsList(Set<? extends ConstraintViolation> constraintViolations)
    {
        return extractPropertyAndMessageAsList(constraintViolations, " ");
    }
    
    /**
     * ��������, ת��ConstraintViolationException�е�Set<ConstraintViolations>ΪList<propertyPath +separator+ message>.
     */
    public static List<String> extractPropertyAndMessageAsList(ConstraintViolationException e, String separator)
    {
        return extractPropertyAndMessageAsList(e.getConstraintViolations(), separator);
    }
    
    /**
     * ��������, ת��Set<ConstraintViolation>ΪList<propertyPath +separator+ message>.
     */
    @SuppressWarnings("rawtypes")
    public static List<String> extractPropertyAndMessageAsList(Set<? extends ConstraintViolation> constraintViolations, String separator)
    {
        List<String> errorMessages = Lists.newArrayList();
        for (ConstraintViolation violation : constraintViolations)
        {
            errorMessages.add(violation.getPropertyPath() + separator + violation.getMessage());
        }
        return errorMessages;
    }
}