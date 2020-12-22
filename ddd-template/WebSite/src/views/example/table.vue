<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-07-15 16:50:12
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-09-18 13:49:43
-->
<template>
  <div class="app-container">
    <el-card shadow="hover">
      <el-row class="row">
        <span class="text-title">示例</span>
      </el-row>
      <el-row class="row">
        <el-table
          :data="tableData"
          style="width: 100%"
          stripe
          :cell-class-name="getCellClass"
        >
          <el-table-column type="selection" align="center" width="55">
          </el-table-column>
          <el-table-column prop="date" label="日期"> </el-table-column>
          <el-table-column prop="name" label="姓名"> </el-table-column>
          <el-table-column prop="amount" label="金额" width="160" align="right">
            <template slot-scope="scope">
              {{ scope.row.amount | moneyFormatter(2, ",") }}
            </template>
          </el-table-column>
          <el-table-column prop="address" label="地址"> </el-table-column>
          <el-table-column label="状态" width="160">
            <template slot-scope="scope">
              <el-tag type="success">{{ scope.row.status }}</el-tag>
              <el-tag type="info">停用</el-tag>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="200">
            <template slot-scope="scope">
              <el-button
                @click="handleClick(scope.row)"
                type="default"
                icon="el-icon-document-copy"
                plain
                >查看</el-button
              >
              <el-button type="primary" icon="el-icon-edit" plain
                >编辑</el-button
              >
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
          background
          layout="total, sizes, prev, pager, next"
          :total="tableData.length"
          :page-sizes="[20, 50, 100]"
          style="margin-top:20px"
        >
        </el-pagination>
      </el-row>
      <el-row class="row" style="margin-top:30px">
        <span class="text-title">注意事项</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              如无特殊情况（例如：多级表头），表格默认使用不带竖直方向边框且带有斑马纹的样式
            </li>
            <li>
              如无特殊情况，表格的列默认左对齐，如该列表示金额则右对齐
            </li>
            <li>
              用于选择行的 checkbox 列应位于最左侧，默认宽度55，居中对齐
            </li>
            <li>
              用于放置各种操作按钮的列应位于最右侧，宽度根据按钮数量决定，当
              table 的列较多时应考虑固定该列
            </li>
            <li>
              表示状态的列需使用 el-tag
              组件，通常，我们约定其意义为真或带有正面含义的状态颜色为绿色或蓝色，其意义为假或带有负面含义的状态颜色为灰色或红色
            </li>
            <li>
              表格默认每页显示 20 条数据，在分页组件中提供 20 / 50 / 100 共 3
              档可调整选项，同时显示总条数
            </li>
          </ul>
        </text-field>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import TextField from "@/components/TextField";
export default {
  name: "Button",
  components: { TextField },
  data() {
    return {
      tableData: [
        {
          date: "2016-05-02",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1518 弄",
          amount: 234791253.11,
          status: "启用"
        },
        {
          date: "2016-05-04",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1517 弄",
          amount: 3241380821.0,
          status: "启用"
        },
        {
          date: "2016-05-01",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1519 弄",
          amount: 5436434234.0,
          status: "启用"
        },
        {
          date: "2016-05-03",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1516 弄",
          amount: 73472122.0,
          status: "启用"
        }
      ]
    };
  },
  methods: {
    getCellClass({ row, column, rowIndex, columnIndex }) {
      if (columnIndex === 3) {
        return "amount-col";
      }
    }
  }
};
</script>

<style>
.amount-col > .cell {
  text-align: right;
}
</style>

<style scoped>
.text-title {
  display: inline-block;
  font-size: 16px;
  font-weight: 400;
  color: #303133;
}
.row {
  margin-bottom: 20px;
}
ul.note {
  padding: 0 0 0 10px !important;
  margin: 0 !important;
}
ul.note > li {
  line-height: 2;
  font-size: 14px;
  color: #606266;
}
</style>
