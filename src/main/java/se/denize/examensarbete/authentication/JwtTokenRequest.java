package se.denize.examensarbete.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;



public record JwtTokenRequest(String username, String password) {}
