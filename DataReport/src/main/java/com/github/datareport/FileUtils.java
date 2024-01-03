package com.github.datareport;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 点位文件缓存工具类
 */
public class FileUtils {

    /**
     * 合并各个进程下的点位缓存文件到主进程缓存文件中
     */
    public static void mergeEventToPersist() {

    }

    /**
     * 从内存中写入点位到点位缓存文件中
     * @param eventList
     * @param storeName
     */
    public static boolean writeEventToDisk(List<Event> eventList, String storeName) throws IOException {
        if (eventList != null && !eventList.isEmpty()) {
            List<Event> events = readEventFromDisk(storeName);
            events.addAll(eventList); //将内存中点位和文件缓存点位进行合并
            Event[] eventArray = new Event[events.size()];
            events.toArray(eventArray);
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(storeName)));
            oos.writeObject(eventArray);

            return true;
        } else {
            return false;
        }
    }

    /**
     * 从缓存文件中读取点位集合
     * @param storeName
     * @return
     */
    public static List<Event> readEventFromDisk(String storeName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storeName));
            Object events = ois.readObject();
            return Arrays.asList((Event[])events);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将从文件缓存的json数据转化为bundle点位
     * @param eventId
     * @param jsonData
     * @return
     */
    public static Bundle convertJsonToBundle(int eventId, String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            Bundle params = new Bundle();
            Iterator<String> keys = jsonObject.keys();
            //遍历jsonObject的key，将key value进行设置
            while(keys.hasNext()) {
                String key = keys.next();
                //根据value的各种类型来设置对应类型到bundle中
                if (ParamsChecker.isBooleanType(jsonObject.get(key))) {
                    params.putBoolean(key, jsonObject.getBoolean(key));
                } else if (ParamsChecker.isIntegerType(jsonObject.get(key))) {
                    params.putInt(key, jsonObject.getInt(key));
                } else if (ParamsChecker.isStringType(jsonObject.get(key))) {
                    params.putString(key, jsonObject.getString(key));
                }
            }
            return params;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
