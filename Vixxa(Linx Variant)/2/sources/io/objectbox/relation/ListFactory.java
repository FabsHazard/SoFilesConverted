package io.objectbox.relation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface ListFactory extends Serializable {
    <T> List<T> createList();

    public static class ArrayListFactory implements ListFactory {
        private static final long serialVersionUID = 8247662514375611729L;

        public <T> List<T> createList() {
            return new ArrayList();
        }
    }

    public static class CopyOnWriteArrayListFactory implements ListFactory {
        private static final long serialVersionUID = 1888039726372206411L;

        public <T> List<T> createList() {
            return new CopyOnWriteArrayList();
        }
    }
}
