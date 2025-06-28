package com.emperror1917.vasco.controller;

import com.emperror1917.vasco.config.CustomUserDetails;
import com.emperror1917.vasco.dto.MarkRequest;
import com.emperror1917.vasco.dto.MarkedCountryResponse;
import com.emperror1917.vasco.service.UserMarkedCountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MarkCountryController {

    private final UserMarkedCountryService service;

    @GetMapping("/marked-countries")
    public ResponseEntity<List<MarkedCountryResponse>> getMarkedCountries(
            @AuthenticationPrincipal CustomUserDetails userDetails) {
        List<MarkedCountryResponse> markedCountries = service.getMarkedCountries(userDetails.getId());
        return ResponseEntity.ok(markedCountries);
    }

    @PostMapping("/mark-country")
    public ResponseEntity<Void> markCountry(@RequestBody MarkRequest request,
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
