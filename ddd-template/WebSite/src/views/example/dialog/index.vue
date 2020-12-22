<!--
 * @Descripttion: 
 * @Author: dongjunhua
 * @Date: 2020-08-16 14:45:34
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-09-18 14:29:36
-->
<template>
  <div class="app-container">
    <jump-dialog :visible.sync="dialogVisible2" :activeName="activeName">
      <el-card shadow="hover" slot="layout">
        <el-row class="row">
          <span class="text-title">示例</span>
        </el-row>
        <el-row>
          <el-button @click="dialogVisible = true">点击弹出对话框</el-button>
          <el-button @click="handleOpenJump1">点击跳转对话框1</el-button>
          <el-button @click="handleOpenJump2">点击跳转对话框2</el-button>
        </el-row>
        <el-row class="row" style="margin-top:30px">
          <span class="text-title">注意事项</span>
        </el-row>
        <el-row>
          <text-field>
            <ul class="note">
              <li>
                对于 pc 端页面，默认使用 el-dialog
                组件，在右下角放置取消和确定按钮（按钮文字描述根据实际业务场景可进行修改，按钮必须放在名称为
                footer 的插槽中）
              </li>
              <li>
                应根据内容的实际情况设置 el-dialog 的百分比宽度
              </li>
              <li>
                对于手机端页面，默认使用 el-drawer
                组件，方向自下往上开启，在底部防止取消和确定按钮
              </li>
              <li>
                对话框中内容较多时，可使用自定义组件 jump-dialog
                进行整页跳转，以下是该组件的使用说明：<br />
                (1) 将原页面内容放置在名为 layout 的插槽中<br />
                (2) 每有一个新的跳转对话框，需在 jump-dialog 中添加一个
                jump-dialog-item 子组件<br />
                (3) 子组件接收 name 和 label 作为参数（必须），其中 label
                会作为跳转对话框的标题展示<br />
                (4)
                一般情况下，应在跳转对话框的右下角放置确定按钮（跳转对话框自带返回故不需要取消按钮）
              </li>
            </ul>
          </text-field>
        </el-row>
      </el-card>
      <jump-dialog-item name="first" label="详情页面1">
        <detail :visible.sync="dialogVisible2"></detail>
      </jump-dialog-item>
      <jump-dialog-item name="second" label="详情页面2">
        <span>这是详情页面2</span>
      </jump-dialog-item>
    </jump-dialog>
    <el-dialog title="编辑" :visible.sync="dialogVisible" width="30%">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>
<script>
import Detail from "./components/Detail";
import TextField from "@/components/TextField";
export default {
  name: "Dialog",
  components: { Detail, TextField },
  data() {
    return {
      dialogVisible: false,
      dialogVisible2: false,
      activeName: null
    };
  },
  methods: {
    handleOpenJump1() {
      this.dialogVisible2 = true;
      this.activeName = "first";
    },
    handleOpenJump2() {
      this.dialogVisible2 = true;
      this.activeName = "second";
    }
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
