package com.example.exam.utils.serialize;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import java.io.IOException;

public class ProtoStuffSerializeUtil implements SerializeUtil {
    @Override
    public <T> byte[] encode(T data) throws IOException {
        if (data == null) {
            throw new RuntimeException("序列化对象为null");
        }
        Schema<T> schema = RuntimeSchema.getSchema((Class<T>) data.getClass());
        LinkedBuffer linkedBuffer = LinkedBuffer.allocate(1024);
        byte[] protobuf = ProtostuffIOUtil.toByteArray(data, schema, linkedBuffer);
        return protobuf;
    }

    @Override
    public <T> T decode(byte[] arrayByte, Class<T> tClass) throws IOException, ClassNotFoundException {
        Schema<T> schema = RuntimeSchema.getSchema(tClass);
        T message = null;
        try {
            message = tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        ProtostuffIOUtil.mergeFrom(arrayByte,message,schema);
        return message;
    }
}
