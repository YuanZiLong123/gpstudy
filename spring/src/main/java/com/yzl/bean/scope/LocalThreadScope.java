package com.yzl.bean.scope;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.NonNull;

import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 线程的生命周期    线程中bean是同一个
 * @author admin
 * @date 2020-08-06 11:18
 */
public class LocalThreadScope implements Scope {

    public static final String SCOPE_NAME = "thread-local";

    private final NamedThreadLocal<Map<String, Object>> threadLocal = new NamedThreadLocal("thread-local-scope") {

        @Override
        public Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    @NonNull
    private Map<String, Object> getContext() {
        return threadLocal.get();
    }

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        Map<String,Object> context = getContext();

        Object object = context.get(s);

        if (null==object){
            object = objectFactory.getObject();
            context.put(s,object);
        }

        return object;
    }

    @Override
    public Object remove(String s) {
        Map<String,Object> context = getContext();

        return context.remove(s);
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        Map<String, Object> context = getContext();
        return context.get(s);
    }

    @Override
    public String getConversationId() {
        return  String.valueOf(Thread.currentThread().getId());
    }
}
