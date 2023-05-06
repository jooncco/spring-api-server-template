package com.templates.springapiserverasync.filter;

import com.google.gson.Gson;
import com.templates.springapiserverasync.constant.BaseStatus;
import com.templates.springapiserverasync.constant.ErrorResponse;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("BaseFilter 가 생성 됩니다.");
    }

    /*
    여기에서 dispatcherServlet 으로 전달하기 전/후 에 대해 request 와 response 제어가 가능하다.
    예) request 의 header 에서 필수 헤더가 없는 경우 요청을 차단할 수 있다.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain) throws IOException, ServletException {
        log.info("==========BaseFilter 시작!==========");
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 필수 헤더
        List<String> requiredHeaders = List.of("Content-Type");
        boolean valid = requiredHeaders.stream().allMatch(x->{
            for (Enumeration<?> e = request.getHeaderNames(); e.hasMoreElements();) {
                String nextHeaderName = (String) e.nextElement();
                if(x.equalsIgnoreCase(nextHeaderName)) {
                    return true;
                }
            }
            return false;
        });
        if (!valid) {
            log.info("==========필수 헤더 검증에 실패하여 요청 차단!==========");
            setErrorResponse(BaseStatus.INVALID_REQUIRED_HEADER, (HttpServletResponse) servletResponse);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("==========BaseFilter 종료!==========");
    }

    @Override
    public void destroy() {
        log.info("BaseFilter 가 사라집니다.");
    }

    private void setErrorResponse(BaseStatus baseStatus, HttpServletResponse response) {
        response.setStatus(baseStatus.getStatus());
        response.setContentType("application/json");
        ErrorResponse errorResponse = ErrorResponse.builder().error(baseStatus.getCode()).msg(
            baseStatus.getMessage()).build();
        try {
            Gson gson = new Gson();
            String json = gson.toJson(errorResponse);
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}