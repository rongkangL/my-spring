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



