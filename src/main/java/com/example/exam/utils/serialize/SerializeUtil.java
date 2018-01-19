package com.example.exam.utils.serialize;

import java.io.IOException;

public interface SerializeUtil {

     <T> byte[] encode(T data) throws IOException;


     <T> T decode(byte[] arrayByte, Class<T> tClass) throws IOException, ClassNotFoundException;
}
