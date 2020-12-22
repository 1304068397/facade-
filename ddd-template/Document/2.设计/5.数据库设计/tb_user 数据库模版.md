# 房价评估表
select * from ny_house_assess;

| 字段          | 类型        | 允许空 | 默认值 | 描述     |
| ------------- | ----------- | ------ | ------ | -------- |
| contact_phone | varchar(24) | NO     | -      | 联系方式 |

<a id="realize" name="realize"></a>
**枚举：变现能力：realize： com.noah.ryt.cityrisk.enums.Realize**

|  值   | 名称      | 说明                 |
| :---: | --------- | -------------------- |
|   0   | Realize_A | 1-3个月              |
|   1   | Realize_B | 3-6个月，急售9折     |
|   2   | Realize_C | 6个月以上，急售8.5折 |
|   3   | Realize_D | 未核实到             |

<a id="price_trend" name="price_trend"></a>
**枚举：价格趋势：price_trend： com.noah.ryt.cityrisk.enums.PriceTrend**

|  值   | 名称         | 说明                 |
| :---: | ------------ | -------------------- |
|   0   | PriceTrend_A | 过去一年震荡10-20%   |
|   1   | PriceTrend_B | 过去一年波动10%以内  |
|   2   | PriceTrend_C | 基本平稳，有上涨趋势 |
|   3   | PriceTrend_D | 基本平稳，有下跌趋势 |

