Задача:
1. Написать сервис принимающий REST запросы: ping-pong
Задача сервиса:
- прием GET запроса по адресу:   {base_url}/ping
- прием POST запроса по адресу: {base_url}/pong с получением и отправкой ответа

2. Написать сервис отправляющий REST запрос на сервис
Задача сервиса:
- отправка GET/POST запросов в первый сервис по расписанию

Требования:
1. объекты данных для запроса и ответа
RequestDto
private String name;
private Date date;
private String request; 

ResponseDto
private String name;
private Date date;
private String response;

2. get/post запросы  реализовать с использованием RestTemplate
-- передача и получение dto в формате json с записью результата в лог

3. настройка application.yaml
-- стандартные настройки: порт сервиса
-- настраиваемый шаблон для ответа (использование @Value)
-- расписание

4. подключить метрики для REST запросов



Проект состоит из 3х модулей:
1) library - модели данных
2) receiver - сервис принимающий REST запросы, порт 8081
3) sender - сервис отправляющий REST запрос, порт 8082
  sender запускает запросы: ping каждые 10 секунд, pong каждую минуту в 20 секунд

Метрики,подключены с помощью actuator, доступны по адресам http://localhost:8082/actuator/metrics http://localhost:8081/actuator/metrics
