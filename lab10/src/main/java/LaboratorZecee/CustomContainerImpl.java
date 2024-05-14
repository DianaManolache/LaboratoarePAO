package LaboratorZecee;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

public class CustomContainerImpl implements CustomContainer {
    private final Map<String, Object> instances = new HashMap<>();
    private final Map<Class<?>, Function<CustomContainer, ?>> factories = new HashMap<>();

    @Override
    public <T> boolean addInstance(T instance) {
        if (instance == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }
        String name = instance.getClass().getName();
        return addInstance(instance, name);
    }

    @Override
    public <T> boolean addInstance(T instance, String customName) {
        if (customName == null || instance == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }
        if (instances.containsKey(customName)) {
            throw new CustomContainerException("Instances cannot be redeclared");
        }
        instances.put(customName, instance);
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> type) {
        if (type == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        T instance = findInstanceByType(type);
        if (instance != null) {
            return instance;
        }

        return createInstanceByType(type);
    }

    @Override
    public <T> T getInstance(Class<T> type, String customName) {
        if (type == null || customName == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        T instance = findInstanceByTypeAndName(type, customName);
        if (instance != null) {
            return instance;
        }

        return createInstanceByType(type, customName);
    }
    private <T> T findInstanceByType(Class<T> type) {
        for (Object instance : instances.values()) {
            if (type.isInstance(instance)) {
                return type.cast(instance);
            }
        }
        return null;
    }

    private <T> T findInstanceByTypeAndName(Class<T> type, String customName) {
        Object instance = instances.get(customName);
        if (instance != null && type.isInstance(instance)) {
            return type.cast(instance);
        }
        return null;
    }

    private <T> T createInstanceByType(Class<T> type) {
        Function<CustomContainer, ?> factoryMethod = factories.get(type);
        if (factoryMethod != null) {
            @SuppressWarnings("unchecked")
            T instance = (T) factoryMethod.apply(this);
            addInstance(instance);
            return instance;
        } else {
            throw new CustomContainerException("Cannot provide instance");
        }
    }

    private <T> T createInstanceByType(Class<T> type, String customName) {
        Function<CustomContainer, ?> factoryMethod = factories.get(type);
        if (factoryMethod != null) {
            @SuppressWarnings("unchecked")
            T instance = (T) factoryMethod.apply(this);
            addInstance(instance, customName);
            return instance;
        } else {
            throw new CustomContainerException("Cannot provide instance");
        }
    }
    @Override
    public <T> boolean addFactoryMethod(Class<T> type, Function<CustomContainer, T> factoryMethod) {
        if (type == null || factoryMethod == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }
        factories.put(type, factoryMethod);
        return true;
    }

    @Override
    public <T> T create(Class<T> type) {
        Function<CustomContainer, ?> factoryMethod = factories.get(type);
        if (factoryMethod != null) {
            @SuppressWarnings("unchecked")
            T instance = (T) factoryMethod.apply(this);
            return instance;
        } else {
            throw new CustomContainerException("Cannot provide instance");
        }
    }

    @Override
    public <T> T create(Class<T> type, Map<String, Object> parameters) {
        if (type == null || parameters == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        Function<CustomContainer, ?> factoryMethod = factories.get(type);
        if (factoryMethod != null) {
            throw new CustomContainerException("Factory method already exists for type: " + type.getName());
        }

        try {
            if (parameters.isEmpty()) {
                return type.getDeclaredConstructor().newInstance();
            } else {
                Object[] constructorArgs = new Object[parameters.size()];
                int index = 0;
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    Object paramInstance = instances.get(entry.getKey());
                    if (paramInstance == null) {
                        throw new CustomContainerException("Instance with name " + entry.getKey() + " does not exist in the container");
                    }
                    constructorArgs[index++] = paramInstance;
                }
                return type.getDeclaredConstructor(getParameterTypes(constructorArgs)).newInstance(constructorArgs);
            }
        } catch (Exception e) {
            throw new CustomContainerException("Failed to create instance");
        }
    }

    private Class<?>[] getParameterTypes(Object[] parameters) {
        Class<?>[] parameterTypes = new Class<?>[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            parameterTypes[i] = parameters[i].getClass();
        }
        return parameterTypes;
    }

    @Override
    public void close() throws Exception {
        for (Object instance : instances.values()) {
            if (instance instanceof AutoCloseable) {
                ((AutoCloseable) instance).close();
            }
        }
        instances.clear();
    }
}