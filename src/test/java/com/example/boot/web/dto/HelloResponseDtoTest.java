package com.example.boot.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class HelloResponseDtoTest {

    @Test
    public void lombok_기능_테스트() {
        String name = "test";
        int amount = 10000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);

    }


}
