# Базовое задание:
Добавить в простое CRUD веб-приложение, которое было разработано на семинаре функцию удаления данных о пользователе:
1) В класс UserRepository добавить метод public void deleteById(int id)(подсказка: SQL запрос "DELETE FROM userTable WHERE id=?", метод jdbc.update) - удаления записи пользователя из БД по ID.
2) В класс UserService добавить метод public void deleteById(int id)(подсказка: в нем вызывается метод userRepository.deleteById) - удаление пользователя через репозиторий.
3) В класс UserController добавить метод public String deleteUser(@PathVariable("id") int id)(с аннотацией: @GetMapping("user-delete/{id}")) (подсказка: в нем вызывается метод userService.deleteById) - перехват команды на удаление студента от браузера.

Если задание выполнено верно, то при запуске приложения по адресу http://localhost:8080/users будет работать кнопка удаления пользователя по ID.

# Задание "со звездочкой":
Реализовать метод обновления данных о пользователе.
- @GetMapping("/user-update/{id}")
- @PostMapping("/user-update")
- User update(User user)
- User getOne(int id)

# Дополнение к работе от 9 апреля 2024 г

Проект домашнего задания для 2 семинара (CRUD приложение USER SERVICE) переписать:
1. Использовать библиотеку Lombok:
   a) @Data - для полей классов
   b) @AllArgsConstructor - для классов с конструкторами
   c) @Log - логировать работу всех контроллеров
2. Использовать configuration-processor для работы с настройками приложения:
   a) Создать объект инкапсулирующий шаблоны запросов к базе данных H2
   b) Использовать аннотации @ConfigurationProperties и @ConfigurationPropertiesScan для заполнения полей этого класса
   с) Вынести все SQL шаблоны в настройки приложения.
