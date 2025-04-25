package org.example.programm;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Класс, необходимый для добавления (регистрации) нескольких контроллеров
 * */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    /**
     * @param registry класс, отвечающий за интеграцию наших контроллеров
     * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {}

}
