package cn.wonderxiao.util;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Created by xiaokai on 2018/10/12.
 */
@Data
public class LogUtil implements Logger {
    private final Logger logger;

    public static LogUtil getLogger(Class<?> clazz){
        Logger logger = LoggerFactory.getLogger(clazz);
        return new LogUtil(logger);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public void debug(String format, Object... args) {
        if (logger.isDebugEnabled()){
            String message = String.format(format,args);
            logger.debug(message);
        }
    }

    @Override
    public void debug(Marker t, String format, Object... args) {
        if (logger.isDebugEnabled()){
            String message = String.format(format,args);
            logger.debug(message,t);
        }
    }

    @Override
    public void debug(String s, Throwable throwable) {

    }

    @Override
    public void info(String format, Object... args) {
        if (logger.isInfoEnabled()) {
            String message = String.format(format, args);
            logger.info(message);
        }
    }

    @Override
    public void info(Marker t, String format, Object... args) {
        if (logger.isInfoEnabled()) {
            String message = String.format(format, args);

            logger.info(message, t);
        }
    }

    @Override
    public void warn(String format, Object... args) {
        if (logger.isWarnEnabled()) {
            String message = String.format(format, args);

            logger.warn(message);
        }
    }

    @Override
    public void warn(Marker t, String format, Object... args) {
        if (logger.isWarnEnabled()) {
            String message = String.format(format, args);

            logger.warn(message, t);
        }
    }

    @Override
    public void error(String format, Object... args) {
        if (logger.isErrorEnabled()) {
            String message = String.format(format, args);

            logger.error(message);
        }
    }

    @Override
    public void error(Marker t, String format, Object... args) {
        if (logger.isErrorEnabled()) {
            String message = String.format(format, args);
            logger.error(message, t);
        }
    }

    @Override
    public String getName() {
        return logger.getName();
    }

    @Override
    public void trace(String s, Object... o) {
        String message = String.format(s,o);
        logger.trace(message);
    }

    @Override
    public void trace(String s, Throwable throwable) {
        if(logger.isTraceEnabled()){
            logger.trace(s,throwable);
        }
    }

    @Override
    public void trace(String s) {

    }

    @Override
    public void trace(String s, Object o) {

    }

    @Override
    public void trace(String s, Object o, Object o1) {

    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return false;
    }

    @Override
    public void trace(Marker marker, String s) {

    }

    @Override
    public void trace(Marker marker, String s, Object o) {

    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {

    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {

    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {

    }

    @Override
    public void debug(String s) {

    }

    @Override
    public void debug(String s, Object o) {

    }

    @Override
    public void debug(String s, Object o, Object o1) {

    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return false;
    }

    @Override
    public void debug(Marker marker, String s) {

    }

    @Override
    public void debug(Marker marker, String s, Object o) {

    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {

    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {

    }

    @Override
    public void info(String s) {

    }

    @Override
    public void info(String s, Object o) {

    }

    @Override
    public void info(String s, Object o, Object o1) {

    }

    @Override
    public void info(String s, Throwable throwable) {

    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    @Override
    public void info(Marker marker, String s) {

    }

    @Override
    public void info(Marker marker, String s, Object o) {

    }

    @Override
    public void info(Marker marker, String s, Object o, Object o1) {

    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {

    }

    @Override
    public void warn(String s) {

    }

    @Override
    public void warn(String s, Object o) {

    }

    @Override
    public void warn(String s, Object o, Object o1) {

    }

    @Override
    public void warn(String s, Throwable throwable) {

    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return false;
    }

    @Override
    public void warn(Marker marker, String s) {

    }

    @Override
    public void warn(Marker marker, String s, Object o) {

    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {

    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {

    }

    @Override
    public void error(String s) {

    }

    @Override
    public void error(String s, Object o) {

    }

    @Override
    public void error(String s, Object o, Object o1) {

    }

    @Override
    public void error(String s, Throwable throwable) {

    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return false;
    }

    @Override
    public void error(Marker marker, String s) {

    }

    @Override
    public void error(Marker marker, String s, Object o) {

    }

    @Override
    public void error(Marker marker, String s, Object o, Object o1) {

    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {

    }
}


