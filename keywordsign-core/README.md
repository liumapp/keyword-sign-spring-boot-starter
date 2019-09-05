# keywordsign-core使用文档

关键词定位签署功能使用文档

## 获取方式

通过maven获取：

````mxml
<dependency>
    <groupId>com.liumapp.keywordsign.core</groupId>
    <artifactId>keywordsign-core</artifactId>
    <version>v1.0.0</version>
</dependency>
````

或者直接获取支持Spring Boot的Starter依赖：

````mxml
<dependency>
    <groupId>com.liumapp.keywordsign.starter</groupId>
    <artifactId>keywordsign-spring-boot-starter</artifactId>
    <version>v1.0.0</version>
</dependency>    
````

## 默认配置

配置项 | 类型 | 默认值 | 描述
 :-:  | :-: | :-: | :-:
tmpPath | String | "./data" | 临时文件存放目录
beforeKeywordSymbol | String | "\\$\\{" | 关键词前置修饰符
afterKeywordSymbok | String | "\\}" | 关键词后置修饰符
timeStampUrl | String | ... | 时间戳服务地址
timeStampCode | String | ... | 时间戳服务码
defaultKeyStorePassword | String | "123456" | 默认生成的证书容器密码
xDeviation | Integer | 50 | 签章水平方向偏移量，单位px(正数向右，负数向左)
yDeviation | Integer | -50 | 签章竖直方向偏移量，单位px(正数向上，负数向下)

修改配置方法

````java
KeywordSignConfig keywordSignConfig = KeywordSignConfigFactory.getInstance();
keywordSignConfig.setBeforeKeywordSymbol("\\$\\[");
keywordSignConfig.setAfterKeywordSymbok("\\]");

KeywordSignConfig keywordSignConfig1 = KeywordSignConfigFactory.getInstance();
Assert.assertEquals("\\$\\[", keywordSignConfig1.getBeforeKeywordSymbol());
Assert.assertEquals("\\]", keywordSignConfig1.getAfterKeywordSymbok());
````

## 功能列表

以下功能均可独立使用

* 获取PDF合同关键词位置信息

* 检查与创建证书容器KeyStore

* 获取签章图片尺寸数据

* 写入pfx证书到证书容器中

* PDF合同关键词定位签署

## 具体实现

### 获取PDF合同关键词位置信息

传入合同PDF的base64数据，以及关键词，返回关键词位置信息

关键词默认会使用${}进行修饰，如果要变更，请修改配置类的前置修饰符与后置修饰符

````java
Keyword keyword = KeywordFactory.getInstance();
List<HashMap<String, Float>> results = keyword.getKeywordPosition(Base64FileTool.filePathToBase64("./data/test.pdf"), "year");
Assert.assertEquals(1, results.size());
for (HashMap<String, Float> item : results) {
    System.out.println("page is : " + item.get("page"));
    System.out.println("x is : " + item.get("x"));
    System.out.println("y is : " + item.get("y"));
}
````

### 检查与创建证书容器KeyStore

检查证书容器是否存在，不存则创建

PS: 证书容器并不是一个普通的文件，而是一个JavaKeyStore

````java
KeyStore keyStore = KeyStoreFactory.getInstance();
keyStore.chkKeyStoreFile("./data/demo.ks");
Assert.assertEquals(true, FileTool.isFileExists("./data/demo.ks"));
````

### 获取签章图片尺寸数据

获取base64格式的图片尺寸信息

````java
SignPic signPic = SignPicFactory.getInstance();
int[] result = signPic.readWidthAndHeightFromBase64Pic(Base64FileTool.filePathToBase64("./data/me.jpg"));
System.out.println("width is : " + result[0] + " and height is : " + result[1]);
Assert.assertEquals(568, result[0]);
Assert.assertEquals(568, result[1]);
````

### 写入pfx证书到证书容器中

在已经创建好证书容器的前提下，将一份PFX格式的数字证书，写入证书容器中

以下代码执行后，请使用命令： keytool -v -list -keystore ./data/demo.ks 查看容器中的证书数据

````java
PfxHandler pfxHandler = PfxHandlerFactory.getInstance();
pfxHandler.writePfxToKeyStore("./data/demo.ks",
        "123456",
        "liumapp",
        Base64FileTool.filePathToBase64("./data/liumapp.pfx"),
        "123123123"
        );
````

### PDF合同关键词定位签署

整个项目的核心功能，输入证书容器路径、证书容器密码、证书别名、PFX格式的证书base64值、证书密码、签章图片、签章字段、签署理由、签署地址、关键词这些数据

返回签好的PDF合同Base64的值

````java
KeywordSign keywordSign = KeywordSignFactory.getInstance();
String signedPdfBase64 = keywordSign.sign("./data/demo.ks",
        "123456",
        "liumapp",
        Base64FileTool.filePathToBase64("./data/liumapp.pfx"),
        "123123123",
        Base64FileTool.filePathToBase64("./data/test.pdf"),
        Base64FileTool.filePathToBase64("./data/me.jpg"),
        "signFiled1",
        "this is sign reason",
        "this is sign location",
        "year"
        );
Base64FileTool.saveBase64File(signedPdfBase64, "./data/result.pdf");
````