package io.github.orionlibs.orion_web.service.heartbeat;

import org.springframework.http.ResponseEntity;

class Heartbeat
{
    static ResponseEntity<?> isServerAlive()
    {
        return ResponseEntity.ok().build();
    }
}