package com.example.hospitalmanagementsystem.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> context) {
                LocalDate parse =
                        LocalDate.parse(context.getSource(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                return parse;
            }
        });

        return modelMapper;
    }
}
