[TOC]

# 1. Bean对象的定义、注册和获取

简单实现了Bean对象的定义、注册和获取(使用了设计模式中的行为型模式——模板方法模式)。

Bean注册到容器中不需要传递一个以及实例化的Bean对象（而是传递一个Class类），而是放进容器的Bean均为单例。

在工厂获取Bean的时候，获取的是单例的Bean，也就是单例Map中存储的Bean。

如果单例Map中不存在这个Bean，则会根据Bean的名字，从Bean定义信息的Map中获取Bean的定义类（BeanDefinition）。
然后通过其Class类创建Bean，并且放进单例Map中。

---

# 2. 使用Cglib实现构造函数含参数的实例化策略

前面的Bean对象定义、注册和获取都是基于无参实现的，也就是注入到容器中的Bean必须是无参构造，如果想要使用有参构造，那么程序就会发生报错。

想要创建含有参数的构造函数的Bean对象，有两种方法，第一种就是使用JDK的`DeclaredConstructor`；另一种就是使用Cglib动态创建Bean对象。

由于有两种方法，为了更好拓展，使用了设计模式中的行为模式——策略模式来设计。

如果想要修改创建Bean的方式，只需要修改`AbstractAutowireCapableBeanFactory`的私有成员变量`instantiationStrategy`为JDK实现即可。

在程序中`CglibSubclassingInstantiationStrategy`和`SimpleInstantiationStrategy`实现了`InstantiationStrategy`，其中前者是Cglib实现，后者为Jdk实现。

并且在`InstantiationStrategy`中，提供了一个含构造参数的获取Bean的方法，并且对获取Bean的方法进行了封装。

---

# 3. 注入属性和依赖对象

进一步将将创建对象的实例化细分，注入的属性不再局限于int、long、String等，还包括没有被实例化的对象。

定义一个`BeanRefernence`引用对象，里面只有一个简单的Bean名称，这个当作一个属性中被注入的Bean。

并且还创建一个`PropertyValues`的集合存放各种属性。`PropertyValues`集合存放的是`PropertyValue`类。

该类只有两个成员变量，分别是属性名称和属性值。可以说是一个key-value的类。

`BeanDefinition`也做了修改，`BeanDefinition`新增了一个`PropertyValues`的成员变量，代表这个Bean的属性信息。

在`AbstractAutowireCapableBeanFactory`的`createBean`中，会首先创建一个Bean，但是这个Bean只是被实例化了，成员变量并没有被赋值。

这时候调用`applyPropertyValues`方法进行成员变量赋值。

遍历`BeanDefinition`中的`PropertyValues`，如果发现`PropertyValue`的`value`是`BeanReference`类型，说明这个value是一个Bean，需要在容器中寻找，于是就需要在容器中获取该Bean。

> 但是，一定一定要注意，要先将这个Bean注册到容器中，否则，会抛出异常说这个Bean没有被定义

之后，通过hutool的工具类，对bean的成员变量赋值即可。

> 注意，这里并没有考虑到循环依赖这种现象。

---



