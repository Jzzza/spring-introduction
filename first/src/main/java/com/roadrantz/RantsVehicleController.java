package com.roadrantz;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin2.main.client.WMozillaServiceDelegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.BindException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RantsVehicleController {
    private static final String BASE_BIEW_NAME = "vehicleRants";

    private String getViewName(HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        String extension = "." + requestUri.substring(requestUri.lastIndexOf("."));
        if ("htm".equals(extension)) {
            extension="";
        }
        return BASE_BIEW_NAME + extension;
    }

    protected ModelAndView handle(HttpServletRequest request,
                                  HttpServletResponse response,
                                  Object command,
                                  BindException errors) throws Exception{
        Map<String, Object> model=new HashMap<String, Object>();
        return new ModelAndView(getViewName(request), model);

    }
}
