package com.templates.springapiserver.filter;

import com.google.gson.Gson;
import com.templates.springapiserver.constant.BaseStatus;
import com.templates.springapiserver.dto.ErrorResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
public class BaseFilter extends OncePerRequestFilter {

    /*
    여기에서 dispatcherServlet 으로 전달하기 전/후 에 대해 request 와 response 제어가 가능하다.
    예) request 의 header 에서 필수 헤더가 없는 경우 요청을 차단할 수 있다.
     */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info("==========BaseFilter 시작!==========");

        // 필수 헤더
        List<String> requiredHeaders = List.of("Content-Type");
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
            log.info("==========필수 헤더 검증에 실패하여 요청 차단!==========");
            setErrorResponse(BaseStatus.INVALID_REQUIRED_HEADER, response);
            return;
        }

        filterChain.doFilter(request, response);

        log.info("==========BaseFilter 종료!==========");
    }

    private void setErrorResponse(BaseStatus baseStatus, HttpServletResponse response) {
        response.setStatus(baseStatus.getStatus());
        response.setContentType("application/json");
        ErrorResponse errorResponse =
                ErrorResponse.builder()
                        .error(baseStatus.getCode())
                        .msg(baseStatus.getMessage())
                        .build();
        try {
            Gson gson = new Gson();
            String json = gson.toJson(errorResponse);
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
