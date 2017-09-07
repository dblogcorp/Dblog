package io.dblog.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * {@code AnnotationUtils}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class AnnotationUtils {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationUtils.class);

    /**
     * 为实体类增加注解
     * @param clazz 实体类的 class
     * @param annotationClazz 注解类的 class
     * @param annotation 需要增加的注解
     */
    public static void addAnnotation(Class clazz, Class annotationClazz, Annotation annotation) {
        clazz.getAnnotations();

        try {
            Field field = Class.class.getDeclaredField("annotationData");
            field.setAccessible(true);
            Object object = field.get(clazz);
            field = object.getClass().getDeclaredField("annotations");
            field.setAccessible(true);

            Map<Class<? extends Annotation>, Annotation> annotations = (Map<Class<? extends Annotation>, Annotation>) field.get(object);
            annotations.put(annotationClazz, annotation);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            logger.error("AnnotationUtils: add annotation failed!");
        }
    }
}
