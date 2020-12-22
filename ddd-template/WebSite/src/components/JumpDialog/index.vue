<!--
 * @Descripttion: 
 * @Author: dongjunhua
 * @Date: 2020-08-16 15:43:55
 * @LastEditors: dongjunhua
 * @LastEditTime: 2020-08-20 12:32:54
-->
<template>
  <div class="jump-dialog-outer-container" :style="{ width }">
    <transition name="jump-dialog" mode="out-in">
      <div class="jump-dialog-inner-container" v-show="!visible">
        <slot name="layout"></slot>
      </div>
    </transition>
    <transition name="jump-dialog" mode="out-in">
      <div class="jump-dialog-inner-container" v-show="visible">
        <el-card shadow="hover">
          <el-page-header @back="goBack" :content="title"></el-page-header>
          <div class="content-container">
            <slot></slot>
          </div>
        </el-card>
      </div>
    </transition>
  </div>
</template>

<script>
import { eventBus } from "./event-bus";
export default {
  name: "JumpDialog",
  props: {
    visible: {
      type: Boolean,
      default: false
    },
    width: {
      type: String,
      default: "100%"
    },
    activeName: {
      type: String
    }
  },
  data() {
    return {
      title: ""
    };
  },
  watch: {
    activeName(val) {
      eventBus.$emit("activeChange", val);
    }
  },
  created() {
    eventBus.$on("setTitle", title => {
      this.title = title;
    });
  },
  mounted() {},
  beforeDestroy() {
    eventBus.$off();
  },
  methods: {
    goBack() {
      this.$emit("update:visible", false);
    }
  }
};
</script>

<style scoped>
.jump-dialog-outer-container {
  position: relative;
  width: 100%;
}
.jump-dialog-inner-container {
  position: absolute;
  width: 100%;
}
.content-container {
  width: 100%;
  margin-top: 20px;
}

.jump-dialog-leave-active {
  transition: all 0.6s ease;
}

.jump-dialog-enter-active {
  transition: all 0.6s ease;
}

.jump-dialog-enter {
  opacity: 0;
  transform: translateX(-30px);
}

.jump-dialog-leave-to {
  opacity: 0;
  transform: translateX(30px);
}
</style>
