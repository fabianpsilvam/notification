package com.zebrands.notification.factories;

import com.zebrands.notification.constants.Constants;
import com.zebrands.notification.constants.Managers;
import com.zebrands.notification.manager.base.BaseEventManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NotificationFactory {

    @Autowired
    private ApplicationContext applicationContext;

    private final Map<String, String> notificationEvents = new HashMap<>() {{
        put(Constants.TRACKING, Managers.TRACKING_MANAGER);
        put(Constants.EMAIL, Managers.NOTIFICATION_MANAGER);
    }};

    private String getBeanManager(String eventType) {
        return notificationEvents.get(eventType);
    }

    public BaseEventManager getByTypeAndNameBean(String eventType) {
        var beanName = getBeanManager(eventType);
        return (BaseEventManager) applicationContext.getBean(beanName);
    }

}
