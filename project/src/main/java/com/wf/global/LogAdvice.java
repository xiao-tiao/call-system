package com.wf.global;

import com.wf.entity.Log;
import com.wf.entity.system.Staff;
import com.wf.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LogAdvice {
    @Autowired
    private LogService logService;
    @AfterReturning("execution(* com.wf.controller.*.*(..)) && !execution(* com.wf.controller.SelfController.*(..)) && !execution(* com.wf.controller.*.to*(..))")
    public void operationLog(JoinPoint joinPoint)
    {
        Log log=new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request=(HttpServletRequest)joinPoint.getArgs()[0];
        HttpSession session=request.getSession();
        Staff staff=(Staff)session.getAttribute("staff");
        log.setOperator(staff.getName());
        log.setResult("成功");
        logService.addOperationLog(log);

    }
    @AfterThrowing(throwing ="e",pointcut ="execution(* com.wf.controller.*.*(..)) && !execution(* com.wf.controller.SelfController.*(..))")
    public void systemLog(JoinPoint joinPoint,Throwable e){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("staff");
        Staff staff =(Staff)obj;
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());
        logService.addSystemLog(log);
    }
    @After("execution(* com.wf.controller.SelfController.login(..))")
    public void loginLog(JoinPoint joinPoint){
        log(joinPoint);
    }
    @Before("execution(* com.wf.controller.SelfController.logout(..))")
    public void logoutLog(JoinPoint joinPoint){
        log(joinPoint);
    }
    private void log(JoinPoint joinPoint){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("staff");
        if(obj==null){
            log.setOperator(request.getParameter("account"));
            log.setResult("失败");
        }else {
            Staff staff = (Staff) obj;
            log.setOperator(staff.getAccount());
            log.setResult("成功");
        }
        logService.addLoginLog(log);
    }
}
