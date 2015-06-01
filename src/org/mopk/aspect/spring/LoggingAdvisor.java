package org.mopk.aspect.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

//import static com.google.common.base.Throwables.propagate;


/**
 * Created by: Aleksandr.Ites (alit0714)
 * Date: 2015-05-27
 * Time: 18:28
 */
public class LoggingAdvisor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println(
                "Intercepting of '"
                        +
                    methodInvocation.getMethod().getName()
                            +
                        "' method has been started."
        );

        final Method method = methodInvocation.getMethod();

        //    This option can be changed in future by an introduction of
        // annotation.
        final boolean logEnabled = true;

        logInput(
                logEnabled,
                method,
                "input",
                methodInvocation.getArguments()
        );

        final Object resultOfInvocation;
        try {
            resultOfInvocation = methodInvocation.proceed();
        } catch (InvocationTargetException e) {
            final Throwable targetException = e.getTargetException();

//            throw propagate(targetException);
            throw targetException;
        }

        logOutput(
                logEnabled,
                method,
                resultOfInvocation
        );

        return resultOfInvocation;
    }


    private void logInput(
            final boolean logEnabled,
            final Method method,
            final String inputParameter,
            final Object[] inputParameterValue
    ) {
        if (logEnabled) {

            // Such approach implies '%c' of Log4j/SLF4j  shows result
            // of 'method.getDeclaringClass()'-expression while '%M'
            // shows "logInput".
            final Logger classLogger =
                    LoggerFactory.getLogger(method.getDeclaringClass());

            if ( classLogger.isDebugEnabled() ) {

                classLogger.debug(
                        LogMessages.ENTER.get(),
                        method.getName(),

                        // This can be customized via selective
                        // 'toString()'-strategies.
                        Arrays.toString(inputParameterValue)
                );
            }
        }
    }


    private void logOutput(
            final boolean logEnabled,
            final Method method,
            final Object resultOfInvocation
    ) {
        if (logEnabled) {

            // Such approach implies '%c' of Log4j/SLF4j  shows result
            // of 'method.getDeclaringClass()'-expression while '%M'
            // shows "logOutput".
            final Logger classLogger =
                    LoggerFactory.getLogger( method.getDeclaringClass() );

            if ( classLogger.isDebugEnabled() ) {

                classLogger.debug(
                        LogMessages.LEAVE.get(),
                        method.getName(),

                        // This can be customized via selective
                        // 'toString()'-strategies.
                        resultOfInvocation
                );
            }
        }
    }

}