/*
 * @Description:
 * @Autor: qun
 * @Date: 2020-06-10 14:23:40
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-07-15 17:15:06
 */

class Base {
  static downloadFile(res) {
    if (!res.data) return;
    var blob = new Blob([res.data], { type: res.data.type });
    // 针对于IE浏览器的处理, 因部分IE浏览器不支持createObjectURL
    if (window.navigator && window.navigator.msSaveOrOpenBlob) {
      window.navigator.msSaveOrOpenBlob(blob, res.fileName);
    } else {
      var downloadElement = document.createElement("a");
      var href = window.URL.createObjectURL(blob); // 创建下载的链接
      downloadElement.href = href;
      downloadElement.download = res.fileName; // 下载后文件名
      document.body.appendChild(downloadElement);
      downloadElement.click(); // 点击下载
      document.body.removeChild(downloadElement); // 下载完成移除元素
      window.URL.revokeObjectURL(href); // 释放掉blob对象
    }
  }

  static processRequestData(data) {
    if (!data.enabled) {
      delete data.enabled;
    }
  }
}
export { Base };
