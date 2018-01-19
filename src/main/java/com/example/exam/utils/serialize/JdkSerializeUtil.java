package com.example.exam.utils.serialize;

import java.io.*;

public class JdkSerializeUtil implements SerializeUtil {

    @Override
    public  <T> byte[] encode(T data) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(data);
        return out.toByteArray();
    }

    @Override
    public  <T> T decode(byte[] arrayByte, Class<T> tClass) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(arrayByte);
        ObjectInputStream os = new ObjectInputStream(in);
        Object object = os.readObject();
        return tClass.cast(object);
    }
}
