package com.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloReponseDtoTest {

    @Test
    public void lombokTest() {
        // give
        String name = "test";
        int amount = 1000;

        // when
        HelloReponseDto helloReponseDto = new HelloReponseDto(name, amount);

        //then
        assertThat(helloReponseDto.getName()).isEqualTo(name);
        assertThat(helloReponseDto.getAmount()).isEqualTo(amount);
    }
}