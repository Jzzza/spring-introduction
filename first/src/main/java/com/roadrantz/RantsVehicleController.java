package com.roadrantz;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

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
}
