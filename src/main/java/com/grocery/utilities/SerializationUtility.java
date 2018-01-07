package com.grocery.utilities;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import java.util.List;

public class SerializationUtility {

    private static RuntimeSchema schema = null;

    public static byte[] serializeObject(Object object) {

        schema = RuntimeSchema.createFrom(object.getClass());

        return ProtostuffIOUtil.toByteArray(object,schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
    }

    public static Object unSerializeObject(byte[] bytes, Object object) {

        schema = RuntimeSchema.createFrom(object.getClass());

        object = schema.newMessage();

        ProtostuffIOUtil.mergeFrom(bytes,object,schema);

        return object;
    }

    public static byte[] serializeList(CacheList cacheList) {

        schema = RuntimeSchema.createFrom(cacheList.getClass());

        return ProtostuffIOUtil.toByteArray(cacheList,schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
    }

    public static CacheList unSerializeList(byte[] bytes, CacheList cacheList) {

        schema = RuntimeSchema.createFrom(cacheList.getClass());

        CacheList cacheListTemp = (CacheList) schema.newMessage();

        ProtostuffIOUtil.mergeFrom(bytes,cacheListTemp,schema);

        return cacheList;
    }

    public static class CacheList<T> {

        private List<T> list;

        public CacheList(List<T> list) {
            this.list = list;
        }

        public CacheList() {
        }

        public List<T> getList() {
            return list;
        }

        public void setList(List<T> list) {
            this.list = list;
        }
    }

}
