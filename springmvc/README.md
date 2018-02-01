### spring mvc

### springmvc出入参处理
如下图所示是springmvc的出入参请求图,
![]()
如果设置了
```xml
<mvc:annotation-driven/>
```
如上面所求的默认配置，springmvc会配置7个常用的转换器。
ByteArrayHttpMessageConverter
StringHttpMessageConverter
ResourceHttpMessageConverter
SourceHttpMessageConverter
AllEncompassingFormHttpMessageConverter
Jaxb2RootElementHttpMessageConverter
MappingJackson2HttpMessageConverter
这些转换器会根据请求信息头部Accept来判断使用哪个

当http请求通过springmvc请求后
[关于springmvc出入参原理](https://www.cnblogs.com/fangjian0423/p/springMVC-xml-json-convert.html)
这里可以先自己看一遍，然后自己去做一次。


### 这里我们可以自定义转换器以适应我们特殊的需求
1.原始springmvc rest接口的使用。
```java
@Controller
public class TestController{
	@RequestMapping("/abc")
}
```

### spring常用注解
