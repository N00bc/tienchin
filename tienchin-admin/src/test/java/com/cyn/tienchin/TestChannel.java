package com.cyn.tienchin;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import io.minio.GetObjectArgs;
import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Types;
import java.util.Collections;

/**
 * @author Godc
 * @description:
 * @date 2023/7/01/0001 16:30
 */
@SpringBootTest
public class TestChannel {
    @Test
    void testGenerate() {
        String outPath = "F:\\Code\\program\\TienChin\\tienchin-contract\\src\\main\\java";
        String path = "F:\\Code\\program\\TienChin\\tienchin-contract\\src\\main\\resources\\mapper";
        FastAutoGenerator.create("jdbc:mysql://myvm:3306/tienchin?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8", "root", "1234")
                .globalConfig(builder -> {
                    builder.author("cyn") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(outPath); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.cyn.tienchin") // 设置父包名
                            .moduleName("contract") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, path)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("tienchin_contract") // 设置需要生成的表名
                            .addTablePrefix("tienchin"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    @Autowired
    private MinioClient minioClient;

    @Test
    void minIO() throws ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket("contract").recursive(true).build());
        for (Result<Item> result : results) {
            System.out.println(result.get().objectName());
        }
    }

    String fileName = "2023/07/17/test.docx";

    @Test
    void name() throws ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        try (InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket("contract")
                        .object(fileName)
                        .build());
             FileOutputStream fileOutputStream = new FileOutputStream("D:\\GoogleDownload\\contract.docx")) {
            // Read data from stream

            byte[] bytes = new byte[1024];
            int len;
            while ((len = stream.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0, len);
            }
        }

    }
}
