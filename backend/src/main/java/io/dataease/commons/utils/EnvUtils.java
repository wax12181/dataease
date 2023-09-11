package io.dataease.commons.utils;

import com.google.gson.Gson;
import io.dataease.dto.datasource.MysqlConfiguration;
import io.dataease.plugins.datasource.entity.JdbcConfiguration;
import org.springframework.core.env.Environment;

import java.util.Objects;

/**
 * 作者： anxiang.wu
 * 描述：
 * 日期: 8/10/23
 */
public class EnvUtils {
    public static <T extends JdbcConfiguration> T createWithEnv(String config, Class<T> clazz, Environment env) {
        return createWithEnv(new Gson().fromJson(config, clazz), env);
    }

    public static <T extends JdbcConfiguration> T createWithEnv(T config, Environment env) {
        if (Objects.equals(config.getPassword(), "QT_MONGODB_PASSWORD")) {
            config.setPassword(env.getProperty(config.getPassword()));
        }
        return config;
    }
}
