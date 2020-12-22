<!--
 * @Descripttion: 
 * @Author: dongjunhua
 * @Date: 2020-08-20 08:32:52
 * @LastEditors: dongjunhua
 * @LastEditTime: 2020-08-20 12:55:38
-->
<template>
  <div v-if="visible">
    <slot></slot>
  </div>
</template>

<script>
import { eventBus } from "../event-bus";
export default {
  name: "JumpDialogItem",
  data() {
    return {
      visible: false
    };
  },
  props: {
    name: {
      type: String
    },
    label: {
      type: String
    }
  },
  created() {
    eventBus.$on("activeChange", activeName => {
      this.visible = this.name === activeName;
      this.visible && eventBus.$emit("setTitle", this.label);
    });
  },
  mounted() {}
};
</script>
