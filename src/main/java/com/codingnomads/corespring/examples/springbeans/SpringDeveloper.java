/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;
    private Country country;

    public SpringDeveloper(Address address, Country country) {
        this.address = address;
        this.country = country;
    }
}
