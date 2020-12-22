<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-07-15 16:50:12
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-09-18 14:23:16
-->
<template>
  <div class="app-container">
    <el-card shadow="hover">
      <el-row class="row">
        <span class="text-title">示例</span>
      </el-row>
      <el-row class="row">
        <el-col :sm="24" :md="12" :lg="6">
          <el-form
            :model="ruleForm"
            :rules="rules"
            ref="ruleForm"
            label-width="100px"
            class="demo-ruleForm"
            label-position="top"
          >
            <el-form-item label="活动名称" prop="name">
              <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="活动区域" prop="region">
              <el-select v-model="ruleForm.region" placeholder="请选择活动区域">
                <el-option label="区域一" value="shanghai"></el-option>
                <el-option label="区域二" value="beijing"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="活动时间" required>
              <el-col :span="11">
                <el-form-item prop="date1">
                  <el-date-picker
                    type="date"
                    placeholder="选择日期"
                    v-model="ruleForm.date1"
                    style="width: 100%;"
                  ></el-date-picker>
                </el-form-item>
              </el-col>
              <el-col class="line" :span="2">-</el-col>
              <el-col :span="11">
                <el-form-item prop="date2">
                  <el-time-picker
                    placeholder="选择时间"
                    v-model="ruleForm.date2"
                    style="width: 100%;"
                  ></el-time-picker>
                </el-form-item>
              </el-col>
            </el-form-item>
            <el-form-item label="即时配送" prop="delivery">
              <el-switch v-model="ruleForm.delivery"></el-switch>
            </el-form-item>
            <el-form-item label="活动性质" prop="type">
              <el-checkbox-group v-model="ruleForm.type">
                <el-checkbox
                  label="美食/餐厅线上活动"
                  name="type"
                ></el-checkbox>
                <el-checkbox label="地推活动" name="type"></el-checkbox>
                <el-checkbox label="线下主题活动" name="type"></el-checkbox>
                <el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
              </el-checkbox-group>
            </el-form-item>
            <el-form-item label="特殊资源" prop="resource">
              <el-radio-group v-model="ruleForm.resource">
                <el-radio label="线上品牌商赞助"></el-radio>
                <el-radio label="线下场地免费"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="活动形式" prop="desc">
              <el-input type="textarea" v-model="ruleForm.desc"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')"
                >立即创建</el-button
              >
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
      <el-row class="row" style="margin-top:30px">
        <span class="text-title">注意事项</span>
      </el-row>
      <el-row>
        <text-field>
          <ul class="note">
            <li>
              应根据具体目标和制约因素，选择最佳的标签对齐方式（例如：当标签文字长度较短时可使用左对齐或右对齐，当长度较长时可使用顶部对齐），但整个项目的对齐方式应尽可能保持一致
            </li>
            <li>
              请根据实际业务需求在提交前对表单项目进行必要的校验和提示
            </li>
            <li>
              如表单处于对话框中，则表单的提交应交由对话框的确定按钮触发
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
  name: "Form",
  components: { TextField },
  data() {
    return {
      ruleForm: {
        name: "",
        region: "",
        date1: "",
        date2: "",
        delivery: false,
        type: [],
        resource: "",
        desc: ""
      },
      rules: {
        name: [
          { required: true, message: "请输入活动名称", trigger: "blur" },
          { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" }
        ],
        region: [
          { required: true, message: "请选择活动区域", trigger: "change" }
        ],
        date1: [
          {
            type: "date",
            required: true,
            message: "请选择日期",
            trigger: "change"
          }
        ],
        date2: [
          {
            type: "date",
            required: true,
            message: "请选择时间",
            trigger: "change"
          }
        ],
        type: [
          {
            type: "array",
            required: true,
            message: "请至少选择一个活动性质",
            trigger: "change"
          }
        ],
        resource: [
          { required: true, message: "请选择活动资源", trigger: "change" }
        ],
        desc: [{ required: true, message: "请填写活动形式", trigger: "blur" }]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
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
.line {
  text-align: center;
}
</style>
