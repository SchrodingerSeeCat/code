package com.valid.web.converter;

import com.valid.web.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/*
* 自定义的converter
* */
public class AppMessageConverter implements HttpMessageConverter<Person> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        // 能不能够自动映射到标注了@RequestBody的参数上
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        // 如果是Person类型就能够正常写入,并返回给服务器

        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        // 返回要支持的类型 假设app要返回的数据类型是 application/x-valid

        return MediaType.parseMediaTypes("application/x-valid");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 自定义类型数据的写出
        String data = person.getUserName() + ";" + person.getAge() + ";" + person.getBirth() + ";" + person.getPet();

        // 写出
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());
        body.close();
    }
}
