<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-07-07 13:04:03
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-07-08 10:28:36
-->

<template>
  <el-dialog
    :loading="loading"
    :before-close="handleCloseDialog"
    :close-on-click-modal="false"
    width="30%"
    :title="`${isInitial ? '首次登录请先' : ''}修改密码`"
    :visible.sync="visible"
  >
    <el-form
      ref="dataForm"
      :model="data"
      label-position="top"
      size="large"
      :rules="rules"
    >
      <el-form-item label="旧密码" style="width: 100%;" prop="oldPassword">
        <el-input
          show-password
          placeholder="请输入旧密码"
          v-model="data.oldPassword"
          autocomplete="new-password"
        ></el-input>
      </el-form-item>
      <el-form-item label="新密码" style="width: 100%;" prop="password">
        <el-input
          show-password
          placeholder="请输入新密码"
          v-model="data.password"
          autocomplete="new-password"
        ></el-input>
      </el-form-item>
      <el-form-item label="确认密码" style="width: 100%;" prop="passwordAgain">
        <el-input
          show-password
          placeholder="请输再次入新密码"
          v-model="data.passwordAgain"
          autocomplete="new-password"
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="handleCloseDialog()">
        取消
      </el-button>
      <el-button type="primary" @click="handleComfirm">
        确认
      </el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "ModifyPassword",
  props: {
    visible: {
      type: Boolean,
      default: false
    },
    isInitial: {
      type: Boolean,
      default: false
    }
  },
  watch: {
    visible(val) {
      if (val) {
        this.$refs["dataForm"] && this.$refs["dataForm"].resetFields();
        this.data.id = this.$store.getters.accountId;
      }
    }
  },
  data() {
    const validPasswordAgain = (rule, value, callback) => {
      if (!value) {
        callback(new Error("请再次输入新密码"));
      } else {
        if (this.data.password !== this.data.passwordAgain) {
          callback(new Error("新密码两次输入必须一致"));
        }
        callback();
      }
    };
    return {
      loading: false,
      data: {
        id: "",
        oldPassword: "",
        password: "",
        passwordAgain: ""
      },
      rules: {
        oldPassword: [
          { required: true, message: "请输入旧密码", trigger: "blur" }
        ],
        password: [
          { required: true, message: "请输入新密码", trigger: "blur" }
        ],
        passwordAgain: [
          { required: true, validator: validPasswordAgain, trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    handleComfirm() {
      this.$refs["dataForm"].validate(async valid => {
        if (valid) {
          try {
            await this.$service.Account.modifyPassword(this.data);
            this.$message.success("修改密码成功");
            this.$emit("update:visible", false);
            this.$emit("handle-confirm");
          } catch (_) {}
        }
      });
    },
    handleCloseDialog() {
      this.$emit("update:visible", false);
    }
  }
};
</script>
