# keywordsign-core使用文档

关键词定位签署功能使用文档

## 默认配置

配置项 | 类型 | 默认值 | 描述
 :-:  | :-: | :-: | :-:
tmpPath | String | "./data" | 临时文件存放目录
beforeKeywordSymbol | String | "\\$\\{" | 关键词前置修饰符
afterKeywordSymbok | String | "\\}" | 关键词后置修饰符
timeStampUrl | String | ... | 时间戳服务地址
timeStampCode | String | ... | 时间戳服务码
defaultKeyStorePassword | String | "123456" | 默认生成的证书容器密码

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

* 获取合同关键词位置信息

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

