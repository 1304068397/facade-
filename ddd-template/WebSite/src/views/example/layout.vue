<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-07-15 16:50:12
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-09-17 10:01:43
-->
<template>
  <div class="app-container">
    <el-card shadow="hover">
      <el-row class="row">
        <span class="text-title">布局指导原则</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              任何时候，页面组件最外层应使用 div 作为最外层容器，且 class 为
              app-container（该样式已在全局 css 中定义）
            </li>
            <li>
              关于总体布局（例如上下左右区块，元素的内容和位置），开发人员应参照
              UI 设计进行
            </li>
            <li>
              以展示的内容性质划分区域（例如查询条件、查询结果），每个区域使用
              el-card 组件作为外部容器
            </li>
            <li>
              每个 el-card 中的内容，应使用 el-row 及 el-col 的栅格化布局
            </li>
            <li>
              对于 el-row 中可能存在多列的情况（例如查询条件），必须使用
              el-col，默认响应尺寸设置为 :sm="12" :md="8"
              :lg="6"，对于确定不存在多列的情况（例如查询结果），可以将 el-col
              设置为 :span=24，也可以不使用 el-col
            </li>
            <li>
              每个块级元素的默认间距为20px（包括但不限于：不同 el-card
              之间、el-card
              和内部元素之间、内部元素和内部元素之间，按钮之间例外，使用
              el-button 默认间隔即可）
            </li>
          </ul>
        </text-field>
      </el-row>
      <el-row class="row" style="margin-top:30px">
        <span class="text-title">示例</span>
      </el-row>
      <el-row>
        <div class="l-app">
          <div class="l-card">
            <el-row :gutter="20">
              <el-col :sm="12" :md="8" :lg="6" style="margin-bottom:20px">
                <div class="grid-content bg-purple l-flex">
                  <b style="color:#666666">el-input</b>
                </div>
              </el-col>
              <el-col :sm="12" :md="8" :lg="6" style="margin-bottom:20px">
                <div class="grid-content bg-purple l-flex">
                  <b style="color:#666666">el-input</b>
                </div>
              </el-col>
              <el-col :sm="12" :md="8" :lg="6" style="margin-bottom:20px">
                <div class="grid-content bg-purple l-flex">
                  <b style="color:#666666">el-input</b>
                </div>
              </el-col>
              <el-col :sm="12" :md="8" :lg="6" style="margin-bottom:20px">
                <div class="grid-content bg-purple l-flex">
                  <b style="color:#666666">el-input</b>
                </div>
              </el-col>
            </el-row>
            <el-row :gutter="20">
              <el-col :span="24">
                <div
                  class="grid-content bg-blue l-i-flex"
                  style="width:100px; margin-right:5px"
                >
                  <b style="color:#ffffff">el-button</b>
                </div>
                <div
                  class="grid-content bg-red l-i-flex"
                  style="width:100px; margin-right:5px"
                >
                  <b style="color:#ffffff">el-button</b>
                </div>
                <div
                  class="grid-content bg-green l-i-flex"
                  style="width:100px; margin-right:5px"
                >
                  <b style="color:#ffffff">el-button</b>
                </div>
              </el-col>
            </el-row>
          </div>
          <div class="l-card" style="margin-top:20px">
            <el-row>
              <div class="grid-content bg-purple l-flex" style="height:300px">
                <b style="color:#666666">el-table</b>
              </div>
            </el-row>
          </div>
        </div>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import TextField from "@/components/TextField";
export default {
  name: "Layout",
  components: { TextField }
};
</script>

<style scoped>
.l-app {
  width: 100%;
  padding: 20px;
  background-color: #eeeeee;
}

.l-card {
  width: 100%;
  padding: 20px;
  background-color: #ffffff;
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.bg-red {
  background: #f56c6c;
}
.bg-green {
  background: #67c23a;
}
.bg-blue {
  background: #409eff;
}
.l-flex {
  display: flex;
  justify-content: center;
  align-items: center;
}
.l-i-flex {
  display: inline-flex;
  justify-content: center;
  align-items: center;
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
