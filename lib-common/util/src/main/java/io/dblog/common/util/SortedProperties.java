package io.dblog.common.util;

import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

/**
 * {@code SortedProperties}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class SortedProperties extends Properties {

    private static final long serialVersionUID = -3548774692891771076L;

    private final LinkedHashSet<Object> keys = Sets.newLinkedHashSet();

    public Enumeration<Object> keys() {
        return Collections.enumeration(keys);
    }

    public Object put(Object key, Object value) {
        keys.add(key);
        return super.put(key, value);
    }

    @Override
    public Set<Object> keySet() {
        return keys;
    }

    public Set<String> stringPropertyNames() {
        Set<String> sets = Sets.newLinkedHashSet();

        keys.forEach(key -> sets.add(key.toString()));
        return sets;
    }
}
