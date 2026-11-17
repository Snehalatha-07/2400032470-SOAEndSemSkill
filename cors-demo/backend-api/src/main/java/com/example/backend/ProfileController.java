package com.example.backend;

import java.util.concurrent.atomic.AtomicReference;
import org.springframework.web.bind.annotation.*;

/** Step 1: REST API with the /profile endpoint. */
@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final AtomicReference<Profile> profile =
            new AtomicReference<>(new Profile("Ravi Kumar", "ravi@example.com", "Student"));

    @GetMapping
    public Profile getProfile() {
        System.out.println(">> GET /profile reached the server");
        return profile.get();
    }

    @PutMapping
    public Profile updateProfile(@RequestBody Profile updated) {
        System.out.println(">> PUT /profile reached the server");
        profile.set(updated);
        return updated;
    }

    // Intentionally NOT allowed by CORS config -> use it to show a blocked method.
    @DeleteMapping
    public String deleteProfile() {
        return "deleted";
    }
}
