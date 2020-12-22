<!--
 @Descripttion:
 @Author: gong qun
 @Date: 2020-06-18 10:25:12
 @LastEditors: gong qun
 @LastEditTime: 2020-06-18 10:25:12
-->
<template>
  <SelectTree
    ref="selectTree"
    :options="options"
    placeholder="请选择部门"
    @change="change"
    :props="props"
  ></SelectTree>
</template>

<script>
import SelectTree from "@/components/SelectTree";
export default {
  components: {
    SelectTree
  },
  name: "organization-select-tree",
  data() {
    return {
      options: [],
      props: {
        value: "id",
        label: "fullName",
        children: "children"
      }
    };
  },
  mounted() {
    let deptTree = sessionStorage.getItem("deptTree");
    if (deptTree) {
      this.options = JSON.parse(deptTree);
      return;
    }
    this.$service.Organization.getTreeList().then(res => {
      this.options = res.data;
      sessionStorage.setItem("deptTree", JSON.stringify(this.options));
    });
  },
  methods: {
    change(value) {
      this.$emit("change", value);
    },
    clearSelect() {
      this.$refs.selectTree.clearSelect();
    }
  }
};
</script>
