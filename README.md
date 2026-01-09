Spring MVC Car Application
Описание проекта
Выполнено практическое задание по созданию Spring MVC приложения с контроллером для отображения списка автомобилей с поддержкой параметра запроса count.

Выполненные требования ТЗ
✅ 1. Создан контроллер /cars
Класс: CarController в пакете web.controller

Маппинг: @GetMapping("/cars")

Параметр: @RequestParam(value = "count", required = false, defaultValue = "5")

Логика: Возвращает указанное количество автомобилей из списка

✅ 2. Создана модель Car
Класс: Car в пакете web.model

Поля:

id (Long) - идентификатор

model (String) - модель автомобиля

series (int) - серия/номер

Методы: Конструктор, геттеры, сеттеры

✅ 3. Создан список из 5 машин
Реализация: В классе CarService, конструктор

Список автомобилей:

Toyota Camry (серия 50)

BMW X5 (серия 30)

Audi A6 (серия 40)

Mercedes-Benz C-Class (серия 60)

Ford Focus (серия 20)

✅ 4. Создан сервис CarService
Класс: CarService в пакете web.service

Аннотация: @Service

Метод: getCars(int count)

Логика метода:

Если count >= 5 или count <= 0 → возвращает все 5 машин

Иначе → возвращает первые count машин через subList()

✅ 5. Создана страница cars.html с Thymeleaf
Расположение: src/main/webapp/WEB-INF/pages/cars.html

Технология: Thymeleaf 3.0.15

Особенности:

Таблица с заголовками: ID, Модель автомобиля, Серия

Цикл th:each="car : ${cars}" для отображения списка

Ссылки для тестирования разных значений count

✅ 6. Реализована работа с параметром count
Тестовые URL:

http://localhost:8080/cars → 5 машин (по умолчанию)

http://localhost:8080/cars?count=1 → 1 машина

http://localhost:8080/cars?count=2 → 2 машины

http://localhost:8080/cars?count=3 → 3 машины

http://localhost:8080/cars?count=4 → 4 машины

http://localhost:8080/cars?count=5 → 5 машин

http://localhost:8080/cars?count=10 → 5 машин (все, так как count ≥ 5)

Технологический стек
Java 17

Spring MVC 5.3.30

Thymeleaf 3.0.15

Tomcat 7 (через Maven Plugin)

Maven 3.6+

Servlet API 4.0.1

Структура проекта
text
src/main/java/web/
├── config/
│   ├── AppInit.java          ← Инициализатор приложения
│   └── WebConfig.java        ← Конфигурация Spring MVC и Thymeleaf
├── controller/
│   ├── HelloController.java  ← Контроллер главной страницы (из заготовки)
│   └── CarController.java    ← Контроллер для /cars (добавлен)
├── model/
│   └── Car.java              ← Модель автомобиля (добавлен)
└── service/
    └── CarService.java       ← Сервис для работы с автомобилями (добавлен)

src/main/webapp/
└── WEB-INF/
    └── pages/
        ├── index.html        ← Главная страница (из заготовки)
        └── cars.html         ← Страница со списком автомобилей (добавлен)
Инструкция по запуску
Способ 1: Через Maven Tomcat Plugin (рекомендуемый)
Клонируйте репозиторий:

bash
git clone <ваш-репозиторий>
cd spring-mvc-cars
Запустите приложение:

bash
mvn tomcat7:run
или через IntelliJ IDEA:

Откройте панель Maven (справа)

Разверните Plugins → tomcat7

Дважды кликните на tomcat7:run

Откройте в браузере:

Главная страница: http://localhost:8080/

Список автомобилей: http://localhost:8080/cars

Способ 2: Через IntelliJ IDEA с Tomcat
Настройте Tomcat:

Run → Edit Configurations

+ → Tomcat Server → Local

На вкладке Deployment добавьте spring:war exploded

Запустите приложение через зеленую стрелку

Архитектурные решения
1. Конфигурация без web.xml
Использован AppInit для инициализации DispatcherServlet

Конфигурация Java-based через WebConfig.java

2. Настройка Thymeleaf
java
@Bean
public SpringResourceTemplateResolver templateResolver() {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setPrefix("/WEB-INF/pages/");
    templateResolver.setSuffix(".html");
    templateResolver.setCharacterEncoding("UTF-8");
    return templateResolver;
}
3. Внедрение зависимостей
Конструкторный @Autowired для CarController

@Service для CarService

4. Обработка параметра запроса
java
@GetMapping("/cars")
public String getCars(@RequestParam(value = "count", required = false, defaultValue = "5") int count,
                      Model model) {
    model.addAttribute("cars", carService.getCars(count));
    return "cars";
}
Особенности реализации
Бизнес-логика в сервисе
Метод getCars() в CarService содержит основную логику:

Проверка граничных значений параметра count

Возврат либо всего списка, либо его части

Тестируемость
Контроллер принимает Model для передачи данных в представление

Сервис может быть легко протестирован независимо

Обработка ошибок
Параметр count сделан необязательным

Значение по умолчанию = 5 (все автомобили)

Проверка на некорректные значения (≤ 0) с возвратом всего списка

Возможные улучшения
Валидация параметров: Добавить @Min и @Max аннотации

База данных: Заменить статический список на JPA/Hibernate

Пагинация: Реализовать полноценную пагинацию вместо count

Стилизация: Улучшить CSS/использовать Bootstrap

Тесты: Добавить unit-тесты для контроллера и сервиса

Проблемы и их решения
Проблема 1: Кодировка русских букв
Решение: Добавлена настройка UTF-8 в WebConfig.java:

java
templateResolver.setCharacterEncoding("UTF-8");
Проблема 2: Зависимость от Tomcat в IDEA Community
Решение: Использован Maven Tomcat Plugin для запуска без установки Tomcat в IDE.

Проблема 3: Несовместимость Spring 6 с javax.servlet
Решение: Использован Spring 5.3.30 для совместимости.

Проверка выполнения ТЗ
Для проверки ментору достаточно:

Запустить приложение: mvn tomcat7:run

Проверить URL:

http://localhost:8080/cars - 5 машин

http://localhost:8080/cars?count=2 - 2 машины

http://localhost:8080/cars?count=10 - 5 машин (все)

Убедиться, что логика работы с параметром count соответствует ТЗ

Автор: Антон Строков
Дата выполнения: 09.01.2026
Версия: 1.0
