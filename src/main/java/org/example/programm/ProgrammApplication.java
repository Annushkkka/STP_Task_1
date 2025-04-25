package org.example.programm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* Класс, отвечающий за запуск нашего веб-приложения
* */
@SpringBootApplication
public class ProgrammApplication {

	/**
	 * Главный метод запуска веб-приложения
	 * @param args аргументы для запуска
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProgrammApplication.class, args);
	}

}
