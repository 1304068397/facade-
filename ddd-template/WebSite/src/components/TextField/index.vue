<!--
 * @Descripttion: 
 * @Author: dongjunhua
 * @Date: 2020-08-16 13:43:13
 * @LastEditors: dongjunhua
 * @LastEditTime: 2020-09-13 15:18:40
-->
<template>
  <div class="text-field">
    <slot></slot>
  </div>
</template>
<script>
export default {
  name: "TextField"
};
</script>
<style scoped>
.text-field {
  width: 100%;
  border: 1px solid #ebeef5;
  border-radius: 4px;
  background-color: #fafafa;
  padding: 20px;
  font-size: 12px;
}

.text-field span {
  line-height: 24px;
}
</style>
