package org.selenium.pom.objects;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BillingAddress {
    private String firstName;
    private String lastName;
    private String country;
    private String addressLineOne;
    private String city;
    private String state;
    private String postalCode;
    private String email;
}
