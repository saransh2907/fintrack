package com.trackfin.fintrack.user.model;

// DTO for profile response
public record UserProfileResponse(Long id, String name, String email, Boolean isActive) {

}
