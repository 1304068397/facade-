- [单位管理](#%e5%8d%95%e4%bd%8d%e7%ae%a1%e7%90%86)
  - [分页](#%e5%88%86%e9%a1%b5)
    - [请求参数](#%e8%af%b7%e6%b1%82%e5%8f%82%e6%95%b0)
    - [请求体](#%e8%af%b7%e6%b1%82%e4%bd%93)
    - [返回](#%e8%bf%94%e5%9b%9e)
  - [查询](#%e6%9f%a5%e8%af%a2)
    - [请求参数](#%e8%af%b7%e6%b1%82%e5%8f%82%e6%95%b0-1)
    - [请求体](#%e8%af%b7%e6%b1%82%e4%bd%93-1)
    - [返回](#%e8%bf%94%e5%9b%9e-1)
  - [新增](#%e6%96%b0%e5%a2%9e)
    - [请求参数](#%e8%af%b7%e6%b1%82%e5%8f%82%e6%95%b0-2)
    - [请求体](#%e8%af%b7%e6%b1%82%e4%bd%93-2)
    - [返回](#%e8%bf%94%e5%9b%9e-2)
  - [修改](#%e4%bf%ae%e6%94%b9)
    - [请求参数](#%e8%af%b7%e6%b1%82%e5%8f%82%e6%95%b0-3)
    - [请求体](#%e8%af%b7%e6%b1%82%e4%bd%93-3)
    - [返回](#%e8%bf%94%e5%9b%9e-3)
  - [逻辑删除](#%e9%80%bb%e8%be%91%e5%88%a0%e9%99%a4)
    - [请求参数](#%e8%af%b7%e6%b1%82%e5%8f%82%e6%95%b0-4)
    - [请求体](#%e8%af%b7%e6%b1%82%e4%bd%93-4)
    - [返回](#%e8%bf%94%e5%9b%9e-4)
  
# 单位管理

## 分页

| 类     | 值                                    |
| ------ | ------------------------------------- |
| URL    | http://localhost:8888/dept/pc/v1/page |
| Method | POST                                  |

### 请求参数

| 参数名    | 类型   | 备注            |
| --------- | ------ | --------------- |
| available | String | 是否删除:YES/NO |
| pageIndex | Number | 页码            |
| pageSize  | Number | 大小            |
| asc       | String | 顺序排序字段    |
| desc      | String | 倒叙排序字段    |

### 请求体
```json
{
	"available":"YES",
    "pageIndex":1,
    "pageSize":10,
    "asc":"id,available",
    "desc":"creator"
}
```

### 返回
| 参数名    | 类型   | 备注     |
| --------- | ------ | -------- |
| id        | Number | 单位主键 |
| available | String |          |

```json
{
  "isSuccess": true,
  "data": {
    "configID": "00000000-0000-0000-0000-000000000000",
    "configType": "string",
    "configName": "string",
    "appID": "string",
    "appSecret": "string",
    "encodingAESKey": "string",
    "extend1": "string",
    "extend2": "string",
    "extend3": "string",
    "extend4": "string",
    "extend5": "string",
    "extend6": "string",
    "extend7": "string",
    "extend8": "string",
    "extend9": "string",
    "pageSize": 0,
    "pageNO": 0,
    "gmtCreateUser": "string",
    "gmtCreateDate": "2020-04-28T05:12:52.421Z",
    "gmtUpdateUser": "string",
    "gmtUpdateDate": "2020-04-28T05:12:52.421Z",
    "timestamp": "string"
  },
  "errorCode": "string",
  "errorMessage": "string"
}


```

----------

## 查询

| 类     | 值                                   |
| ------ | ------------------------------------ |
| URL    | http://localhost:8888/dept/pc/v1/get |
| Method | POST                                 |

### 请求参数

| 参数名 | 类型   | 备注     |
| ------ | ------ | -------- |
| id     | Number | 单位主键 |

### 请求体
```json
{
    "id":"1"
}
```

### 返回
| 参数名    | 类型   | 备注     |
| --------- | ------ | -------- |
| id        | Number | 单位主键 |
| available | String |          |

```json
{
  "isSuccess": true,
  "data": {
    "configID": "00000000-0000-0000-0000-000000000000",
    "configType": "string",
    "configName": "string",
    "appID": "string",
    "appSecret": "string",
    "encodingAESKey": "string",
    "extend1": "string",
    "extend2": "string",
    "extend3": "string",
    "extend4": "string",
    "extend5": "string",
    "extend6": "string",
    "extend7": "string",
    "extend8": "string",
    "extend9": "string",
    "pageSize": 0,
    "pageNO": 0,
    "gmtCreateUser": "string",
    "gmtCreateDate": "2020-04-28T05:12:52.421Z",
    "gmtUpdateUser": "string",
    "gmtUpdateDate": "2020-04-28T05:12:52.421Z",
    "timestamp": "string"
  },
  "errorCode": "string",
  "errorMessage": "string"
}
```

----------

## 新增

| 类     | 值                                   |
| ------ | ------------------------------------ |
| URL    | http://localhost:8888/dept/pc/v1/add |
| Method | POST                                 |

### 请求参数

| 参数名      | 类型   | 备注         |
| ----------- | ------ | ------------ |
| serial      | String | 单位编号     |
| category    | String | 单位类别     |
| orgCode     | String | 组织结构代码 |
| deptName    | String | 单位名称     |
| properties1 | String | 单位属性1    |
| properties2 | String | 单位属性2    |
| properties3 | String | 单位属性3    |
| properties4 | String | 单位属性4    |

### 请求体
```json
{
    "serial": "10000001",
    "category": "GX",
    "orgCode": "test2222",
    "deptName": "test2",
    "properties1": "ZNCS",
    "properties2": "HY",
    "properties3": "HK",
    "properties4": "GB"
}
```

### 返回
| 参数名    | 类型   | 备注     |
| --------- | ------ | -------- |
| id        | Number | 单位主键 |
| available | String |          |

```json
{
  "isSuccess": true,
  "data": {
    "configID": "00000000-0000-0000-0000-000000000000",
    "configType": "string",
    "configName": "string",
    "appID": "string",
    "appSecret": "string",
    "encodingAESKey": "string",
    "extend1": "string",
    "extend2": "string",
    "extend3": "string",
    "extend4": "string",
    "extend5": "string",
    "extend6": "string",
    "extend7": "string",
    "extend8": "string",
    "extend9": "string",
    "pageSize": 0,
    "pageNO": 0,
    "gmtCreateUser": "string",
    "gmtCreateDate": "2020-04-28T05:12:52.421Z",
    "gmtUpdateUser": "string",
    "gmtUpdateDate": "2020-04-28T05:12:52.421Z",
    "timestamp": "string"
  },
  "errorCode": "string",
  "errorMessage": "string"
}
```

----------


## 修改

| 类     | 值                                      |
| ------ | --------------------------------------- |
| URL    | http://localhost:8888/dept/pc/v1/update |
| Method | POST                                    |

### 请求参数

| 参数名      | 类型   | 备注         |
| ----------- | ------ | ------------ |
| id          | String | 单位主键id   |
| serial      | String | 单位编号     |
| category    | String | 单位类别     |
| orgCode     | String | 组织结构代码 |
| deptName    | String | 单位名称     |
| properties1 | String | 单位属性1    |
| properties2 | String | 单位属性2    |
| properties3 | String | 单位属性3    |
| properties4 | String | 单位属性4    |

### 请求体
```json
{
	"id":3,
    "serial": "10000001",
    "category": "GX",
    "orgCode": "test2222",
    "deptName": "test2修改后",
    "properties1": "ZNCS",
    "properties2": "HY",
    "properties3": "HK",
    "properties4": "GB"
}
```

### 返回
| 参数名    | 类型   | 备注     |
| --------- | ------ | -------- |
| id        | Number | 单位主键 |
| available | String |          |

```json
{
  "isSuccess": true,
  "data": {
    "configID": "00000000-0000-0000-0000-000000000000",
    "configType": "string",
    "configName": "string",
    "appID": "string",
    "appSecret": "string",
    "encodingAESKey": "string",
    "extend1": "string",
    "extend2": "string",
    "extend3": "string",
    "extend4": "string",
    "extend5": "string",
    "extend6": "string",
    "extend7": "string",
    "extend8": "string",
    "extend9": "string",
    "pageSize": 0,
    "pageNO": 0,
    "gmtCreateUser": "string",
    "gmtCreateDate": "2020-04-28T05:12:52.421Z",
    "gmtUpdateUser": "string",
    "gmtUpdateDate": "2020-04-28T05:12:52.421Z",
    "timestamp": "string"
  },
  "errorCode": "string",
  "errorMessage": "string"
}
```

----------

## 逻辑删除

| 类     | 值                                        |
| ------ | ----------------------------------------- |
| URL    | http://localhost:8888/dept/pc/v1/logicDel |
| Method | POST                                      |

### 请求参数

| 参数名 | 类型   | 备注       |
| ------ | ------ | ---------- |
| id     | String | 单位主键id |

### 请求体
```json
{
	"id":2
}
```

### 返回
| 参数名    | 类型   | 备注     |
| --------- | ------ | -------- |
| id        | Number | 单位主键 |
| available | String |          |

```json
{
    "code": "00000",
    "description": "SUCCESS",
    "currentTime": 1581920420114
}
```