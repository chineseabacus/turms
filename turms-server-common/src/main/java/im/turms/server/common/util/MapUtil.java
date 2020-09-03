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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author James Chen
 */
public class MapUtil {

    private MapUtil() {
    }

    public static int getCapability(int expectedSize) {
        return (int) ((float) expectedSize / 0.75F + 1.0F);
    }

    public static <K, V> Map<K, V> deepMerge(Map<K, V> baseMap, Map<? extends K, ? extends V> mapToMerge) {
        for (Map.Entry<? extends K, ? extends V> entry : mapToMerge.entrySet()) {
            K key = entry.getKey();
            V existingValue = baseMap.get(key);
            V valueToMerge = entry.getValue();
            if (existingValue instanceof Collection && valueToMerge instanceof Collection) {
                if (!((Collection) existingValue).containsAll((Collection) valueToMerge)) {
                    ((Collection) existingValue).addAll((Collection) valueToMerge);
                }
            } else if (existingValue instanceof Map && valueToMerge instanceof Map) {
                deepMerge((Map) existingValue, (Map) valueToMerge);
            } else if (existingValue == null || !existingValue.equals(valueToMerge)) {
                baseMap.put(key, valueToMerge);
            }
        }
        return baseMap;
    }

    public static Map addValueKeyToAllLeaves(Object properties) {
        if (properties instanceof Map) {
            for (Map.Entry<String, Object> entry : ((Map<String, Object>) properties).entrySet()) {
                Object value = entry.getValue();
                entry.setValue(addValueKeyToAllLeaves(value));
            }
            return (Map) properties;
        } else {
            // Don't use the immutable map because the code may add elements to it later
            HashMap<Object, Object> map = new HashMap<>(1, 1);
            map.put("value", properties);
            return map;
        }
    }

}
