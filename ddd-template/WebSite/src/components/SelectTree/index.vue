<!--
 @Descripttion:
 @Author: gong qun
 @Date: 2020-06-18 10:25:12
 @LastEditors: gong qun
 @LastEditTime: 2020-06-18 10:25:12
-->
<template>
  <el-select
    :value="valueTitle"
    :clearable="clearable"
    @clear="clearSelect"
    :placeholder="placeholder"
    ref="select"
    :filterable="filterable"
    :filter-method="filterMethod"
    style="width:100%"
  >
    <el-option :value="valueTitle" :label="valueTitle">
      <el-tree
        id="tree-option"
        ref="selectTree"
        :data="options"
        :props="props"
        :node-key="props.value"
        :default-expanded-keys="defaultExpandedKey"
        :default-expand-all="true"
        @node-click="handleNodeClick"
        :filter-node-method="filterNode"
        :expand-on-click-node="false"
      >
      </el-tree>
    </el-option>
  </el-select>
</template>

<script>
export default {
  name: "select-tree",
  props: {
    /* 配置项 */
    props: {
      type: Object,
      default: () => {
        return {
          value: "id", // ID字段名
          label: "name", // 显示名称
          children: "children" // 子级字段名
        };
      }
    },
    /* 选项列表（树） */
    options: {
      type: Array,
      default: () => {
        return [];
      }
    },
    /* 初始值 */
    value: {
      type: String,
      default: () => {
        return null;
      }
    },
    /* 可清空选项 */
    clearable: {
      type: Boolean,
      default: () => {
        return true;
      }
    },
    /* 选中后隐藏下拉框 */
    autoHide: {
      type: Boolean,
      default: () => {
        return true;
      }
    },
    /* 是否可搜索 */
    filterable: {
      type: Boolean,
      default: () => {
        return true;
      }
    },
    /* 提示文字 */
    placeholder: {
      type: String,
      default: () => {
        return "请选择";
      }
    }
  },
  data() {
    return {
      valueId: this.value, // 初始值
      valueTitle: "",
      defaultExpandedKey: []
    };
  },
  mounted() {
    this.initHandle();
  },
  methods: {
    // 初始化值
    initHandle() {
      if (this.valueId) {
        this.valueTitle = this.$refs.selectTree.getNode(this.valueId).data[
          this.props.label
        ]; // 初始化显示
        this.$refs.selectTree.setCurrentKey(this.valueId); // 设置默认选中
        this.defaultExpandedKey = [this.valueId]; // 设置默认展开
      }
      this.$nextTick(() => {
        let scrollWrap = document.querySelectorAll(
          ".el-scrollbar .el-select-dropdown__wrap"
        )[0];
        let scrollBar = document.querySelectorAll(
          ".el-scrollbar .el-scrollbar__bar"
        );
        scrollWrap.style.cssText =
          "margin: 0px; max-height: none; overflow: hidden;";
        scrollBar.forEach(ele => (ele.style.width = 0));
      });
    },
    // 切换选项
    handleNodeClick(node) {
      this.valueTitle = node[this.props.label];
      this.valueId = node[this.props.value];
      this.$emit("change", this.valueId);
      this.defaultExpandedKey = [];
      if (this.autoHide) {
        this.$refs.select.blur();
      }
      this.filterMethod(null);
    },
    // 清除选中
    clearSelect() {
      this.valueTitle = "";
      this.valueId = null;
      this.defaultExpandedKey = [];
      this.clearSelected();
      this.$emit("change", null);
      this.filterMethod(null);
    },
    /* 清空选中样式 */
    clearSelected() {
      let allNode = document.querySelectorAll("#tree-option .el-tree-node");
      allNode.forEach(element => element.classList.remove("is-current"));
    },
    /* 筛选节点 */
    filterMethod(val) {
      this.$refs.selectTree.filter(val);
    },
    filterNode(value, data) {
      if (!value) return true;
      return (
        data[this.props.label].toLowerCase().indexOf(value.toLowerCase()) !== -1
      );
    }
  },
  watch: {
    value() {
      this.valueId = this.value;
      this.initHandle();
    }
  }
};
</script>

<style scoped>
.el-scrollbar .el-scrollbar__view .el-select-dropdown__item {
  height: auto;
  max-height: 274px;
  padding: 0;
  overflow: hidden;
  overflow-y: auto;
}
.el-select-dropdown__item.selected {
  font-weight: normal;
}
ul li >>> .el-tree .el-tree-node__content {
  height: auto;
  padding: 0 20px;
}
.el-tree-node__label {
  font-weight: normal;
}
.el-tree >>> .is-current .el-tree-node__label {
  color: #409eff;
  font-weight: 700;
}
.el-tree >>> .is-current .el-tree-node__children .el-tree-node__label {
  color: #606266;
  font-weight: normal;
}
.el-select-dropdown__list {
  padding: 0px;
}
</style>
