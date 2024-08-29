package io.github.orionlibs.orion_web.service.heartbeat;

import io.github.orionlibs.orion_web.service.OrionWebService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeartbeatAPIService extends OrionWebService
{
    @GetMapping(value = "/heartbeat")
    public ResponseEntity<?> isServerAlive(HttpServletRequest request, HttpServletResponse response, Model model, CsrfToken token)
    {
        return Heartbeat.isServerAlive();
    }
}