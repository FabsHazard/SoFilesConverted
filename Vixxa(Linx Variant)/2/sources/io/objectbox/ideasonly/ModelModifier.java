package io.objectbox.ideasonly;

public class ModelModifier {

    public class EntityModifier {
        final String name;
        final String schemaName;

        public void remove() {
        }

        public void renameTo(String str) {
        }

        EntityModifier(String str, String str2) {
            this.schemaName = str;
            this.name = str2;
        }

        public PropertyModifier property(String str) {
            return new PropertyModifier(this, str);
        }
    }

    public class PropertyModifier {
        final EntityModifier entityModifier;
        final String name;

        public void remove() {
        }

        public void renameTo(String str) {
        }

        PropertyModifier(EntityModifier entityModifier2, String str) {
            this.entityModifier = entityModifier2;
            this.name = str;
        }
    }

    public EntityModifier entity(String str) {
        return new EntityModifier("default", str);
    }
}
