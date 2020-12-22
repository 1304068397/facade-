<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-06-11 13:21:28
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-07-15 17:33:39
-->
<template>
  <el-dialog
    :visible.sync="visible"
    width="30%"
    :show-close="false"
    :close-on-click-modal="false"
  >
    <span slot="title">
      <i class="el-icon-user"> 选择用户</i>
    </span>
    <el-row :gutter="20">
      <el-col
        v-for="item in userList"
        :key="item.id"
        :item="item"
        :sm="24"
        :md="12"
        :lg="8"
      >
        <div @click="handleSelectUser(item.id)">
          <el-card
            :class="{
              'box-card': true,
              'box-card-selected': selectedUserId === item.id
            }"
            :shadow="selectedUserId === item.id ? 'always' : 'hover'"
          >
            <el-radio v-model="selectedUserId" :label="item.id">
              {{ `${item.name}` }}
            </el-radio>
          </el-card>
        </div>
      </el-col>
    </el-row>
    <span slot="footer" class="dialog-footer tright">
      <el-button type="primary" @click="handleConfirm">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
export default {
  name: "SelectUser",
  props: {
    visible: {
      type: Boolean,
      default: false
    },
    userList: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      selectedUserId: ""
    };
  },
  watch: {
    visible(val) {
      if (val) {
        this.selectedUserId = this.userList[0].id;
      }
    }
  },
  methods: {
    handleSelectUser(id) {
      this.selectedUserId = id;
    },
    handleConfirm() {
      this.$emit("handle-confirm", this.selectedUserId);
      this.$emit("update:visible", false);
    }
  }
};
</script>

<style scoped>
.el-col {
  margin-bottom: 10px;
}
.box-card {
  cursor: pointer;
  border-color: #dcdfe6;
}
.box-card-selected {
  background: rgb(236, 245, 255);
  border-color: rgb(102, 177, 255);
}
</style>
