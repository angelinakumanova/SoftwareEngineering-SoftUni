package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Configuration
public class ApplicationBeanConfiguration {


    @Bean
    public Gson gson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        Converter<String, LocalDateTime> converter = mappingContext -> {
            //2022-02-02 12:43:00
            return LocalDateTime.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        };
        modelMapper.typeMap(String.class, LocalDateTime.class).setConverter(converter);

        return modelMapper;
    }

}
