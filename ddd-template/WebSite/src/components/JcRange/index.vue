<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-06-18 16:39:04
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-06-19 16:21:56
-->
<template>
  <div class="jc-component__range">
    <div class="jc-range" :class="rangeStatus ? 'success' : ''">
      <div
        :class="{ 'jc-range-block': true, login: rangeStatus }"
        @mousedown="rangeMove"
        @click="handleConfirm"
      >
        <i :class="rangeStatus ? successIcon : startIcon"></i>
        <span> 登 录</span>
      </div>
      {{ rangeStatus ? successText : startText }}
    </div>
  </div>
</template>

<script>
export default {
  name: "JcRange",
  props: {
    // 成功之后的函数
    successFun: {
      type: Function
    },
    //成功图标
    successIcon: {
      type: String,
      default: "el-icon-mouse"
    },
    //成功文字
    successText: {
      type: String,
      default: "验证成功"
    },
    //开始的图标
    startIcon: {
      type: String,
      default: "el-icon-right"
    },
    //开始的文字
    startText: {
      type: String,
      default: "拖动滑块至最右以登录"
    },
    //失败之后的函数
    errorFun: {
      type: Function
    },
    //或者用值来进行监听
    status: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      disX: 0,
      rangeStatus: false
    };
  },
  methods: {
    handleConfirm() {
      this.$emit("handle-confirm");
    },
    //滑块移动
    rangeMove(e) {
      let ele = document.querySelector(".jc-range-block");
      let startX = e.clientX;
      let eleWidth = ele.offsetWidth;
      let parentWidth = ele.parentElement.offsetWidth;
      let MaxX = parentWidth - eleWidth;
      if (this.rangeStatus) {
        //不运行
        return false;
      }
      document.onmousemove = e => {
        let endX = e.clientX;
        this.disX = endX - startX;
        if (this.disX <= 0) {
          this.disX = 0;
        }
        if (this.disX >= MaxX - eleWidth) {
          //减去滑块的宽度,体验效果更好
          this.disX = MaxX;
        }
        ele.style.transition = ".1s all";
        ele.style.transform = "translateX(" + this.disX + "px)";
        e.preventDefault();
      };
      document.onmouseup = () => {
        if (this.disX !== MaxX) {
          ele.style.transition = ".5s all";
          ele.style.transform = "translateX(0)";
          //执行成功的函数
          this.errorFun && this.errorFun();
        } else {
          this.rangeStatus = true;
          if (!this.status) {
            this.$emit("update:status", true);
          }
          //执行成功的函数
          this.successFun && this.successFun();
        }
        document.onmousemove = null;
        document.onmouseup = null;
      };
    }
  }
};
</script>

<style lang="scss" scoped>
@mixin jc-flex {
  display: flex;
  justify-content: center;
  align-items: center;
}
.jc-component__range {
  .jc-range {
    background-color: #e9e9e9;
    position: relative;
    transition: 1s all;
    user-select: none;
    color: #585858;
    border-radius: 3px;
    @include jc-flex;
    height: 40px; /*no*/
    &.success {
      background-color: rgb(24, 144, 255);
      color: #fff;
      i {
        color: rgb(24, 144, 255);
      }
    }
    .jc-range-block {
      position: absolute;
      left: 0;
      width: 50px; /*no*/
      height: 100%;
      color: #409eff;
      border-radius: 3px;
      background-color: #fff;
      border: 1px solid #d8d8d8;
      cursor: pointer;
      font-size: 20px;
      @include jc-flex;

      span {
        position: absolute;
        left: 50px;
        font-size: 14px;
        margin-left: 5px;
        opacity: 0;
      }
    }

    .login {
      left: -50px;
      width: 100px;
    }
  }
}
</style>
