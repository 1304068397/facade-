<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-07-08 16:06:00
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-07-09 10:56:45
-->

<template>
  <div class="frame-container">
    <iframe :src="url" class="frame"></iframe>
  </div>
</template>

<script>
export default {
  name: "Outer",
  data() {
    return {
      url: ""
    };
  },
  watch: {
    $route: {
      handler() {
        this.url = this.$route.query.url;
      },
      deep: true
    }
  },
  mounted() {
    this.url = this.$route.query.url;
    this.setFrameHeight();
    window.onresize = () => {
      this.setFrameHeight();
    };
  },
  methods: {
    setFrameHeight() {
      const container = document.querySelector(".frame-container");
      const frame = document.querySelector(".frame");
      const height = container.offsetHeight;
      frame.style.height = `${height}px`;
    }
  }
};
</script>

<style scoped>
.frame-container {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  /* width: 100%;
  height: 800px; */
}
.frame {
  width: 100%;
  border: none;
}
</style>
