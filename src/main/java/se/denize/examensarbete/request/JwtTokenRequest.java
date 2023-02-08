package se.denize.examensarbete.request;

import lombok.AllArgsConstructor;
import lombok.Getter;



public record JwtTokenRequest(String username, String password) {}
