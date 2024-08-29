package io.github.orionlibs.orion_web.app.exception;

import io.github.orionlibs.orion_web.session.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrionGlobalExceptionService
{
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiCallError<String>> handleAccessDeniedException(HttpServletRequest request, AccessDeniedException exception)
    {
        String userID = SessionService.getUserID(request);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiCallError<>("Access denied!", List.of("")));
    }


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiCallError<String>> handleInternalServerError(HttpServletRequest request, Throwable exception)
    {
        String userID = SessionService.getUserID(request);
        return ResponseEntity.badRequest().build();
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApiCallError<T>
    {
        private String message;
        private List<T> details;
    }
}