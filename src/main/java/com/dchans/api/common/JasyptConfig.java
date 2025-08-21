package com.dchans.api.common;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        // 마스터 키 (환경변수나 시스템 프로퍼티에서 가져오기)
        config.setPassword(getEncryptionKey());
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");

        encryptor.setConfig(config);
        return encryptor;
    }

    private String getEncryptionKey() {
        // 환경변수에서 마스터 키 가져오기
        String key = System.getenv("JASYPT_ENCRYPTOR_PASSWORD");
        if (key == null || key.isEmpty()) {
            // 시스템 프로퍼티에서 가져오기
            key = System.getProperty("jasypt.encryptor.password");
        }
        if (key == null || key.isEmpty()) {
            throw new RuntimeException("암호화 키를 찾을 수 없습니다. JASYPT_ENCRYPTOR_PASSWORD 환경변수를 설정해주세요.");
        }
        return key;
    }
}
