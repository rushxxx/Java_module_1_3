# Java_module_1_3

Необходимо реализовать консольное CRUD приложение, которое имеет следующие сущности:
- Team(id, name, List<Developer> developers)
- Developer(id, firstName, lastName, List<Skill> skills)
- Skill(id, name)
- TeamStatus (enum ACTIVE, DELETED)

В качестве хранилища данных необходимо использовать текстовые файлы:
teams.json, developers.json, skills.json
    
Пользователь в консоли должен иметь возможность создания, получения, редактирования и удаления данных.
Слои:
model - POJO классы
repository - классы, реализующие доступ к текстовым файлам
controller - обработка запросов от пользователя
view - все данные, необходимые для работы с консолью

## Инструкция по запуску
    1. Клонировать репозиторий
    2. Открыть проект в IntellijIDEA
    3. Запустить класс main
