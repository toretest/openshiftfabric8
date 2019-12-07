package org.toregard.openshiftfabric8.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class PingRestController {
    private static final UUID id = UUID.randomUUID();

    @RequestMapping(value = "/ping", produces = "application/json")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("ok4");
    }

    @RequestMapping(value = "/ping2", produces = "application/json")
    public ResponseEntity<String> ping2() {
        return ResponseEntity.ok("hello2");
    }

    @RequestMapping(value = "/ping3", produces = "application/json")
    public ResponseEntity<String> ping3() {
        return ResponseEntity.ok("hello3");
    }
}
