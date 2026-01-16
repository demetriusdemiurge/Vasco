package com.demetriusdemiurge.vasco.controller.api;

import com.demetriusdemiurge.vasco.config.CustomUserDetails;
import com.demetriusdemiurge.vasco.dto.MarkedCountryDto;
import com.demetriusdemiurge.vasco.service.map.UserMarkedCountryService;
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
    public ResponseEntity<List<MarkedCountryDto>> getMarkedCountries(
            @AuthenticationPrincipal CustomUserDetails userDetails) {
        List<MarkedCountryDto> markedCountries = service.getMarkedCountries(userDetails.getId());
        return ResponseEntity.ok(markedCountries);
    }

    @PostMapping("/mark-country")
    public ResponseEntity<Void> markCountry(@RequestBody MarkedCountryDto request,
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