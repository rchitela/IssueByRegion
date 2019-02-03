package com.region.us.issues.exceptions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorHandler implements ErrorController {
	
//	private ErrorAttributes errorAttributes;
    private final static String ERROR_PATH = "/error";
    
//    public CustomErrorHandler(ErrorAttributes errorAttributes) {
//        this.errorAttributes = errorAttributes;
//    }
    
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request) {
        return new ModelAndView("/errors/error", getErrorAttributes(request, false));
    }
    
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

//    private boolean getTraceParameter(HttpServletRequest request) {
//        String parameter = request.getParameter("trace");
//        if (parameter == null) {
//            return false;
//        }
//        return !"false".equals(parameter.toLowerCase());
//    }
    
    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
            boolean includeStackTrace) {
    	
        Map<String, Object> errorAttributes = this.getErrorAttributes(request, includeStackTrace);
        errorAttributes.put("locale", request.getLocale().toString());
        errorAttributes.remove("error");
   		return errorAttributes;
    }
    
//    private HttpStatus getStatus(HttpServletRequest request) {
//        Integer statusCode = (Integer) request
//                .getAttribute("javax.servlet.error.status_code");
//        if (statusCode != null) {
//            try {
//                return HttpStatus.valueOf(statusCode);
//            }
//            catch (Exception ex) {
//            }
//        }
//        return HttpStatus.INTERNAL_SERVER_ERROR;
//    }
    
}
