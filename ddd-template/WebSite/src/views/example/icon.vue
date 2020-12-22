<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-07-15 16:50:12
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-09-18 13:47:36
-->
<template>
  <div class="app-container">
    <el-card shadow="hover">
      <el-row class="row">
        <span class="text-title">图标</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              推荐使用默认和 element 两种图标样式
            </li>
            <li>
              如有需要可引入外部图标库，但需注意保持风格一致
            </li>
          </ul>
        </text-field>
      </el-row>
      <el-row style="margin-top:20px">
        <icons></icons>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import TextField from "@/components/TextField";
import Icons from "@/views/icons";
export default {
  name: "Icon",
  components: { TextField, Icons }
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
