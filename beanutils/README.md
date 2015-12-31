## commons-beanutils ##

commons-beanutils 是 apache commons 子项目中的一个软件包，其主要目的是利用反射机制对 JavaBean 的属性进行处理。

BeanUtils最核心的好处在于：

我们在编码时，并不需要知道我们处理的 JavaBeans 具体是什么类型，有哪些属性，这些信息是可以动态获取的，甚至我们都可以不必去关心事实上是否存在这样一个具体的 JavaBean 类。我们只需要知道有一个 JavaBean 的实例，我们需要从中取得某个属性，设定某个属性的值，或者仅仅是需要一个属性表。
要做到这些，依靠 Sun 提供的 JavaBean 规范似乎找不到一个很直接的方式，除非硬编码，将 getXxxx() 和 setXxxx() 直接写进我们的程序。但是这样就大大增加了代码的复杂度、耦合性和维护成本。还好Commons BeanUtils 对这个问题提供了一种优雅的解决方案。
