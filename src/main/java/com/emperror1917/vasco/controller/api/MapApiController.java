package com.emperror1917.vasco.controller.api;

import com.emperror1917.vasco.config.CustomUserDetails;
import com.emperror1917.vasco.dto.UserMarkedCountryDto;
import com.emperror1917.vasco.service.UserMarkedCountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MapApiController {

    private final UserMarkedCountryService service;

    @GetMapping("/marked-countries")
    public ResponseEntity<List<UserMarkedCountryDto>> getMarkedCountries(
            @AuthenticationPrincipal CustomUserDetails userDetails) {
        List<UserMarkedCountryDto> markedCountries = service.getMarkedCountries(userDetails.getId());
        return ResponseEntity.ok(markedCountries);
    }

    @PostMapping("/mark-country")
    public ResponseEntity<Void> markCountry(@RequestBody UserMarkedCountryDto request,
                                            @AuthenticationPrincipal CustomUserDetails userDetails) {
        service.markCountry(userDetails.getId(), request.getCountryIsoCode(), request.isMarked());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/unmark-country/{countryIsoCode}")
    public ResponseEntity<Void> unmarkCountry(@PathVariable String countryIsoCode,
                                              @AuthenticationPrincipal CustomUserDetails userDetails) {
        service.unmarkCountry(userDetails.getId(), countryIsoCode);
        return ResponseEntity.ok().build();
    }
}
