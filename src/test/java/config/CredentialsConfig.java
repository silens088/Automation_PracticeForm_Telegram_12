package config;

import org.aeonbits.owner.Config;

//делаем интерфейс для передачи данные (логин пароль) - и указываем путь к конфигу.

@Config.Sources({"classpath:config/credentials.properties"}) //это путь к credentials.properties
public interface CredentialsConfig extends Config {
    String login();
    String password();
}
