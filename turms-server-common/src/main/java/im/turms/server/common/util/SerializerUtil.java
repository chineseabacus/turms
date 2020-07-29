/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.turms.server.common.util;

import com.google.common.collect.Maps;
import im.turms.server.common.cluster.service.serialization.serializer.Serializer;
import im.turms.server.common.cluster.service.serialization.serializer.SerializerPool;
import io.netty.buffer.ByteBuf;

import javax.annotation.Nullable;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author James Chen
 */
public class SerializerUtil {

    private SerializerUtil() {
    }

    // Common

    public static void writeMap(ByteBuf output, Map map) {
        int size = map.size();
        output.writeShort(size);
        final Set<Map.Entry> set = map.entrySet();
        for (Map.Entry entry : set) {
            final Object key = entry.getKey();
            final Object value = entry.getValue();
            writeObject(output, key);
            writeObject(output, value);
        }
    }

    public static Map readMaps(ByteBuf input) {
        final int size = input.readShort();
        Map map = Maps.newHashMapWithExpectedSize(size);
        for (int i = 0; i < size; i++) {
            map.put(readObject(input), readObject(input));
        }
        return map;
    }

    public static void writeObject(ByteBuf output, Object obj) {
        Serializer<Object> serializer = SerializerPool.getSerializer(obj.getClass());
        serializer.write(output, obj);
    }

    public static <T> T readObject(ByteBuf input) {
        int serializerId = input.readShort();
        Serializer<T> serializer = SerializerPool.getSerializer(serializerId);
        return serializer.read(input);
    }

    public static void writeString(ByteBuf output, @Nullable String str) {
        if (str == null) {
            output.writeShort(0);
        } else {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            output.writeShort(bytes.length);
            output.writeBytes(bytes);
        }
    }

    public static String readString(ByteBuf input) {
        int length = input.readShort();
        if (length == 0) {
            return null;
        } else {
            byte[] bytes = new byte[length];
            input.readBytes(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }

    public static void writeStrings(ByteBuf output, Collection<String> strings) {
        int size = strings.size();
        output.writeShort(size);
        for (String string : strings) {
            writeString(output, string);
        }
    }

    public static List<String> readStringList(ByteBuf input) {
        int length = input.readShort();
        List<String> strings = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            strings.add(readString(input));
        }
        return strings;
    }

    public static void writeInts(ByteBuf output, Collection<Integer> integers) {
        int size = integers.size();
        output.writeInt(size);
        for (Integer integer : integers) {
            output.writeInt(integer);
        }
    }

    public static List<Integer> readIntList(ByteBuf input) {
        int length = input.readInt();
        List<Integer> integers = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            integers.add(input.readInt());
        }
        return integers;
    }

}
