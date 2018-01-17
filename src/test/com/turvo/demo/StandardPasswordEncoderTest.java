package com.turvo.demo;

import org.junit.Test;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class StandardPasswordEncoderTest {

    @Test
    public void encodeTest() {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        String test = encoder.encode("charan");
    }
}
