[TOC]

# 1. Bean对象的定义、注册和获取

简单实现了Bean对象的定义、注册和获取(使用了设计模式中的行为型模式——模板方法模式)。
Bean注册到容器中不需要传递一个以及实例化的Bean对象（而是传递一个Class类），而是放进容器的Bean均为单例。
在工厂获取Bean的时候，获取的是单例的Bean，也就是单例Map中存储的Bean。
如果单例Map中不存在这个Bean，则会根据Bean的名字，从Bean定义信息的Map中获取Bean的定义类（BeanDefinition）。
然后通过其Class类创建Bean，并且放进单例Map中。