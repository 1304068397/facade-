<!--
 * @Descripttion: 
 * @Author: dongjunhua
 * @Date: 2020-08-20 12:48:20
 * @LastEditors: dongjunhua
 * @LastEditTime: 2020-08-20 12:59:30
-->
<template>
  <div>
    <span>这是详情页面1</span>
    <div class="footer-container">
      <el-button type="primary" @click="handleConfirm">确 定</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Detail",
  props: {
    visible: {
      type: Boolean
    }
  },
  methods: {
    handleConfirm() {
      this.$emit("update:visible", false);
    }
  }
};
</script>

<style scoped>
.footer-container {
  width: 100%;
  margin-top: 20px;
  text-align: right;
}
</style>
