package com.templates.springapiserver.filter;

import com.google.gson.Gson;
import com.templates.springapiserver.constant.BaseStatus;
import com.templates.springapiserver.dto.ErrorResponseBody;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
public class BaseFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        List<String> requiredHeaders = List.of(HttpHeaders.CONTENT_TYPE);
        boolean valid =
                requiredHeaders.stream()
                        .allMatch(
                                x -> {
                                    for (Enumeration<?> e = request.getHeaderNames();
                                            e.hasMoreElements(); ) {
                                        String nextHeaderName = (String) e.nextElement();
                                        if (x.equalsIgnoreCase(nextHeaderName)) {
                                            return true;
                                        }
                                    }
                                    return false;
                                });
        if (!valid) {
            setErrorResponse(BaseStatus.INVALID_REQUEST_HEADER, response);
            return;
        }
        filterChain.doFilter(request, response);
    }

    private void setErrorResponse(BaseStatus baseStatus, HttpServletResponse response) {
        response.setStatus(baseStatus.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ErrorResponseBody errorResponseBody =
                ErrorResponseBody.builder()
                        .error(baseStatus.getCode())
                        .message(baseStatus.getMessage())
                        .build();
        try {
            Gson gson = new Gson();
            String json = gson.toJson(errorResponseBody);
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
