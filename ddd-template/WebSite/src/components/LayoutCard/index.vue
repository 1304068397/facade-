<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-06-19 09:00:48
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-06-19 11:01:53
-->
<template>
  <div :class="['container', type]">
    <header>
      <div class="title-container" v-if="showTitle">
        <slot name="title"></slot>
      </div>
    </header>
    <main>
      <div class="filter-container" v-if="showFilter">
        <slot name="filter"></slot>
      </div>
      <div class="button-container" v-if="showButton">
        <slot name="button"></slot>
      </div>
      <div class="content-container">
        <slot name="content"></slot>
      </div>
    </main>
  </div>
</template>

<script>
export default {
  name: "LayoutCard",
  props: {
    type: {
      type: String
    },
    showTitle: {
      type: Boolean,
      default: true
    },
    showFilter: {
      type: Boolean,
      default: true
    },
    showButton: {
      type: Boolean,
      default: true
    }
  }
};
</script>

<style scoped>
.container {
  width: 100%;
  border-radius: 4px;
  border: 1px solid #e6ebf5;
  background-color: #fff;
  overflow: hidden;
  color: #303133;
  transition: 0.3s;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  padding: 20px;
}
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}
.primary {
  border-top: 3px solid #409eff;
}
.success {
  border-top: 3px solid #67c23a;
}
.warning {
  border-top: 3px solid #e6a23c;
}
.danger {
  border-top: 3px solid #f56c6c;
}
.info {
  border-top: 3px solid #909399;
}
.title-container {
  padding-bottom: 20px;
  margin-bottom: 20px;
  border-bottom: 1px solid #dcdfe6;
}
.filter-container {
  padding-bottom: 20px;
  margin-bottom: 20px;
  border-bottom: 1px solid #dcdfe6;
}
.button-container {
  padding-bottom: 20px;
}
.content-container {
  padding-bottom: 10px;
}
</style>
