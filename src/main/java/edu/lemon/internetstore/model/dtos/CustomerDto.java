package edu.lemon.internetstore.model.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.Instant;

@Builder
public record CustomerDto(
    String id,
    @Size(min=2, max=30, message = "First name must be from 2 to 30 chars")
    String firstName,
    @Size(min=2, max=30, message = "First name must be from 2 to 30 chars")
    String lastName,

    @Pattern(regexp = " ^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",
            message = "Phone format is incorrect")
    String phone,

    @Size(min=2, max=30, message = "Login must be from 2 to 30 chars")
    String login,

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Wrong Email format")
    String email,


    @Pattern(regexp = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}+$",
            message = """
                    Password must has:
                    - two uppercase letters
                    - one special case letter
                    - two digits
                    - three lowercase letters - at least 8 symbols\s
                    """)
    String password,

    Instant birthDate){}


