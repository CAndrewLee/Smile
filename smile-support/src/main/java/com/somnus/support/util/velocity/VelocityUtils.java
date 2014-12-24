package com.somnus.support.util.velocity;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * VelocityUtils
 *
 * @author levis
 * @version 1.0 14-6-11
 */
public class VelocityUtils {

    private static final String DEFAULT_ENCODING="UTF-8";

    /**
     * 根据模板生成文件到指定路径
     *
     * @param velocityEngine
     * @param template
     * @param param
     * @param outPath
     */
    public static void mergeTemplate(VelocityEngine velocityEngine,String template,Map<String,Object> param, String outPath){
        try{
			mergeTemplate(velocityEngine, template, param, new FileOutputStream(outPath), DEFAULT_ENCODING);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    /**
     * 根据模板生成文件到指定流
     *
     * @param velocityEngine
     * @param template
     * @param param
     */
	public static void mergeTemplate(VelocityEngine velocityEngine, String template, Map<String, Object> param, OutputStream outputStream, String encoding) {
        try{
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, encoding));
            VelocityContext velocityContext = new VelocityContext(param);
			velocityEngine.mergeTemplate(template, DEFAULT_ENCODING, velocityContext, bufferedWriter);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    /**
     * 根据模板生成文件到指定路径
     *
     * @param velocityEngine
     * @param template
     * @param obj
     * @param outPath
     */
    public static void mergeTemplate(VelocityEngine velocityEngine,String template,Object obj, String outPath){
        mergeTemplate(velocityEngine,template,bean2Map(obj),outPath);
    }

    /**
     * 根据模板生成文件到指定路径
     *
     * @param velocityEngine
     * @param template
     * @param obj
     * @param outputStream
     */
	public static void mergeTemplate(VelocityEngine velocityEngine,String template,Object obj, OutputStream outputStream,String encoding){
		mergeTemplate(velocityEngine, template, bean2Map(obj), outputStream, encoding);
    }

    /**
     * javaban 转化为map
     *
     * @param bean
     * @return
     */
    public static Map bean2Map(Object bean){
        Map returnMap = new HashMap();
        try{
            Class type = bean.getClass();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
            for (int i = 0; i< propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, "");
                    }
                }
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return returnMap;
    }
}