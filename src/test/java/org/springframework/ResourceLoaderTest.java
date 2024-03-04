package org.springframework;

import cn.hutool.core.io.IoUtil;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.InputStream;

public class ResourceLoaderTest {
    @Test
    public void testResourceLoader() throws Exception {
        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
}