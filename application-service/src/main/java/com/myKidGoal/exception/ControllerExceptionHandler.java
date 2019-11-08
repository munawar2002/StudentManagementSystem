package com.myKidGoal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Logger;

/**
 * Created by Munawar on 19/03/2019. This class is created to send UI Internal_Server_Error to UI when any exception
 * occurred in backend
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger logger = Logger.getLogger(ControllerExceptionHandler.class.getName());

    /**
     * The method will catch exception that is thrown in any controller.
     * 
     * @param e
     *            Exception it self
     * @return Response to UI timestamp": Current timestamp, e.g, "2019-01-03T10:49:54.130+0000", status": 500, error":
     *         "Internal Server Error", exception": The real exception, e.g,
     *         "com.primatics.analytics.baserate.exception.BalanceNotFoundException", message": The message thrown at
     *         runtime, e.g, "Balance Not Found", path": URL that caused the exception, e.g,
     *         "/evolv/analytics/baserate/scenarios/output/1"
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Integer handleRuntimeException(RuntimeException e) {
        logger.severe("Exception occurred while performing task." + e);
        e.printStackTrace();
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

}
