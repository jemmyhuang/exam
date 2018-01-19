package com.example.exam;

import com.example.exam.domain.User;
import com.example.exam.utils.serialize.JdkSerializeUtil;
import com.example.exam.utils.serialize.ProtoStuffSerializeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class serializeTest {

    private static byte[] arr;

    @Test
    public  void encode() throws IOException{
        User user = new User();
        user.setId("32234");
        user.setUserName("lisai");
        user.setPassword("323243");
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));

        JdkSerializeUtil jdkSerializeUtil = new JdkSerializeUtil();
        byte[] bytes = jdkSerializeUtil.encode(user);
        System.out.println(bytes);
        System.out.println(bytes.length);
    }

    @Test
    public  void encode2() throws IOException{
        User user = new User();
        user.setId("32234");
        user.setUserName("lisai");
        user.setPassword("323243");
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));

        ProtoStuffSerializeUtil protoStuffSerializeUtil = new ProtoStuffSerializeUtil();
        arr = protoStuffSerializeUtil.encode(user);
        System.out.println(arr);
        System.out.println(arr.length);
    }

    @Test
    public  void decode2() throws IOException,ClassNotFoundException{
        ProtoStuffSerializeUtil protoStuffSerializeUtil = new ProtoStuffSerializeUtil();
        User user = protoStuffSerializeUtil.decode(arr,User.class);
        System.out.println(user);
        System.out.println(arr.length);
    }
}
