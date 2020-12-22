<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-06-08 09:28:06
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-06-16 10:06:27
-->
<template>
  <div>
    <div style="margin-bottom:15px;">Your roles: {{ roles }}</div>
    Switch roles:
    <el-radio-group v-model="switchRoles">
      <el-radio-button label="editor" />
      <el-radio-button label="admin" />
    </el-radio-group>
  </div>
</template>

<script>
export default {
  computed: {
    roles() {
      return this.$store.getters.roles;
    },
    switchRoles: {
      get() {
        return this.roles[0];
      },
      set(val) {}
    }
  }
};
</script>
