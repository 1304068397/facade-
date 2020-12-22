<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-07-15 16:50:12
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-09-18 15:17:46
-->
<template>
  <div class="app-container" style="position:relative">
    <div class="tag-outer">
      <div style="color:#ffffff"><b>ver</b></div>
      <div style="color:#ffffff">
        <b>1.0</b>
      </div>
    </div>
    <el-card shadow="hover">
      <el-row class="row">
        <span class="text-title">概述</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              此规范为前端 UI 规范，基于 element-ui 制定，其目的是保证项目 UI
              效果的一致性 ，解决以往开发中项目组不同成员间样式不统一的问题
            </li>
            <li>
              默认情况下，前端开发人员在开发过程中需遵循规范所述内容进行页面开发
            </li>
            <li>
              如当前项目有特殊的样式需求
              ，则可经由项目负责人和前端开发人员共同讨论制定 UI
              样式以替代默认样式规范
            </li>
            <li>
              此规范可能会随时间进行更迭，启动新项目时请参照当前最新规范
            </li>
            <li>
              element-ui 组件的使用，请参阅官网
              <a
                href="https://element.eleme.cn/#/zh-CN/component/quickstart"
                target="_blank"
                style="color:#409EFF"
                >https://element.eleme.cn/#/zh-CN/component/quickstart</a
              >
            </li>
          </ul>
        </text-field>
      </el-row>
      <el-row class="row" style="margin-top:30px">
        <span class="text-title">字体</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              为了在不同环境下都能达到最佳效果，我们默认使用以下字体：<br />
              <b>Helvetica Neue</b>, <b>Helvetica</b>, <b>PingFang SC</b>,
              <b>Hiragino Sans GB</b>, <b>Microsoft YaHei</b>, <b>Arial</b>,
              <b>sans-serif</b>
            </li>
            <li>
              以上字体已在全局 css 中设置，如无特殊情况禁止使用其他字体
            </li>
          </ul>
        </text-field>
      </el-row>
      <el-row class="row" style="margin-top:30px">
        <span class="text-title">字号</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              默认情况下，我们对字号进行以下规定：
              <br /><span style="font-size:12px; line-height:2"
                ><b>12px</b> - 用于辅助性提示内容</span
              ><br /><span style="font-size:14px; line-height:2"
                ><b>14px</b> - 用于正文内容</span
              ><br /><span style="font-size:16px; line-height:2"
                ><b>16px</b> - 用于标题</span
              >
            </li>
            <li>
              字号根据实际情况可以酌情考虑，但只允许使用偶数字号，且字号规格尽量控制在3种以内
            </li>
            <li>
              字体的行间距一般为字号的1.5 - 2倍，推荐使用2倍
            </li>
          </ul>
        </text-field>
      </el-row>
      <el-row class="row" style="margin-top:30px">
        <span class="text-title">颜色</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              默认情况下，我们对字体和边框的颜色进行以下规定：<br />
              <b>#303133</b> - 用于主要文字（标题） <br /><b>#606266</b> -
              用于常规文字（正文） <br /><b>#909399</b> -
              用于次要文字（辅助）<br />
              <b>#e4ebed</b> - 一级边框（外层） <br /><b>#ebeef5</b> -
              二级边框（内层）
            </li>
            <li>任何时候禁止使用纯黑色 <b>#000000</b></li>
          </ul>
        </text-field>
      </el-row>
      <el-row class="row" style="margin-top:30px">
        <span class="text-title">交互组件的使用</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              默认情况下，我们对常用交互组件的使用场合进行以下规定：<br />
              <b>el-input</b> - 默认输入框，适合需要文字输入的查询条件或内容<br />
              <el-input
                v-model="input"
                placeholder="请输入内容"
                style="width:200px; margin:10px 0"
              ></el-input>
              <br /><b>el-select</b> - 用于需要进行选择的查询条件或内容 <br />
              <el-select
                v-model="value"
                placeholder="请选择"
                style="width:200px; margin:10px 0"
              >
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                >
                </el-option>
              </el-select>
              <br />
              <b>el-date-picker</b>
              - 用于日期类型的查询条件或内容<br />
              <el-date-picker
                v-model="value1"
                type="date"
                placeholder="选择日期"
                style="width:200px; margin:10px 0"
              >
              </el-date-picker
              ><br />
              <b>el-time-select</b> - 用于时间类型的查询条件或内容 <br />
              <el-time-select
                v-model="value"
                :picker-options="{
                  start: '08:30',
                  step: '00:15',
                  end: '18:30'
                }"
                placeholder="选择时间"
                style="width:200px; margin:10px 0"
              >
              </el-time-select>
              <br />
              <b>el-checkbox</b>
              -
              单独使用表示两种状态之间的切换，多个使用表示一组备选项中进行多选<br />
              <el-row style="margin:10px 0">
                <el-checkbox-group v-model="checkList">
                  <el-checkbox label="复选框 A"></el-checkbox>
                  <el-checkbox label="复选框 B"></el-checkbox>
                  <el-checkbox label="复选框 C"></el-checkbox>
                  <el-checkbox label="禁用" disabled></el-checkbox>
                  <el-checkbox label="选中且禁用" disabled></el-checkbox>
                </el-checkbox-group>
              </el-row>
              <b>el-radio</b>
              - 不允许单独使用，多个使用表示一组备选项中进行单选<br />
              <el-row style="margin:10px 0">
                <el-radio-group v-model="radio">
                  <el-radio :label="3">单选框 A</el-radio>
                  <el-radio :label="6">单选框 B</el-radio>
                  <el-radio :label="9">单选框 C</el-radio>
                </el-radio-group>
              </el-row>
            </li>
          </ul>
        </text-field>
      </el-row>
      <el-row class="row" style="margin-top:30px">
        <span class="text-title">消息提示</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              我们使用 message
              组件进行消息提示，下面是4种提示类型的使用场合：<br />
              <b>message</b> - 默认，通常用于一般提示信息
              <el-button type="text" @click="openInfo">点击</el-button> <br /><b
                >message<span style="color:#67C23A">.success</span></b
              >
              - 成功，用于表示操作或行为达成
              <el-button type="text" @click="openSuccess">点击</el-button
              ><br /><b>message<span style="color:#E6A23C">.warning</span></b> -
              警告，用于表示操作或行为达成但存在潜在风险或可能未完全达到预期
              <el-button type="text" @click="openWarning">点击</el-button><br />
              <b>message<span style="color:#F56C6C">.error</span></b> -
              错误，用于表示操作或行为不允许或未达成
              <el-button type="text" @click="openError">点击</el-button>
            </li>
            <li>
              所有弹出框默认显示时间5秒，且需带有关闭按钮
            </li>
            <li>
              对于 http 请求的返回结果，axios
              实例中已添加全局错误提示，一般情况下无需额外处理（成功提示仍需手动添加）
            </li>
          </ul>
        </text-field>
      </el-row>
      <el-row class="row" style="margin-top:30px">
        <span class="text-title">其他注意事项</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              任何不可逆操作在执行前必须弹出确认框
            </li>
            <li>
              事件触发调用 http
              请求到返回结果这段时间内，应防止事件再次被触发（手段包括但不限于添加
              loading、设置 disabled 等）
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
  name: "Exmple",
  components: { TextField },
  data() {
    return {
      input: "",
      options: [
        {
          value: "选项1",
          label: "黄金糕"
        },
        {
          value: "选项2",
          label: "双皮奶"
        },
        {
          value: "选项3",
          label: "蚵仔煎"
        },
        {
          value: "选项4",
          label: "龙须面"
        },
        {
          value: "选项5",
          label: "北京烤鸭"
        }
      ],
      value1: "",
      value: "",
      checkList: ["选中且禁用", "复选框 A"],
      radio: 3
    };
  },
  methods: {
    openInfo() {
      this.$message({
        showClose: true,
        message: "这是一条消息提示"
      });
    },

    openSuccess() {
      this.$message({
        showClose: true,
        message: "恭喜你，这是一条成功消息",
        type: "success"
      });
    },

    openWarning() {
      this.$message({
        showClose: true,
        message: "警告哦，这是一条警告消息",
        type: "warning"
      });
    },

    openError() {
      this.$message({
        showClose: true,
        message: "错了哦，这是一条错误消息",
        type: "error"
      });
    }
  }
};
</script>

<style scoped>
.tag-outer {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 20px;
  right: 40px;
  width: 40px;
  height: 40px;
  font-size: 12px;
  background-color: #409eff;
  border-right: 5px solid rgb(121, 187, 255);
  border-left: 5px solid rgb(121, 187, 255);
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
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
