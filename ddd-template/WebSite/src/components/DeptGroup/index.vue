<template>
  <div class="deptGroup" style="position:relative">
    <el-input
      :placeholder="holder"
      name="treeInfo"
      @click.native="showDeptInfo"
      v-model="deptName"
      :suffix-icon="treeVisble ? 'el-icon-caret-top' : 'el-icon-caret-bottom'"
    ></el-input>
    <div class="deptInfo" v-if="treeVisble">
      <el-input
        placeholder="输入关键字进行过滤"
        name="treeInfo"
        v-model="filterText"
        @click.native="showDeptInfo"
      >
      </el-input>
      <el-tree
        class="filter-tree"
        :data="deptList"
        :props="defaultProps"
        highlight-current
        :default-expand-all="true"
        :filter-node-method="filterNode"
        ref="tree"
        @node-click="handleNodeClick"
      >
      </el-tree>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    holder: {
      type: String
    },
    deptList: {
      type: Array
    }
  },
  data() {
    return {
      treeVisble: false,
      deptName: "", //部门名称
      filterText: "",
      defaultProps: {
        children: "children",
        label: "fullName"
      },
      event: null
    };
  },
  mounted() {
    document.body.addEventListener("click", e => {
      if (this.event) {
        if (e.target.name !== "treeInfo" || e.target !== this.event.target) {
          this.treeVisble = false;
        }
      }
    });
  },
  watch: {
    filterText(val) {
      this.$refs.tree.filter(val);
    },
    deptName(val) {
      if (val == "") {
        this.$emit("clearGroupId");
      }
    }
  },
  methods: {
    showDeptInfo(e) {
      this.event = e;
      this.treeVisble = true;
    },
    // 树节点点击
    handleNodeClick(data) {
      this.deptName = data.fullName;
      this.$emit("handleSetVal", data);
      this.treeVisble = false;
    },
    filterNode(value, data) {
      if (!value) return true;
      return data.fullName.indexOf(value) !== -1;
    }
  }
};
</script>

<style lang="scss" scoped>
.deptInfo {
  // position: absolute;
  position: fixed;
  width: 209px;
  height: 200px;
  z-index: 10;
  .el-tree {
    height: 200px;
    overflow: scroll;
  }
}
</style>
