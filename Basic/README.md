## commons-lang ##

commons-lang 包用来处理 Java 基本对象方法的工具类包，可以简化很多平时经常要用到的写法，例如判断字符串是否为空等等。

commons.lang 包共包含了17个实用的类：
 
* ArrayUtils – 用于对数组的操作，如添加、查找、删除、子数组、倒序、元素类型转换等；
* BitField – 用于操作位元，提供了一些方便而安全的方法；
* BooleanUtils – 用于操作和转换 boolean 或者 Boolean 及相应的数组；
* CharEncoding – 包含了 Java 环境支持的字符编码，提供是否支持某种编码的判断；
* CharRange – 用于设定字符范围并做相应检查；
* CharSet – 用于设定一组字符作为范围并做相应检查；
* CharSetUtils – 用于操作 CharSet；
* CharUtils – 用于操作 char 值和 Character 对象；
* ClassUtils – 用于对 Java 类的操作，不使用反射；
* ObjectUtils – 用于操作 Java 对象，提供 null 安全的访问和其他一些功能；
* RandomStringUtils – 用于生成随机的字符串；
* SerializationUtils – 用于处理对象序列化，提供比一般 Java 序列化更高级的处理能力；
* StringEscapeUtils – 用于正确处理转义字符，产生正确的 Java、JavaScript、HTML、XML 和 SQL 代码；
* StringUtils – 处理 String 的核心类，提供了相当多的功能；
* SystemUtils – 在 java.lang.System 基础上提供更方便的访问，如用户路径、Java 版本、时区、操作系统等判断；
* Validate – 提供验证的操作，有点类似 assert 断言；
* WordUtils – 用于处理单词大小写、换行等。

## commons-Primitives ##

commons-Primitives 提供了一个更小，更快和更易使用的对 Java 基本类型的支持。当前主要是针对基本类型的 collection。

尽管 JDK1.5 提供了基础类型的自动拆箱/装箱功能，但是这个功能对内存消耗和性能都是有影响的。

commons-Primitives 可以容纳基础类型，并且提供更快的速度，更高的性能。
