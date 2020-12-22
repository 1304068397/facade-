<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-07-15 16:50:12
 * @LastEditors: dongjunhua
 * @LastEditTime: 2020-09-13 14:28:05
-->
<template>
  <div class="app-container">
    <el-card shadow="hover">
      <el-row class="row">
        <span class="text-title">基本按钮类型</span>
      </el-row>
      <el-row class="row">
        <el-button>默认按钮</el-button>
        <el-button type="primary" plain>主要按钮</el-button>
        <el-button type="success" plain>成功按钮</el-button>
        <el-button type="info" plain>信息按钮</el-button>
        <el-button type="warning" plain>警告按钮</el-button>
        <el-button type="danger" plain>危险按钮</el-button>
      </el-row>
      <el-row class="row" style="margin-top:30px">
        <span class="text-title">常见按钮示例</span>
      </el-row>
      <el-row class="row">
        <el-table :data="tableData" style="width: 100%" stripe>
          <el-table-column prop="type" label="类型"> </el-table-column>
          <el-table-column prop="text" label="名称"> </el-table-column>
          <el-table-column prop="icon" label="图标"> </el-table-column>
          <el-table-column label="展示">
            <template slot-scope="scope">
              <el-button
                :type="scope.row.type"
                :icon="scope.row.icon"
                :plain="scope.row.plain"
                >{{ scope.row.text }}</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </el-row>
      <el-row class="row" style="margin-top:30px">
        <span class="text-title">注意事项</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              如无特殊情况，所有按钮默认 size 为
              mini（已全局设置，无需单独添加）
            </li>
            <li>
              如无特殊情况，除 “取消” 和 “确定” 外的所有按钮默认添加 plain
              属性（朴素样式）
            </li>
            <li>
              在常见按钮中已列出的按钮请遵循对应样式，未列出的按钮团队成员间应达成共识，保持样式统一
            </li>
            <li>查询条件区域的按钮须单独另起一行</li>
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
          type: "default",
          text: "查询",
          icon: "el-icon-search",
          plain: true
        },
        {
          type: "default",
          text: "查看",
          icon: "el-icon-document-copy",
          plain: true
        },
        {
          type: "primary",
          text: "新增",
          icon: "el-icon-plus",
          plain: true
        },
        {
          type: "primary",
          text: "修改",
          icon: "el-icon-edit",
          plain: true
        },
        {
          type: "danger",
          text: "删除",
          icon: "el-icon-delete",
          plain: true
        },
        {
          type: "danger",
          text: "重置",
          icon: "el-icon-refresh-left",
          plain: true
        },
        {
          type: "info",
          text: "上传",
          icon: "el-icon-upload2",
          plain: true
        },
        {
          type: "info",
          text: "下载",
          icon: "el-icon-download",
          plain: true
        },
        {
          type: "default",
          text: "取消",
          icon: "",
          plain: false
        },
        {
          type: "primary",
          text: "确定",
          icon: "",
          plain: false
        }
      ]
    };
  }
};
</script>

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
