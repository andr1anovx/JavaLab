package com.example.jakarta.services;

import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

import java.text.MessageFormat;
import java.util.logging.Logger;

@Singleton
@Startup
public class LogTimer {

    private static Integer number = 1;
    private static final Logger LOGGER = Logger.getLogger(LogTimer.class.getName());

    @Schedule(hour = "*", minute = "*", second = "*/5", persistent = false)
    public void logMessage() {
        LOGGER.info(MessageFormat.format("Повідомлення {0} виведено у логи", number));
        LogTimer.number++;
    }
}