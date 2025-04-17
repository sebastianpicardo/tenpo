package com.tenpo.spicardo.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    private static final int MAX_REQUESTS_PER_MINUTE = 3;
    private static final long TIME_FRAME = 60000; // 1 minuto
    private static final ConcurrentHashMap<String, List<Long>> requestTimestamps = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientIP = request.getRemoteAddr();
        long currentTime = System.currentTimeMillis();

        requestTimestamps.computeIfAbsent(clientIP, k -> new java.util.ArrayList<>());

        List<Long> timestamps = requestTimestamps.get(clientIP);
        timestamps = timestamps.stream()
                .filter(timestamp -> currentTime - timestamp < TIME_FRAME)
                .collect(Collectors.toList());

        if (timestamps.size() >= MAX_REQUESTS_PER_MINUTE) {
            response.setStatus(429);
            response.getWriter().write("Too Many Requests. Try again later.");
            return false;
        }

        timestamps.add(currentTime);
        requestTimestamps.put(clientIP, timestamps);

        return true;
    }
}
